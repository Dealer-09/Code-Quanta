# 🧠 Code-Quanta

A quiz app to test programming knowledge across **8 languages** with **40 questions**.

![Android](https://img.shields.io/badge/Android-3DDC84?style=flat&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Firebase](https://img.shields.io/badge/Firebase-039BE5?style=flat&logo=Firebase&logoColor=white)

## 📱 Features

- 🔐 Firebase Authentication (Email/Password)
- 📊 Real-time scoring with instant feedback
- 🎨 Modern Material Design 3 UI
- 📱 Edge-to-edge dark theme

## 🚀 Supported Languages

| Language | Questions |
|----------|:---------:|
| Java | 5 |
| Kotlin | 5 |
| Python | 5 |
| JavaScript | 5 |
| C | 5 |
| C++ | 5 |
| Dart | 5 |
| Rust | 5 |

## �️ Tech Stack

- **Min SDK**: 29 (Android 10)
- **Target SDK**: 35 (Android 14)
- **Language**: Java 11
- **Backend**: Firebase Auth + Firestore
- **Build**: Gradle 8.10.1 (Kotlin DSL)

## ⚡ Quick Start

```bash
# Clone
git clone https://github.com/your-username/Code-Quanta.git

# Add Firebase config
# Place google-services.json in app/

# Build & Run
./gradlew installDebug
```

## 📁 Project Structure

```
app/src/main/java/com/Archis/code_quanta/
├── SplashScreen.java      # Animated intro
├── SignUp.java            # Registration
├── SignIn.java            # Login
├── MainActivity.java      # Language selection
├── QuestionActivity.java  # Quiz logic (all 40 questions)
└── ResultActivity.java    # Score display
```

## � Contributing

1. Fork → Branch → Code → Test → PR
2. Follow [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
3. Use conventional commits: `feat(quiz): add timer`

## 📄 License

MIT License - see [LICENSE](LICENSE)
