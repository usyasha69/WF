package com.usyasha69.pk.wf.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.usyasha69.pk.wf.R;
import com.usyasha69.pk.wf.database.DatabaseManager;
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
                DatabaseManager databaseManager = new DatabaseManager(getContentResolver());

                ShortWeatherModel shortWeatherModel;
                DetailedWeatherModel detailedWeatherModel;

                if (!databaseManager.isWeatherExistence()) {
                    databaseManager.insertWeather(parsingWeatherModel);
                    System.out.println("Insert to DB weather!");
                    shortWeatherModel = WeatherModelCreator.toShortWeatherModel(parsingWeatherModel);
                    detailedWeatherModel = WeatherModelCreator.toDetailedWeatherModel(parsingWeatherModel);
                } else {
                    shortWeatherModel = databaseManager.getShortWeather();
                    detailedWeatherModel = databaseManager.getDetailedWeather();

                    System.out.println("Read from DB weather!");
                }

                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class).
                putExtra(ShortWeatherModel.SHORT_WEATHER_MODEL_KEY, shortWeatherModel).
                putExtra(DetailedWeatherModel.DETAILED_WEATHER_MODEL_KEY, detailedWeatherModel));
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
