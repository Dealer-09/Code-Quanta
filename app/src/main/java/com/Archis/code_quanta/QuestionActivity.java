package com.Archis.code_quanta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestionActivity extends AppCompatActivity {
    int flag = 0;
    int marks = 0;
    static int correct = 0;
    int wrong = 0;
    String currentLanguage = "Java";

    // Current question set (will be loaded based on language)
    String[] questions;
    String[] options;
    String[] answer;

    // ==================== JAVA QUESTIONS ====================
    String[] javaQuestions = {
            "Which of the following modifiers CANNOT be used for a top-level class in Java?",
            "Which of the following is not true about Java memory model?",
            "Which one of these statements about interfaces is TRUE?",
            "Which of the following is true about Java's garbage collection?",
            "What is the default value of a local variable in Java?"
    };
    String[] javaOptions = {
            "public", "abstract", "final", "protected",
            "Local variables are stored on the stack", "Objects are always created on the heap",
            "final fields are always immutable", " Static fields belong to the class, not instances",
            "Interfaces can have constructors", "An interface can extend multiple interfaces",
            "An interface can implement another interface", "All methods in interfaces must be abstract",
            "It guarantees no memory leaks", "Objects are immediately destroyed when there are no references",
            "finalize() is always called before an object is collected", "Garbage collection can never be forced",
            "0", "null", "Depends on the type", "It has no default value",
    };
    String[] javaAnswer = {
            "protected",
            "final fields are always immutable",
            "An interface can extend multiple interfaces",
            "Garbage collection can never be forced",
            "It has no default value",
    };

    // ==================== KOTLIN QUESTIONS ====================
    String[] kotlinQuestions = {
            "Which keyword is used to define a variable that can be reassigned in Kotlin?",
            "What is the correct way to declare a nullable type in Kotlin?",
            "Which function is used to safely call a method on a nullable object?",
            "What is the purpose of the 'data' keyword before a class in Kotlin?",
            "Which of the following is NOT a visibility modifier in Kotlin?"
    };
    String[] kotlinOptions = {
            "val", "var", "const", "let",
            "String!", "String?", "String*", "Nullable<String>",
            "safeCall()", "?.", "!!", ".?",
            "Makes the class abstract", "Automatically generates equals(), hashCode(), toString()",
            "Makes the class serializable", "Prevents inheritance",
            "public", "private", "protected", "static",
    };
    String[] kotlinAnswer = {
            "var",
            "String?",
            "?.",
            "Automatically generates equals(), hashCode(), toString()",
            "static",
    };

    // ==================== PYTHON QUESTIONS ====================
    String[] pythonQuestions = {
            "Which of the following is used to define a function in Python?",
            "What will be the output of: print(type([]))?",
            "Which method is used to add an element to the end of a list?",
            "What is the correct way to create a dictionary in Python?",
            "Which of the following is NOT a valid Python data type?"
    };
    String[] pythonOptions = {
            "function", "def", "func", "define",
            "<class 'array'>", "<class 'list'>", "<class 'tuple'>", "<class 'set'>",
            "add()", "insert()", "append()", "push()",
            "dict = {}", "dict = []", "dict = dict()", "Both A and C",
            "list", "tuple", "array", "dictionary",
    };
    String[] pythonAnswer = {
            "def",
            "<class 'list'>",
            "append()",
            "Both A and C",
            "array",
    };

    // ==================== JAVASCRIPT QUESTIONS ====================
    String[] javascriptQuestions = {
            "Which company developed JavaScript?",
            "Which of the following is used to declare a constant in JavaScript?",
            "What will typeof null return?",
            "Which method is used to parse a JSON string in JavaScript?",
            "What is the correct syntax for an arrow function?"
    };
    String[] javascriptOptions = {
            "Microsoft", "Sun Microsystems", "Netscape", "Google",
            "var", "let", "const", "constant",
            "null", "undefined", "object", "NaN",
            "JSON.stringify()", "JSON.parse()", "JSON.convert()", "JSON.decode()",
            "=> function()", "function => ()", "() => {}", "-> () {}",
    };
    String[] javascriptAnswer = {
            "Netscape",
            "const",
            "object",
            "JSON.parse()",
            "() => {}",
    };

    // ==================== C QUESTIONS ====================
    String[] cQuestions = {
            "Who developed the C programming language?",
            "Which header file is required for printf() function?",
            "What is the size of int data type in C (on most 32-bit systems)?",
            "Which operator is used to access the address of a variable?",
            "What is the correct way to declare a pointer in C?"
    };
    String[] cOptions = {
            "James Gosling", "Bjarne Stroustrup", "Dennis Ritchie", "Guido van Rossum",
            "<stdlib.h>", "<stdio.h>", "<string.h>", "<conio.h>",
            "2 bytes", "4 bytes", "8 bytes", "Depends on compiler",
            "*", "&", "#", "@",
            "int ptr;", "int *ptr;", "*int ptr;", "ptr int*;",
    };
    String[] cAnswer = {
            "Dennis Ritchie",
            "<stdio.h>",
            "4 bytes",
            "&",
            "int *ptr;",
    };

    // ==================== C++ QUESTIONS ====================
    String[] cppQuestions = {
            "Which of the following is used for single-line comments in C++?",
            "What is the correct way to create an object in C++?",
            "Which keyword is used to inherit a class in C++?",
            "What is the purpose of the 'virtual' keyword in C++?",
            "Which operator is used for dynamic memory allocation in C++?"
    };
    String[] cppOptions = {
            "/* */", "//", "#", "<!-- -->",
            "MyClass obj();", "MyClass obj = new MyClass();", "MyClass obj;", "create MyClass obj;",
            "extends", "implements", "inherits", "::",
            "To define abstract methods", "To enable runtime polymorphism", "To make a function inline",
            "To prevent inheritance",
            "malloc", "alloc", "new", "create",
    };
    String[] cppAnswer = {
            "//",
            "MyClass obj;",
            "::",
            "To enable runtime polymorphism",
            "new",
    };

    // ==================== DART QUESTIONS ====================
    String[] dartQuestions = {
            "Which company developed Dart programming language?",
            "What keyword is used to declare a variable with type inference in Dart?",
            "Which symbol is used for string interpolation in Dart?",
            "What is the entry point function in a Dart program?",
            "Which of the following is used to define an asynchronous function in Dart?"
    };
    String[] dartOptions = {
            "Apple", "Microsoft", "Google", "Facebook",
            "let", "var", "auto", "dynamic",
            "#", "@", "$", "%",
            "start()", "init()", "main()", "run()",
            "async", "await", "future", "thread",
    };
    String[] dartAnswer = {
            "Google",
            "var",
            "$",
            "main()",
            "async",
    };

    // ==================== RUST QUESTIONS ====================
    String[] rustQuestions = {
            "What is the primary feature that Rust is known for?",
            "Which keyword is used to declare an immutable variable in Rust?",
            "What is the Rust equivalent of a class?",
            "Which symbol is used for the borrowing operator in Rust?",
            "What is the name of Rust's package manager?"
    };
    String[] rustOptions = {
            "Garbage collection", "Memory safety without GC", "Dynamic typing", "Interpreted execution",
            "var", "const", "let", "immut",
            "class", "struct", "object", "type",
            "*", "&", "@", "#",
            "npm", "pip", "cargo", "rustpkg",
    };
    String[] rustAnswer = {
            "Memory safety without GC",
            "let",
            "struct",
            "&",
            "cargo",
    };

    TextView quitBtn, dispNo, question, score;
    Button next;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the selected language from Intent
        Intent intent = getIntent();
        currentLanguage = intent.getStringExtra("language");
        if (currentLanguage == null) {
            currentLanguage = "Java"; // Default to Java
        }

        // Load questions based on selected language
        loadLanguageQuestions();

        // Initialize views
        quitBtn = findViewById(R.id.quitBtn);
        question = findViewById(R.id.questions);
        dispNo = findViewById(R.id.dispNo);
        score = findViewById(R.id.score);
        next = findViewById(R.id.nextBtn);
        radio_g = findViewById(R.id.answerGroup);
        rb1 = findViewById(R.id.rabioBtn1);
        rb2 = findViewById(R.id.rabioBtn2);
        rb3 = findViewById(R.id.rabioBtn3);
        rb4 = findViewById(R.id.rabioBtn4);

        // Load first question
        loadQuestion();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Use RadioGroup method (will work now with fixed XML)
                int checkedId = radio_g.getCheckedRadioButtonId();

                // Check if an option is selected
                if (checkedId == -1) {
                    Toast.makeText(QuestionActivity.this, "Please Select An option", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Get selected answer
                RadioButton selectedRadioButton = findViewById(checkedId);
                String selectedAnswer = selectedRadioButton.getText().toString();

                // Check if answer is correct
                if (selectedAnswer.equals(answer[flag])) {
                    correct++;
                    Toast.makeText(QuestionActivity.this, "Correct! Well done!", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(QuestionActivity.this, "Wrong! The correct answer was: " + answer[flag],
                            Toast.LENGTH_LONG).show();
                }

                // Move to next question
                flag++;

                // Update score display
                if (score != null) {
                    score.setText(String.valueOf(correct));
                }

                // Load next question or finish quiz
                if (flag < questions.length) {
                    loadQuestion();
                } else {
                    // Quiz finished - go to results
                    marks = correct;
                    Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                    intent.putExtra("attempted", flag);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    intent.putExtra("language", currentLanguage);
                    startActivity(intent);
                    finish();
                }
            }
        });

        quitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                intent.putExtra("attempted", flag);
                intent.putExtra("correct", correct);
                intent.putExtra("wrong", wrong);
                intent.putExtra("language", currentLanguage);
                startActivity(intent);
                finish();
            }
        });
    }

    // Method to load questions based on selected language
    private void loadLanguageQuestions() {
        switch (currentLanguage) {
            case "Java":
                questions = javaQuestions;
                options = javaOptions;
                answer = javaAnswer;
                break;
            case "Kotlin":
                questions = kotlinQuestions;
                options = kotlinOptions;
                answer = kotlinAnswer;
                break;
            case "Python":
                questions = pythonQuestions;
                options = pythonOptions;
                answer = pythonAnswer;
                break;
            case "JavaScript":
                questions = javascriptQuestions;
                options = javascriptOptions;
                answer = javascriptAnswer;
                break;
            case "C":
                questions = cQuestions;
                options = cOptions;
                answer = cAnswer;
                break;
            case "C++":
                questions = cppQuestions;
                options = cppOptions;
                answer = cppAnswer;
                break;
            case "Dart":
                questions = dartQuestions;
                options = dartOptions;
                answer = dartAnswer;
                break;
            case "Rust":
                questions = rustQuestions;
                options = rustOptions;
                answer = rustAnswer;
                break;
            default:
                questions = javaQuestions;
                options = javaOptions;
                answer = javaAnswer;
                break;
        }
    }

    // Method to load questions and clear previous selections
    private void loadQuestion() {
        // Clear any previous selection FIRST
        radio_g.clearCheck();

        // Set question text
        question.setText(questions[flag]);

        // Set option texts
        rb1.setText(options[flag * 4]);
        rb2.setText(options[flag * 4 + 1]);
        rb3.setText(options[flag * 4 + 2]);
        rb4.setText(options[flag * 4 + 3]);

        // Update question number display
        dispNo.setText((flag + 1) + "/" + questions.length);

        // Make sure all radio buttons are enabled and visible
        rb1.setEnabled(true);
        rb2.setEnabled(true);
        rb3.setEnabled(true);
        rb4.setEnabled(true);
    }
}
