package com.sd.saruj.cuhelpguide.Activity.ModelQuestion.PracticeTest;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;


import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;

public class ToggleButtonGroupTableLayout extends TableLayout {

    private RadioButton mActiveRadioButton;

    public ToggleButtonGroupTableLayout(Context context) {
        super(context);
    }

    public ToggleButtonGroupTableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public ArrayList<RadioButton> getChildren() {
        ArrayList<RadioButton> radioButtons = new ArrayList<>();
        int childCount = this.getChildCount();
      //  Toast.makeText(getContext(),"childcount"+childCount,Toast.LENGTH_SHORT).show();
        for(int i=0; i<childCount; i++) {

            TableRow tableRow = (TableRow) this.getChildAt(i);
            int rowChildCount = tableRow.getChildCount();
         //   Toast.makeText(getContext(),"rowchild"+rowChildCount,Toast.LENGTH_SHORT).show();
            int j=0;
         //   for(int j=0 ;j<rowChildCount; j++) {
            while(j<rowChildCount){
                View v = tableRow.getChildAt(j);
                if(v instanceof RadioButton) {
                    radioButtons.add((RadioButton) v);
                }
                j++;
            }
        }
        return radioButtons;
    }

    public void checkAnswer(final RadioButton rb, String answer, Context mContext) {
        if(mActiveRadioButton != null) {
            mActiveRadioButton.setChecked(false);
        }
        ((QuestionActivity) mContext).selectScore();
        int id = -1;
     //   rb.setChecked(true);
        if(rb.getText().equals(answer)) {
            setRadioButtonBackgroundColor(rb, R.color.transparent_green);
            ((QuestionActivity) mContext).updateScore();
        } else {
            setRadioButtonBackgroundColor(rb, R.color.transparent_red);
            for(RadioButton radioButton:getChildren()) {
                if(radioButton.getText().equals(answer)) {
                    setRadioButtonBackgroundColor(radioButton, R.color.transparent_green);
                    id = radioButton.getId();
                }
            }
        }
        ((QuestionActivity) mContext).displayScore();
      //  mActiveRadioButton = rb;
        for(RadioButton radioButton:getChildren()) {
            radioButton.setClickable(false);
            if(radioButton.getId() != rb.getId() && radioButton.getId() != id){
                setRadioButtonBackgroundColor(radioButton, R.color.transparent_grey);
                radioButton.setTextColor(getResources().getColor(R.color.transparent_black));
            }
        }

    }

    private void setRadioButtonBackgroundColor(RadioButton button, int colorId) {
        button.getBackground().setColorFilter(Color.parseColor(getContext().getString(colorId)), PorterDuff.Mode.MULTIPLY);
    }
}
