package com.sd.saruj.cuhelpguide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.sd.saruj.cuhelpguide.Activity.ChoiceActivity;
import com.sd.saruj.cuhelpguide.Activity.LoginActivity;
import com.sd.saruj.cuhelpguide.Activity.RetriveSubjectPostListActivity;
import com.sd.saruj.cuhelpguide.Activity.UpploadPostActivity;
import com.sd.saruj.cuhelpguide.Class.FacultyBuilderClass;
import com.sd.saruj.cuhelpguide.Activity.FacultyNameActivity;
import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.Activity.ModelQuestion.ModelQuestionMainActivity;
import com.sd.saruj.cuhelpguide.Activity.ModelQuestion.PracticeTest.PracticeTestActivity;
import com.sd.saruj.cuhelpguide.Activity.SubjectReviewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    TextView appName;
    ActionBarDrawerToggle drawerToggle;

    RecyclerView recyclerList;
    List<FacultyBuilderModel> mainToolsList;
    private MainPageRecyclerAdapter adapter ;
    String[] mainToolsName = {
            "Faculty Information",
            "Subject Pre-Requirement",
            "Subject Choice",
            "Subject Review",
            "Question and Test",
            "Admission Notice"
    };

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FacultyBuilderModel builderModel;


    private BottomSheetBehavior sheetBehavior;

    private AlertDialog.Builder dialogBuilder  ;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.main_page_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CU Help Guide");




        recyclerList = findViewById(R.id.main_page_recycler) ;
        recyclerList.setHasFixedSize(true);
        recyclerList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.header);

        mainToolsList = new ArrayList<>();


        for(int i=0; i<mainToolsName.length; i++){
            builderModel = new FacultyBuilderClass().setId(i+1).setName(mainToolsName[i]).build();
            mainToolsList.add(builderModel);
        }



        adapter = new MainPageRecyclerAdapter(this, mainToolsList);
        recyclerList.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerList.setLayoutManager(manager);

        navigationView.setNavigationItemSelectedListener(this);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
        R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        //for bottom Sheet
        getBottomSheet() ;

        //dialog
        dialogBuilder = new AlertDialog.Builder(this);

    }

    private void getBottomSheet() {
        TextView mPracticeText, mModelText;
        mPracticeText = findViewById(R.id.text_practice_bottom) ;
        mModelText = findViewById(R.id.text_model_bottom) ;

        mPracticeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PracticeTestActivity.class));
            }
        });

        mModelText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ModelQuestionMainActivity.class));
            }
        });

    }




    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        String itemName = (String) item.getTitle();

        // tvInfo.setText(itemName);

        closeDrawer();

        switch (item.getItemId()){
            case R.id.item_information:
                startActivity(new Intent(this, FacultyNameActivity.class));
                break;
            case R.id.item_review:
                startActivity(new Intent(this, SubjectReviewActivity.class));
                break;
            case R.id.item_choice:
                startActivity(new Intent(this, ChoiceActivity.class));
                break;
            case R.id.item_upload:
                startActivity(new Intent(this, UpploadPostActivity.class));
                break;
            case R.id.item_retrive:
                startActivity(new Intent(this, RetriveSubjectPostListActivity.class));
                break;
            case R.id.item_volunteer:
//                startActivity(new Intent(this, UpploadPostActivity.class));
                Toast.makeText(this, "Volunteer Student List", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_logout:
                mAuth.signOut();
                startActivity(new Intent(this, LoginActivity.class));
                break;


        }
        return false;
    }
    private void closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }
    private void openDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            closeDrawer();
        }
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        LinearLayout layoutBottomSheet = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    public static void sharedSaved(SharedPreferences sharedPreferences, String state, String memberState){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(state, memberState);
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.menu_about){
            createPopupDialog();
        }

        return super.onOptionsItemSelected(item);
    }
    private void createPopupDialog()
    {
        View view = getLayoutInflater().inflate(R.layout.popup_about, null);
        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();
    }
}
