package com.pond.pomodoro.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PomodoroScreen(
    pomodoroViewModel: PomodoroViewModel,
    taskViewModel: TaskViewModel
) {
    val timerState by pomodoroViewModel.timerState.collectAsState()
    val activeTasks by taskViewModel.activeTasks.collectAsState(initial = emptyList())
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pomodoro Timer") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
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
            // Session type selector
            SessionTypeSelector(
                currentType = timerState.sessionType,
                onTypeSelected = { pomodoroViewModel.selectSessionType(it) }
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Circular timer
            CircularTimer(
                timeRemaining = timerState.timeRemaining,
                totalTime = timerState.totalTime,
                sessionType = timerState.sessionType,
                isRunning = timerState.isRunning
            )
            
            // Timer controls
            TimerControls(
                isRunning = timerState.isRunning,
                isPaused = timerState.isPaused,
                onStart = { pomodoroViewModel.startTimer() },
                onPause = { pomodoroViewModel.pauseTimer() },
                onReset = { pomodoroViewModel.resetTimer() },
                onSkip = { pomodoroViewModel.skipTimer() }
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Task selector (optional)
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

@Composable
fun SessionTypeSelector(
    currentType: PomodoroSession.SessionType,
    onTypeSelected: (PomodoroSession.SessionType) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SessionTypeButton(
            type = PomodoroSession.SessionType.FOCUS,
            label = "Focus",
            isSelected = currentType == PomodoroSession.SessionType.FOCUS,
            onClick = { onTypeSelected(PomodoroSession.SessionType.FOCUS) },
            color = FocusColor,
            modifier = Modifier.weight(1f)
        )
        SessionTypeButton(
            type = PomodoroSession.SessionType.SHORT_BREAK,
            label = "Short Break",
            isSelected = currentType == PomodoroSession.SessionType.SHORT_BREAK,
            onClick = { onTypeSelected(PomodoroSession.SessionType.SHORT_BREAK) },
            color = ShortBreakColor,
            modifier = Modifier.weight(1f)
        )
        SessionTypeButton(
            type = PomodoroSession.SessionType.LONG_BREAK,
            label = "Long Break",
            isSelected = currentType == PomodoroSession.SessionType.LONG_BREAK,
            onClick = { onTypeSelected(PomodoroSession.SessionType.LONG_BREAK) },
            color = LongBreakColor,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun SessionTypeButton(
    type: PomodoroSession.SessionType,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    color: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) color else MaterialTheme.colorScheme.surfaceVariant,
            contentColor = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
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
        animationSpec = tween(durationMillis = 1000),
        label = "timer_progress"
    )
    
    val color = when (sessionType) {
        PomodoroSession.SessionType.FOCUS -> FocusColor
        PomodoroSession.SessionType.SHORT_BREAK -> ShortBreakColor
        PomodoroSession.SessionType.LONG_BREAK -> LongBreakColor
    }
    
    Box(
        modifier = Modifier.size(300.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 16.dp.toPx()
            val radius = (size.minDimension - strokeWidth) / 2
            val center = Offset(size.width / 2, size.height / 2)
            
            // Background circle
            drawCircle(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                radius = radius,
                center = center,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
            
            // Progress circle
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360f * animatedProgress,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                size = Size(radius * 2, radius * 2),
                topLeft = Offset(center.x - radius, center.y - radius)
            )
        }
        
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = formatTime(timeRemaining),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
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
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Reset button
        IconButton(
            onClick = onReset,
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Reset",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
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
                .height(64.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Icon(
                imageVector = if (isRunning) Icons.Default.Pause else Icons.Default.PlayArrow,
                contentDescription = if (isRunning) "Pause" else "Start",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = if (isRunning) "Pause" else if (isPaused) "Resume" else "Start",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
        
        // Skip button
        IconButton(
            onClick = onSkip,
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Icon(
                imageVector = Icons.Default.SkipNext,
                contentDescription = "Skip",
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun TaskSelector(
    tasks: List<com.pond.pomodoro.data.model.Task>,
    selectedTaskId: Long?,
    onTaskSelected: (Long) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Link to Task",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            tasks.take(3).forEach { task ->
                TaskItem(
                    task = task,
                    isSelected = task.id == selectedTaskId,
                    onClick = { onTaskSelected(task.id) }
                )
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
    Surface(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else Color.Transparent
    ) {
        Text(
            text = task.title,
            modifier = Modifier.padding(12.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
        )
    }
}

fun formatTime(milliseconds: Long): String {
    val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
    val seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60
    return String.format("%02d:%02d", minutes, seconds)
}

