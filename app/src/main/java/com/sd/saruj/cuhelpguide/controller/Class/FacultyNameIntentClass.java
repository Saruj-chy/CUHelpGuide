package com.sd.saruj.cuhelpguide.controller.Class;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sd.saruj.cuhelpguide.controller.Interfaces.PutIntentInterface;

public class FacultyNameIntentClass implements PutIntentInterface {

    Context context ;

    public FacultyNameIntentClass(Context context) {
        this.context = context;
    }

    @Override
    public void onIntent( Object activity, String name, String value) {
        Log.e("TAG", "name: "+name) ;
        Intent intent = new Intent(context, (Class<?>) activity);
        intent.putExtra(name, value);
        context.startActivity(intent);
    }
}
