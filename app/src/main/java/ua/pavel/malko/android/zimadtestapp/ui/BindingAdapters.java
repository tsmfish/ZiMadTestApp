package ua.pavel.malko.android.zimadtestapp.ui;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public abstract class BindingAdapters {
    @BindingAdapter("setSrc")
    public static void setSrc(ImageView view, String url) {
        if (view != null && !TextUtils.isEmpty(url)) {
            Picasso
                    .get()
                    .load(url)
                    .fit()
                    .centerCrop()
                    .into(view);
        }
    }
}
