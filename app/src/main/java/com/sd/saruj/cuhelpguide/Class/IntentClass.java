package com.sd.saruj.cuhelpguide.Class;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sd.saruj.cuhelpguide.Interfaces.ExtraIntentInterface;
import com.sd.saruj.cuhelpguide.Interfaces.IntentInterface;

public class IntentClass implements IntentInterface {

    Context context ;

    public IntentClass(Context context) {
        this.context = context;
    }


    @Override
    public void onIntent(Object activity) {
        Intent intent = new Intent(context, (Class<?>) activity);
        context.startActivity(intent);
    }
}
