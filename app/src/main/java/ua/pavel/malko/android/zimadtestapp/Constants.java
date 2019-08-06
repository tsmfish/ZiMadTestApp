package ua.pavel.malko.android.zimadtestapp;

public abstract class Constants {
    public static final String TAG_LIST_CONTAINER = "list container";
    public static final String TAG_TAB_CONTAINER = "tab container";

    public static final String BASE_URL = "http://kot3.com";

    public enum PetsType {
        CATS("cat"), DOGS("dog");

        public final String key;
        PetsType(String key) {
            this.key = key;
        }
    }
}
