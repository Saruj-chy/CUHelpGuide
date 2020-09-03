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
import com.sd.saruj.cuhelpguide.Choice.ChoiceActivity;
import com.sd.saruj.cuhelpguide.Faculty.Faculty;
import com.sd.saruj.cuhelpguide.Faculty.FacultyNameActivity;
import com.sd.saruj.cuhelpguide.ModelQuestion.ModelQuestionMainActivity;
import com.sd.saruj.cuhelpguide.ModelQuestion.PracticeTest.PracticeTestActivity;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities.AllUnitViewActivity;
import com.sd.saruj.cuhelpguide.UploadPost.DepartmentPostActivity;

import java.util.List;

public class MainPageRecyclerAdapter extends RecyclerView.Adapter<MainPageRecyclerAdapter.MainPageViewHolder>
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
                    Context context = view.getContext();
                    Intent intent = new Intent(context, FacultyNameActivity.class);
//                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }
        else if(position==1) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, AllUnitViewActivity.class);
//                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }

        else if(position==2) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ChoiceActivity.class);
//                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }
        else if(position==3) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DepartmentPostActivity.class);
//                    intent.putExtra("name", Name);
                    context.startActivity(intent);
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
                                Context context = view.getContext();
                                Intent intent = new Intent(context, PracticeTestActivity.class);
                                context.startActivity(intent);
                            }
                            else if( i == 1){
                                Context context = view.getContext();
                                Intent intent = new Intent(context, ModelQuestionMainActivity.class);
                                context.startActivity(intent);
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
                    Context context = view.getContext();
                    Intent intent = new Intent(context, NoticeListActivity.class);
//                    intent.putExtra("name", Name);
                    context.startActivity(intent);
//                    Toast.makeText(mCtx, "Upcoming soon...", Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return toolsList.size();
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