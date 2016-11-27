package com.usyasha69.pk.wf.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.usyasha69.pk.wf.R;
import com.usyasha69.pk.wf.model.DetailedWeatherModel;
import com.usyasha69.pk.wf.model.ShortWeatherModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(getIntent().getParcelableExtra(ShortWeatherModel.SHORT_WEATHER_MODEL_KEY).toString()
                + "\n" + getIntent().getParcelableExtra(DetailedWeatherModel.DETAILED_WEATHER_MODEL_KEY).toString());
    }
}
