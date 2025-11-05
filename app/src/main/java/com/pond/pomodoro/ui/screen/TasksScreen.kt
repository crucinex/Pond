package com.pond.pomodoro.ui.screen

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pond.pomodoro.data.model.Task
import com.pond.pomodoro.ui.theme.PriorityHigh
import com.pond.pomodoro.ui.theme.PriorityLow
import com.pond.pomodoro.ui.theme.PriorityMedium
import com.pond.pomodoro.ui.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun TasksScreen(taskViewModel: TaskViewModel) {
    val tasks by taskViewModel.activeTasks.collectAsState(initial = emptyList())
    val isDialogOpen by taskViewModel.isTaskDialogOpen.collectAsState()
    val editingTask by taskViewModel.editingTask.collectAsState()
    
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
                                "Tasks",
                                fontWeight = FontWeight.Bold
                            ) 
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color.Transparent,
                            titleContentColor = MaterialTheme.colorScheme.onSurface
                        )
                    )
                }
            },
            floatingActionButton = {
                AnimatedFloatingActionButton(
                    onClick = { taskViewModel.openTaskDialog() }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Animated category tabs
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(animationSpec = tween(500)) + slideInHorizontally(
                        initialOffsetX = { -it },
                        animationSpec = tween(600, easing = FastOutSlowInEasing)
                    )
                ) {
                    CategoryTabs(
                        selectedCategory = taskViewModel.selectedCategory.value,
                        onCategorySelected = { taskViewModel.selectCategory(it) }
                    )
                }
                
                // Animated tasks list
                AnimatedContent(
                    targetState = tasks.isEmpty(),
                    transitionSpec = {
                        fadeIn(animationSpec = tween(300)) + scaleIn(initialScale = 0.9f) togetherWith
                        fadeOut(animationSpec = tween(300)) + scaleOut(targetScale = 0.9f)
                    },
                    label = "tasks_content"
                ) { isEmpty ->
                    if (isEmpty) {
                        EmptyTasksView()
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(
                                items = tasks,
                                key = { it.id }
                            ) { task ->
                                AnimatedTaskCard(
                                    task = task,
                                    onToggleComplete = { taskViewModel.toggleTaskCompletion(task) },
                                    onDelete = { taskViewModel.deleteTask(task) },
                                    onEdit = { taskViewModel.openTaskDialog(task) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
    
    // Animated task dialog
    AnimatedVisibility(
        visible = isDialogOpen,
        enter = fadeIn(animationSpec = tween(300)) + scaleIn(initialScale = 0.8f),
        exit = fadeOut(animationSpec = tween(200)) + scaleOut(targetScale = 0.8f)
    ) {
        if (isDialogOpen) {
            TaskDialog(
                task = editingTask,
                onDismiss = { taskViewModel.closeTaskDialog() },
                onSave = { title, description, priority ->
                    if (editingTask != null) {
                        taskViewModel.updateTask(editingTask!!.copy(
                            title = title,
                            description = description,
                            priority = priority
                        ))
                    } else {
                        taskViewModel.addTask(title, description, priority)
                    }
                    taskViewModel.closeTaskDialog()
                }
            )
        }
    }
}

@Composable
fun AnimatedFloatingActionButton(onClick: () -> Unit) {
    val infiniteTransition = rememberInfiniteTransition(label = "fab_pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "fab_scale"
    )
    
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier.scale(scale),
        containerColor = MaterialTheme.colorScheme.primary,
        shape = CircleShape
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add Task",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
fun CategoryTabs(
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    val categories = listOf("inbox", "today", "upcoming", "completed")
    val categoryLabels = mapOf(
        "inbox" to "Inbox",
        "today" to "Today",
        "upcoming" to "Upcoming",
        "completed" to "Completed"
    )
    
    ScrollableTabRow(
        selectedTabIndex = categories.indexOf(selectedCategory).coerceAtLeast(0),
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.primary,
        edgePadding = 16.dp
    ) {
        categories.forEachIndexed { index, category ->
            val isSelected = selectedCategory == category
            val scale by animateFloatAsState(
                targetValue = if (isSelected) 1.05f else 1f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                ),
                label = "tab_scale_$index"
            )
            
            Tab(
                selected = isSelected,
                onClick = { onCategorySelected(category) },
                modifier = Modifier.scale(scale),
                text = { 
                    Text(
                        categoryLabels[category] ?: category,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                    ) 
                }
            )
        }
    }
}

@Composable
fun AnimatedTaskCard(
    task: Task,
    onToggleComplete: () -> Unit,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEdit() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Animated checkbox
            AnimatedCheckbox(
                isChecked = task.isCompleted,
                onToggle = onToggleComplete
            )
            
            // Task content
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AnimatedContent(
                    targetState = task.isCompleted,
                    transitionSpec = {
                        fadeIn(animationSpec = tween(300)) togetherWith
                        fadeOut(animationSpec = tween(300))
                    },
                    label = "task_title"
                ) { completed ->
                    Text(
                        text = task.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = if (completed) {
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        } else {
                            MaterialTheme.colorScheme.onSurface
                        }
                    )
                }
                
                if (task.description.isNotEmpty()) {
                    Text(
                        text = task.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }
                
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Priority indicator with pulse
                    AnimatedPriorityIndicator(priority = task.priority)
                    
                    // Pomodoro count
                    if (task.pomodorosEstimated > 0) {
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                        ) {
                            Text(
                                text = "${task.pomodorosCompleted}/${task.pomodorosEstimated} 🍅",
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                            )
                        }
                    }
                }
            }
            
            // Action buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                IconButton(
                    onClick = onEdit,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                }
                IconButton(
                    onClick = onDelete,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AnimatedCheckbox(
    isChecked: Boolean,
    onToggle: () -> Unit
) {
    val scale by animateFloatAsState(
        targetValue = if (isChecked) 1.2f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessHigh
        ),
        label = "checkbox_scale"
    )
    
    IconButton(
        onClick = onToggle,
        modifier = Modifier.size(56.dp)
    ) {
        AnimatedContent(
            targetState = isChecked,
            transitionSpec = {
                scaleIn(initialScale = 0.8f) + fadeIn() togetherWith
                scaleOut(targetScale = 0.8f) + fadeOut()
            },
            label = "checkbox_icon"
        ) { checked ->
            Icon(
                imageVector = if (checked) Icons.Default.CheckCircle else Icons.Default.Circle,
                contentDescription = if (checked) "Mark incomplete" else "Mark complete",
                tint = if (checked) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                },
                modifier = Modifier
                    .size(32.dp)
                    .scale(scale)
            )
        }
    }
}

@Composable
fun AnimatedPriorityIndicator(priority: Task.Priority) {
    val color = when (priority) {
        Task.Priority.HIGH -> PriorityHigh
        Task.Priority.MEDIUM -> PriorityMedium
        Task.Priority.LOW -> PriorityLow
    }
    
    val infiniteTransition = rememberInfiniteTransition(label = "priority_pulse")
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.6f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "priority_alpha"
    )
    
    Box(
        modifier = Modifier
            .size(12.dp)
            .clip(CircleShape)
            .background(color.copy(alpha = alpha))
    )
}

@Composable
fun EmptyTasksView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "No tasks yet",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            Text(
                text = "Tap the + button to add a new task",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDialog(
    task: Task?,
    onDismiss: () -> Unit,
    onSave: (String, String, Task.Priority) -> Unit
) {
    var title by remember { mutableStateOf(task?.title ?: "") }
    var description by remember { mutableStateOf(task?.description ?: "") }
    var priority by remember { mutableStateOf(task?.priority ?: Task.Priority.MEDIUM) }
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { 
            Text(
                if (task == null) "New Task" else "Edit Task",
                fontWeight = FontWeight.Bold
            ) 
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description (optional)") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 3,
                    shape = RoundedCornerShape(12.dp)
                )
                PrioritySelector(
                    selectedPriority = priority,
                    onPrioritySelected = { priority = it }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (title.isNotBlank()) {
                        onSave(title, description, priority)
                    }
                },
                enabled = title.isNotBlank(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Save")
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss,
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Cancel")
            }
        },
        shape = RoundedCornerShape(24.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp
    )
}

@Composable
fun PrioritySelector(
    selectedPriority: Task.Priority,
    onPrioritySelected: (Task.Priority) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Priority",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.SemiBold
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Task.Priority.values().forEach { pri ->
                val isSelected = selectedPriority == pri
                val scale by animateFloatAsState(
                    targetValue = if (isSelected) 1.1f else 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    ),
                    label = "priority_scale_${pri.name}"
                )
                
                FilterChip(
                    selected = isSelected,
                    onClick = { onPrioritySelected(pri) },
                    label = { 
                        Text(
                            pri.name.lowercase().replaceFirstChar { it.uppercaseChar() },
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                        ) 
                    },
                    modifier = Modifier.scale(scale)
                )
            }
        }
    }
}
