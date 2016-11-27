package com.usyasha69.pk.wf.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.usyasha69.pk.wf.R;
import com.usyasha69.pk.wf.model.FullWeatherModel;
import com.usyasha69.pk.wf.net.QueryManager;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(getIntent().getParcelableExtra("full weather model").toString());
    }
}
