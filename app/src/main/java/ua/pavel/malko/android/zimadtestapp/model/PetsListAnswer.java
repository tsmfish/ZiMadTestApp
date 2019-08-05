package ua.pavel.malko.android.zimadtestapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PetsListAnswer {
    @SerializedName("data")
    List<Pet> pets;
    @SerializedName("message")
    private String text;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public List<Pet> getPets() {
        return pets;
    }
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
