package com.sd.saruj.cuhelpguide.UploadPost;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.sd.saruj.cuhelpguide.R;

public class ShowPostActivity extends AppCompatActivity {

    TextView titleText, detailsText;
    String title, details, subjectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_post);

        titleText = findViewById(R.id.titleText);
        detailsText = findViewById(R.id.detailsText);

        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        details = intent.getStringExtra("details");
        subjectName = intent.getStringExtra("subjectName");

        Toolbar toolbar = findViewById(R.id.show_post_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(subjectName);

        titleText.setText(title);
        detailsText.setText(details);
    }
}
