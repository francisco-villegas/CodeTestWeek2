package com.example.francisco.codetestweek2;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddCar.OnFragmentInteractionListener {

    private static final String TAG = "ADD";
    private static final String TAG2 = "LIST";
    ListCars list_cars;
    AddCar add_car;
    ArrayList<Car> cars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_car = new AddCar();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.add_car, add_car, TAG);
        //ft.addToBackStack(TAG);
        ft.commit();

        list_cars = new ListCars();
        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();

        ft2.replace(R.id.list_cars, list_cars, TAG2);
        //ft2.addToBackStack(TAG2);
        ft2.commit();

        //No keyboard on start
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @Override
    public void onFragmentInteraction(ArrayList<Car> carss) {
        list_cars.sendItems(carss);
        cars = carss;
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()==1)
            finish();
        else
            super.onBackPressed();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("car_key",cars);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        cars = savedInstanceState.getParcelableArrayList("car_key");
        add_car.fill_again(cars);
        list_cars.fill_list(cars);
    }
}
