package com.sd.saruj.cuhelpguide.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sd.saruj.cuhelpguide.R;

public class ChoiceActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                createPopDialog();
            }
        });
    }

    private void createPopDialog() {
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.choice_dialog, null);
        final Spinner unitSpin = view.findViewById(R.id.unit_Spinner);
        final Spinner grpSpin = view.findViewById(R.id.grp_Spinner);
        final RelativeLayout grpRelative = view.findViewById(R.id.grpRelative);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();

        unitSpin.setAdapter(new ArrayAdapter<String>(ChoiceActivity.this,R.layout.choice_list_color,
                R.id.dropdown,getResources().getStringArray(R.array.all_unit)));

        unitSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedClass = parent.getItemAtPosition(position).toString();

                switch (selectedClass){
                    case "A Unit":
                        grpSpin.setAdapter(new ArrayAdapter<String>(ChoiceActivity.this, R.layout.choice_list_color,
                                R.id.dropdown, getResources().getStringArray(R.array.a_unit)));
                        grpRelative.setVisibility(View.VISIBLE);
                        break;

                    case "All Unit":
                        grpRelative.setVisibility(View.GONE);
                        break;


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        grpSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedClass = parent.getItemAtPosition(position).toString();
                Intent intent = new Intent(getApplicationContext(), ChoiceListActivity.class);
                switch (selectedClass) {
                    case "Engineer":
//                        startActivity(new Intent(getApplicationContext(), ChoiceListActivity.class));
                        intent.putExtra("subCategory","Engineer");
                        startActivity(intent);
                        break;
                    case "Biology":
                        intent.putExtra("subCategory","Biology");
                        startActivity(intent);
                        break;


                }

               /* Snackbar.make(view, "Choice saved!", Snackbar.LENGTH_LONG).show();
                // Log.d("Item Added ID:", String.valueOf(db.getGroceriesCount()));
                 new Handler().postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         dialog.dismiss();
                         //start a new activity
                         //  startActivity(new Intent(ChoiceActivity.this, ListActivity.class));
                           }
                     }, 1200); //  1 second.*/


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }
}
