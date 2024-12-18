package com.kellima.edutrpl

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kellima.edutrpl.data.SksDatasource
import com.kellima.edutrpl.model.EduTRPLRepository

@Composable
fun EduTRPLApp(contentPadding: PaddingValues) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "semesterList") {
        composable("semesterList") {
            EduTRPLList(
                semester = EduTRPLRepository.daftarSemester,
                onSemesterClick = { semesterIndex ->
                    navController.navigate("semester${semesterIndex + 1}")
                },
                contentPadding = contentPadding,
            )
        }

        composable("semester1") {
            SemesterScreen(
                sksList = SksDatasource.loadSemesterData()[0],
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("semester2") {
            SemesterScreen(
                sksList = SksDatasource.loadSemesterData()[1],
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("semester3") {
            SemesterScreen(
                sksList = SksDatasource.loadSemesterData()[2],
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("semester4") {
            SemesterScreen(
                sksList = SksDatasource.loadSemesterData()[3],
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}


