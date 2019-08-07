package ua.pavel.malko.android.zimadtestapp.ui.listcontainer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import ua.pavel.malko.android.zimadtestapp.BuildConfig;
import ua.pavel.malko.android.zimadtestapp.Constants;
import ua.pavel.malko.android.zimadtestapp.R;
import ua.pavel.malko.android.zimadtestapp.databinding.FragmentListContinerBinding;
import ua.pavel.malko.android.zimadtestapp.ui.petinfo.PetInfoFragment;

import static ua.pavel.malko.android.zimadtestapp.Constants.TAG_INFO_CONTAINER;

public class ListContainerFragment extends Fragment {
    private static final String LOG_TAG = ListContainerFragment.class.getSimpleName();

    private final static String PETS_TYPE_KEY = "pets";
    private final static String SCROLL_STATE_KEY = "pets";

    private ListContainerViewModel viewModel;
    private FragmentListContinerBinding binding;
    private PetsAdapter adapter = new PetsAdapter((position, pet) -> {
        if (BuildConfig.DEBUG)
            Log.d(LOG_TAG, "PetsAdapter::onItemClick(" + position + ", " + pet.getTitle() + ")");
        if (position != RecyclerView.NO_POSITION && pet != null) {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.nav_host_fragment,
                            PetInfoFragment.getInstance(pet.getImageUrl(), pet.getTitle(), position + 1),
                            TAG_INFO_CONTAINER
                    )
                    .commit();
        }
    });

    public static ListContainerFragment getInstance(Constants.PetsType type) {
        if (BuildConfig.DEBUG)
            Log.d(LOG_TAG, "getInstance() called with: type = [" + type + "]");
        final ListContainerFragment instance = new ListContainerFragment();
        final Bundle arguments = new Bundle();
        arguments.putString(PETS_TYPE_KEY, type.name());

        instance.setArguments(arguments);
        return instance;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Bundle arguments = getArguments() != null ? getArguments() : new Bundle();
        final Constants.PetsType type = Constants.PetsType.valueOf(arguments.getString(PETS_TYPE_KEY, Constants.PetsType.CATS.name()));
        viewModel = ViewModelProviders.of(this, new ListContainerViewModelFactory(type)).get(ListContainerViewModel.class);

        binding.rvPets.setHasFixedSize(true);
        binding.setAdapter(adapter);

        subscribeToViewModel(viewModel);

//        if (savedInstanceState != null && savedInstanceState.containsKey(SCROLL_STATE_KEY)) {
//            binding.rvPets.setScrollY(savedInstanceState.getInt(SCROLL_STATE_KEY));
//        }
    }

    private void subscribeToViewModel(ListContainerViewModel viewModel) {
        viewModel.pets.observe(getViewLifecycleOwner(), pets -> {
            if (pets != null) {
                Log.d(LOG_TAG, "before update rvPets.getScaleY(): " + binding.rvPets.getScaleY());
                adapter.update(pets);
                Log.d(LOG_TAG, "after update rvPets.getScaleY(): " + binding.rvPets.getScaleY());
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_continer, container, false);
        return binding.getRoot();
    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        outState.putInt(SCROLL_STATE_KEY, binding.rvPets.getScrollY());
//        super.onSaveInstanceState(outState);
//    }
}
