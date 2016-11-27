package com.usyasha69.pk.wf.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

import com.usyasha69.pk.wf.BuildConfig;

public class WeatherTable implements Table {
    public static final String NAME = "weather";

    public static final String CREATE = "CREATE TABLE "
            + NAME
            + "("
            + Columns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Columns.CNT
            + " INTEGER, "
            + Columns.NAME
            + " TEXT, "
            + Columns.LATITUDE
            + " REAL, "
            + Columns.LONGITUDE
            + " REAL, "
            + Columns.POPULATION
            + " INTEGER, "
            + Columns.UNIX_DATE
            + " INTEGER, "
            + Columns.TXT_DATE
            + " TEXT, "
            + Columns.DAY_TEMPERATURE
            + " REAL, "
            + Columns.MIN_TEMPERATURE
            + " REAL, "
            + Columns.MAX_TEMPERATURE
            + " REAL, "
            + Columns.NIGHT_TEMPERATURE
            + " REAL, "
            + Columns.EVENING_TEMPERATURE
            + " REAL, "
            + Columns.MORNING_TEMPERATURE
            + " REAL, "
            + Columns.PRESSURE
            + " REAL, "
            + Columns.HUMIDITY
            + " INTEGER, "
            + Columns.MAIN_WEATHER
            + " TEXT, "
            + Columns.DESCRIPTION_WEATHER
            + " TEXT, "
            + Columns.WIND_SPEED
            + " REAL, "
            + Columns.DEG
            + " INTEGER, "
            + Columns.CLOUDS
            + " INTEGER, "
            + Columns.RAIN
            + " REAL "
            + ");";

    public static final String DROP = "DROP TABLE IF EXISTS " + NAME;

    private static final String MIME_TYPE = "vnd." + BuildConfig.AUTHORITY + "_" + NAME;

    private static final String CONTENT_PATH = "content://" + BuildConfig.AUTHORITY + "/" + NAME;

    public static final Uri CONTENT_URI = Uri.parse(CONTENT_PATH);

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getColumnId() {
        return Columns._ID;
    }

    @Override
    public Uri getItemUri(long id) {
        return Uri.parse(CONTENT_PATH + "/" + id);
    }

    public String getContentItemType() {
        return ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + MIME_TYPE;
    }

    public String getContentType() {
        return ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + MIME_TYPE;
    }

    public interface Columns extends BaseColumns {
        String CNT = "cnt";
        String NAME = "name";
        String LATITUDE = "latitude";
        String LONGITUDE = "longitude";
        String POPULATION = "population";
        String UNIX_DATE = "unix_date";
        String TXT_DATE = "txt_date";
        String DAY_TEMPERATURE = "day_temperature";
        String MIN_TEMPERATURE = "min_temperature";
        String MAX_TEMPERATURE = "max_temperature";
        String NIGHT_TEMPERATURE = "night_temperature";
        String EVENING_TEMPERATURE = "evening_temperature";
        String MORNING_TEMPERATURE = "morning_temperature";
        String PRESSURE = "pressure";
        String HUMIDITY = "humidity";
        String MAIN_WEATHER = "main_weather";
        String DESCRIPTION_WEATHER = "description_weather";
        String WIND_SPEED = "wind_speed";
        String DEG = "deg";
        String CLOUDS = "clouds";
        String RAIN = "rain";
    }

    public interface ColumnIndices {
        int _ID = 0;
        int CNT = 1;
        int NAME = 2;
        int LATITUDE = 3;
        int LONGITUDE = 4;
        int POPULATION = 5;
        int UNIX_DATE = 6;
        int TXT_DATE = 7;
        int DAY_TEMPERATURE = 8;
        int MIN_TEMPERATURE = 9;
        int MAX_TEMPERATURE = 10;
        int NIGHT_TEMPERATURE = 11;
        int EVENING_TEMPERATURE = 12;
        int MORNING_TEMPERATURE = 13;
        int PRESSURE = 14;
        int HUMIDITY = 15;
        int MAIN_WEATHER = 16;
        int DESCRIPTION_WEATHER = 17;
        int WIND_SPEED = 18;
        int DEG = 19;
        int CLOUDS = 20;
        int RAIN = 21;
    }
}
