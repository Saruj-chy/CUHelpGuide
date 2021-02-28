package com.sd.saruj.cuhelpguide.controller.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.controller.Interfaces.NoticeClickInterfaces;
import com.sd.saruj.cuhelpguide.model.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class NoticeListAdapter extends RecyclerView.Adapter<NoticeListAdapter.Holder> {

    private List<FacultyBuilderModel> mNoticeList;
    private Context mContext;
    NoticeClickInterfaces mNoticeClickListener;

    public NoticeListAdapter(List<FacultyBuilderModel> list, Context context, NoticeClickInterfaces noticeClickListener) {
        this.mNoticeList = list;
        this.mContext = context;
        this.mNoticeClickListener = noticeClickListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.choice_list,parent,false);
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.pdfListTitle.setText(mNoticeList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mNoticeList.size();
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
            mNoticeClickListener.onClick(v,getAdapterPosition(),false);
        }
    }
}