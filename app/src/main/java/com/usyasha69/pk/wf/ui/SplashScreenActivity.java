package com.usyasha69.pk.wf.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.usyasha69.pk.wf.R;
import com.usyasha69.pk.wf.model.FullWeatherModel;
import com.usyasha69.pk.wf.net.QueryManager;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        QueryManager.getWeatherByCity("Kharkiv", 3, new Callback<FullWeatherModel>() {
            @Override
            public void success(FullWeatherModel fullWeatherModel, Response response) {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class).
                putExtra("full weather model", fullWeatherModel));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
