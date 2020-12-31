package com.sd.saruj.cuhelpguide.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.Activity.RetriveSubjectPostListActivity;

import java.util.List;

public class SubjectReviewAdapter extends RecyclerView.Adapter<SubjectReviewAdapter.ProductViewHolderownmake>
{
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<FacultyBuilderModel> productList;

    public SubjectReviewAdapter(Context mCtx, List<FacultyBuilderModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }


    //  subject search option
    public void filterList(List<FacultyBuilderModel> filteredList) {
        productList = filteredList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public SubjectReviewAdapter.ProductViewHolderownmake onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_list, null);
        return new SubjectReviewAdapter.ProductViewHolderownmake(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectReviewAdapter.ProductViewHolderownmake holder, final int position) {

        FacultyBuilderModel faculty = productList.get(position);

        holder.textViewName.setText(faculty.getName());

        final String Name = faculty.getName().toString().trim();


            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, RetriveSubjectPostListActivity.class);
                    intent.putExtra("subjectName", Name);
                    context.startActivity(intent);
                }
            });




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