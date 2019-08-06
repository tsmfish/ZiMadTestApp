package ua.pavel.malko.android.zimadtestapp.ui.listcontainer;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ua.pavel.malko.android.zimadtestapp.BuildConfig;
import ua.pavel.malko.android.zimadtestapp.Constants;
import ua.pavel.malko.android.zimadtestapp.model.Pet;
import ua.pavel.malko.android.zimadtestapp.repository.NetworkRepository;

class ListContainerViewModel extends ViewModel {
    private static final String LOG_TAG = ListContainerViewModel.class.getSimpleName();

    private final Constants.PetsType type;
    final LiveData<List<Pet>> pets;

    ListContainerViewModel(Constants.PetsType type) {
        super();
        this.type = type;
        pets = NetworkRepository.getInstance().getPets(type);

        if (BuildConfig.DEBUG)
            Log.d(LOG_TAG, "PetInfoViewModel() called with: type = [" + type + "]");
    }


}
