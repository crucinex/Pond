package com.pond.pomodoro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pond.pomodoro.data.repository.PomodoroRepository
import com.pond.pomodoro.data.repository.TaskRepository
import com.pond.pomodoro.ui.navigation.BottomNavigation
import com.pond.pomodoro.ui.screen.PomodoroScreen
import com.pond.pomodoro.ui.screen.StatsScreen
import com.pond.pomodoro.ui.screen.TasksScreen
import com.pond.pomodoro.ui.theme.PondTheme
import com.pond.pomodoro.ui.viewmodel.PomodoroViewModel
import com.pond.pomodoro.ui.viewmodel.StatsViewModel
import com.pond.pomodoro.ui.viewmodel.TaskViewModel
import com.pond.pomodoro.ui.viewmodel.ViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        val database = (application as PondApplication).database
        val taskRepository = TaskRepository(database.taskDao())
        val pomodoroRepository = PomodoroRepository(database.pomodoroSessionDao())
        
        setContent {
            PondTheme {
                PondApp(
                    taskRepository = taskRepository,
                    pomodoroRepository = pomodoroRepository
                )
            }
        }
    }
}

@Composable
fun PondApp(
    taskRepository: TaskRepository,
    pomodoroRepository: PomodoroRepository
) {
    val navController = rememberNavController()
    
    val factory = ViewModelFactory(taskRepository, pomodoroRepository)
    val pomodoroViewModel: PomodoroViewModel = viewModel(factory = factory)
    val taskViewModel: TaskViewModel = viewModel(factory = factory)
    val statsViewModel: StatsViewModel = viewModel(factory = factory)
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "timer",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("timer") {
                PomodoroScreen(
                    pomodoroViewModel = pomodoroViewModel,
                    taskViewModel = taskViewModel
                )
            }
            composable("tasks") {
                TasksScreen(taskViewModel = taskViewModel)
            }
            composable("stats") {
                StatsScreen(statsViewModel = statsViewModel)
            }
        }
    }
}

