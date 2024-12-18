package com.kellima.edutrpl

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kellima.edutrpl.model.Semester
import com.kellima.edutrpl.model.EduTRPLRepository
import com.kellima.edutrpl.model.Sks
import com.kellima.edutrpl.data.SksDatasource
import com.kellima.edutrpl.ui.theme.EduTRPLTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun EduTRPLNavigation(contentPadding: PaddingValues) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "semester_list"
    ) {
        // Halaman daftar semester
        composable("semester_list") {
            EduTRPLList(
                semester = EduTRPLRepository.daftarSemester,
                onSemesterClick = { semesterIndex ->
                    navController.navigate("semester_detail/$semesterIndex")
                },
                contentPadding = contentPadding
            )
        }

        // Halaman detail semester
        composable("semester_detail/{semesterIndex}") { backStackEntry ->
            val semesterIndex = backStackEntry.arguments?.getString("semesterIndex")?.toIntOrNull()
            val semesterSksList = SksDatasource.loadSemesterData().getOrNull(semesterIndex ?: 0) ?: emptyList()

            if (semesterIndex != null) {
                SemesterScreen(
                    sksList = semesterSksList,
                    onBackClick = { navController.popBackStack() }
                )
            } else {
                Text("Invalid Semester")
            }
        }
    }
}

@Composable
fun SemesterScreen(sksList: List<Sks>, onBackClick: () -> Unit) {
    Column {
        TopAppBarWithBackButton(onBackClick = onBackClick)

        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(sksList) { sks ->
                SksItem(sks)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithBackButton(onBackClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back Icon",
                    tint = colorResource(id = R.color.abu)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.softungu)
        ),
        modifier = Modifier.height(50.dp)
    )
}

@Composable
fun SksItem(sks: Sks) {
    val colors = listOf(
        colorResource(id = R.color.purple_200).copy(alpha = 0.15f),
        colorResource(id = R.color.teal_200).copy(alpha = 0.15f),
        colorResource(id = R.color.hijau).copy(alpha = 0.15f),
        colorResource(id = R.color.pink).copy(alpha = 0.15f),
        colorResource(id = R.color.Oranye).copy(alpha = 0.15f),
        colorResource(id = R.color.Kuning).copy(alpha = 0.15f),
        colorResource(id = R.color.Biru).copy(alpha = 0.15f),
        colorResource(id = R.color.Teal).copy(alpha = 0.15f)
    )

    val backgroundColor = colors[sks.code.hashCode() % colors.size]

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = sks.code,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = sks.name,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(text = "SKS: ${sks.sks}")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Lab: ${sks.lab}")
            }
        }
    }
}

@Composable
fun EduTRPLList(
    semester: List<Semester>,
    onSemesterClick: (Int) -> Unit,
    contentPadding: PaddingValues
) {
    val colors = listOf(
        colorResource(id = R.color.purple_200).copy(alpha = 0.3f),
        colorResource(id = R.color.teal_200).copy(alpha = 0.3f),
        colorResource(id = R.color.hijau).copy(alpha = 0.3f),
        colorResource(id = R.color.pink).copy(alpha = 0.3f),
        colorResource(id = R.color.Oranye).copy(alpha = 0.3f),
        colorResource(id = R.color.Kuning).copy(alpha = 0.3f),
        colorResource(id = R.color.Biru).copy(alpha = 0.3f),
        colorResource(id = R.color.Teal).copy(alpha = 0.3f)
    )

    LazyColumn(contentPadding = PaddingValues(top = 8.dp)) {
        itemsIndexed(semester) { index, sem ->

            val backgroundColor = colors[index % colors.size]

            SemesterListItem(
                sem = sem,
                onClick = { onSemesterClick(index) },
                backgroundColor = backgroundColor,
                modifier = Modifier.padding(top = if (index == 0) 0.dp else 8.dp, start = 8.dp, end = 8.dp)
            )
        }
    }
}

@Composable
fun SemesterListItem(
    sem: Semester,
    onClick: () -> Unit,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .padding(16.dp)
            .background(backgroundColor, RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(sem.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(end = 16.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Box(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(sem.nameRes),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        color = colorResource(id = R.color.black)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(sem.descriptionRes),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                color = colorResource(id = R.color.black)
            )
        }
    }
}


@Composable
fun EduTRPLPreviewWithNavController(contentPadding: PaddingValues) {
    val navController = rememberNavController()

    EduTRPLTheme(darkTheme = false) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            EduTRPLList(
                semester = EduTRPLRepository.daftarSemester,
                onSemesterClick = { semesterIndex ->
                    navController.navigate("semester_detail/$semesterIndex")
                },
                contentPadding = contentPadding
            )
        }
    }
}
