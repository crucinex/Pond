package com.pond.pomodoro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PondApp(
    taskRepository: TaskRepository,
    pomodoroRepository: PomodoroRepository
) {
    val navController = rememberNavController()
    
    val pomodoroViewModel: PomodoroViewModel = viewModel {
        PomodoroViewModel(pomodoroRepository)
    }
    val taskViewModel: TaskViewModel = viewModel {
        TaskViewModel(taskRepository)
    }
    val statsViewModel: StatsViewModel = viewModel {
        StatsViewModel(pomodoroRepository)
    }
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            AnimatedBottomNavigation(navController = navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "timer",
            modifier = Modifier.padding(paddingValues),
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(400, easing = FastOutSlowInEasing)
                ) + fadeIn(animationSpec = tween(400))
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -it },
                    animationSpec = tween(400, easing = FastOutSlowInEasing)
                ) + fadeOut(animationSpec = tween(400))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -it },
                    animationSpec = tween(400, easing = FastOutSlowInEasing)
                ) + fadeIn(animationSpec = tween(400))
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { it },
                    animationSpec = tween(400, easing = FastOutSlowInEasing)
                ) + fadeOut(animationSpec = tween(400))
            }
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

@Composable
fun AnimatedBottomNavigation(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    AnimatedVisibility(
        visible = true,
        enter = slideInVertically(
            initialOffsetY = { it },
            animationSpec = tween(400, easing = FastOutSlowInEasing)
        ) + fadeIn(animationSpec = tween(400)),
        exit = slideOutVertically(
            targetOffsetY = { it },
            animationSpec = tween(300)
        ) + fadeOut(animationSpec = tween(300))
    ) {
        BottomNavigation(navController = navController)
    }
}
