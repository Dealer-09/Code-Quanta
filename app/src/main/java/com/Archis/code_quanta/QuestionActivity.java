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
    int flag=0;
    int marks=0;
    static int correct=0;
    int wrong=0;
    String[] questions={
            "Which of the following modifiers CANNOT be used for a top-level class in Java?",
            "Which of the following is not true about Java memory model?",
            "Which one of these statements about interfaces is TRUE?",
            "Which of the following is true about Java's garbage collection?",
            "What is the default value of a local variable in Java?"
    };
    String[] options={
            "public","abstract","final","protected",
            "Local variables are stored on the stack","Objects are always created on the heap","final fields are always immutable"," Static fields belong to the class, not instances",
            "Interfaces can have constructors","An interface can extend multiple interfaces","An interface can implement another interface","All methods in interfaces must be abstract",
            "It guarantees no memory leaks","Objects are immediately destroyed when there are no references","finalize() is always called before an object is collected","Garbage collection can never be forced",
            "0","null","Depends on the type","It has no default value",
    };
    String[] answer={
            "protected",
            "final fields are always immutable",
            "An interface can extend multiple interfaces",
            "Garbage collection can never be forced",
            "It has no default value",
    };

    TextView quitBtn,dispNo,question,score;
    Button next;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

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

        // Initialize views
        quitBtn=findViewById(R.id.quitBtn);
        question=findViewById(R.id.questions);
        dispNo=findViewById(R.id.dispNo);
        score=findViewById(R.id.score);
        next=findViewById(R.id.nextBtn);
        radio_g=findViewById(R.id.answerGroup);
        rb1=findViewById(R.id.rabioBtn1);
        rb2=findViewById(R.id.rabioBtn2);
        rb3=findViewById(R.id.rabioBtn3);
        rb4=findViewById(R.id.rabioBtn4);

        // Load first question
        loadQuestion();        next.setOnClickListener(new View.OnClickListener() {
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
                if(selectedAnswer.equals(answer[flag])){
                    correct++;
                    Toast.makeText(QuestionActivity.this, "Correct! Well done!", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(QuestionActivity.this, "Wrong! The correct answer was: " + answer[flag], Toast.LENGTH_LONG).show();
                }

                // Move to next question
                flag++;

                // Update score display
                if(score != null){
                    score.setText(String.valueOf(correct));
                }

                // Load next question or finish quiz
                if(flag < questions.length) {
                    loadQuestion();
                } else {
                    // Quiz finished - go to results
                    marks = correct;
                    Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                    intent.putExtra("attempted", flag);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
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
                startActivity(intent);
                finish();
            }
        });
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
