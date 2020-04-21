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

import com.google.android.material.navigation.NavigationView;
import com.sd.saruj.cuhelpguide.ModelQuestion.ModelQuestionMainActivity;
import com.sd.saruj.cuhelpguide.ModelQuestion.PracticeTest.PracticeTestActivity;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities.AllUnitActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;
    TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.header);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
        R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        appName = (TextView) findViewById(R.id.appName);


        appName.setText("CU Help Guide");


    }





@Override
public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
        }

@Override
public boolean onNavigationItemSelected(MenuItem item) {

        String itemName = (String) item.getTitle();

       // tvInfo.setText(itemName);

        closeDrawer();

        switch (item.getItemId()){
        case R.id.item_a:
        startActivity(new Intent(this, Faculty_MainActivity.class));
        break;
        case R.id.item_b:
            startActivity(new Intent(this, AllUnitActivity.class));
            break;
        case R.id.item_c:
                startActivity(new Intent(this, ModelQuestionMainActivity.class));
                break;
        case R.id.item_d:
                startActivity(new Intent(this, PracticeTestActivity.class));
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
