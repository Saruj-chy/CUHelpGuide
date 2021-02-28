package com.sd.saruj.cuhelpguide.controller.Class;

import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sd.saruj.cuhelpguide.controller.Activity.AllUnitViewActivity;
import com.sd.saruj.cuhelpguide.controller.Activity.ChoiceActivity;
import com.sd.saruj.cuhelpguide.controller.Activity.FacultyNameActivity;
import com.sd.saruj.cuhelpguide.controller.Activity.SubjectReviewActivity;
import com.sd.saruj.cuhelpguide.controller.Activity.NoticeListActivity;
import com.sd.saruj.cuhelpguide.controller.Interfaces.MainPageInterfaces;
import com.sd.saruj.cuhelpguide.controller.Activity.MainActivity;
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
