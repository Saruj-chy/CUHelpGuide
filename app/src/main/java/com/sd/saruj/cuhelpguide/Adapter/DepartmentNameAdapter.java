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
import com.sd.saruj.cuhelpguide.ModelClass.Faculty;
import com.sd.saruj.cuhelpguide.R;

import java.util.List;

public class DepartmentNameAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context mCtx;
    private List<Faculty> productList;
    int departmentType ;

    public DepartmentNameAdapter(Context mCtx, List<Faculty> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public int getItemViewType(int position) {
        String faculty = productList.get(position).getType() ;
//        Log.e("faculty", "Faculty: "+ faculty ) ;

        switch (faculty){
            case "Engineer":
                departmentType = 1 ;
                return departmentType;
            case "Arts":
                departmentType = 2 ;
                return departmentType;
            case "Biology":
                departmentType = 3 ;
                return departmentType;
            case "Business":
                departmentType = 4 ;
                return departmentType;
            case "Forestry":
                departmentType = 5 ;
                return departmentType;
            case "Science":
                departmentType = 6 ;
                return departmentType;
            case "Social":
                departmentType = 7 ;
                return departmentType;

            default:
                return departmentType=1;

        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_list, null);
        Log.e("faculty", "viewType: "+ viewType ) ;

        return new DepartmentNameAdapter.ProductViewHolderownmake(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        Faculty department = productList.get(position);

        ((ProductViewHolderownmake) holder).bind(department, departmentType);


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

        public void bind(Faculty department, int type) {
            textViewName.setText(department.getName());
            String typeName = department.getType() ;

//            Log.e("faculty", "Faculty Name: "+ department.getName() ) ;
            Log.e("faculty", "Faculty type: "+ department.getType() ) ;

            switch (type){
                case 1:
                    switch (getPosition()){
                        case 0:
                            setIntent(typeName, "CSE");
                            break;
                        default:
                            setIntent(typeName, "EEE");
                            break;
                    }
                    break;
                case 2:
                    switch (getPosition()){
                        case 0:
                            setIntent(typeName, "bangla");
                            break;
                        case 1:
                            setIntent(typeName, "english");
                            break;
                        case 2:
                            setIntent(typeName, "History");
                            break;
                        case 3:
                            setIntent(typeName, "Philosopy");
                            break;
                        default:
                            setIntent(typeName, "IslamicHistory");
                            break;
                    }
                    break;
                case 3:
                    switch (getPosition()){
                        case 0:
                            setIntent(typeName, "zoology");
                            break;
                        case 1:
                            setIntent(typeName, "botany");
                            break;
                        case 2:
                            setIntent(typeName, "pharmacy");
                            break;
                        case 3:
                            setIntent(typeName, "biochemistry");
                            break;
                        case 4:
                            setIntent(typeName, "microbiology");
                            break;
                        case 5:
                            setIntent(typeName, "soil");
                            break;
                        case 6:
                            setIntent(typeName, "genetic");
                            break;
                        case 7:
                            setIntent(typeName, "psychology");
                            break;
                        default:
                            setIntent(typeName, "geography");
                            break;
                    }
                    break;
                case 4:
                    switch (getPosition()){
                        case 0:
                            setIntent(typeName, "accounting");
                            break;
                        case 1:
                            setIntent(typeName, "management");
                            break;
                        case 2:
                            setIntent(typeName, "finance");
                            break;
                        case 3:
                            setIntent(typeName, "marketing");
                            break;
                        case 4:
                            setIntent(typeName, "humanResource");
                            break;
                        default:
                            setIntent(typeName, "banking");
                            break;
                    }
                    break;
                case 5:
                    switch (getPosition()){
                        case 0:
                            setIntent(typeName, "forestry");
                            break;
                        default:
                            setIntent(typeName, "environment");
                            break;
                    }
                    break;
                case 6:
                    switch (getPosition()){
                        case 0:
                            setIntent(typeName, "physics");
                            break;
                        case 1:
                            setIntent(typeName, "chemistry");
                            break;
                        case 2:
                            setIntent(typeName, "mathematics");
                            break;
                        case 3:
                            setIntent(typeName, "statistics");
                            break;
                        default:
                            setIntent(typeName, "appliedChemistry");
                            break;
                    }
                    break;
                case 7:
                    switch (getPosition()){
                        case 0:
                            setIntent(typeName, "economic");
                            break;
                        case 1:
                            setIntent(typeName, "political");
                            break;
                        case 2:
                            setIntent(typeName, "sociology");
                            break;
                        case 3:
                            setIntent(typeName, "public");
                            break;
                        case 4:
                            setIntent(typeName, "journalism");
                            break;
                        default:
                            setIntent(typeName, "PoliceScience");
                            break;
                    }
                    break;


            }



        }

        private void setIntent(final String facultyName, final String departmentName) {
            textViewName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DepartmentInformationActivity.class);
                    intent.putExtra("faculty", facultyName);
                    intent.putExtra("department", departmentName);
                    context.startActivity(intent);
                }
            });

        }

    }




}