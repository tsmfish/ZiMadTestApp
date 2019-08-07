package ua.pavel.malko.android.zimadtestapp.ui.listcontainer;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ua.pavel.malko.android.zimadtestapp.Constants;

public class ListContainerViewModelFactory implements ViewModelProvider.Factory {
    private static final String LOG_TAG = ListContainerViewModelFactory.class.getSimpleName();
    private final Constants.PetsType type;

    ListContainerViewModelFactory(Constants.PetsType type) {
        super();
        this.type = type;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ListContainerViewModel.class))
            return (T) new ListContainerViewModel(type);
        else
            throw new IllegalArgumentException("");
    }
}
