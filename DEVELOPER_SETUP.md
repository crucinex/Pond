# Developer Setup Guide - Pond App

This guide will help you set up all the necessary tools to run, test, and export the Pond Pomodoro Timer app.

## Required Software

### 1. Android Studio (Required)
**Download:** [Android Studio Hedgehog (2023.1.1) or later](https://developer.android.com/studio)

**Why:** This is the official IDE for Android development. It includes:
- Code editor with Kotlin support
- Android SDK Manager
- Emulator for testing
- Build tools (Gradle)
- APK/AAB builder

**Installation Steps:**
1. Download Android Studio from the link above
2. Run the installer and follow the setup wizard
3. During setup, make sure to install:
   - Android SDK
   - Android SDK Platform
   - Android Virtual Device (AVD)
   - Performance (Intel HAXM or AMD Hypervisor) - for faster emulator

### 2. Java Development Kit (JDK) 17 or Later
**Download:** 
- [Oracle JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) OR
- [OpenJDK 17](https://adoptium.net/) (Recommended - Free)

**Why:** The app requires Java 17 for compilation (as specified in `build.gradle`)

**Installation:**
- **macOS:** Use Homebrew: `brew install openjdk@17`
- **Windows:** Download installer and run it
- **Linux:** `sudo apt install openjdk-17-jdk` (Ubuntu/Debian)

**Verify Installation:**
```bash
java -version
# Should show: openjdk version "17" or higher
```

### 3. Android SDK Components

**Required SDK Platforms:**
- Android SDK Platform 34 (Android 14) - Required
- Android SDK Platform 26-33 - Recommended (for compatibility testing)

**Required SDK Build Tools:**
- Android SDK Build-Tools 34.0.0 or later
- Android SDK Command-line Tools

**Required System Images:**
- At least one Android Virtual Device (AVD) image for testing

**How to Install:**
1. Open Android Studio
2. Go to **Tools → SDK Manager** (or click the SDK Manager icon)
3. In the **SDK Platforms** tab:
   - Check ✅ **Android 14.0 (UpsideDownCake)** - API Level 34
   - Check ✅ **Android 13.0 (Tiramisu)** - API Level 33 (optional but recommended)
4. In the **SDK Tools** tab, ensure these are checked:
   - ✅ Android SDK Build-Tools
   - ✅ Android SDK Command-line Tools
   - ✅ Android SDK Platform-Tools
   - ✅ Android Emulator
   - ✅ Intel x86 Emulator Accelerator (HAXM installer) - if on Intel Mac/Windows
   - ✅ Google Play services
5. Click **Apply** and wait for installation

### 4. Gradle (Included with Android Studio)

**Version Required:** Gradle 8.0 or later (Android Studio includes this automatically)

**Verify:** Android Studio will automatically download and configure Gradle when you first open the project.

## System Requirements

### Minimum System Requirements:
- **OS:** Windows 10/11, macOS 10.15+, or Linux (Ubuntu 18.04+)
- **RAM:** 8 GB minimum (16 GB recommended)
- **Storage:** 10 GB free space for Android Studio + SDKs
- **CPU:** 64-bit processor
- **Screen:** 1280x800 minimum resolution

### Recommended System Requirements:
- **RAM:** 16 GB or more
- **Storage:** 20 GB+ free space (SSD recommended)
- **CPU:** Multi-core processor (Intel i5/i7 or AMD equivalent)

## Setup Steps

### Step 1: Clone/Open the Project
1. Open Android Studio
2. Select **File → Open**
3. Navigate to the `Pond` project folder
4. Click **OK**
5. Wait for Gradle sync to complete (first time may take 5-10 minutes)

### Step 2: Configure SDK Path
1. Go to **File → Project Structure** (or press `Ctrl+Alt+Shift+S` / `Cmd+;` on Mac)
2. Under **SDK Location**, verify:
   - Android SDK Location points to your SDK installation
   - Default: `~/Library/Android/sdk` (macOS) or `C:\Users\YourName\AppData\Local\Android\Sdk` (Windows)

### Step 3: Set Up an Android Virtual Device (AVD)
1. Go to **Tools → Device Manager** (or click the Device Manager icon)
2. Click **Create Device**
3. Select a device (e.g., **Pixel 6**)
4. Click **Next**
5. Select a system image:
   - **Recommended:** API Level 34 (Android 14) with Google Play
   - Click **Download** if not installed
6. Click **Next** → **Finish**

### Step 4: Test Run
1. Select your AVD from the device dropdown (top toolbar)
2. Click the **Run** button (green play icon) or press `Shift+F10`
3. Wait for the app to build and launch on the emulator

## Running on Physical Device

### Enable Developer Options:
1. On your Android device, go to **Settings → About Phone**
2. Tap **Build Number** 7 times
3. Go back to **Settings → System → Developer Options**
4. Enable:
   - ✅ **USB Debugging**
   - ✅ **Stay Awake** (optional, for testing)

### Connect Device:
1. Connect your Android device via USB
2. On your device, allow USB debugging when prompted
3. In Android Studio, select your device from the device dropdown
4. Click **Run**

**Note:** Device must be running Android 8.0 (API 26) or higher

## Building and Exporting the App

### Option 1: Build Debug APK (For Testing)
1. Go to **Build → Build Bundle(s) / APK(s) → Build APK(s)**
2. Wait for build to complete
3. Click **locate** in the notification
4. APK will be in: `app/build/outputs/apk/debug/app-debug.apk`

### Option 2: Build Release APK (For Distribution)
**Before building release, you need a signing key:**

1. **Generate a Keystore:**
   ```bash
   keytool -genkey -v -keystore pond-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias pond-key
   ```
   - Save the keystore file securely
   - Remember the password and alias name

2. **Create `keystore.properties` file** in the project root:
   ```properties
   storePassword=your_store_password
   keyPassword=your_key_password
   keyAlias=pond-key
   storeFile=pond-release-key.jks
   ```

3. **Update `app/build.gradle`** to add signing config:
   ```gradle
   android {
       signingConfigs {
           release {
               def keystorePropertiesFile = rootProject.file("keystore.properties")
               def keystoreProperties = new Properties()
               keystoreProperties.load(new FileInputStream(keystorePropertiesFile))
               
               storeFile file(keystoreProperties['storeFile'])
               storePassword keystoreProperties['storePassword']
               keyAlias keystoreProperties['keyAlias']
               keyPassword keystoreProperties['keyPassword']
           }
       }
       
       buildTypes {
           release {
               signingConfig signingConfigs.release
               minifyEnabled false
               proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
           }
       }
   }
   ```

4. **Build Release APK:**
   - Go to **Build → Generate Signed Bundle / APK**
   - Select **APK**
   - Choose your keystore file
   - Enter passwords
   - Select **release** build variant
   - Click **Finish**
   - APK will be in: `app/build/outputs/apk/release/app-release.apk`

### Option 3: Build Android App Bundle (AAB) - For Google Play Store
1. Go to **Build → Generate Signed Bundle / APK**
2. Select **Android App Bundle**
3. Follow the same signing process as above
4. AAB will be in: `app/build/outputs/bundle/release/app-release.aab`

**Note:** AAB is the preferred format for Google Play Store (smaller file size, optimized delivery)

## Command Line Build (Alternative)

If you prefer command line:

```bash
# Navigate to project directory
cd /path/to/Pond

# Build debug APK
./gradlew assembleDebug

# Build release APK (requires signing config)
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug
```

**APK Location:** `app/build/outputs/apk/debug/app-debug.apk` or `app/build/outputs/apk/release/app-release.apk`

## Troubleshooting

### Gradle Sync Failed
- **Solution:** Go to **File → Invalidate Caches / Restart → Invalidate and Restart**

### SDK Not Found
- **Solution:** Go to **File → Project Structure → SDK Location** and set correct path

### Build Errors
- **Solution:** Clean and rebuild: **Build → Clean Project**, then **Build → Rebuild Project**

### Emulator Too Slow
- **Solution:** 
  - Enable hardware acceleration (HAXM or Hypervisor)
  - Increase emulator RAM in AVD settings
  - Use a physical device for faster testing

### Out of Memory Errors
- **Solution:** Increase Gradle memory in `gradle.properties`:
  ```properties
  org.gradle.jvmargs=-Xmx4096m -Dfile.encoding=UTF-8
  ```

## Quick Reference

### Essential Android Studio Shortcuts:
- **Run:** `Shift + F10` (Windows/Linux) or `Ctrl + R` (Mac)
- **Build:** `Ctrl + F9` (Windows/Linux) or `Cmd + F9` (Mac)
- **Sync Project:** `Ctrl + Shift + O` (Windows/Linux) or `Cmd + Shift + O` (Mac)
- **Find:** `Ctrl + F` (Windows/Linux) or `Cmd + F` (Mac)

### Project Structure:
```
Pond/
├── app/
│   ├── build.gradle          # App build configuration
│   ├── src/
│   │   └── main/
│   │       ├── java/         # Kotlin source code
│   │       ├── res/          # Resources (images, strings, etc.)
│   │       └── AndroidManifest.xml
├── build.gradle              # Project build configuration
└── gradle.properties         # Gradle settings
```

## Next Steps

1. ✅ Install Android Studio
2. ✅ Install JDK 17
3. ✅ Configure Android SDK
4. ✅ Create an AVD
5. ✅ Run the app
6. ✅ Build and test on physical device
7. ✅ Generate signing key for release
8. ✅ Build release APK/AAB

## Resources

- [Android Studio Official Documentation](https://developer.android.com/studio/intro)
- [Android Developer Guide](https://developer.android.com/guide)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)

## Support

If you encounter issues:
1. Check Android Studio's **Build** output window for error messages
2. Check **Logcat** for runtime errors
3. Verify all SDK components are installed correctly
4. Ensure Java 17 is properly configured

---

**Happy Coding! 🚀**

