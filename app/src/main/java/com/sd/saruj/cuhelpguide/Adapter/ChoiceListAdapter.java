package com.sd.saruj.cuhelpguide.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.Interfaces.NoticeClickInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class ChoiceListAdapter extends RecyclerView.Adapter<ChoiceListAdapter.ProductViewHolderownmake>
{
    private Context mCtx;
    private List<FacultyBuilderModel> productList;

    public ChoiceListAdapter(Context mCtx, List<FacultyBuilderModel> productList ) {
        this.mCtx = mCtx;
        this.productList = productList;
    }



    @NonNull
    @Override
    public ChoiceListAdapter.ProductViewHolderownmake onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.choice_list, null);
        return new ChoiceListAdapter.ProductViewHolderownmake(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChoiceListAdapter.ProductViewHolderownmake holder, final int position) {

        FacultyBuilderModel faculty = productList.get(position);

        holder.textViewName.setText(faculty.getName());

        final String Name = faculty.getName().toString().trim();

     /*   if(position==0) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Engineering_Activity.class);
                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }
        else if(position==1) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Business_Activity.class);
                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }

        else if(position==2) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Social_Activity.class);
                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }
        else if(position==3) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Science_Activity.class);
                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }

        else if(position==4) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ArtsAndHumanities_Activity.class);
                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }
        else if(position==5) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Biological_Activity.class);
                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }
        else if(position==6) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Marine_Activity.class);
                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }
        else if(position==7) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ForestryActivity.class);
                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }
        else{
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DepartmentInformationActivity.class);
                    intent.putExtra("faculty", "Law");

                    context.startActivity(intent);
                }
            });
        }*/

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolderownmake  extends RecyclerView.ViewHolder
    {
        TextView textViewName;

        public ProductViewHolderownmake(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.cardChoicetextview);

        }
    }
}