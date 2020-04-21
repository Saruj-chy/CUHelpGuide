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

public class EngineeringAdapter extends RecyclerView.Adapter<EngineeringAdapter.ProductViewHolderownmake>
{
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Faculty> productList;

    public EngineeringAdapter(Context mCtx, List<Faculty> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }



    @NonNull
    @Override
    public EngineeringAdapter.ProductViewHolderownmake onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_list, null);
        return new EngineeringAdapter.ProductViewHolderownmake(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EngineeringAdapter.ProductViewHolderownmake holder, final int position) {

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
                    intent.putExtra("faculty", "Engineer");
                    intent.putExtra("department", "CSE");
                    context.startActivity(intent);
                }
            });
        }
        else  {
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DepartmentInformationActivity.class);
                    intent.putExtra("faculty", "Engineer");
                    intent.putExtra("department", "EEE");
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