package com.sd.saruj.cuhelpguide.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.Class.AllUnitViewIntentClass;
import com.sd.saruj.cuhelpguide.Interfaces.PutIntentInterface;
import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;
import com.sd.saruj.cuhelpguide.Activity.UnitSubjectViewActivity;
import com.sd.saruj.cuhelpguide.Activity.DUnitSubjectViewActivity;

import java.util.List;

public class AllUnitViewAdapter extends RecyclerView.Adapter<AllUnitViewAdapter.ProductViewHolderownmake>
{
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<FacultyBuilderModel> productList;
    private PutIntentInterface extraInterface ;

    public AllUnitViewAdapter(Context mCtx, List<FacultyBuilderModel> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }



    @NonNull
    @Override
    public AllUnitViewAdapter.ProductViewHolderownmake onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_list, null);
        extraInterface = new AllUnitViewIntentClass(mCtx) ;
        return new AllUnitViewAdapter.ProductViewHolderownmake(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllUnitViewAdapter.ProductViewHolderownmake holder, final int position) {

        FacultyBuilderModel faculty = productList.get(position);

        holder.textViewName.setText(faculty.getName());

        final String Name = faculty.getName().toString().trim();


        if(position==4){
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    extraInterface.onIntent(DUnitSubjectViewActivity.class, "name", Name);
                }
            });
        }
        else{
            holder.textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    extraInterface.onIntent(UnitSubjectViewActivity.class, "name", Name);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


//
//    @Override
//    public void onIntent(Context context, Object activity, String name, String value) {
//        Intent intent = new Intent(context, (Class<?>) activity);
//        intent.putExtra(name, value);
//        context.startActivity(intent);
//    }


    class ProductViewHolderownmake  extends RecyclerView.ViewHolder
    {
        TextView textViewName;
        public ProductViewHolderownmake(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.cardtextview);
        }
    }
}