package com.sd.saruj.cuhelpguide.Activity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.sd.saruj.cuhelpguide.Class.RegistrationFlagClass;
import com.sd.saruj.cuhelpguide.Class.RegistrationIntentClass;
import com.sd.saruj.cuhelpguide.Interfaces.OnIntentInterface;
import com.sd.saruj.cuhelpguide.MainActivity;
import com.sd.saruj.cuhelpguide.ModelClass.Members;
import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;
import java.util.List;

import static com.sd.saruj.cuhelpguide.MainActivity.sharedSaved;

public class RegistrationActivity extends AppCompatActivity  {

    private EditText userFirstName, userLastName, userName, userEmail, userPassword, userConfirmPassword;
    private Button createAccountButton;
    private TextView alreadyHaveAccountLink;

    private FirebaseAuth mAuth;
    private FirebaseFirestore memberFireStore ;
    private CollectionReference memberRef ;
    String currentId;

    List<Members> members;

    private ProgressDialog loadingBar;

    //=========   sharedprefarence
    String SHARED_PREFS = "codeTheme";
    String state = "state";
    String getState ;
    SharedPreferences sharedPreferences;

    OnIntentInterface mInterface ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);


        mAuth = FirebaseAuth.getInstance();
        memberFireStore = FirebaseFirestore.getInstance() ;
        memberRef = memberFireStore.collection("Members");

        initialFields();

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateNewAccount();
            }
        });

        alreadyHaveAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInterface = new RegistrationIntentClass(getApplicationContext()) ;
                mInterface.onIntent(LoginActivity.class);
            }
        });

    }


    private void initialFields() {
        userFirstName = findViewById(R.id.register_first_name);
        userLastName = findViewById(R.id.register_last_name);
        userName = findViewById(R.id.register_UserName);
        userEmail = findViewById(R.id.register_email);
        userPassword = findViewById(R.id.register_password);
        userConfirmPassword = findViewById(R.id.register_confirm_password);
        createAccountButton = findViewById(R.id.register_button);
        alreadyHaveAccountLink = findViewById(R.id.already_account_link);
        loadingBar = new ProgressDialog(this);

        members = new ArrayList<>();
    }

    private void CreateNewAccount() {
        final String firstName = userFirstName.getText().toString();
        final String lastName = userLastName.getText().toString();
        final String username = userName.getText().toString();
        final String email = userEmail.getText().toString();
        final String password = userPassword.getText().toString();
        String confirm_password = userConfirmPassword.getText().toString();

        if(TextUtils.isEmpty(username)){
            Toast.makeText(getApplicationContext(), "Please enter your UserName..", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(), "Please enter your email..", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password) || TextUtils.isEmpty(confirm_password)){
            Toast.makeText(getApplicationContext(), "Please enter your password..", Toast.LENGTH_SHORT).show();
        }
        else if(password.length()<6){
            Toast.makeText(this, "Enter password above 6 digit", Toast.LENGTH_SHORT).show();
        }
        else if(!password.equals(confirm_password)){
            Toast.makeText(getApplicationContext(), "Your password is not match...", Toast.LENGTH_SHORT).show();
        }
        else{
            loadingBar.setTitle("Creating New Account");
            loadingBar.setMessage("Plaese wait, while we are creating new account for you...");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                currentId = mAuth.getCurrentUser().getUid() ;
                                Members member = new Members(currentId, firstName, lastName, username, email, password, "user") ;
                                sharedSaved(sharedPreferences, state, "user") ;

                                memberRef.document(currentId).set(member).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Clear();
//                                        SentRegisterToUserActivity();
                                        mInterface = new RegistrationFlagClass(getApplicationContext()) ;
                                        mInterface.onIntent(MainActivity.class);
                                        loadingBar.dismiss();
                                    }
                                }) ;

                            }
                            else{
                                String message = task.getException().toString();
                                Toast.makeText(RegistrationActivity.this, "Error: "+message, Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                        }
                    });
        }

    }
    private void Clear() {
        userFirstName.setText("");
        userLastName.setText("");
        userName.setText("");
        userEmail.setText("");
        userPassword.setText("");
        userConfirmPassword.setText("");
    }

//    private void SentRegisterToUserActivity() {
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//        finish();
//    }



}