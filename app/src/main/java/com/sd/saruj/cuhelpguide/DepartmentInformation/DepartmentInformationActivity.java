package com.sd.saruj.cuhelpguide.DepartmentInformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.sd.saruj.cuhelpguide.R;

import static com.sd.saruj.cuhelpguide.R.string.science_chemistry;

public class DepartmentInformationActivity extends AppCompatActivity {
    TextView departmentText;
    ImageView departmentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_information);


        Intent intent = getIntent();


       /* String SocialFaculty = intent.getExtras().getString("socialScience");
        String ArtsFaculty = intent.getExtras().getString("artsandHumanities");*/
        String FacultyName = intent.getExtras().getString("faculty");
        String departmentName = intent.getExtras().getString("department");





        departmentText = (TextView)findViewById(R.id.departmentText);
        departmentImage = (ImageView) findViewById(R.id.departmentImage);



        switch (FacultyName){
            case "Arts":
                switch (departmentName){
                    case "bangla":
                        departmentImage.setImageResource(R.drawable.arts);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_economic);
                    case "english":
                        departmentImage.setImageResource(R.drawable.arts);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_political);
                        break;
                    case "History":
                        departmentImage.setImageResource(R.drawable.arts);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_sociology);
                        break;
                    case "Philosopy":
                        departmentImage.setImageResource(R.drawable.arts);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_administration);
                        break;
                    case "IslamicHistory":
                        departmentImage.setImageResource(R.drawable.arts);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_economic);
                        break;
                }
                break;
            case "Social":
                switch (departmentName){
                    case "economic":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_economic);
                        break;
                    case "political":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_political);
                        break;
                    case "sociology":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_sociology);
                        break;
                    case "public":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_administration);
                        break;
                    case "journalism":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_journalism);
                        break;
                    case "PoliceScience":
                        departmentImage.setImageResource(R.drawable.social);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.social_criminology);
                        break;
                }
                break;
            case "Biology":
                switch (departmentName)
                {
                    case "zoology":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_zoology);
                        break;
                    case "botany":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_botany);
                        break;
                    case "pharmacy":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_pharmacy);
                        break;
                    case "biochemistry":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_biochemistry);
                        break;
                    case "microbiology":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_microbiology);
                        break;
                    case "soil":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_soil);
                        break;
                    case "genetic":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_genetic);
                        break;
                    case "psychology":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_psychology);
                        break;
                    case "geography":
                        departmentImage.setImageResource(R.drawable.biology);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.biology_geography);
                        break;
                }
                break;

            case "Business":
                switch (departmentName)
                {
                    case "accounting":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_account);
                        break;
                    case "management":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_management);
                        break;
                    case "finance":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_finance);
                        break;
                    case "marketing":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_marketing);
                        break;
                    case "humanResource":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_human);
                        break;
                    case "banking":
                        departmentImage.setImageResource(R.drawable.business);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.business_banking);
                        break;

                }
                break;
            case "Engineer":
                switch (departmentName)
                {
                    case "CSE":
                        departmentImage.setImageResource(R.drawable.engineer);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.engineer_cse);
                        break;
                    case "EEE":
                        departmentImage.setImageResource(R.drawable.engineer);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.engineer_eee);
                        break;


                }
                break;

            case "Forestry":
                switch (departmentName)
                {
                    case "forestry":
                        departmentImage.setImageResource(R.drawable.forestry);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.forestry_forestry);
                        break;
                    case "environment":
                        departmentImage.setImageResource(R.drawable.forestry);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.forestry_environmental);
                        break;


                }
                break;

            case "Marine":
                switch (departmentName)
                {
                    case "marine":
                        departmentImage.setImageResource(R.drawable.merine);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.marine_marine);
                        break;
                    case "fisharies":
                        departmentImage.setImageResource(R.drawable.merine);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.marine_fisharies);
                        break;


                }
                break;

            case "Science":
                switch (departmentName)
                {
                    case "physics":
                        departmentImage.setImageResource(R.drawable.science);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.science_physic);
                        break;
                    case "chemistry":
                        departmentImage.setImageResource(R.drawable.science);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(science_chemistry);
                        break;
                    case "mathematics":
                        departmentImage.setImageResource(R.drawable.science);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.science_mathematics);
                        break;
                    case "statistics":
                        departmentImage.setImageResource(R.drawable.science);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.science_statistics);
                        break;
                    case "appliedChemistry":
                        departmentImage.setImageResource(R.drawable.science);
                        departmentText.setText(DepartmentInformationClass.socialeconomic);
                        setTitle(R.string.science_appliedchemistry);
                        break;




                }
                break;
            case "Law":
                setTitle("Law");



        }



    }
}
