package com.simhadri.yummy.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.simhadri.yummy.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PreparationsFragment extends Fragment {

    View roottview;
    RecyclerView rv_ingrediant_list;
    List<PreparationGetter> examlist;
    String recipes_id="";
    public PreparationsFragment(String recipes_id) {
        this.recipes_id = recipes_id;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        roottview = inflater.inflate(R.layout.ingrediant_list, container, false);

        rv_ingrediant_list = (RecyclerView) roottview.findViewById(R.id.rv_ingrediant_list);




        examlist = new ArrayList<>();

        loadcategorylist();

        // Inflate the layout for this fragment
        return roottview;
    }

    private void loadcategorylist() {

        PreparationGetter records = new PreparationGetter("",recipes_id,"","");

        examlist.add(records);

        PreparationGetter records2 = new PreparationGetter("",recipes_id,"","");

        examlist.add(records2);

        PreparationGetter record3 = new PreparationGetter("",recipes_id,"","");

        examlist.add(record3);

        PreparationGetter records4 = new PreparationGetter("",recipes_id,"","");

        examlist.add(records4);

        PreparationGetter records5 = new PreparationGetter("",recipes_id,"","");

        examlist.add(records5);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv_ingrediant_list.setLayoutManager(layoutManager);
        ProductAdapter adapter = new ProductAdapter(getContext(), examlist);
        rv_ingrediant_list.setAdapter(adapter);




    }


    class PreparationGetter{


        String preparation_steps_id,recipes_id,preparation_step,steps;

        public String getPreparation_steps_id() {
            return preparation_steps_id;
        }

        public void setPreparation_steps_id(String preparation_steps_id) {
            this.preparation_steps_id = preparation_steps_id;
        }

        public String getRecipes_id() {
            return recipes_id;
        }

        public void setRecipes_id(String recipes_id) {
            this.recipes_id = recipes_id;
        }

        public String getPreparation_step() {
            return preparation_step;
        }

        public void setPreparation_step(String preparation_step) {
            this.preparation_step = preparation_step;
        }

        public String getSteps() {
            return steps;
        }

        public void setSteps(String steps) {
            this.steps = steps;
        }

        public PreparationGetter(String preparation_steps_id, String recipes_id, String preparation_step, String steps) {
            this.preparation_steps_id=preparation_steps_id;
            this.recipes_id=recipes_id;
            this.preparation_step=preparation_step;
            this.steps=steps;
        }
    }

    class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

        private static final String TAG = "RecyclerViewAdapter";

        //vars
        private List<PreparationGetter> categorylist = new ArrayList<>();
        List<PreparationGetter> arraylist;

        private Context mContext;

        public ProductAdapter(Context context, List<PreparationGetter> categorylist) {
            this.categorylist = categorylist;
            mContext = context;
            this.arraylist = new ArrayList<>();
            this.arraylist.addAll(categorylist);
        }


//        public void filter(String charText) {
//            try {
//
//                charText = charText.toLowerCase(Locale.getDefault());
//                categorylist.clear();
//                if (charText.length() == 0) {
//                    categorylist.addAll(arraylist);
//                } else {
//                    for (ProductGetter wp : arraylist) {
//
//                        String title = wp.getExamname();
//
//                        String[] nameArray = title
//                                .toLowerCase(Locale.getDefault()).split(" ");
//
//                        if (nameArray[0].startsWith(charText)) {
//                            categorylist.add(wp);
//                        }
//                    }
//                }
//                notifyDataSetChanged();
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }


        @Override
        public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.preparation_list_adapter, parent, false);
            return new ProductAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ProductAdapter.ViewHolder holder, final int position) {


            final PreparationGetter records = categorylist.get(position);







        }

        @Override
        public int getItemCount() {
            return this.categorylist.size();
        }


        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);

            }
        }
    }
}
