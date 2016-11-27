package com.usyasha69.pk.wf.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;

import com.usyasha69.pk.wf.model.DetailedWeatherModel;
import com.usyasha69.pk.wf.model.ParsingWeatherModel;
import com.usyasha69.pk.wf.model.ShortWeatherModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DatabaseManager {
    private static final int DEFAULT_WEATHER_INDEX = 0;
    private static final int M_SEC = 1000;

    private ContentResolver contentResolver;

    public DatabaseManager(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    public void insertWeather(ParsingWeatherModel parsingWeatherModel) {
        ContentValues[] contentValuesArray = new ContentValues[parsingWeatherModel.cnt];

        for (int i = 0; i < contentValuesArray.length; i++) {
            ContentValues contentValues = new ContentValues();

            contentValues.put(WeatherTable.Columns.CNT, parsingWeatherModel.cnt);
            contentValues.put(WeatherTable.Columns.NAME, parsingWeatherModel.city.name);
            contentValues.put(WeatherTable.Columns.LATITUDE, parsingWeatherModel.city.coord.lat);
            contentValues.put(WeatherTable.Columns.LONGITUDE, parsingWeatherModel.city.coord.lon);
            contentValues.put(WeatherTable.Columns.POPULATION, parsingWeatherModel.city.population);
            contentValues.put(WeatherTable.Columns.UNIX_DATE, parsingWeatherModel.list.get(i).dt * M_SEC);
            contentValues.put(WeatherTable.Columns.TXT_DATE,
                    new SimpleDateFormat("dd-MM-y HH:mm:ss", Locale.getDefault())
                            .format(parsingWeatherModel.list.get(i).dt * M_SEC));
            contentValues.put(WeatherTable.Columns.DAY_TEMPERATURE, parsingWeatherModel.list.get(i).temp.day);
            contentValues.put(WeatherTable.Columns.MIN_TEMPERATURE, parsingWeatherModel.list.get(i).temp.min);
            contentValues.put(WeatherTable.Columns.MAX_TEMPERATURE, parsingWeatherModel.list.get(i).temp.max);
            contentValues.put(WeatherTable.Columns.NIGHT_TEMPERATURE, parsingWeatherModel.list.get(i).temp.night);
            contentValues.put(WeatherTable.Columns.EVENING_TEMPERATURE, parsingWeatherModel.list.get(i).temp.eve);
            contentValues.put(WeatherTable.Columns.MORNING_TEMPERATURE, parsingWeatherModel.list.get(i).temp.morn);
            contentValues.put(WeatherTable.Columns.PRESSURE, parsingWeatherModel.list.get(i).pressure);
            contentValues.put(WeatherTable.Columns.HUMIDITY, parsingWeatherModel.list.get(i).humidity);
            contentValues.put(WeatherTable.Columns.MAIN_WEATHER,
                    parsingWeatherModel.list.get(i).weather.get(DEFAULT_WEATHER_INDEX).main);
            contentValues.put(WeatherTable.Columns.DESCRIPTION_WEATHER,
                    parsingWeatherModel.list.get(i).weather.get(DEFAULT_WEATHER_INDEX).description);
            contentValues.put(WeatherTable.Columns.WIND_SPEED, parsingWeatherModel.list.get(i).speed);
            contentValues.put(WeatherTable.Columns.DEG, parsingWeatherModel.list.get(i).deg);
            contentValues.put(WeatherTable.Columns.CLOUDS, parsingWeatherModel.list.get(i).clouds);
            contentValues.put(WeatherTable.Columns.RAIN, parsingWeatherModel.list.get(i).rain);

            contentValuesArray[i] = contentValues;
        }

        contentResolver.bulkInsert(WeatherTable.CONTENT_URI, contentValuesArray);
    }

    public void updateWeather(ParsingWeatherModel parsingWeatherModel) {

    }

    public ShortWeatherModel getShortWeather() {
        ShortWeatherModel shortWeatherModel = new ShortWeatherModel();

        Cursor cursor = contentResolver.query(WeatherTable.CONTENT_URI, new String[]{WeatherTable.Columns.NAME,
                WeatherTable.Columns.UNIX_DATE, WeatherTable.Columns.TXT_DATE, WeatherTable.Columns.DAY_TEMPERATURE,
                WeatherTable.Columns.DESCRIPTION_WEATHER}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            ArrayList<Long> unixDate = new ArrayList<>();
            ArrayList<String> txtDate = new ArrayList<>();
            ArrayList<Double> temperature = new ArrayList<>();
            ArrayList<String> weather = new ArrayList<>();

            do {
                if (shortWeatherModel.cityName == null) {
                    shortWeatherModel.cityName = cursor.getString(WeatherTable.ColumnIndices.NAME);
                }

                unixDate.add(cursor.getLong(WeatherTable.ColumnIndices.UNIX_DATE));
                txtDate.add(cursor.getString(WeatherTable.ColumnIndices.TXT_DATE));
                temperature.add(cursor.getDouble(WeatherTable.ColumnIndices.DAY_TEMPERATURE));
                weather.add(cursor.getString(WeatherTable.ColumnIndices.DESCRIPTION_WEATHER));
            } while (cursor.moveToNext());

            shortWeatherModel.unixDate = unixDate;
            shortWeatherModel.txtDate = txtDate;
            shortWeatherModel.temperature = temperature;
            shortWeatherModel.weather = weather;

            cursor.close();
        }

        return shortWeatherModel;
    }

    public DetailedWeatherModel getDetailedWeather() {
        return null;
    }

    public boolean checkWeatherExistence() {
        return false;
    }
}
