package com.sd.saruj.cuhelpguide.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.Class.ExtraIntentClass;
import com.sd.saruj.cuhelpguide.DepartmentInformation.DepartmentInformationActivity;
import com.sd.saruj.cuhelpguide.Activity.DepartmentNameActivity;
import com.sd.saruj.cuhelpguide.Interfaces.ExtraIntentInterface;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class FacultyNameAdapter extends RecyclerView.Adapter<FacultyNameAdapter.ProductViewHolderownmake>
{
   private Context mCtx;
   private List<Faculty> productList;

   ExtraIntentInterface facultyNameInterface ;

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

        facultyNameInterface = new ExtraIntentClass(view.getContext()) ;
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

                    facultyNameInterface.onIntent( DepartmentInformationActivity.class, "department","Law");

                }
            });
        }
        else{
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    facultyNameInterface.onIntent( DepartmentNameActivity.class,"name", Name);
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