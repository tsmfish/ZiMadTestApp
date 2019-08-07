package ua.pavel.malko.android.zimadtestapp.repository;

import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public class StateRepository {
    private static final String LOG_TAG = StateRepository.class.getSimpleName();

    private static StateRepository instance = null;
    public Integer selectedTab = 0;
    private Map<String, Parcelable> scrollState = new HashMap<>();
    public static StateRepository getInstance() {
        if (instance == null)
            synchronized (StateRepository.class) {
                if (instance == null) instance = new StateRepository();
            }
        return instance;
    }

    public void saveScroll(String key, Parcelable state) {
        scrollState.put(key, state);
    }
    public Parcelable getScroll(String key) {
        return scrollState.containsKey(key) ? scrollState.get(key) : null;
    }
}
