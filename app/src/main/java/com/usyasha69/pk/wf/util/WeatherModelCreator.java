package com.usyasha69.pk.wf.util;

import com.usyasha69.pk.wf.model.DetailedWeatherModel;
import com.usyasha69.pk.wf.model.ParsingWeatherModel;
import com.usyasha69.pk.wf.model.ShortWeatherModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class WeatherModelCreator {
    private static final int DEFAULT_WEATHER_INDEX = 0;
    private static final int M_SEC = 1000;

    public static ShortWeatherModel toShortWeatherModel(ParsingWeatherModel parsingWeatherModel) {
        ShortWeatherModel shortWeatherModel = new ShortWeatherModel();

        ArrayList<Long> unixDate = new ArrayList<>();
        ArrayList<String> txtDate = new ArrayList<>();
        ArrayList<Double> temperature = new ArrayList<>();
        ArrayList<String> weather = new ArrayList<>();

        for (ParsingWeatherModel.List list : parsingWeatherModel.list) {
            unixDate.add(list.dt * M_SEC);
            txtDate.add(new SimpleDateFormat("dd-MM-y HH:mm:ss", Locale.getDefault()).format(list.dt * M_SEC));
            temperature.add(list.temp.day);
            weather.add(list.weather.get(DEFAULT_WEATHER_INDEX).description);
        }

        shortWeatherModel.cityName = parsingWeatherModel.city.name;
        shortWeatherModel.unixDate = unixDate;
        shortWeatherModel.txtDate = txtDate;
        shortWeatherModel.temperature = temperature;
        shortWeatherModel.weather = weather;

        return shortWeatherModel;
    }

    public static DetailedWeatherModel toDetailedWeatherModel(ParsingWeatherModel parsingWeatherModel) {
        DetailedWeatherModel detailedWeatherModel = new DetailedWeatherModel();

        ArrayList<Long> unixDate = new ArrayList<>();
        ArrayList<String> txtDate = new ArrayList<>();
        ArrayList<Double> dayTemperature = new ArrayList<>();
        ArrayList<Double> minTemperature = new ArrayList<>();
        ArrayList<Double> maxTemperature = new ArrayList<>();
        ArrayList<Double> nightTemperature = new ArrayList<>();
        ArrayList<Double> eveningTemperature = new ArrayList<>();
        ArrayList<Double> morningTemperature = new ArrayList<>();
        ArrayList<Double> pressure = new ArrayList<>();
        ArrayList<Integer> humidity = new ArrayList<>();
        ArrayList<String> weather = new ArrayList<>();
        ArrayList<Double> speed = new ArrayList<>();
        ArrayList<Integer> deg = new ArrayList<>();
        ArrayList<Integer> clouds = new ArrayList<>();
        ArrayList<Double> rain = new ArrayList<>();

        for (ParsingWeatherModel.List list : parsingWeatherModel.list) {
            unixDate.add(list.dt * M_SEC);
            txtDate.add(new SimpleDateFormat("dd-MM-y HH:mm:ss", Locale.getDefault()).format(list.dt * M_SEC));
            dayTemperature.add(list.temp.day);
            minTemperature.add(list.temp.min);
            maxTemperature.add(list.temp.max);
            nightTemperature.add(list.temp.night);
            eveningTemperature.add(list.temp.eve);
            morningTemperature.add(list.temp.morn);
            pressure.add(list.pressure);
            humidity.add(list.humidity);
            weather.add(list.weather.get(DEFAULT_WEATHER_INDEX).description);
            speed.add(list.speed);
            deg.add(list.deg);
            clouds.add(list.clouds);
            rain.add(list.rain);
        }

        detailedWeatherModel.cityName = parsingWeatherModel.city.name;
        detailedWeatherModel.unixDate = unixDate;
        detailedWeatherModel.txtDate = txtDate;
        detailedWeatherModel.dayTemperature = dayTemperature;
        detailedWeatherModel.minTemperature = minTemperature;
        detailedWeatherModel.maxTemperature = maxTemperature;
        detailedWeatherModel.nightTemperature = nightTemperature;
        detailedWeatherModel.eveningTemperature = eveningTemperature;
        detailedWeatherModel.morningTemperature = morningTemperature;
        detailedWeatherModel.pressure = pressure;
        detailedWeatherModel.humidity = humidity;
        detailedWeatherModel.weather = weather;
        detailedWeatherModel.speed = speed;
        detailedWeatherModel.deg = deg;
        detailedWeatherModel.clouds = clouds;
        detailedWeatherModel.rain = rain;

        return detailedWeatherModel;
    }
}
