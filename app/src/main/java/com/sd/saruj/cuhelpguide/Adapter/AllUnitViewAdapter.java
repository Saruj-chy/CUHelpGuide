package com.sd.saruj.cuhelpguide.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.Interfaces.FacultyNameInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.Activity.UnitSubjectViewActivity;
import com.sd.saruj.cuhelpguide.Activity.DUnitSubjectViewActivity;

import java.util.List;

public class AllUnitViewAdapter extends RecyclerView.Adapter<AllUnitViewAdapter.ProductViewHolderownmake> implements FacultyNameInterfaces
{
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Faculty> productList;

    public AllUnitViewAdapter(Context mCtx, List<Faculty> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }



    @NonNull
    @Override
    public AllUnitViewAdapter.ProductViewHolderownmake onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_list, null);
        return new AllUnitViewAdapter.ProductViewHolderownmake(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllUnitViewAdapter.ProductViewHolderownmake holder, final int position) {

        Faculty faculty = productList.get(position);

        Faculty product = productList.get(position);
        holder.textViewName.setText(product.getName());

        final String Name = faculty.getName().toString().trim();


        if(position==4){
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onIntent(view.getContext(), DUnitSubjectViewActivity.class, "name", Name);
                }
            });
        }
        else{
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onIntent(view.getContext(), UnitSubjectViewActivity.class, "name", Name);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }



    @Override
    public void onIntent(Context context, Object activity, String name, String value) {
        Intent intent = new Intent(context, (Class<?>) activity);
        intent.putExtra(name, value);
        context.startActivity(intent);
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