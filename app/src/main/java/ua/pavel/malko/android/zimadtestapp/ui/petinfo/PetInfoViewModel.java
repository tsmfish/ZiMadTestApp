package ua.pavel.malko.android.zimadtestapp.ui.petinfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PetInfoViewModel extends ViewModel {
    private static final String LOG_TAG = PetInfoViewModel.class.getSimpleName();

    private final MutableLiveData<String> imageUrl, title;
    private final MutableLiveData<Integer> index;

    PetInfoViewModel(String imageUrl, String title, Integer index) {
        super();

        this.imageUrl = new MutableLiveData<>(imageUrl);
        this.title = new MutableLiveData<>(title);
        this.index = new MutableLiveData<>(index);
    }

    public LiveData<String> getImageUrl() {
        return imageUrl;
    }
    public LiveData<String> getTitle() {
        return title;
    }
    public LiveData<Integer> getIndex() {
        return index;
    }
}
