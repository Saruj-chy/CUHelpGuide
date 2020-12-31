package com.sd.saruj.cuhelpguide.Class;

import android.content.Context;
import android.content.Intent;

import com.sd.saruj.cuhelpguide.Interfaces.OnIntentInterface;

public class LoginIntentClass implements OnIntentInterface {

    Context context ;

    public LoginIntentClass(Context context) {
        this.context = context;
    }


    @Override
    public void onIntent(Object activity) {
        Intent intent = new Intent(context, (Class<?>) activity);
        context.startActivity(intent);
    }
}
