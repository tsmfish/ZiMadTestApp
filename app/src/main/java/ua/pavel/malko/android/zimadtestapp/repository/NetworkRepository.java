package ua.pavel.malko.android.zimadtestapp.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.readystatesoftware.chuck.ChuckInterceptor;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.pavel.malko.android.zimadtestapp.BuildConfig;
import ua.pavel.malko.android.zimadtestapp.Constants;
import ua.pavel.malko.android.zimadtestapp.model.Pet;
import ua.pavel.malko.android.zimadtestapp.model.PetsListResponse;

import static ua.pavel.malko.android.zimadtestapp.Constants.BASE_URL;

public class NetworkRepository {
    private static final String LOG_TAG = NetworkRepository.class.getSimpleName();

    private static NetworkRepository instance = null;
    private Retrofit retrofit;
    private Api api;
    private MutableLiveData<List<Pet>> result = new MutableLiveData<>();
    private NetworkRepository() {
    }
    public static NetworkRepository getInstance() {
        if (instance == null)
            synchronized (NetworkRepository.class) {
                if (instance == null) instance = new NetworkRepository();
            }
        return instance;
    }
    public NetworkRepository init(Application application) {
        if (!isInit()) {
            final OkHttpClient client;
            if (BuildConfig.DEBUG) {
                client = new OkHttpClient.Builder()
                        .addInterceptor(new ChuckInterceptor(application.getApplicationContext())
                                .showNotification(true))
                        .build();
            } else {
                client = new OkHttpClient.Builder()
                        .build();
            }
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(Api.class);
        }

        return this;
    }

    public boolean isInit() {
        return retrofit != null;
    }

    public LiveData<List<Pet>> getPets(Constants.PetsType type) {
        if (!isInit()) throw new IllegalStateException("Must be initialised before call");

        result.postValue(new ArrayList<>());

        api.friends(type.key).enqueue(new Callback<PetsListResponse>() {
            @Override
            public void onResponse(Call<PetsListResponse> call, Response<PetsListResponse> response) {
                if (response.isSuccessful()
                        && response.body() != null) {
                    if (BuildConfig.DEBUG)
                        Log.d(LOG_TAG, String.format("NetworkRepository::getPets(%s).size(): %d",
                                type.name(),
                                response.body().getPets().size()));
                    result.postValue(response.body().getPets());
                }
            }
            @Override
            public void onFailure(Call<PetsListResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return result;
    }
}
