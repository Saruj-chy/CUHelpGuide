package com.sd.saruj.cuhelpguide.Activity.ModelQuestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.sd.saruj.cuhelpguide.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        TextView scoreTxtView = (TextView) findViewById(R.id.score);
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar1);
        ImageView img = (ImageView)findViewById(R.id.img1);
        Button showAnswer = findViewById(R.id.btn);





        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        final String name = b.getString("name");
        final String modelname = b.getString("name1");
        ratingBar.setRating(score);
        scoreTxtView.setText(String.valueOf(score));



        if(score == 0){
            img.setImageResource(R.drawable.score_0);
        }else if(score == 1){
            img.setImageResource(R.drawable.score_1);
        }else if(score == 2){
            img.setImageResource(R.drawable.score_2);
        }else if(score == 3){
            img.setImageResource(R.drawable.score_3);
        }else if(score == 4){
            img.setImageResource(R.drawable.score_4);
        }else if(score >= 5){
            img.setImageResource(R.drawable.score_5);
        }


     /*   showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShowAnswerActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("name1",modelname);
                startActivity(intent);
            }
        });*/
    }
}
