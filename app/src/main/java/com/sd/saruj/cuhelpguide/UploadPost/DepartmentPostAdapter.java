package com.sd.saruj.cuhelpguide.UploadPost;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.Faculty.Faculty;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class DepartmentPostAdapter extends RecyclerView.Adapter<DepartmentPostAdapter.ProductViewHolderownmake>
{
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Faculty> productList;

    public DepartmentPostAdapter(Context mCtx, List<Faculty> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }


    //  subject search option
    //======================
    public void filterList(List<Faculty> filteredList) {
        productList = filteredList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DepartmentPostAdapter.ProductViewHolderownmake onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_list, null);
        return new DepartmentPostAdapter.ProductViewHolderownmake(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentPostAdapter.ProductViewHolderownmake holder, final int position) {

        Faculty faculty = productList.get(position);

        Faculty product = productList.get(position);
        holder.textViewName.setText(product.getName());

        final String Name = faculty.getName().toString().trim();


            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, RetrivePostListActivity.class);
                    intent.putExtra("subjectName", Name);
                    context.startActivity(intent);
                }
            });


   /*     else if(position==1) {
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

            textViewName = itemView.findViewById(R.id.cardtextview);



        }
    }




}