package com.sd.saruj.cuhelpguide.AdmisionNotice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.JavaClass.Faculty;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class NoticeListAdapter extends RecyclerView.Adapter<NoticeListAdapter.Holder> {

    private List<Faculty> list;
    private Context context;
    NoticeClickListener noticeClickListener;

    public NoticeListAdapter(List<Faculty> list, Context context, NoticeClickListener noticeClickListener) {
        this.list = list;
        this.context = context;
        this.noticeClickListener = noticeClickListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.choice_list,parent,false);
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.pdfListTitle.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView pdfListTitle;
        public Holder(View itemView) {
            super(itemView);
            pdfListTitle = itemView.findViewById(R.id.cardChoicetextview);

            pdfListTitle.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            noticeClickListener.onClick(v,getAdapterPosition(),false);
        }
    }
}