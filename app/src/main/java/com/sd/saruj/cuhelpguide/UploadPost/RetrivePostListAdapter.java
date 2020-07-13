package com.sd.saruj.cuhelpguide.UploadPost;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class RetrivePostListAdapter extends RecyclerView.Adapter<RetrivePostListAdapter.ProductViewHolder> {


    private Context mCtx;
    private List<Faculty> productList;

    public RetrivePostListAdapter(Context mCtx, List<Faculty> productList) {
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
        final Faculty product = productList.get(position);



        holder.textViewId.setText(String.valueOf(position+1));
        holder.textViewtitle.setText(product.getTitle());
        holder.textViewPost.setText(String.valueOf(product.getDetails()));

        holder.textViewMore.setOnClickListener(new View.OnClickListener() {
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