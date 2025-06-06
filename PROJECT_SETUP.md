# 🛠️ Code-Quanta Developer Setup Guide

> **Quick Start**: See [README.md](README.md) for project overview and basic setup

This guide provides detailed technical setup instructions for developers contributing to Code-Quanta.

---

## 🔧 Development Environment Setup

### Required Software & Versions
- **Android Studio**: Latest stable (Hedgehog 2023.1.1 or newer)
- **JDK**: 11 or higher (OpenJDK recommended)
- **Git**: Latest version
- **Gradle**: 8.10.1 (via wrapper)

### Environment Variables
```bash
# Windows
JAVA_HOME=C:\Program Files\Java\jdk-11
ANDROID_HOME=C:\Users\%USERNAME%\AppData\Local\Android\Sdk

# macOS/Linux
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home
export ANDROID_HOME=$HOME/Library/Android/sdk
```

---

## 🔥 Firebase Setup (Detailed)

### 1. Create Firebase Project
1. Go to [Firebase Console](https://console.firebase.google.com/)
2. Click "Create a project"
3. Enter project name: `code-quanta` (or your preferred name)
4. Enable Google Analytics (optional)
5. Select country/region

### 2. Configure Authentication
```bash
# Enable Authentication providers:
- Email/Password: ✅ Enabled
- Google Sign-In: ⏸️ Planned
- Anonymous: ⏸️ For offline mode
```

### 3. Setup Firestore Database
```javascript
// Security Rules
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Users can read/write their own data
    match /users/{userId} {
      allow read, write: if request.auth != null && request.auth.uid == userId;
    }
    
    // Quiz data is read-only for authenticated users
    match /quizzes/{document=**} {
      allow read: if request.auth != null;
    }
  }
}
```

### 4. Database Structure
```
firestore/
├── users/
│   └── {userId}/
│       ├── email: string
│       ├── displayName: string
│       ├── createdAt: timestamp
│       └── scores/
│           └── {quizId}/
│               ├── score: number
│               ├── totalQuestions: number
│               ├── correctAnswers: number
│               ├── timeTaken: number
│               └── completedAt: timestamp
├── quizzes/
│   └── {language}/
│       └── questions/
│           └── {questionId}/
│               ├── question: string
│               ├── options: array
│               ├── correctAnswer: string
│               ├── explanation: string
│               └── difficulty: string
└── app_config/
    └── settings/
        ├── minAppVersion: number
        └── maintenanceMode: boolean
```

---

## ⚙️ Build Configuration Details

### Gradle Properties
```properties
# gradle.properties
android.useAndroidX=true
android.enableJetifier=true
org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
org.gradle.parallel=true
org.gradle.caching=true
```

### Build Types
```kotlin
// app/build.gradle.kts
buildTypes {
    debug {
        applicationIdSuffix = ".debug"
        versionNameSuffix = "-DEBUG"
        isDebuggable = true
        isMinifyEnabled = false
    }
    
    release {
        isMinifyEnabled = true
        isShrinkResources = true
        proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro"
        )
        signingConfig = signingConfigs.getByName("release")
    }
}
```

---

## 🧪 Testing Configuration

### Unit Tests
```kotlin
// Example test structure
src/test/java/com/Archis/code_quanta/
├── models/
│   ├── QuestionTest.java
│   └── UserTest.java
├── utils/
│   ├── ScoreCalculatorTest.java
│   └── ValidatorTest.java
└── repositories/
    ├── AuthRepositoryTest.java
    └── QuizRepositoryTest.java
```

### Integration Tests
```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests="*.QuestionActivityTest"

# Generate test report
./gradlew test jacocoTestReport
```

---

## 🚨 Troubleshooting Guide

### Common Build Issues

#### 1. Gradle Sync Failed
```bash
# Solutions (try in order):
1. ./gradlew clean
2. File → Invalidate Caches and Restart
3. Delete .gradle/ folder and sync again
4. Check gradle-wrapper.properties version
```

#### 2. Firebase Configuration Issues
```bash
# Symptoms: google-services plugin errors
Solutions:
1. Verify google-services.json is in app/ directory
2. Check package name matches applicationId
3. Ensure google-services plugin is applied LAST in app/build.gradle.kts
```

#### 3. Java/Android SDK Issues
```bash
# Error: "Could not find or load main class"
Solutions:
1. Verify JAVA_HOME points to JDK (not JRE)
2. Check Android SDK path in local.properties
3. Update Android SDK tools via SDK Manager
```

#### 4. Memory Issues
```bash
# Error: "OutOfMemoryError"
Solutions:
1. Increase heap size in gradle.properties:
   org.gradle.jvmargs=-Xmx4g -XX:MaxMetaspaceSize=512m
2. Enable Gradle daemon:
   org.gradle.daemon=true
```

---

## 🔐 Security & Signing

### Debug Signing
```bash
# Debug keystore (auto-generated)
~/.android/debug.keystore
# Password: android
# Alias: androiddebugkey
```

### Release Signing
```bash
# Generate release keystore
keytool -genkey -v -keystore code-quanta-release.keystore \
        -alias code-quanta -keyalg RSA -keysize 2048 -validity 25000

# Add to gradle.properties (local only)
KEYSTORE_PATH=../code-quanta-release.keystore
KEYSTORE_PASSWORD=your_keystore_password
KEY_ALIAS=code-quanta
KEY_PASSWORD=your_key_password
```

---

## 📱 Device Testing

### Minimum Test Devices
- **Physical**: Any Android 10+ device
- **Emulator**: Pixel 4 (API 29), Pixel 6 (API 33)
- **Screen Sizes**: Phone (5"), Tablet (10")

### Testing Checklist
- [ ] App launches successfully
- [ ] Firebase Auth works (Sign up/Sign in)
- [ ] Quiz questions load properly
- [ ] Score calculation is correct
- [ ] Offline handling (graceful degradation)
- [ ] Back button navigation
- [ ] Screen rotation handling

---

## 🚀 Deployment Pipeline

### Pre-deployment Checklist
- [ ] All tests pass (`./gradlew test`)
- [ ] Code analysis clean (`./gradlew lint`)
- [ ] Version number updated
- [ ] Release notes prepared
- [ ] Firebase rules updated (if needed)

### Build Commands
```bash
# Debug build for testing
./gradlew assembleDebug

# Release build for production
./gradlew bundleRelease

# Install on connected device
./gradlew installDebug
```

---

## 📊 Code Quality Tools

### Static Analysis
```bash
# Lint checks
./gradlew lint

# Spotbugs (if configured)
./gradlew spotbugsMain

# Checkstyle (if configured)
./gradlew checkstyleMain
```

### Code Coverage
```bash
# Generate coverage report
./gradlew jacocoTestReport

# View report
open app/build/reports/jacoco/test/html/index.html
```

---

## 🔄 Git Workflow

### Branch Naming Convention
```bash
feature/add-kotlin-quiz
bugfix/auth-crash-fix
hotfix/critical-security-patch
release/v1.2.0
```

### Commit Message Format
```bash
type(scope): description

# Examples:
feat(auth): add Google Sign-In support
fix(quiz): resolve score calculation bug
docs(readme): update setup instructions
style(ui): improve button styling
```

---

## 📚 Useful Commands

### Development
```bash
# Clean build
./gradlew clean build

# Install and launch
./gradlew installDebug && adb shell am start -n com.Archis.code_quanta.debug/.SplashScreen

# View logs
adb logcat | grep "CodeQuanta"

# Clear app data
adb shell pm clear com.Archis.code_quanta.debug
```

### Debugging
```bash
# Enable USB debugging
adb devices

# Screenshot
adb exec-out screencap -p > screenshot.png

# Record screen
adb shell screenrecord /sdcard/demo.mp4
```

---

## 🆘 Getting Help

### Internal Resources
- [Architecture Decision Records](docs/adr/)
- [API Documentation](docs/api/)
- [UI Style Guide](docs/ui-guidelines.md)

### External Resources
- [Android Developer Docs](https://developer.android.com/)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Material Design Guidelines](https://material.io/design)

### Community Support
- [Stack Overflow - Android](https://stackoverflow.com/questions/tagged/android)
- [Reddit - r/androiddev](https://reddit.com/r/androiddev)
- [Android Dev Discord](https://discord.gg/android-dev)

---

**💡 Pro Tip**: Keep this guide updated as the project evolves. Consider automating common tasks with shell scripts or Gradle tasks.
- Firebase Storage
- Firebase Realtime Database

### UI Enhancements:
- CircularProgressBar (com.mikhaellopez:circularprogressbar:3.1.0)

---

## 🎯 Build Configurations

### Debug Build:
- MinSDK: 29 (Android 10)
- TargetSDK: 35 (Android 14)
- Java Version: 11
- Debugging enabled

### Release Build:
- Proguard optimization enabled
- Code shrinking enabled
- Debug info removed

---

## 🔥 Firebase Configuration

### Authentication:
- Email/Password sign-in enabled
- User profiles stored in Firestore

### Database Structure:
```
users/
  ├── userId/
      ├── email
      ├── name
      └── scores/
          └── quizResults
```

---

## 🚨 Common Issues & Solutions

### Gradle Sync Issues:
1. Check internet connection
2. Invalidate caches: File → Invalidate Caches and Restart
3. Update Gradle version in gradle-wrapper.properties

### Firebase Issues:
1. Verify google-services.json is in correct location
2. Check Firebase project configuration
3. Ensure all required Firebase services are enabled

### Build Errors:
1. Clean project: Build → Clean Project
2. Rebuild: Build → Rebuild Project
3. Check Java/Android SDK versions

---

## 📱 Testing

### Debug Testing:
```bash
./gradlew installDebug
```

### Run Tests:
```bash
./gradlew test
./gradlew connectedAndroidTest
```

---

## 🚀 Deployment

### Generate APK:
```bash
./gradlew assembleRelease
```

### Generate App Bundle (recommended):
```bash
./gradlew bundleRelease
```

---

## 📝 Development Notes

### Code Style:
- Follow Android coding conventions
- Use meaningful variable/method names
- Add comments for complex logic

### Git Workflow:
- Create feature branches for new functionality
- Use conventional commit messages
- Test before pushing changes

### Future Enhancements:
- [ ] Add more programming languages
- [ ] Implement difficulty levels
- [ ] Add timer functionality
- [ ] Create leaderboard system
- [ ] Add offline mode support

---

## 📞 Support

For setup issues or questions:
1. Check Android Studio logs
2. Review Firebase console errors
3. Consult Android documentation
4. Check Stack Overflow for common issues

---

**Happy Coding! 🎉**
