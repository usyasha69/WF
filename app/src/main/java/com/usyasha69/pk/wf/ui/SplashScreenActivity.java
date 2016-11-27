package com.usyasha69.pk.wf.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.usyasha69.pk.wf.R;
import com.usyasha69.pk.wf.model.DetailedWeatherModel;
import com.usyasha69.pk.wf.model.ParsingWeatherModel;
import com.usyasha69.pk.wf.model.ShortWeatherModel;
import com.usyasha69.pk.wf.net.QueryManager;
import com.usyasha69.pk.wf.util.WeatherModelCreator;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        QueryManager.getWeatherByCity("Kharkiv", 3, new Callback<ParsingWeatherModel>() {
            @Override
            public void success(ParsingWeatherModel parsingWeatherModel, Response response) {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class).
                putExtra(ShortWeatherModel.SHORT_WEATHER_MODEL_KEY, WeatherModelCreator.toShortWeatherModel(parsingWeatherModel)).
                putExtra(DetailedWeatherModel.DETAILED_WEATHER_MODEL_KEY, WeatherModelCreator.toDetailedWeatherModel(parsingWeatherModel)));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
