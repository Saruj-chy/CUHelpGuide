package com.sd.saruj.cuhelpguide.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.Activity.ShowPostActivity;
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class RetriveSubjectPostListAdapter extends RecyclerView.Adapter<RetriveSubjectPostListAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<FacultyBuilderModel> productList;

    public RetriveSubjectPostListAdapter(Context mCtx, List<FacultyBuilderModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.retrive_post_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final FacultyBuilderModel product = productList.get(position);



        holder.textViewId.setText(position+1+".");
        holder.textViewtitle.setText(product.getTitle());

        String detailsText = product.getDetails() ;
        if(detailsText.length()>100){
            String text = detailsText.substring(0, 100);
            holder.textViewPost.setText("               "+text+"...see more");
        }else{
            holder.textViewPost.setText("               "+detailsText);
        }
        Log.e("name", product.getName()+" subj... ") ;


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, ShowPostActivity.class);
                intent.putExtra("title", product.getTitle());
                intent.putExtra("details", product.getDetails());
                intent.putExtra("subjectName", product.getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewId, textViewtitle, textViewPost, textViewMore;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.textViewid);
            textViewtitle = itemView.findViewById(R.id.textViewTitle);
            textViewPost = itemView.findViewById(R.id.textViewDetails);
            textViewMore = itemView.findViewById(R.id.textViewMore);


        }
    }
}