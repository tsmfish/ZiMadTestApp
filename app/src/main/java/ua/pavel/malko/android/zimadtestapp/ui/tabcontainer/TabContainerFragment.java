package ua.pavel.malko.android.zimadtestapp.ui.tabcontainer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

import ua.pavel.malko.android.zimadtestapp.BuildConfig;
import ua.pavel.malko.android.zimadtestapp.Constants;
import ua.pavel.malko.android.zimadtestapp.R;
import ua.pavel.malko.android.zimadtestapp.ui.listcontainer.ListContainerFragment;

import static ua.pavel.malko.android.zimadtestapp.Constants.TAG_LIST_CONTAINER;

public class TabContainerFragment extends Fragment {
    private static final String LOG_TAG = TabContainerFragment.class.getSimpleName();
    private static final String KEY_SELECTED_TAB = "selected tab";
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_continer, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onActivityCreated() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onActivityCreated(savedInstanceState);

        tabLayout = getView().findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (BuildConfig.DEBUG)
                    Log.d(LOG_TAG, "onTabSelected() called with: tab.getPosition = [" + tab.getPosition() + "]");
                switch (tab.getPosition()) {
                    case 0:
                        getActivity()
                                .getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.fl_tab_fragment_container,
                                        ListContainerFragment.getInstance(Constants.PetsType.CATS),
                                        TAG_LIST_CONTAINER)
                                .commit();
                        break;
                    case 1:
                        getActivity()
                                .getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.fl_tab_fragment_container,
                                        ListContainerFragment.getInstance(Constants.PetsType.DOGS),
                                        TAG_LIST_CONTAINER)
                                .commit();
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(LOG_TAG, "onSaveInstanceState() called with: outState = [" + outState + "]");
        outState.putInt(KEY_SELECTED_TAB, tabLayout.getSelectedTabPosition());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onViewStateRestored() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(KEY_SELECTED_TAB)) {
                tabLayout.getTabAt(savedInstanceState.getInt(KEY_SELECTED_TAB)).select();
            }
        }
    }
}
