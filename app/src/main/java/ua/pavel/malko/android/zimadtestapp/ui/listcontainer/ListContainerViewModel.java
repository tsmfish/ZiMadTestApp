package ua.pavel.malko.android.zimadtestapp.ui.listcontainer;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import ua.pavel.malko.android.zimadtestapp.BuildConfig;
import ua.pavel.malko.android.zimadtestapp.Constants;

public class ListContainerViewModel extends ViewModel {
    private static final String LOG_TAG = ListContainerViewModel.class.getSimpleName();

    private final Constants.PetsType type;
    public ListContainerViewModel(Constants.PetsType type) {
        super();
        this.type = type;

        if (BuildConfig.DEBUG)
            Log.d(LOG_TAG, "PetInfoViewModel() called with: type = [" + type + "]");
    }


}
