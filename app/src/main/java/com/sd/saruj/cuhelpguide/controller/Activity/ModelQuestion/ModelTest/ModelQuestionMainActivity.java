package com.sd.saruj.cuhelpguide.controller.Activity.ModelQuestion.ModelTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sd.saruj.cuhelpguide.R;

public class ModelQuestionMainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_question_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  startActivity(new Intent(getApplicationContext(), MoelQuestionActivity.class));
                Intent intent = new Intent(getApplicationContext(), ModelQuestionActivity.class);
                intent.putExtra("name","model1");
                intent.putExtra("name1",btn1.getText());
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  startActivity(new Intent(getApplicationContext(), MoelQuestionActivity.class));
                Intent intent = new Intent(getApplicationContext(), ModelQuestionActivity.class);
                intent.putExtra("name","model2");
                intent.putExtra("name1",btn2.getText());
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ModelQuestionMainActivity.this, "Question not set Yet...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
