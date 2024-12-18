package com.kellima.edutrpl

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kellima.edutrpl.data.SksDatasource
import com.kellima.edutrpl.model.EduTRPLRepository
import com.kellima.edutrpl.ui.theme.EduTRPLTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")
        setContent {
            EduTRPLTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EduTRPLApp()
                }
            }
        }
    }
}

@Composable
fun EduTRPLApp() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { EduTRPLTopBar() }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = "semester_list",
            modifier = Modifier.padding(contentPadding)
        ) {
            composable("semester_list") {
                val semester = EduTRPLRepository.daftarSemester
                EduTRPLList(
                    semester = semester,
                    contentPadding = contentPadding,
                    onSemesterClick = { semesterIndex ->
                        navController.navigate("semester_detail/$semesterIndex")
                    }
                )
            }
            composable("semester_detail/{semesterIndex}") { backStackEntry ->
                val semesterIndex = backStackEntry.arguments?.getString("semesterIndex")?.toIntOrNull()
                val sksData = SksDatasource.loadSemesterData()

                if (semesterIndex != null && semesterIndex in sksData.indices) {
                    // Back
                    SemesterScreen(
                        sksList = sksData[semesterIndex],
                        onBackClick = { navController.popBackStack() }
                    )
                } else {
                    Text("Invalid Semester", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EduTRPLTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.top_bar1),
                    fontSize = 25.sp,
                    style = MaterialTheme.typography.displayMedium,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(R.string.top_bar2),
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colorResource(id = R.color.ungu)
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun EduTRPLPreview() {
    EduTRPLTheme {
        EduTRPLApp()
    }
}
