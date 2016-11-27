package com.usyasha69.pk.wf.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.usyasha69.pk.wf.R;
import com.usyasha69.pk.wf.database.DatabaseManager;
import com.usyasha69.pk.wf.model.DetailedWeatherModel;
import com.usyasha69.pk.wf.model.ParsingWeatherModel;
import com.usyasha69.pk.wf.model.ShortWeatherModel;
import com.usyasha69.pk.wf.net.QueryManager;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(getIntent().getParcelableExtra(ShortWeatherModel.SHORT_WEATHER_MODEL_KEY).toString()
                + "\n" + getIntent().getParcelableExtra(DetailedWeatherModel.DETAILED_WEATHER_MODEL_KEY).toString());

        QueryManager.getWeatherByCity("London", 3, new Callback<ParsingWeatherModel>() {
            @Override
            public void success(ParsingWeatherModel parsingWeatherModel, Response response) {
                DatabaseManager databaseManager = new DatabaseManager(getContentResolver());
                databaseManager.updateWeather(parsingWeatherModel);

                System.out.println(databaseManager.getShortWeather().toString()
                        + "\n" + databaseManager.getDetailedWeather().toString());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
