package com.sd.saruj.cuhelpguide.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sd.saruj.cuhelpguide.Interfaces.NoticeClickInterfaces;
import com.sd.saruj.cuhelpguide.ModelClass.FacultyBuilderModel;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class VolunteerStudentAdapter extends RecyclerView.Adapter<VolunteerStudentAdapter.Holder> {

    private List<FacultyBuilderModel> mVolunteerList;
    private Context mContext;

    public VolunteerStudentAdapter(Context context, List<FacultyBuilderModel> list) {
        this.mVolunteerList = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_volunteer_student,parent,false);
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        FacultyBuilderModel volunteer = mVolunteerList.get(position);

        Log.e("List", volunteer.getName()) ;
        holder.mVolunteerName.setText(volunteer.getName());
        holder.mVolunteerPhn.setText(volunteer.getPhone());
        holder.mDepartmentName.setText(volunteer.getDepartment_name());
    }

    @Override
    public int getItemCount() {
        return mVolunteerList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView mVolunteerName, mVolunteerPhn, mDepartmentName;

//        public Holder(View itemView) {
//            super(itemView);
//            mVolunteerName = itemView.findViewById(R.id.cardChoicetextview);
//
//        }

        public Holder(View itemView) {
            super(itemView);
            mVolunteerName = itemView.findViewById(R.id.text_volunteer_name);
            mVolunteerPhn = itemView.findViewById(R.id.text_volunteer_phn);
            mDepartmentName = itemView.findViewById(R.id.text_volunteer_department);

        }

    }
}