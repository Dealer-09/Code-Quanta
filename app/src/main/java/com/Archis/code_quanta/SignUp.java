package com.Archis.code_quanta;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUp extends AppCompatActivity {
    EditText userName, userEmail, userPhone, password;
    Button register;
    TextView signIn;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userName= findViewById(R.id.userName);
        userEmail= findViewById(R.id.userEmail);
        userPhone= findViewById(R.id.userPhone);
        password= findViewById(R.id.password);
        register= findViewById(R.id.register);
        progressBar= findViewById(R.id.progressBar);
        signIn= findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, SignIn.class));
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mUserName=userName.getText().toString();
                String mEmail=userEmail.getText().toString().trim();
                String mPhone=userPhone.getText().toString().trim();
                String mPassword=password.getText().toString();

                if(TextUtils.isEmpty(mUserName)){
                    userName.setError("Please enter your name");
                    return;
                }
                if(TextUtils.isEmpty(mEmail)){
                    userEmail.setError("Please enter your mail");
                    return;
                }
                if(TextUtils.isEmpty(mPhone)){
                    userPhone.setError("Please enter your Phone number");
                    return;
                }
                if(TextUtils.isEmpty(mPassword)){
                    password.setError("Please enter your password");
                    return;
                }
                if(mPassword.length()<6)
                {
                    password.setError("Password Should Be Greater Than 6 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }
}