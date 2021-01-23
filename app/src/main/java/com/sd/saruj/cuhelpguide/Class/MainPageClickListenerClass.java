package com.sd.saruj.cuhelpguide.Class;

import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sd.saruj.cuhelpguide.Activity.AllUnitViewActivity;
import com.sd.saruj.cuhelpguide.Activity.ChoiceActivity;
import com.sd.saruj.cuhelpguide.Activity.FacultyNameActivity;
import com.sd.saruj.cuhelpguide.Activity.SubjectReviewActivity;
import com.sd.saruj.cuhelpguide.AdmisionNotice.NoticeListActivity;
import com.sd.saruj.cuhelpguide.Interfaces.MainPageInterfaces;
import com.sd.saruj.cuhelpguide.MainActivity;
import com.sd.saruj.cuhelpguide.R;

public class MainPageClickListenerClass implements MainPageInterfaces {
    Context context ;
    private BottomSheetBehavior sheetBehavior;


    public MainPageClickListenerClass(Context context) {
        this.context = context;
    }

    @Override
    public void OnClick(int position) {
        switch (position){
            case 0:
                onIntent(FacultyNameActivity.class);
                break;
            case 1:
                onIntent(AllUnitViewActivity.class);
                break;
            case 2:
                onIntent(ChoiceActivity.class);
                break;
            case 3:
                onIntent(SubjectReviewActivity.class);
                break;
            case 4:
                LinearLayout layoutBottomSheet = ((MainActivity)context).findViewById(R.id.bottom_sheet);
                sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);

                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }

                break;
            case 5:
                onIntent(NoticeListActivity.class);
                break;
            default:
                break;
        }

    }

    @Override
    public void onIntent(Object activity) {
        Intent intent = new Intent(context, (Class<?>) activity);
        context.startActivity(intent);
    }
}
