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
    int marks=0,correct=0,wrong=0;
    String[] questions={};
    String[] options={};
    String[] answer={};

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

        question.setText(questions[flag]);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(QuestionActivity.this, "Please Select An option", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uAnswer = findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uAnswer.getText().toString();
                if(ansText.equals(answer[flag])){
                    correct++;
                    Toast.makeText(QuestionActivity.this, "You've Done it", Toast.LENGTH_SHORT).show();

                }else {
                    wrong++;
                    Toast.makeText(QuestionActivity.this, "Emotional Damage!!", Toast.LENGTH_SHORT).show();
                }
                flag++;
                if(score!=null){
                    score.setText(correct);
                    if(flag<questions.length)
                    {
                        question.setText(questions[flag]);
                        rb1.setText(options[flag*4]);
                        rb2.setText(options[flag*4+1]);
                        rb3.setText(options[flag*4+2]);
                        rb4.setText(options[flag*4+3]);
                        dispNo.setText((flag+1)+"/"+questions.length);
                    }
                    else
                    {
                        //Intent Passing(Pass the values to next activity)
                        marks=correct;
                        Intent intent=new Intent(QuestionActivity.this,ResultActivity.class);
                        intent.putExtra("marks",marks);
                        intent.putExtra("correct",correct);
                        intent.putExtra("wrong",wrong);
                        startActivity(intent);
                        finish();
                    }
                    radio_g.clearCheck();
                }
            }

        });
        quitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuestionActivity.this,ResultActivity.class));
                finish();
            }
        });
    }
}