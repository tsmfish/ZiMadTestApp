package ua.pavel.malko.android.zimadtestapp.ui.petinfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PetInfoViewModel extends ViewModel {
    private static final String LOG_TAG = PetInfoViewModel.class.getSimpleName();

    private final MutableLiveData<String> imageUrl, title;

    PetInfoViewModel(String imageUrl, String title) {
        super();

        this.imageUrl = new MutableLiveData<>(imageUrl);
        this.title = new MutableLiveData<>(title);
    }

    public LiveData<String> getImageUrl() {
        return imageUrl;
    }
    public LiveData<String> getTitle() {
        return title;
    }
}
