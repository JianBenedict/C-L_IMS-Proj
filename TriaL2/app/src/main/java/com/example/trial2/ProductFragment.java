package com.example.trial2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductFragment extends Fragment {

//    private ListView listView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private android.widget.ListAdapter ListAdapter;

    public ProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


//    ListAdapter listAdapter;
//    ArrayList<ListData> dataArrayList = new ArrayList<>();
//    ListData listData;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ListView listView;
    String[] name = {"Rosanna", "Minola", "Dona Maria", "Sinandomeng", "Hapi Fiesta"};
    String[] stocks = {"Stocks: 8", "Stocks: 3", "Stocks: 6", "Stocks: 11", "Stocks: 7"};
    String[] category = {"Rice", "Oil", "Rice", "Rice", "Oil"};
    int[] img = {R.drawable.rice, R.drawable.mantiks, R.drawable.donamaria, R.drawable.sinandomeng, R.drawable.joil};


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        listView = view.findViewById(R.id.listProducts);
        CustomAdapter customAdapter = new CustomAdapter(name, stocks, category, img);
        listView.setAdapter(customAdapter);

        return view;
    }

    public class CustomAdapter extends BaseAdapter {
        private String[] productName;
        private String[] productStocks;
        private String[] productCategory;
        private int[] imgPhoto;
        private LayoutInflater layoutInflater;

        public CustomAdapter(String[] productName, String[] productStocks, String[] productCategory, int[] imgPhoto) {
            this.productName = productName;
            this.productStocks = productStocks;
            this.productCategory = productCategory;
            this.imgPhoto = imgPhoto;
            this.layoutInflater = LayoutInflater.from(getActivity());

        }

        @Override
        public int getCount() {
            return imgPhoto.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view == null) {
                view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
            }

            ImageView listImage = view.findViewById(R.id.listImage);
            TextView listName2 = view.findViewById(R.id.listName2);
            TextView listName = view.findViewById(R.id.listName);
            TextView category = view.findViewById(R.id.Category);

            listImage.setImageResource(imgPhoto[i]);
            listName2.setText(productStocks[i]);
            listName.setText(productName[i]);
            category.setText(productCategory[i]);
            return view;
        }
    }
}