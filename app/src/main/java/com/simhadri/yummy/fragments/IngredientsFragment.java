package com.simhadri.yummy.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public class IngredientsFragment extends Fragment {

    View roottview;
    RecyclerView rv_ingrediant_list;
    List<IngredientGetter> examlist;
    String recipes_id="";

    public IngredientsFragment(String recipes_id) {
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

        IngredientGetter records = new IngredientGetter("",recipes_id,"","","","");

        examlist.add(records);

        IngredientGetter records1 = new IngredientGetter("",recipes_id,"","","","");

        examlist.add(records1);

        IngredientGetter records2 = new IngredientGetter("",recipes_id,"","","","");

        examlist.add(records2);

        IngredientGetter records3 = new IngredientGetter("",recipes_id,"","","","");

        examlist.add(records3);

        IngredientGetter records4 = new  IngredientGetter("",recipes_id,"","","","");

        examlist.add(records4);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv_ingrediant_list.setLayoutManager(layoutManager);
        ProductAdapter adapter = new ProductAdapter(getContext(), examlist);
        rv_ingrediant_list.setAdapter(adapter);




    }


    class IngredientGetter{

        String ingredient_id,recipes_id,ingredient_name,amount,ingredient_image_url,measurement;

        public String getIngredient_id() {
            return ingredient_id;
        }

        public void setIngredient_id(String ingredient_id) {
            this.ingredient_id = ingredient_id;
        }

        public String getRecipes_id() {
            return recipes_id;
        }

        public void setRecipes_id(String recipes_id) {
            this.recipes_id = recipes_id;
        }

        public String getIngredient_name() {
            return ingredient_name;
        }

        public void setIngredient_name(String ingredient_name) {
            this.ingredient_name = ingredient_name;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getIngredient_image_url() {
            return ingredient_image_url;
        }

        public void setIngredient_image_url(String ingredient_image_url) {
            this.ingredient_image_url = ingredient_image_url;
        }

        public String getMeasurement() {
            return measurement;
        }

        public void setMeasurement(String measurement) {
            this.measurement = measurement;
        }

        public IngredientGetter(String ingredient_id, String recipes_id, String ingredient_name,
                                String amount, String ingredient_image_url, String measurement) {

            this.ingredient_id=ingredient_id;
            this.recipes_id=recipes_id;
            this.ingredient_name=ingredient_name;
            this.amount=amount;
            this.ingredient_image_url=ingredient_image_url;
            this.measurement=measurement;

        }
    }

    class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

        private static final String TAG = "RecyclerViewAdapter";

        //vars
        private List<IngredientGetter> categorylist = new ArrayList<>();
        List<IngredientGetter> arraylist;

        private Context mContext;

        public ProductAdapter(Context context, List<IngredientGetter> categorylist) {
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingrediants_list_adapter, parent, false);
            return new ProductAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ProductAdapter.ViewHolder holder, final int position) {


            final IngredientGetter records = categorylist.get(position);



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
