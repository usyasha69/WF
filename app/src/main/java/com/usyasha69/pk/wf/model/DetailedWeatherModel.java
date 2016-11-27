package com.usyasha69.pk.wf.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class DetailedWeatherModel implements Parcelable {
    public static final String DETAILED_WEATHER_MODEL_KEY = "detailed weather model";

    public String cityName;
    public ArrayList<Long> unixDate;
    public ArrayList<String> txtDate;
    public ArrayList<Double> dayTemperature;
    public ArrayList<Double> minTemperature;
    public ArrayList<Double> maxTemperature;
    public ArrayList<Double> nightTemperature;
    public ArrayList<Double> eveningTemperature;
    public ArrayList<Double> morningTemperature;
    public ArrayList<Double> pressure;
    public ArrayList<Integer> humidity;
    public ArrayList<String> weather;
    public ArrayList<Double> windSpeed;
    public ArrayList<Integer> deg;
    public ArrayList<Integer> clouds;
    public ArrayList<Double> rain;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailedWeatherModel that = (DetailedWeatherModel) o;

        if (!cityName.equals(that.cityName)) return false;
        if (!unixDate.equals(that.unixDate)) return false;
        if (!txtDate.equals(that.txtDate)) return false;
        if (!dayTemperature.equals(that.dayTemperature)) return false;
        if (!minTemperature.equals(that.minTemperature)) return false;
        if (!maxTemperature.equals(that.maxTemperature)) return false;
        if (!nightTemperature.equals(that.nightTemperature)) return false;
        if (!eveningTemperature.equals(that.eveningTemperature)) return false;
        if (!morningTemperature.equals(that.morningTemperature)) return false;
        if (!pressure.equals(that.pressure)) return false;
        if (!humidity.equals(that.humidity)) return false;
        if (!weather.equals(that.weather)) return false;
        if (!windSpeed.equals(that.windSpeed)) return false;
        if (!deg.equals(that.deg)) return false;
        if (!clouds.equals(that.clouds)) return false;
        return rain.equals(that.rain);

    }

    @Override
    public int hashCode() {
        int result = cityName.hashCode();
        result = 31 * result + unixDate.hashCode();
        result = 31 * result + txtDate.hashCode();
        result = 31 * result + dayTemperature.hashCode();
        result = 31 * result + minTemperature.hashCode();
        result = 31 * result + maxTemperature.hashCode();
        result = 31 * result + nightTemperature.hashCode();
        result = 31 * result + eveningTemperature.hashCode();
        result = 31 * result + morningTemperature.hashCode();
        result = 31 * result + pressure.hashCode();
        result = 31 * result + humidity.hashCode();
        result = 31 * result + weather.hashCode();
        result = 31 * result + windSpeed.hashCode();
        result = 31 * result + deg.hashCode();
        result = 31 * result + clouds.hashCode();
        result = 31 * result + rain.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DetailedWeatherModel{" +
                "cityName='" + cityName + '\'' +
                ", unixDate=" + unixDate +
                ", txtDate=" + txtDate +
                ", dayTemperature=" + dayTemperature +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", nightTemperature=" + nightTemperature +
                ", eveningTemperature=" + eveningTemperature +
                ", morningTemperature=" + morningTemperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", weather=" + weather +
                ", windSpeed=" + windSpeed +
                ", deg=" + deg +
                ", clouds=" + clouds +
                ", rain=" + rain +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cityName);
        dest.writeList(this.unixDate);
        dest.writeStringList(this.txtDate);
        dest.writeList(this.dayTemperature);
        dest.writeList(this.minTemperature);
        dest.writeList(this.maxTemperature);
        dest.writeList(this.nightTemperature);
        dest.writeList(this.eveningTemperature);
        dest.writeList(this.morningTemperature);
        dest.writeList(this.pressure);
        dest.writeList(this.humidity);
        dest.writeStringList(this.weather);
        dest.writeList(this.windSpeed);
        dest.writeList(this.deg);
        dest.writeList(this.clouds);
        dest.writeList(this.rain);
    }

    public DetailedWeatherModel() {
    }

    protected DetailedWeatherModel(Parcel in) {
        this.cityName = in.readString();
        this.unixDate = new ArrayList<>();
        in.readList(this.unixDate, Long.class.getClassLoader());
        this.txtDate = in.createStringArrayList();
        this.dayTemperature = new ArrayList<>();
        in.readList(this.dayTemperature, Double.class.getClassLoader());
        this.minTemperature = new ArrayList<>();
        in.readList(this.minTemperature, Double.class.getClassLoader());
        this.maxTemperature = new ArrayList<>();
        in.readList(this.maxTemperature, Double.class.getClassLoader());
        this.nightTemperature = new ArrayList<>();
        in.readList(this.nightTemperature, Double.class.getClassLoader());
        this.eveningTemperature = new ArrayList<>();
        in.readList(this.eveningTemperature, Double.class.getClassLoader());
        this.morningTemperature = new ArrayList<>();
        in.readList(this.morningTemperature, Double.class.getClassLoader());
        this.pressure = new ArrayList<>();
        in.readList(this.pressure, Double.class.getClassLoader());
        this.humidity = new ArrayList<>();
        in.readList(this.humidity, Integer.class.getClassLoader());
        this.weather = in.createStringArrayList();
        this.windSpeed = new ArrayList<>();
        in.readList(this.windSpeed, Double.class.getClassLoader());
        this.deg = new ArrayList<>();
        in.readList(this.deg, Integer.class.getClassLoader());
        this.clouds = new ArrayList<>();
        in.readList(this.clouds, Integer.class.getClassLoader());
        this.rain = new ArrayList<>();
        in.readList(this.rain, Double.class.getClassLoader());
    }

    public static final Creator<DetailedWeatherModel> CREATOR = new Creator<DetailedWeatherModel>() {
        @Override
        public DetailedWeatherModel createFromParcel(Parcel source) {
            return new DetailedWeatherModel(source);
        }

        @Override
        public DetailedWeatherModel[] newArray(int size) {
            return new DetailedWeatherModel[size];
        }
    };
}
