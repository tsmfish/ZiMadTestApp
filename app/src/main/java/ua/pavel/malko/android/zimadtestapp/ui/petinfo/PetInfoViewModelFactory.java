package ua.pavel.malko.android.zimadtestapp.ui.petinfo;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class PetInfoViewModelFactory implements ViewModelProvider.Factory {

    private final String imageUrl, title;
    private final Integer index;
    PetInfoViewModelFactory(String imageUrl, String title, Integer index) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.index = index;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PetInfoViewModel(imageUrl, title, index);
    }
}
