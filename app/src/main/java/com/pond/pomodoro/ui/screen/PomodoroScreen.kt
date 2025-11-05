package com.pond.pomodoro.ui.screen

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pond.pomodoro.data.model.PomodoroSession
import com.pond.pomodoro.ui.theme.*
import com.pond.pomodoro.ui.viewmodel.PomodoroViewModel
import com.pond.pomodoro.ui.viewmodel.TaskViewModel
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun PomodoroScreen(
    pomodoroViewModel: PomodoroViewModel,
    taskViewModel: TaskViewModel
) {
    val timerState by pomodoroViewModel.timerState.collectAsState()
    val activeTasks by taskViewModel.activeTasks.collectAsState(initial = emptyList())
    
    // Animated background gradient
    val infiniteTransition = rememberInfiniteTransition(label = "background")
    val gradientOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "gradient"
    )
    
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
                                "Pomodoro Timer",
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                // Animated session type selector
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(animationSpec = tween(500)) + slideInHorizontally(
                        initialOffsetX = { -it },
                        animationSpec = tween(600, easing = FastOutSlowInEasing)
                    )
                ) {
                    SessionTypeSelector(
                        currentType = timerState.sessionType,
                        onTypeSelected = { pomodoroViewModel.selectSessionType(it) }
                    )
                }
                
                Spacer(modifier = Modifier.weight(1f))
                
                // Animated circular timer
                AnimatedContent(
                    targetState = timerState.sessionType,
                    transitionSpec = {
                        fadeIn(animationSpec = tween(300)) + scaleIn(initialScale = 0.8f) togetherWith
                        fadeOut(animationSpec = tween(300)) + scaleOut(targetScale = 0.8f)
                    },
                    label = "timer_type"
                ) { sessionType ->
                    CircularTimer(
                        timeRemaining = timerState.timeRemaining,
                        totalTime = timerState.totalTime,
                        sessionType = sessionType,
                        isRunning = timerState.isRunning
                    )
                }
                
                // Animated timer controls
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(animationSpec = tween(500, delayMillis = 200)) + 
                            slideInVertically(
                                initialOffsetY = { it },
                                animationSpec = tween(600, easing = FastOutSlowInEasing)
                            )
                ) {
                    TimerControls(
                        isRunning = timerState.isRunning,
                        isPaused = timerState.isPaused,
                        onStart = { pomodoroViewModel.startTimer() },
                        onPause = { pomodoroViewModel.pauseTimer() },
                        onReset = { pomodoroViewModel.resetTimer() },
                        onSkip = { pomodoroViewModel.skipTimer() }
                    )
                }
                
                Spacer(modifier = Modifier.weight(1f))
                
                // Animated task selector
                AnimatedVisibility(
                    visible = activeTasks.isNotEmpty(),
                    enter = fadeIn(animationSpec = tween(500)) + 
                            slideInVertically(
                                initialOffsetY = { it },
                                animationSpec = tween(600, easing = FastOutSlowInEasing)
                            ),
                    exit = fadeOut(animationSpec = tween(300)) + 
                           slideOutVertically(
                               targetOffsetY = { it },
                               animationSpec = tween(300)
                           )
                ) {
                    if (activeTasks.isNotEmpty()) {
                        TaskSelector(
                            tasks = activeTasks,
                            selectedTaskId = timerState.currentTaskId,
                            onTaskSelected = { taskId ->
                                pomodoroViewModel.startTimer(taskId)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SessionTypeSelector(
    currentType: PomodoroSession.SessionType,
    onTypeSelected: (PomodoroSession.SessionType) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SessionType.values().forEach { sessionType ->
            SessionTypeButton(
                sessionType = sessionType,
                isSelected = currentType == sessionType.type,
                onClick = { onTypeSelected(sessionType.type) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

data class SessionType(
    val type: PomodoroSession.SessionType,
    val label: String,
    val color: Color
) {
    companion object {
        val values = listOf(
            SessionType(PomodoroSession.SessionType.FOCUS, "Focus", FocusColor),
            SessionType(PomodoroSession.SessionType.SHORT_BREAK, "Short Break", ShortBreakColor),
            SessionType(PomodoroSession.SessionType.LONG_BREAK, "Long Break", LongBreakColor)
        )
    }
}

@Composable
fun SessionTypeButton(
    sessionType: SessionType,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.05f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "button_scale"
    )
    
    val alpha by animateFloatAsState(
        targetValue = if (isSelected) 1f else 0.6f,
        animationSpec = tween(300),
        label = "button_alpha"
    )
    
    Button(
        onClick = onClick,
        modifier = modifier
            .height(56.dp)
            .scale(scale)
            .alpha(alpha),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) {
                sessionType.color
            } else {
                MaterialTheme.colorScheme.surfaceVariant
            },
            contentColor = if (isSelected) {
                Color.White
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = if (isSelected) 8.dp else 2.dp,
            pressedElevation = if (isSelected) 12.dp else 4.dp
        )
    ) {
        Text(
            text = sessionType.label,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
        )
    }
}

@Composable
fun CircularTimer(
    timeRemaining: Long,
    totalTime: Long,
    sessionType: PomodoroSession.SessionType,
    isRunning: Boolean
) {
    val progress = if (totalTime > 0) {
        (totalTime - timeRemaining).toFloat() / totalTime.toFloat()
    } else {
        0f
    }
    
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing),
        label = "timer_progress"
    )
    
    val color = when (sessionType) {
        PomodoroSession.SessionType.FOCUS -> FocusColor
        PomodoroSession.SessionType.SHORT_BREAK -> ShortBreakColor
        PomodoroSession.SessionType.LONG_BREAK -> LongBreakColor
    }
    
    // Pulse animation when running
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )
    
    Box(
        modifier = Modifier
            .size(320.dp)
            .scale(if (isRunning) pulseScale else 1f),
        contentAlignment = Alignment.Center
    ) {
        // Outer glow effect
        if (isRunning) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val strokeWidth = 20.dp.toPx()
                val radius = (size.minDimension - strokeWidth) / 2
                val center = Offset(size.width / 2, size.height / 2)
                
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            color.copy(alpha = 0.3f),
                            color.copy(alpha = 0f)
                        ),
                        center = center,
                        radius = radius * 1.2f
                    ),
                    radius = radius * 1.1f,
                    center = center
                )
            }
        }
        
        // Main timer circle
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 18.dp.toPx()
            val radius = (size.minDimension - strokeWidth) / 2
            val center = Offset(size.width / 2, size.height / 2)
            
            // Background circle with gradient
            drawCircle(
                brush = Brush.sweepGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.1f)
                    ),
                    center = center
                ),
                radius = radius,
                center = center,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
            
            // Progress circle with gradient
            drawArc(
                brush = Brush.sweepGradient(
                    colors = listOf(
                        color,
                        color.copy(alpha = 0.7f),
                        color.copy(alpha = 0.5f)
                    ),
                    center = center
                ),
                startAngle = -90f,
                sweepAngle = 360f * animatedProgress,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                size = Size(radius * 2, radius * 2),
                topLeft = Offset(center.x - radius, center.y - radius)
            )
        }
        
        // Time display
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AnimatedContent(
                targetState = formatTime(timeRemaining),
                transitionSpec = {
                    slideInVertically(
                        initialOffsetY = { -it },
                        animationSpec = tween(300)
                    ) + fadeIn(animationSpec = tween(300)) togetherWith
                    slideOutVertically(
                        targetOffsetY = { it },
                        animationSpec = tween(300)
                    ) + fadeOut(animationSpec = tween(300))
                },
                label = "time_text"
            ) { time ->
                Text(
                    text = time,
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
            }
            
            Text(
                text = if (isRunning) "Focusing..." else "Ready",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
fun TimerControls(
    isRunning: Boolean,
    isPaused: Boolean,
    onStart: () -> Unit,
    onPause: () -> Unit,
    onReset: () -> Unit,
    onSkip: () -> Unit
) {
    val startButtonScale by animateFloatAsState(
        targetValue = 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        label = "start_button_scale"
    )
    
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Reset button
        IconButton(
            onClick = onReset,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surfaceVariant,
                            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
                        )
                    )
                )
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Reset",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(28.dp)
            )
        }
        
        // Start/Pause button
        Button(
            onClick = {
                if (isRunning) {
                    onPause()
                } else {
                    onStart()
                }
            },
            modifier = Modifier
                .weight(1f)
                .height(72.dp)
                .scale(startButtonScale),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(20.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 12.dp
            )
        ) {
            AnimatedContent(
                targetState = isRunning,
                transitionSpec = {
                    scaleIn(initialScale = 0.8f) + fadeIn() togetherWith
                    scaleOut(targetScale = 0.8f) + fadeOut()
                },
                label = "button_icon"
            ) { running ->
                Icon(
                    imageVector = if (running) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = if (running) "Pause" else "Start",
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = when {
                    isRunning -> "Pause"
                    isPaused -> "Resume"
                    else -> "Start"
                },
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
        
        // Skip button
        IconButton(
            onClick = onSkip,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surfaceVariant,
                            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
                        )
                    )
                )
        ) {
            Icon(
                imageVector = Icons.Default.SkipNext,
                contentDescription = "Skip",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskSelector(
    tasks: List<com.pond.pomodoro.data.model.Task>,
    selectedTaskId: Long?,
    onTaskSelected: (Long) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Link to Task",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            tasks.take(3).forEachIndexed { index, task ->
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(animationSpec = tween(300, delayMillis = index * 100)) +
                            slideInHorizontally(
                                initialOffsetX = { it },
                                animationSpec = tween(400, delayMillis = index * 100)
                            )
                ) {
                    TaskItem(
                        task = task,
                        isSelected = task.id == selectedTaskId,
                        onClick = { onTaskSelected(task.id) }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskItem(
    task: com.pond.pomodoro.data.model.Task,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.02f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMedium
        ),
        label = "task_scale"
    )
    
    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale),
        shape = RoundedCornerShape(12.dp),
        color = if (isSelected) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            Color.Transparent
        },
        tonalElevation = if (isSelected) 4.dp else 0.dp
    ) {
        Text(
            text = task.title,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            color = if (isSelected) {
                MaterialTheme.colorScheme.onPrimaryContainer
            } else {
                MaterialTheme.colorScheme.onSurface
            }
        )
    }
}

fun formatTime(milliseconds: Long): String {
    val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
    val seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60
    return String.format("%02d:%02d", minutes, seconds)
}
