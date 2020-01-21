package com.myapp.mvvm.repository;

import androidx.lifecycle.MutableLiveData;

import com.myapp.mvvm.model.NicePlaces;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {

    private static NicePlaceRepository mInstance;
    private ArrayList<NicePlaces> dataSet = new ArrayList<>();

    public static NicePlaceRepository getmInstance() {
        if (mInstance == null) {
            mInstance = new NicePlaceRepository();
        }
        return mInstance;
    }

    public MutableLiveData<List<NicePlaces>> getNicePlaces() {
        setDataSet();
        MutableLiveData<List<NicePlaces>> liveData = new MutableLiveData<>();
        liveData.setValue(dataSet);
        return liveData;
    }

    //get from the webservice

    private void setDataSet() {
        dataSet.add(new NicePlaces("Hong Kong", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("Singapore", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("Thailand", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("UK", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("India", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("United States Of America", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("Macau", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("Malaysia", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("China", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("Turkey", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("Saudi Arabia", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("Russia", "https://tinyurl.com/uvao5ph"));
        dataSet.add(new NicePlaces("Spain", "https://tinyurl.com/uvao5ph"));
    }
}
