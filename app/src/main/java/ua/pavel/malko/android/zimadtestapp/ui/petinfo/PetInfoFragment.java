package ua.pavel.malko.android.zimadtestapp.ui.petinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import ua.pavel.malko.android.zimadtestapp.R;
import ua.pavel.malko.android.zimadtestapp.databinding.FragmentPetInfoBinding;

public class PetInfoFragment extends Fragment {
    private static final String LOG_TAG = PetInfoFragment.class.getSimpleName();
    private static final String KEY_IMAGE_URL = "image url";
    private static final String KEY_TITLE = "title";
    private FragmentPetInfoBinding binding;
    private PetInfoViewModel viewModel;
    public static PetInfoFragment getInstance(String imageUrl, String title) {
        final PetInfoFragment fragment = new PetInfoFragment();
        final Bundle arguments = new Bundle();

        arguments.putString(KEY_IMAGE_URL, imageUrl);
        arguments.putString(KEY_TITLE, title);
        fragment.setArguments(arguments);

        return fragment;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Bundle arguments = getArguments() != null ? getArguments() : new Bundle();
        final String imageUrl = arguments.getString(KEY_IMAGE_URL, ""),
                title = arguments.getString(KEY_TITLE, "");
        viewModel = ViewModelProviders.of(this, new PetInfoViewModelFactory(imageUrl, title)).get(PetInfoViewModel.class);

        binding.setViewModel(viewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pet_info, container, false);
        return binding.getRoot();
    }
}
