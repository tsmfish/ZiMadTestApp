package ua.pavel.malko.android.zimadtestapp.repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.pavel.malko.android.zimadtestapp.model.PetsListResponse;

public interface Api {
    @GET("/xim/api.php")
    Call<PetsListResponse> friends(@Query("query") String type);
}
