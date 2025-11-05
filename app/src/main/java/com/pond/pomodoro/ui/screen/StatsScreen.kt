package com.pond.pomodoro.ui.screen

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pond.pomodoro.ui.viewmodel.StatsViewModel
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun StatsScreen(statsViewModel: StatsViewModel) {
    val stats by statsViewModel.stats.collectAsState()
    
    LaunchedEffect(Unit) {
        statsViewModel.loadStats()
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.background,
                        MaterialTheme.colorScheme.surface.copy(alpha = 0.3f)
                    )
                )
            )
    ) {
        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(animationSpec = tween(500)) + slideInVertically(
                        initialOffsetY = { -it },
                        animationSpec = tween(500, easing = FastOutSlowInEasing)
                    )
                ) {
                    TopAppBar(
                        title = { 
                            Text(
                                "Statistics",
                                fontWeight = FontWeight.Bold
                            ) 
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.Transparent,
                            titleContentColor = MaterialTheme.colorScheme.onSurface
                        )
                    )
                }
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    AnimatedStatCard(
                        title = "Today",
                        pomodoros = stats.todayPomodoros,
                        focusTime = stats.todayFocusTime,
                        index = 0
                    )
                }
                item {
                    AnimatedStatCard(
                        title = "This Week",
                        pomodoros = stats.weekPomodoros,
                        focusTime = stats.weekFocusTime,
                        index = 1
                    )
                }
                item {
                    AnimatedStatCard(
                        title = "This Month",
                        pomodoros = stats.monthPomodoros,
                        focusTime = stats.monthFocusTime,
                        index = 2
                    )
                }
                item {
                    AnimatedStatCard(
                        title = "All Time",
                        pomodoros = stats.totalPomodoros,
                        focusTime = stats.totalFocusTime,
                        index = 3
                    )
                }
            }
        }
    }
}

@Composable
fun AnimatedStatCard(
    title: String,
    pomodoros: Int,
    focusTime: Long,
    index: Int
) {
    val infiniteTransition = rememberInfiniteTransition(label = "stat_card_$index")
    val shimmerOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "shimmer"
    )
    
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(
            animationSpec = tween(500, delayMillis = index * 100)
        ) + slideInVertically(
            initialOffsetY = { it },
            animationSpec = tween(600, delayMillis = index * 100, easing = FastOutSlowInEasing)
        ) + scaleIn(
            initialScale = 0.9f,
            animationSpec = tween(500, delayMillis = index * 100)
        )
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.1f + shimmerOffset * 0.1f),
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.05f),
                                MaterialTheme.colorScheme.primary.copy(alpha = 0.1f + shimmerOffset * 0.1f)
                            ),
                            startX = shimmerOffset * 1000f
                        )
                    )
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        AnimatedStatItem(
                            label = "Pomodoros",
                            value = pomodoros.toString(),
                            icon = "🍅",
                            delay = index * 50
                        )
                        AnimatedStatItem(
                            label = "Focus Time",
                            value = formatFocusTime(focusTime),
                            icon = "⏱️",
                            delay = index * 50 + 100
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AnimatedStatItem(
    label: String,
    value: String,
    icon: String,
    delay: Int
) {
    var isVisible by remember { mutableStateOf(false) }
    
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(delay.toLong())
        isVisible = true
    }
    
    val scale by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        label = "stat_item_scale"
    )
    
    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(300, delayMillis = delay),
        label = "stat_item_alpha"
    )
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .scale(scale)
            .alpha(alpha)
    ) {
        Text(
            text = icon,
            style = MaterialTheme.typography.displayMedium
        )
        AnimatedContent(
            targetState = value,
            transitionSpec = {
                slideInVertically(
                    initialOffsetY = { -it },
                    animationSpec = tween(300)
                ) + fadeIn() togetherWith
                slideOutVertically(
                    targetOffsetY = { it },
                    animationSpec = tween(300)
                ) + fadeOut()
            },
            label = "stat_value"
        ) { currentValue ->
            Text(
                text = currentValue,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}

fun formatFocusTime(milliseconds: Long): String {
    val hours = TimeUnit.MILLISECONDS.toHours(milliseconds)
    val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds) % 60
    
    return when {
        hours > 0 -> "${hours}h ${minutes}m"
        minutes > 0 -> "${minutes}m"
        else -> "0m"
    }
}
