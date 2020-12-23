package com.sd.saruj.cuhelpguide.Adapter;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.DepartmentInformation.DepartmentInformationActivity;
import com.sd.saruj.cuhelpguide.Activity.DepartmentNameActivity;
import com.sd.saruj.cuhelpguide.Interfaces.FacultyNameInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class FacultyNameAdapter extends RecyclerView.Adapter<FacultyNameAdapter.ProductViewHolderownmake> implements FacultyNameInterfaces
{
   private Context mCtx;
   private List<Faculty> productList;

    public FacultyNameAdapter(Context mCtx, List<Faculty> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }



    @NonNull
    @Override
    public ProductViewHolderownmake onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_list, null);
        return new ProductViewHolderownmake(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolderownmake holder, final int position) {

        final Faculty faculty = productList.get(position);

        Faculty product = productList.get(position);
        holder.textViewName.setText(product.getName());

        final String Name = faculty.getName().toString().trim();

        if(position==8){
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Context context = view.getContext();
//                    Intent intent = new Intent(context, DepartmentInformationActivity.class);
//                    intent.putExtra("faculty", "Law");
//
//                    context.startActivity(intent);

                    onIntent(view.getContext(), DepartmentInformationActivity.class, "faculty","Law");
                }
            });
        }
        else{
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Context context = view.getContext();
//                    Intent intent = new Intent(context, DepartmentNameActivity.class);
//                    intent.putExtra("name", Name);
//                    context.startActivity(intent);
                    onIntent(view.getContext(), DepartmentNameActivity.class,"name", Name);
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
        Log.e("TAG", "name: "+name) ;
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