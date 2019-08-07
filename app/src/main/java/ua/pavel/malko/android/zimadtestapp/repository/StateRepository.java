package ua.pavel.malko.android.zimadtestapp.repository;

public class StateRepository {
    private static final String LOG_TAG = StateRepository.class.getSimpleName();

    private static StateRepository instance = null;
    public Integer selectedTab = 0;
    public static StateRepository getInstance() {
        if (instance == null)
            synchronized (StateRepository.class) {
                if (instance == null) instance = new StateRepository();
            }
        return instance;
    }
}
