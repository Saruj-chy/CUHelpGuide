package com.sd.saruj.cuhelpguide.controller.Activity.ModelQuestion.ModelTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sd.saruj.cuhelpguide.controller.Activity.ModelQuestion.ModelDD.DBBuildChain;
import com.sd.saruj.cuhelpguide.controller.Activity.ModelQuestion.ModelDD.DBHandler;
import com.sd.saruj.cuhelpguide.model.QuestionModel;
import com.sd.saruj.cuhelpguide.R;

import java.util.Collections;
import java.util.List;

public class ModelQuestionActivity extends AppCompatActivity {


    List<QuestionModel> questionList;

    int quid = 0;
    String name, modelName;
    QuestionModel currentQuestion1, currentQuestion2, currentQuestion3, currentQuestion4, currentQuestion5, currentQuestion6 ;

    TextView txtQuestion1, txtQuestion2, txtQuestion3, txtQuestion4, txtQuestion5, txtQuestion6;
    RadioButton rda0,rdb1,rdc2,  rda10,rdb11,rdc12,  rda20,rdb21,rdc22,   rda30,rdb31,rdc32,  rda40,rdb41,rdc42,  rda50,rdb51,rdc52;
    Button butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_question);

        Intent intent = getIntent();
        name = intent.getStringExtra("name").toLowerCase().trim();
//        modelName = intent.getStringExtra("name1").toLowerCase().trim();


//        setTitle(modelName);
//        if(questionList.size()>0){
//            questionList.clear();
//        }

        DBHandler dbHandler = new DBBuildChain(getApplicationContext()).createChain() ;
        questionList = dbHandler.process(name);


