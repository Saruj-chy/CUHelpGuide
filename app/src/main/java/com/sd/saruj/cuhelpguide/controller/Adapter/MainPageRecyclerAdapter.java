package com.sd.saruj.cuhelpguide.controller.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.controller.Class.MainPageClickListenerClass;
import com.sd.saruj.cuhelpguide.controller.Interfaces.MainPageInterfaces;
import com.sd.saruj.cuhelpguide.model.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class MainPageRecyclerAdapter extends RecyclerView.Adapter<MainPageRecyclerAdapter.MainPageViewHolder>
{
    private Context mCtx;
    private List<FacultyBuilderModel> toolsList;
    MainPageInterfaces mInterface  ;

    public MainPageRecyclerAdapter(Context mCtx, List<FacultyBuilderModel> toolsList) {
        this.mCtx = mCtx;
        this.toolsList = toolsList;
    }



    @NonNull
    @Override
    public MainPageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_list, null);
        mInterface  = new MainPageClickListenerClass(mCtx);
        return new MainPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainPageViewHolder holder, final int position) {

        FacultyBuilderModel faculty = toolsList.get(position);
        holder.textViewName.setText(faculty.getName());

        final String Name = faculty.getName().toString().trim();
        holder.textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mCtx, "clicked"+ position, Toast.LENGTH_SHORT).show();
                mInterface.OnClick(position);
            }
        });

//        LinearLayout layoutBottomSheet = mCtx.findViewById(R.id.bottom_sheet);


//        else if(position==4) {
//            holder.textViewName.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(final View view) {
//                    CharSequence options[] = new CharSequence[]
//                            {
//                                    "Practice Test",
//                                    "Model Test"
//                            };
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
//                    builder.setTitle("Select Any Test?") ;
//
//                    builder.setItems(options, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            if( i == 0){
//                                mInterface.onIntent(PracticeTestActivity.class);
//                            }
//                            else if( i == 1){
//                                mInterface.onIntent(ModelQuestionActivity.class);
//                            }
//                        }
//                    });
//                    builder.show() ;
//                }
//            });


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