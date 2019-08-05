package ua.pavel.malko.android.zimadtestapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ua.pavel.malko.android.zimadtestapp.R;
import ua.pavel.malko.android.zimadtestapp.ui.tabcontainer.TabContainerFragment;

import static ua.pavel.malko.android.zimadtestapp.Constants.TAG_TAB_CONTAINER;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.nav_host_fragment,
                        new TabContainerFragment(),
                        TAG_TAB_CONTAINER)
                .commit();
    }
}
