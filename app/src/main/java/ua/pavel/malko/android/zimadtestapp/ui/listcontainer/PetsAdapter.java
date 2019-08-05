package ua.pavel.malko.android.zimadtestapp.ui.listcontainer;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ua.pavel.malko.android.zimadtestapp.model.Pet;

public class PetsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final OnItemClick listener;
    private List<Pet> pets = null;

    public PetsAdapter(OnItemClick listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return pets != null ? pets.size() : 0;
    }

    interface OnItemClick {
        void OnItemClick(int position, Pet pet);
    }

    class PetViewHolder extends RecyclerView.ViewHolder {

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
