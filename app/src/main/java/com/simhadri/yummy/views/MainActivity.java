package com.simhadri.yummy.views;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.simhadri.yummy.R;
import com.simhadri.yummy.patterns.VerticalTextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ProductGetter> examlist;
    RecyclerView rv_recommended_list;

    LinearLayout ll_breakfast,ll_lunch,ll_snacks,ll_dinner;
    VerticalTextView vtv_breakfast,vtv_lunch,vtv_snacks,vtv_dinner;
    TextView tv_breakfast,tv_lunch,tv_snacks,tv_dinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(getColor(R.color.white));
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        }

        setContentView(R.layout.dashboard);

        ll_breakfast = (LinearLayout) findViewById(R.id.ll_breakfast);
        ll_lunch = (LinearLayout) findViewById(R.id.ll_lunch);
        ll_snacks = (LinearLayout) findViewById(R.id.ll_snacks);
        ll_dinner = (LinearLayout) findViewById(R.id.ll_dinner);

        vtv_breakfast = (VerticalTextView) findViewById(R.id.vtv_breakfast);
        vtv_lunch = (VerticalTextView) findViewById(R.id.vtv_lunch);
        vtv_snacks = (VerticalTextView) findViewById(R.id.vtv_snacks);
        vtv_dinner = (VerticalTextView) findViewById(R.id.vtv_dinner);

        tv_breakfast = (TextView) findViewById(R.id.tv_breakfast);
        tv_lunch = (TextView) findViewById(R.id.tv_lunch);
        tv_snacks = (TextView) findViewById(R.id.tv_snacks);
        tv_dinner = (TextView) findViewById(R.id.tv_dinner);



        examlist = new ArrayList<>();

        rv_recommended_list = (RecyclerView) findViewById(R.id.rv_recommended_list);
        rv_recommended_list.setNestedScrollingEnabled(false);
        loadcategorylist("Breakfast");


        ll_breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vtv_breakfast.setTextColor(getResources().getColor(R.color.black));
                tv_breakfast.setVisibility(View.VISIBLE);
                vtv_lunch.setTextColor(getResources().getColor(R.color.gray));
                tv_lunch.setVisibility(View.INVISIBLE);
                vtv_snacks.setTextColor(getResources().getColor(R.color.gray));
                tv_snacks.setVisibility(View.INVISIBLE);
                vtv_dinner.setTextColor(getResources().getColor(R.color.gray));
                tv_dinner.setVisibility(View.INVISIBLE);

                examlist = new ArrayList<>();
                ProductAdapter adapter = new ProductAdapter(MainActivity.this, examlist);
                adapter.notifyDataSetChanged();
                rv_recommended_list.setAdapter(adapter);


                loadcategorylist("Breakfast");
            }
        });


        ll_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vtv_breakfast.setTextColor(getResources().getColor(R.color.gray));
                tv_breakfast.setVisibility(View.INVISIBLE);
                vtv_lunch.setTextColor(getResources().getColor(R.color.black));
                tv_lunch.setVisibility(View.VISIBLE);
                vtv_snacks.setTextColor(getResources().getColor(R.color.gray));
                tv_snacks.setVisibility(View.INVISIBLE);
                vtv_dinner.setTextColor(getResources().getColor(R.color.gray));
                tv_dinner.setVisibility(View.INVISIBLE);

                examlist = new ArrayList<>();
                ProductAdapter adapter = new ProductAdapter(MainActivity.this, examlist);
                adapter.notifyDataSetChanged();
                rv_recommended_list.setAdapter(adapter);

                loadcategorylist("Lunch");
            }
        });


        ll_snacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vtv_breakfast.setTextColor(getResources().getColor(R.color.gray));
                tv_breakfast.setVisibility(View.INVISIBLE);
                vtv_lunch.setTextColor(getResources().getColor(R.color.gray));
                tv_lunch.setVisibility(View.INVISIBLE);
                vtv_snacks.setTextColor(getResources().getColor(R.color.black));
                tv_snacks.setVisibility(View.VISIBLE);
                vtv_dinner.setTextColor(getResources().getColor(R.color.gray));
                tv_dinner.setVisibility(View.INVISIBLE);

                examlist = new ArrayList<>();
                ProductAdapter adapter = new ProductAdapter(MainActivity.this, examlist);
                adapter.notifyDataSetChanged();
                rv_recommended_list.setAdapter(adapter);

                loadcategorylist("Snacks");
            }
        });


        ll_dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vtv_breakfast.setTextColor(getResources().getColor(R.color.gray));
                tv_breakfast.setVisibility(View.INVISIBLE);
                vtv_lunch.setTextColor(getResources().getColor(R.color.gray));
                tv_lunch.setVisibility(View.INVISIBLE);
                vtv_snacks.setTextColor(getResources().getColor(R.color.gray));
                tv_snacks.setVisibility(View.INVISIBLE);
                vtv_dinner.setTextColor(getResources().getColor(R.color.black));
                tv_dinner.setVisibility(View.VISIBLE);

                examlist = new ArrayList<>();
                ProductAdapter adapter = new ProductAdapter(MainActivity.this, examlist);
                adapter.notifyDataSetChanged();
                rv_recommended_list.setAdapter(adapter);

                loadcategorylist("Dinner");
            }
        });


    }


    private void loadcategorylist(String categorytype) {


        ProductGetter records = new ProductGetter("","","","","","","");

        examlist.add(records);

        ProductGetter records1 = new ProductGetter("","","","","","","");

        examlist.add(records1);

        ProductGetter records2 = new ProductGetter("","","","","","","");

        examlist.add(records2);

        ProductGetter records3 = new ProductGetter("","","","","","","");

        examlist.add(records3);

        ProductGetter records4 = new ProductGetter("","","","","","","");

        examlist.add(records4);


        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rv_recommended_list.setLayoutManager(layoutManager);
        ProductAdapter adapter = new ProductAdapter(MainActivity.this, examlist);
        rv_recommended_list.setAdapter(adapter);



   }



    class ProductGetter{

        String recipes_id,recipes_title,recipes_category,recipes_total_time,recipes_cooking_time,recipes_image_link,recipes_short_desc;

        public String getRecipes_id() {
            return recipes_id;
        }

        public void setRecipes_id(String recipes_id) {
            this.recipes_id = recipes_id;
        }

        public String getRecipes_title() {
            return recipes_title;
        }

        public void setRecipes_title(String recipes_title) {
            this.recipes_title = recipes_title;
        }

        public String getRecipes_category() {
            return recipes_category;
        }

        public void setRecipes_category(String recipes_category) {
            this.recipes_category = recipes_category;
        }

        public String getRecipes_total_time() {
            return recipes_total_time;
        }

        public void setRecipes_total_time(String recipes_total_time) {
            this.recipes_total_time = recipes_total_time;
        }

        public String getRecipes_cooking_time() {
            return recipes_cooking_time;
        }

        public void setRecipes_cooking_time(String recipes_cooking_time) {
            this.recipes_cooking_time = recipes_cooking_time;
        }

        public String getRecipes_image_link() {
            return recipes_image_link;
        }

        public void setRecipes_image_link(String recipes_image_link) {
            this.recipes_image_link = recipes_image_link;
        }

        public String getRecipes_short_desc() {
            return recipes_short_desc;
        }

        public void setRecipes_short_desc(String recipes_short_desc) {
            this.recipes_short_desc = recipes_short_desc;
        }

        public ProductGetter(String recipes_id, String recipes_title, String recipes_category, String recipes_total_time,
                             String recipes_cooking_time, String recipes_image_link, String recipes_short_desc) {

            this.recipes_id=recipes_id;
            this.recipes_title = recipes_title;
            this.recipes_category=recipes_category;
            this.recipes_total_time=recipes_total_time;
            this.recipes_cooking_time=recipes_cooking_time;
            this.recipes_image_link=recipes_image_link;
            this.recipes_short_desc=recipes_short_desc;

        }
    }

    class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

        private static final String TAG = "RecyclerViewAdapter";

        //vars
        private List<ProductGetter> categorylist = new ArrayList<>();
        List<ProductGetter> arraylist;

        private Context mContext;

        public ProductAdapter(Context context, List<ProductGetter> categorylist) {
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_adapter, parent, false);
            return new ProductAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ProductAdapter.ViewHolder holder, final int position) {


            final ProductGetter records = categorylist.get(position);

            holder.ll_card_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent details = new Intent(MainActivity.this,DetailsActivity.class);
                    startActivity(details);
                }
            });

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

            LinearLayout ll_card_layout;
            public ViewHolder(View itemView) {
                super(itemView);

                ll_card_layout = itemView.findViewById(R.id.ll_card_layout);


            }
        }
    }
}