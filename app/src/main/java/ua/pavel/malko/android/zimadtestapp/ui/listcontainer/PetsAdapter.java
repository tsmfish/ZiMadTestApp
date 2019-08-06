package ua.pavel.malko.android.zimadtestapp.ui.listcontainer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ua.pavel.malko.android.zimadtestapp.R;
import ua.pavel.malko.android.zimadtestapp.databinding.ItemPetBinding;
import ua.pavel.malko.android.zimadtestapp.model.Pet;

public class PetsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final OnItemClick listener;
    private List<Pet> pets = null;
    private Context context;

    public PetsAdapter(OnItemClick listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null) context = parent.getContext();
        return new PetViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(context),
                        R.layout.item_pet,
                        parent,
                        false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((PetViewHolder) holder).bind(pets.get(position), position + 1);
    }

    @Override
    public int getItemCount() {
        return pets != null ? pets.size() : 0;
    }
    public void update(List<Pet> pets) {
        this.pets = pets;
        notifyDataSetChanged();
    }

    interface OnItemClick {
        void OnItemClick(int position, Pet pet);
    }

    class PetViewHolder extends RecyclerView.ViewHolder {
        ItemPetBinding binding;
        View.OnClickListener listener = view -> {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && position < getItemCount() && PetsAdapter.this.listener != null)
                PetsAdapter.this.listener.OnItemClick(position, pets.get(position));
        };

        public PetViewHolder(@NonNull ItemPetBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Pet item, Integer position) {
            binding.setItem(item);
            binding.setIndex(position);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(listener);
        }
    }
}
