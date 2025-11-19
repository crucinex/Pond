# Pond - Beautiful Pomodoro Timer & Task Manager

A beautiful and intuitive Android productivity app featuring a Pomodoro timer, smart task management, calendar sync, and comprehensive statistics.

## Features

### 🍅 Pomodoro Timer
- **Beautiful Circular Timer**: Animated circular progress indicator with smooth transitions
- **Multiple Session Types**: Focus sessions, short breaks, and long breaks
- **Customizable Durations**: Adjust focus time, break durations, and pomodoros until long break
- **Task Linking**: Link pomodoro sessions to specific tasks
- **Auto-transition**: Automatically switch between focus and break sessions

### 📋 Task Management
- **Smart Task Inbox**: Organize tasks with categories (Inbox, Today, Upcoming, Completed)
- **Priority Levels**: High, Medium, and Low priority indicators
- **Pomodoro Tracking**: Estimate and track pomodoros per task
- **Task Details**: Add descriptions and due dates
- **Quick Actions**: Mark complete, edit, or delete tasks with ease

### 📊 Statistics
- **Comprehensive Analytics**: View your productivity across different time periods
- **Focus Time Tracking**: Monitor total focus time (Today, This Week, This Month, All Time)
- **Pomodoro Counts**: Track completed pomodoros over time
- **Visual Cards**: Beautiful stat cards for easy reading

### 📅 Calendar Sync
- **Automatic Sync**: Tasks with due dates automatically sync to your calendar
- **Event Updates**: Calendar events update when tasks are modified
- **Priority Colors**: Task priorities reflected in calendar event colors
- **Offline Support**: Changes sync when connection is restored

### 🔄 Offline Auto-Sync
- **Background Sync**: Periodic background synchronization every 15 minutes
- **Offline-First**: All data stored locally with Room database
- **Sync Queue**: Changes queued for sync when offline
- **Automatic Recovery**: Syncs automatically when connection is restored

### 🎨 Beautiful UI
- **Material Design 3**: Modern Material You design system
- **Smooth Animations**: Fluid transitions and animations throughout
- **Dark Mode Support**: Automatic dark mode based on system settings
- **Intuitive Navigation**: Bottom navigation for easy access to all features

## Technology Stack

- **Kotlin**: Modern Android development
- **Jetpack Compose**: Declarative UI framework
- **Material Design 3**: Latest Material Design components
- **Room Database**: Local data persistence
- **ViewModel**: State management with lifecycle awareness
- **Coroutines**: Asynchronous programming
- **WorkManager**: Background sync scheduling
- **Calendar Provider**: Android calendar integration

## Project Structure

```
app/
├── src/main/
│   ├── java/com/pond/pomodoro/
│   │   ├── data/
│   │   │   ├── model/          # Data models (Task, PomodoroSession)
│   │   │   ├── dao/            # Room DAOs
│   │   │   ├── database/       # Room database setup
│   │   │   └── repository/     # Data repositories
│   │   ├── ui/
│   │   │   ├── screen/         # Compose screens
│   │   │   ├── viewmodel/      # ViewModels
│   │   │   ├── navigation/     # Navigation components
│   │   │   └── theme/          # Theme and styling
│   │   ├── sync/               # Calendar sync and offline sync
│   │   └── MainActivity.kt     # Main entry point
│   └── res/                    # Resources
```

## Getting Started

### Prerequisites

- Android Studio Hedgehog (2023.1.1) or later
- Android SDK 26 (Android 8.0) or higher
- Gradle 8.0 or higher

### Building the App

1. Clone the repository
2. Open the project in Android Studio
3. Sync Gradle files
4. Build and run on an emulator or device

### Permissions

The app requires the following permissions:
- `READ_CALENDAR` & `WRITE_CALENDAR`: For calendar sync
- `POST_NOTIFICATIONS`: For timer notifications (Android 13+)
- `VIBRATE` & `WAKE_LOCK`: For timer functionality

## Usage

### Starting a Pomodoro Session

1. Navigate to the Timer tab
2. Select session type (Focus, Short Break, or Long Break)
3. Optionally link to a task
4. Tap Start to begin the timer

### Managing Tasks

1. Navigate to the Tasks tab
2. Tap the + button to add a new task
3. Enter task details and set priority
4. Use category tabs to filter tasks
5. Swipe or use actions to complete/edit/delete tasks

### Viewing Statistics

1. Navigate to the Stats tab
2. View your productivity metrics
3. Statistics update automatically as you complete pomodoros

## Architecture

The app follows the MVVM (Model-View-ViewModel) architecture pattern:

- **Model**: Room database entities and data classes
- **View**: Jetpack Compose UI screens
- **ViewModel**: Manages UI-related data and business logic
- **Repository**: Abstracts data sources and provides clean API

## Future Enhancements

- [ ] Cloud sync with backend service
- [ ] Task templates and recurring tasks
- [ ] Sound customization for timer
- [ ] Widget support
- [ ] Export statistics to CSV
- [ ] Task sharing and collaboration
- [ ] Custom themes and colors

## License

This project is part of a portfolio/demo project.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
