package com.sd.saruj.cuhelpguide.controller.Class;

import android.content.Context;
import android.content.Intent;

import com.sd.saruj.cuhelpguide.controller.Interfaces.OnIntentInterface;

public class LoginFlagClass implements OnIntentInterface {

    Context context ;

    public LoginFlagClass(Context context) {
        this.context = context;
    }


    @Override
    public void onIntent(Object activity) {
//        Toast.makeText(context, "Account created Successfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(context, (Class<?>) activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}
