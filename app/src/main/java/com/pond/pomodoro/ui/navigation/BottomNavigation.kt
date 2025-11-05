package com.pond.pomodoro.ui.navigation

import androidx.compose.animation.core.*
import androidx.compose.animation.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pond.pomodoro.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        NavigationItem("timer", R.string.nav_timer, Icons.Filled.Timer),
        NavigationItem("tasks", R.string.nav_tasks, Icons.Filled.List),
        NavigationItem("stats", R.string.nav_stats, Icons.Filled.CheckCircle)
    )
    
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    NavigationBar(
        containerColor = androidx.compose.material3.MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp
    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route
            val scale by animateFloatAsState(
                targetValue = if (isSelected) 1.1f else 1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                ),
                label = "nav_item_scale"
            )
            
            NavigationBarItem(
                icon = {
                    AnimatedContent(
                        targetState = isSelected,
                        transitionSpec = {
                            scaleIn(initialScale = 0.8f) + fadeIn() togetherWith
                            scaleOut(targetScale = 0.8f) + fadeOut()
                        },
                        label = "nav_icon"
                    ) { selected ->
                        Icon(
                            imageVector = item.icon,
                            contentDescription = stringResource(item.label),
                            modifier = Modifier.scale(scale)
                        )
                    }
                },
                label = {
                    AnimatedContent(
                        targetState = isSelected,
                        transitionSpec = {
                            fadeIn() + slideInVertically { -it } togetherWith
                            fadeOut() + slideOutVertically { it }
                        },
                        label = "nav_label"
                    ) { selected ->
                        Text(
                            text = stringResource(item.label),
                            style = androidx.compose.material3.MaterialTheme.typography.labelSmall
                        )
                    }
                },
                selected = isSelected,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                    selectedTextColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                    indicatorColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    }
}

data class NavigationItem(
    val route: String,
    val label: Int,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)
