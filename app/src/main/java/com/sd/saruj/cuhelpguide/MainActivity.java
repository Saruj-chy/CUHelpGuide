package com.sd.saruj.cuhelpguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.sd.saruj.cuhelpguide.Choice.ChoiceActivity;
import com.sd.saruj.cuhelpguide.Faculty.Faculty;
import com.sd.saruj.cuhelpguide.Faculty.FacultyNameActivity;
import com.sd.saruj.cuhelpguide.ModelQuestion.ModelQuestionMainActivity;
import com.sd.saruj.cuhelpguide.ModelQuestion.PracticeTest.PracticeTestActivity;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities.AllUnitViewActivity;
import com.sd.saruj.cuhelpguide.UploadPost.DepartmentPostActivity;
import com.sd.saruj.cuhelpguide.UploadPost.UpploadPostActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    TextView appName;
    ActionBarDrawerToggle drawerToggle;

    RecyclerView recyclerList;
    List<Faculty> mainToolsList;
    String[] mainToolsName = {
            "Faculty Information",
            "Subject Pre-Requirement",
            "Subject Choice",
            "Subject Review",
            "Question and Test",
            "Admission Notice"
    };



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
            mainToolsList.add(
                    new Faculty(
                            i+1,
                            mainToolsName[i]
                    )
            );
        }

        MainPageRecyclerAdapter adapter = new MainPageRecyclerAdapter(this, mainToolsList);
        recyclerList.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerList.setLayoutManager(manager);

        navigationView.setNavigationItemSelectedListener(this);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
        R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

//        appName = (TextView) findViewById(R.id.appName);
//        appName.setText("CU Help Guide");


    }



@Override
public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
        }

@Override
public boolean onNavigationItemSelected(MenuItem item) {

        String itemName = (String) item.getTitle();

       // tvInfo.setText(itemName);

        closeDrawer();

        switch (item.getItemId()){
        case R.id.item_a:
        startActivity(new Intent(this, FacultyNameActivity.class));
        break;
        case R.id.item_b:
            startActivity(new Intent(this, AllUnitViewActivity.class));
            break;
        case R.id.item_c:
                startActivity(new Intent(this, ModelQuestionMainActivity.class));
                break;
        case R.id.item_d:
                startActivity(new Intent(this, PracticeTestActivity.class));
                break;
        case R.id.item_e:
                startActivity(new Intent(this, ChoiceActivity.class));
                break;
        case R.id.item_f:
                startActivity(new Intent(this, UpploadPostActivity.class));
                break;
            case R.id.item_g:
                startActivity(new Intent(this, DepartmentPostActivity.class));
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
}
