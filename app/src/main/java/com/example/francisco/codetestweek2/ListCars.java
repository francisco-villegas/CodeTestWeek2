package com.example.francisco.codetestweek2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ListCars extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "ListCars";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListCars() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment list_cars.
     */
    // TODO: Rename and change types and number of parameters
    public static ListCars newInstance(String param1, String param2) {
        ListCars fragment = new ListCars();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_cars, container, false);
    }

    ArrayList<Car> cars = new ArrayList<>();
    RecyclerView rvCarList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    CarListAdapter carListAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCarList = (RecyclerView) view.findViewById(R.id.rvCarList);
        fill_list(cars);
    }

    public void sendItems(ArrayList<Car> carss){
        cars = carss;
        fill_list(cars);
    }

    public void fill_list(ArrayList<Car> carss){
        cars=carss;
        layoutManager = new LinearLayoutManager(getActivity());
        itemAnimator = new DefaultItemAnimator();
        rvCarList.setLayoutManager(layoutManager);
        rvCarList.setItemAnimator(itemAnimator);

        //initialize the adapter
        carListAdapter = new CarListAdapter(cars);
        rvCarList.setAdapter(carListAdapter);

        carListAdapter.notifyDataSetChanged();
    }
}
