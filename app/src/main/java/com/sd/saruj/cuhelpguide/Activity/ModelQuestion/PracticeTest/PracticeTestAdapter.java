package com.sd.saruj.cuhelpguide.Activity.ModelQuestion.PracticeTest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.R;

import java.util.ArrayList;

public class PracticeTestAdapter extends ArrayAdapter<PracticeTestItemModel> {

    static final String CATEGORY_COLOR = "CategoryColor";
    static final String CATEGORY_ID = "CategoryID";
    static final String CATEGORY_TITLE = "CategoryTitle";
    private Context mContext;
    private ArrayList<PracticeTestItemModel> mCategoryItems;

    PracticeTestAdapter(@NonNull Context context, int resource, @NonNull ArrayList<PracticeTestItemModel> categoryItems) {
        super(context, resource, categoryItems);
        this.mContext = context;
        this.mCategoryItems = categoryItems;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        CategoryViewHolder categoryViewHolder;
        final PracticeTestItemModel categoryItem = mCategoryItems.get(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.question_grid_view_item, parent, false);
            categoryViewHolder = new CategoryViewHolder(convertView);
            convertView.setTag(categoryViewHolder);
        }
        categoryViewHolder = (CategoryViewHolder) convertView.getTag();

        categoryViewHolder.categoryImage.setBackgroundColor(categoryItem.getmBgColor());
        categoryViewHolder.categoryTitle.setText(categoryItem.getmCategoryTitle());

//==================  all click in gridlayout
        categoryViewHolder.categoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent questionIntent = new Intent(mContext, QuestionActivity.class);
                questionIntent.putExtra(CATEGORY_ID, categoryItem.getmCategoryID());
                questionIntent.putExtra(CATEGORY_TITLE, categoryItem.getmCategoryTitle());
                questionIntent.putExtra(CATEGORY_COLOR, categoryItem.getmBgColor());
                mContext.startActivity(questionIntent);
            }
        });

        return convertView;
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder{

        ImageView categoryImage;
        TextView categoryTitle;

        CategoryViewHolder(View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.category_image);
            categoryTitle = itemView.findViewById(R.id.category_title);
        }
    }
}
