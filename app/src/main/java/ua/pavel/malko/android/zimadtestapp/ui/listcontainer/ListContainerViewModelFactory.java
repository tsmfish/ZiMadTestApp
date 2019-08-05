package ua.pavel.malko.android.zimadtestapp.ui.listcontainer;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ua.pavel.malko.android.zimadtestapp.Constants;

public class ListContainerViewModelFactory implements ViewModelProvider.Factory {
    private final Constants.PetsType type;

    ListContainerViewModelFactory(Constants.PetsType type) {
        this.type = type;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ListContainerViewModel(type);
    }
}
