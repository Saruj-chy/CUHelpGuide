package com.sd.saruj.cuhelpguide.JavaClass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.DepartmentInformation.DepartmentInformationActivity;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.ProductViewHolderownmake> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Faculty> productList;

    public SocialAdapter(Context mCtx, List<Faculty> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }


    @NonNull
    @Override
    public SocialAdapter.ProductViewHolderownmake onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_list, null);
        return new SocialAdapter.ProductViewHolderownmake(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialAdapter.ProductViewHolderownmake holder, final int position) {

        Faculty department = productList.get(position);

        Faculty product = productList.get(position);
        holder.textViewName.setText(product.getName());

        final String Name = department.getName().toString().trim();

        if(position==0) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DepartmentInformationActivity.class);
                    intent.putExtra("faculty", "Social");
                    intent.putExtra("department", "economic");

                 //   intent.putExtra("name", "economic");
                    context.startActivity(intent);
                }
            });
        }


        else if(position==1) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DepartmentInformationActivity.class);
                    intent.putExtra("faculty", "Social");
                    intent.putExtra("department", "political");

                    context.startActivity(intent);
                }
            });
        }
        else if(position==2) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DepartmentInformationActivity.class);

                    intent.putExtra("faculty", "Social");
                    intent.putExtra("department", "sociology");

                    context.startActivity(intent);
                }
            });
        }

        else if(position==3) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DepartmentInformationActivity.class);

                    intent.putExtra("faculty", "Social");
                    intent.putExtra("department", "public");

                    context.startActivity(intent);
                }
            });
        }
        else if(position==4) {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DepartmentInformationActivity.class);

                    intent.putExtra("faculty", "Social");
                    intent.putExtra("department", "journalism");

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
                    intent.putExtra("faculty", "Social");
                    intent.putExtra("department", "PoliceScience");


                    context.startActivity(intent);
                }
            });
        }



    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolderownmake extends RecyclerView.ViewHolder {
        TextView textViewName;


        public ProductViewHolderownmake(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.cardtextview);


        }
    }
}


