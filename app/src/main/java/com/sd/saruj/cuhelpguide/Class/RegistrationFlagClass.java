package com.sd.saruj.cuhelpguide.Class;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.sd.saruj.cuhelpguide.Interfaces.OnIntentInterface;

public class RegistrationFlagClass implements OnIntentInterface {

    Context context ;

    public RegistrationFlagClass(Context context) {
        this.context = context;
    }


    @Override
    public void onIntent(Object activity) {
        Toast.makeText(context, "Account created Successfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(context, (Class<?>) activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}
