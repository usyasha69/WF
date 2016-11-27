package com.usyasha69.pk.wf.net;

import com.usyasha69.pk.wf.model.ParsingWeatherModel;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

public class QueryManager {
    private static final String OPEN_WEATHER_MAP_BASE_URL = "http://api.openweathermap.org";
    private static final String OPEN_WEATHER_MAP_APPID_KEY = "aea31abf1a19c86b906ba10fba61066e";

    private static WeatherAPI weatherAPI;

    static {
        initialize();
    }

    private interface WeatherAPI {
        @GET("/data/2.5/forecast/daily")
        void getWeatherByCity(@Query("q") String city, @Query("cnt") int cnt,
                              @Query("appid") String appid, Callback<ParsingWeatherModel> callback);

        @GET("/data/2.5/forecast/daily")
        void getWeatherByCoordinates(@Query("lat") String lat, @Query("lon") String lon,
                                     @Query("cnt") int cnt, @Query("appid") String appid,
                                     Callback<ParsingWeatherModel> callback);
    }

    private static void initialize() {
        RestAdapter restAdapter  = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(OPEN_WEATHER_MAP_BASE_URL)
                .build();

        weatherAPI = restAdapter.create(WeatherAPI.class);
    }

    public static void getWeatherByCity(String city, int cnt, Callback<ParsingWeatherModel> callback) {
        weatherAPI.getWeatherByCity(city, cnt, OPEN_WEATHER_MAP_APPID_KEY, callback);
    }

    public static void getWeatherByCoordinates(String lat, String lon, int cnt,
                                               Callback<ParsingWeatherModel> callback) {
        weatherAPI.getWeatherByCoordinates(lat, lon, cnt, OPEN_WEATHER_MAP_APPID_KEY, callback);
    }
}
