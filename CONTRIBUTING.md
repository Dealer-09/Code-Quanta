# 🤝 Contributing to Code-Quanta

First off, thanks for taking the time to contribute! 🎉

The following is a set of guidelines for contributing to Code-Quanta. These are mostly guidelines, not rules. Use your best judgment, and feel free to propose changes to this document in a pull request.

---

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [How Can I Contribute?](#how-can-i-contribute)
- [Styleguides](#styleguides)
- [Development Setup](#development-setup)
- [Pull Request Process](#pull-request-process)

---

## 📜 Code of Conduct

This project and everyone participating in it is governed by our Code of Conduct. By participating, you are expected to uphold this code.

### Our Pledge
- Be respectful and inclusive
- Accept constructive criticism gracefully
- Focus on what is best for the community
- Show empathy towards other community members

---

## 🚀 How Can I Contribute?

### 🐛 Reporting Bugs

Before creating bug reports, please check the issue list as you might find out that you don't need to create one. When you are creating a bug report, please include as many details as possible:

**Bug Report Template:**
```markdown
**Describe the bug**
A clear and concise description of what the bug is.

**To Reproduce**
Steps to reproduce the behavior:
1. Go to '...'
2. Click on '....'
3. Scroll down to '....'
4. See error

**Expected behavior**
A clear and concise description of what you expected to happen.

**Screenshots**
If applicable, add screenshots to help explain your problem.

**Device Information:**
- Device: [e.g. Pixel 6]
- OS: [e.g. Android 13]
- App Version: [e.g. 1.0.0]

**Additional context**
Add any other context about the problem here.
```

### 💡 Suggesting Enhancements

Enhancement suggestions are tracked as GitHub issues. When creating an enhancement suggestion, include:

- Use a clear and descriptive title
- Provide a step-by-step description of the suggested enhancement
- Provide specific examples to demonstrate the steps
- Describe the current behavior and explain which behavior you expected to see
- Explain why this enhancement would be useful

### 🔧 Code Contributions

#### Areas Where We Need Help:
- 📱 New quiz questions for existing languages
- 🌐 Support for additional programming languages
- 🎨 UI/UX improvements
- 🔍 Bug fixes and performance improvements
- 📝 Documentation improvements
- 🧪 Test coverage expansion

---

## 🎨 Styleguides

### Java Styleguide
- Follow [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- Use meaningful variable and method names
- Add JavaDoc comments for public methods
- Keep methods focused and concise (max 20-30 lines)

#### Example:
```java
/**
 * Calculates the quiz score based on correct answers.
 * 
 * @param correctAnswers Number of correct answers
 * @param totalQuestions Total number of questions
 * @return Score percentage (0-100)
 */
public int calculateScore(int correctAnswers, int totalQuestions) {
    if (totalQuestions == 0) {
        return 0;
    }
    return (correctAnswers * 100) / totalQuestions;
}
```

### XML Styleguide
- Use meaningful IDs (e.g., `questionTextView`, `nextButton`)
- Group related attributes together
- Use proper indentation (4 spaces)
- Add comments for complex layouts

#### Example:
```xml
<!-- Main quiz question display -->
<TextView
    android:id="@+id/questionTextView"
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_marginHorizontal="16dp"
    android:textSize="18sp"
    android:textStyle="bold"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@+id/progressBar" />
```

### Git Commit Messages
- Use the present tense ("Add feature" not "Added feature")
- Use the imperative mood ("Move cursor to..." not "Moves cursor to...")
- Limit the first line to 72 characters or less
- Reference issues and pull requests liberally after the first line

#### Commit Message Format:
```
type(scope): description

[optional body]

[optional footer]
```

#### Types:
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, missing semi colons, etc)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

#### Examples:
```
feat(quiz): add timer functionality for questions

fix(auth): resolve Firebase sign-in crash on Android 10

docs(readme): update installation instructions

style(ui): improve button spacing in quiz interface
```

---

## 🛠️ Development Setup

### Prerequisites
1. Android Studio (latest stable version)
2. JDK 11 or higher
3. Git
4. Firebase account

### Local Development
1. **Fork the repository**
   ```bash
   # Clone your fork
   git clone https://github.com/YOUR_USERNAME/Code-Quanta.git
   cd Code-Quanta
   ```

2. **Set up Firebase**
   - Create a Firebase project
   - Download `google-services.json`
   - Place it in the `app/` directory

3. **Install dependencies**
   ```bash
   ./gradlew build
   ```

4. **Run the app**
   ```bash
   ./gradlew installDebug
   ```

### Testing
```bash
# Run unit tests
./gradlew test

# Run integration tests
./gradlew connectedAndroidTest

# Run lint checks
./gradlew lint
```

---

## 🔄 Pull Request Process

### Before You Submit

1. **Search existing PRs** to avoid duplicates
2. **Follow the styleguides** mentioned above
3. **Test your changes** thoroughly
4. **Update documentation** if needed
5. **Add tests** for new functionality

### PR Template

When creating a pull request, please include:

```markdown
## Description
Brief description of changes made.

## Type of Change
- [ ] Bug fix (non-breaking change which fixes an issue)
- [ ] New feature (non-breaking change which adds functionality)
- [ ] Breaking change (fix or feature that would cause existing functionality to not work as expected)
- [ ] Documentation update

## Testing
- [ ] I have tested these changes locally
- [ ] I have added tests that prove my fix is effective or that my feature works
- [ ] New and existing unit tests pass locally with my changes

## Screenshots (if applicable)
Add screenshots to help explain your changes.

## Checklist
- [ ] My code follows the style guidelines of this project
- [ ] I have performed a self-review of my own code
- [ ] I have commented my code, particularly in hard-to-understand areas
- [ ] I have made corresponding changes to the documentation
- [ ] My changes generate no new warnings
```

### Review Process

1. **Automated checks** must pass (CI/CD pipeline)
2. **Code review** by at least one maintainer
3. **Testing** on different devices/versions if applicable
4. **Documentation** review if docs were changed

### After Your PR is Merged

1. Delete your feature branch
2. Pull the latest changes from main
3. Consider if any follow-up issues need to be created

---

## 🏆 Recognition

Contributors will be recognized in:
- The project's README.md
- Release notes for significant contributions
- Special mentions in the app's About section

---

## 📞 Questions?

If you have questions about contributing, feel free to:
- Open an issue with the `question` label
- Reach out to the maintainers
- Join our community discussions

---

## 🎯 Good First Issues

Look for issues labeled with:
- `good first issue` - Good for newcomers
- `help wanted` - Extra attention is needed
- `beginner friendly` - Perfect for first-time contributors

---

Thank you for contributing to Code-Quanta! 🚀
