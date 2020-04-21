package com.sd.saruj.cuhelpguide.SubjectPrerequirement.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities.AUnitActivity;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities.B1UnitActivity;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities.BUnitActivity;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities.CUnitActivity;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities.D1UnitActivity;
import com.sd.saruj.cuhelpguide.SubjectPrerequirement.Activities.DUnitActivity;

import java.util.List;

public class AllUnitAdapter extends RecyclerView.Adapter<AllUnitAdapter.ProductViewHolderownmake>
{
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Faculty> productList;

    public AllUnitAdapter(Context mCtx, List<Faculty> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }



    @NonNull
    @Override
    public AllUnitAdapter.ProductViewHolderownmake onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_list, null);
        return new AllUnitAdapter.ProductViewHolderownmake(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllUnitAdapter.ProductViewHolderownmake holder, final int position) {

        Faculty faculty = productList.get(position);

        Faculty product = productList.get(position);
        holder.textViewName.setText(product.getName());

        final String Name = faculty.getName().toString().trim();

        if(position==0) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, AUnitActivity.class);
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
                    Intent intent = new Intent(context, BUnitActivity.class);
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
                    Intent intent = new Intent(context, B1UnitActivity.class);
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
                    Intent intent = new Intent(context, CUnitActivity.class);
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
                    Intent intent = new Intent(context, DUnitActivity.class);
                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }
        else {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, D1UnitActivity.class);
                    intent.putExtra("name", Name);
                    context.startActivity(intent);
                }
            });
        }



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

            textViewName = itemView.findViewById(R.id.cardtextview);



        }
    }




}