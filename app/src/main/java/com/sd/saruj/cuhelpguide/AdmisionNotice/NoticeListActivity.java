package com.sd.saruj.cuhelpguide.AdmisionNotice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.List;

public class NoticeListActivity extends AppCompatActivity {

    private RecyclerView noticeRecyclerList;
    private Toolbar noticeToolbar;

    public static List<Faculty> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_list);

        noticeToolbar = findViewById(R.id.notice_list_toolbar);
        setSupportActionBar(noticeToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Admission Notice List");

        noticeRecyclerList = findViewById(R.id.noticeRecyclerView) ;

        list = new ArrayList<>();
        list.add(new Faculty("Social Science pdf","https://drive.google.com/file/d/1iAuJjQ5NmDEJuRzEjVeySAfxdJLRXG1t/view"));
        list.add(new Faculty("মুজিব বর্ষ উদযাপন ", "https://drive.google.com/file/d/1VL7NyO6E6rl75cq8QKPY0dJMeW56RM5j/view"));
        list.add(new Faculty("Leaveing Application","https://drive.google.com/file/d/154KW7tmDlvJbFfmnDYsfimQ-7u6BfYpw/view"));
        list.add(new Faculty("Higher Study in Abroad","https://drive.google.com/file/d/1IE980vynBJ5pmPcl10ympOw4rdN9PdA7/view?usp=sharing"));
        list.add(new Faculty("Engineering Admission","https://drive.google.com/file/d/1DStvAPzv5QqXm471Zjv2hpCsLDppcyBX/view"));
        list.add(new Faculty("Varsity days event","https://drive.google.com/file/d/1EynJB8-UDLdPPIZWKnRewCozExq6qmad/view"));
        list.add(new Faculty("d unit all news","https://drive.google.com/file/d/1K9upxXuercvjCY6dZd1gt4-ttDWYhG6u/view"));

        noticeRecyclerList.setLayoutManager(new GridLayoutManager(this,1));


        NoticeClickListener itemClickListener = new NoticeClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(NoticeListActivity.this,NoticeViewActivity.class);
                //intent.putExtra("url",list.get(position).getPdfUrl());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };


        NoticeListAdapter adapter = new NoticeListAdapter(list,this,itemClickListener);
        noticeRecyclerList.setAdapter(adapter);


    }
}
