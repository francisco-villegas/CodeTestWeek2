package com.example.francisco.codetestweek2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by FRANCISCO on 11/08/2017.
 */

public class Car implements Parcelable{
    String model, type;
    int year;

    public Car(String model, String type, int year) {
        this.model = model;
        this.type = type;
        this.year = year;
    }

    protected Car(Parcel in) {
        model = in.readString();
        type = in.readString();
        year = in.readInt();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(model);
        parcel.writeString(type);
        parcel.writeInt(year);
    }
}
