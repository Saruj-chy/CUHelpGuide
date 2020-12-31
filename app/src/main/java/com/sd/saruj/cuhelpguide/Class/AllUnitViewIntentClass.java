package com.sd.saruj.cuhelpguide.Class;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.sd.saruj.cuhelpguide.Interfaces.PutIntentInterface;

public class AllUnitViewIntentClass implements PutIntentInterface {

    Context context ;

    public AllUnitViewIntentClass(Context context) {
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
