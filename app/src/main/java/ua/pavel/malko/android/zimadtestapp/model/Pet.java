package ua.pavel.malko.android.zimadtestapp.model;


import com.google.gson.annotations.SerializedName;

public class Pet {
    @SerializedName("url")
    private String imageUrl;

    @SerializedName("title")
    private String title;

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
