package com.sd.saruj.cuhelpguide;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.AdmisionNotice.NoticeListActivity;
import com.sd.saruj.cuhelpguide.Activity.ChoiceActivity;
import com.sd.saruj.cuhelpguide.Interfaces.FacultyNameInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.Activity.FacultyNameActivity;
import com.sd.saruj.cuhelpguide.ModelQuestion.ModelQuestionActivity;
import com.sd.saruj.cuhelpguide.ModelQuestion.ModelQuestionMainActivity;
import com.sd.saruj.cuhelpguide.ModelQuestion.PracticeTest.PracticeTestActivity;
import com.sd.saruj.cuhelpguide.Activity.AllUnitViewActivity;
import com.sd.saruj.cuhelpguide.Activity.SubjectReviewActivity;

import java.util.List;

public class MainPageRecyclerAdapter extends RecyclerView.Adapter<MainPageRecyclerAdapter.MainPageViewHolder> implements FacultyNameInterfaces
{
    private Context mCtx;
    private List<Faculty> toolsList;

    public MainPageRecyclerAdapter(Context mCtx, List<Faculty> toolsList) {
        this.mCtx = mCtx;
        this.toolsList = toolsList;
    }



    @NonNull
    @Override
    public MainPageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_list, null);
        return new MainPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainPageViewHolder holder, final int position) {

        Faculty faculty = toolsList.get(position);
        holder.textViewName.setText(faculty.getName());

        final String Name = faculty.getName().toString().trim();

        if(position==0) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onIntent(view.getContext(), FacultyNameActivity.class, "", "");
                }
            });
        }
        else if(position==1) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
               onIntent(view.getContext(), AllUnitViewActivity.class, "", "");
                }
            });
        }

        else if(position==2) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 onIntent(view.getContext(), ChoiceActivity.class, "", "");
                }
            });
        }
        else if(position==3) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onIntent(view.getContext(), SubjectReviewActivity.class, "", "");
                }
            });
        }

        else if(position==4) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    CharSequence options[] = new CharSequence[]
                            {
                                    "Practice Test",
                                    "Model Test"
                            };

                    AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
                    builder.setTitle("Select Any Test?") ;

                    builder.setItems(options, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if( i == 0){
                                onIntent(view.getContext(), PracticeTestActivity.class, "", "");
                            }
                            else if( i == 1){
                                onIntent(view.getContext(), ModelQuestionActivity.class, "", "");
                            }
                        }
                    });
                    builder.show() ;
                }
            });





        }
        else if(position==5) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onIntent(view.getContext(), NoticeListActivity.class, "", "");
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return toolsList.size();
    }

    @Override
    public void onIntent(Context context, Object activity, String name, String value) {
        Intent intent = new Intent(context, (Class<?>) activity);
        context.startActivity(intent);
    }


    class MainPageViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewName;
        public MainPageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.cardtextview);
        }
    }
}