//        switch (name){
//            case "model1":
//                setTitle(modelName);
//                DbHelper dbHelper = new DbHelper(this);
//                questionList = dbHelper.getAllQuestions();
//                break;
//
//            case "model2":
//                setTitle(modelName);
//                DbHelper2 dbHelper2 = new DbHelper2(this);
//                questionList = dbHelper2.getAllQuestions();
//                break;
//
//        }




        Collections.shuffle(questionList);

        currentQuestion1 = questionList.get(quid);
        currentQuestion2 = questionList.get(quid+1);
        currentQuestion3 = questionList.get(quid+2);
        currentQuestion4 = questionList.get(quid+3);
        currentQuestion5 = questionList.get(quid+4);
        currentQuestion6 = questionList.get(quid+5);




        txtQuestion1 = (TextView)findViewById(R.id.question);
        txtQuestion2 = (TextView)findViewById(R.id.question2);
        txtQuestion3 = (TextView)findViewById(R.id.question3);
        txtQuestion4 = (TextView)findViewById(R.id.question4);
        txtQuestion5 = (TextView)findViewById(R.id.question5);
        txtQuestion6 = (TextView)findViewById(R.id.question6);


        rda0 = (RadioButton)findViewById(R.id.radio0);
        rdb1 = (RadioButton)findViewById(R.id.radio1);
        rdc2 = (RadioButton)findViewById(R.id.radio2);

        rda10 = (RadioButton)findViewById(R.id.radio10);
        rdb11 = (RadioButton)findViewById(R.id.radio11);
        rdc12 = (RadioButton)findViewById(R.id.radio12);

        rda20 = (RadioButton)findViewById(R.id.radio20);
        rdb21 = (RadioButton)findViewById(R.id.radio21);
        rdc22 = (RadioButton)findViewById(R.id.radio22);

        rda30 = (RadioButton)findViewById(R.id.radio30);
        rdb31= (RadioButton)findViewById(R.id.radio31);
        rdc32 = (RadioButton)findViewById(R.id.radio32);

        rda40 = (RadioButton)findViewById(R.id.radio40);
        rdb41 = (RadioButton)findViewById(R.id.radio41);
        rdc42 = (RadioButton)findViewById(R.id.radio42);

        rda50 = (RadioButton)findViewById(R.id.radio50);
        rdb51 = (RadioButton)findViewById(R.id.radio51);
        rdc52 = (RadioButton)findViewById(R.id.radio52);

        butNext = (Button)findViewById(R.id.button1);
        setQuestionView();

        //btClick();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btClick();


            }
        });

    }


    private void setQuestionView(){
        txtQuestion1.setText(currentQuestion1.getQuestion());
        rda0.setText(currentQuestion1.getOptA());
        rdb1.setText(currentQuestion1.getOptB());
        rdc2.setText(currentQuestion1.getOptC());

        txtQuestion2.setText(currentQuestion2.getQuestion());
        rda10.setText(currentQuestion2.getOptA());
        rdb11.setText(currentQuestion2.getOptB());
        rdc12.setText(currentQuestion2.getOptC());

        txtQuestion3.setText(currentQuestion3.getQuestion());
        rda20.setText(currentQuestion3.getOptA());
        rdb21.setText(currentQuestion3.getOptB());
        rdc22.setText(currentQuestion3.getOptC());

        txtQuestion4.setText(currentQuestion4.getQuestion());
        rda30.setText(currentQuestion4.getOptA());
        rdb31.setText(currentQuestion4.getOptB());
        rdc32.setText(currentQuestion4.getOptC());

        txtQuestion5.setText(currentQuestion5.getQuestion());
        rda40.setText(currentQuestion5.getOptA());
        rdb41.setText(currentQuestion5.getOptB());
        rdc42.setText(currentQuestion5.getOptC());

        txtQuestion6.setText(currentQuestion6.getQuestion());
        rda50.setText(currentQuestion6.getOptA());
        rdb51.setText(currentQuestion6.getOptB());
        rdc52.setText(currentQuestion6.getOptC());
        //  quid++;
    }

    public void btClick(){

        RadioGroup grp1 = (RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton answer1 = (RadioButton)findViewById(grp1.getCheckedRadioButtonId());

        RadioGroup grp2 = (RadioGroup)findViewById(R.id.radioGroup2);
        RadioButton answer2 = (RadioButton)findViewById(grp2.getCheckedRadioButtonId());

        RadioGroup grp3 = (RadioGroup)findViewById(R.id.radioGroup3);
        RadioButton answer3 = (RadioButton)findViewById(grp3.getCheckedRadioButtonId());

        RadioGroup grp4 = (RadioGroup)findViewById(R.id.radioGroup4);
        RadioButton answer4 = (RadioButton)findViewById(grp4.getCheckedRadioButtonId());

        RadioGroup grp5 = (RadioGroup)findViewById(R.id.radioGroup5);
        RadioButton answer5 = (RadioButton)findViewById(grp5.getCheckedRadioButtonId());

        RadioGroup grp6 = (RadioGroup)findViewById(R.id.radioGroup6);
        RadioButton answer6 = (RadioButton)findViewById(grp6.getCheckedRadioButtonId());

        int score1 = 0, score2=0, score3=0,score4 = 0, score5=0, score6=0, score = 0;



        if(grp1.getCheckedRadioButtonId() != -1 ) {
            if (currentQuestion1.getAnswer().equals(answer1.getText())) {
                score1++;
                Log.d("Score", "Your score: " + score1);
                //   Toast.makeText(getApplicationContext(), "yes" + score, Toast.LENGTH_SHORT).show();

            }
        }
        if(grp2.getCheckedRadioButtonId() != -1 ) {
            if (currentQuestion2.getAnswer().equals(answer2.getText())) {
                score2++;
                Log.d("Score", "Your score: " + score2);
            }
        }
        if(grp3.getCheckedRadioButtonId() != -1 ) {
            if (currentQuestion3.getAnswer().equals(answer3.getText())) {
                score3++;
                Log.d("Score", "Your score: " + score3);
            }
        }
        if(grp4.getCheckedRadioButtonId() != -1 ) {
            if (currentQuestion4.getAnswer().equals(answer4.getText())) {
                score4++;
                Log.d("Score", "Your score: " + score4);
            }
        }
        if(grp5.getCheckedRadioButtonId() != -1 ) {
            if (currentQuestion5.getAnswer().equals(answer5.getText())) {
                score5++;
                Log.d("Score", "Your score: " + score5);

            }
        }
        if(grp6.getCheckedRadioButtonId() != -1 ) {

            if (currentQuestion6.getAnswer().equals(answer6.getText())) {
                score6++;
                Log.d("Score", "Your score: " + score6);
            }
        }


        score=score1+score2+score3+score4+score5+score6;
        Toast.makeText(getApplicationContext(), "yes"+score, Toast.LENGTH_SHORT).show();


      /*  if(quid<5){
            currentQuestion = questionList.get(quid);
            setQuestionView();
        }else{*/
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        Bundle b = new Bundle();
        b.putInt("score",score);
        intent.putExtras(b);
        intent.putExtra("name",name);
        intent.putExtra("name1",modelName);
        startActivity(intent);
        finish();
        // }


    }
}
