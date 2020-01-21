package com.myapp.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.myapp.mvvm.model.NicePlaces;
import com.myapp.mvvm.repository.NicePlaceRepository;

import java.util.List;

public class MainActViewModel extends ViewModel {

    //all business logic goes here.

    private MutableLiveData<List<NicePlaces>> mNicePlaces;
    private NicePlaceRepository nicePlaceRepository;

    public void init() {

        if (mNicePlaces != null) {
            return;
        }
        nicePlaceRepository = NicePlaceRepository.getmInstance();
        mNicePlaces = nicePlaceRepository.getNicePlaces();

    }

    public LiveData<List<NicePlaces>> getNicePlaces() {
        return mNicePlaces;
    }

}
