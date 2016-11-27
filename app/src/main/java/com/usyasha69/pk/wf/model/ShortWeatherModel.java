package com.usyasha69.pk.wf.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ShortWeatherModel implements Parcelable {
    public static final String SHORT_WEATHER_MODEL_KEY = "short weather model";

    public String cityName;
    public ArrayList<Long> unixDate;
    public ArrayList<String> txtDate;
    public ArrayList<Double> temperature;
    public ArrayList<String> weather;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShortWeatherModel that = (ShortWeatherModel) o;

        if (!cityName.equals(that.cityName)) return false;
        if (!unixDate.equals(that.unixDate)) return false;
        if (!txtDate.equals(that.txtDate)) return false;
        if (!temperature.equals(that.temperature)) return false;
        return weather.equals(that.weather);

    }

    @Override
    public int hashCode() {
        int result = cityName.hashCode();
        result = 31 * result + unixDate.hashCode();
        result = 31 * result + txtDate.hashCode();
        result = 31 * result + temperature.hashCode();
        result = 31 * result + weather.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ShortWeatherModel{" +
                "cityName='" + cityName + '\'' +
                ", unixDate=" + unixDate +
                ", txtDate=" + txtDate +
                ", temperature=" + temperature +
                ", weather=" + weather +
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
        dest.writeList(this.temperature);
        dest.writeStringList(this.weather);
    }

    public ShortWeatherModel() {
    }

    protected ShortWeatherModel(Parcel in) {
        this.cityName = in.readString();
        this.unixDate = new ArrayList<>();
        in.readList(this.unixDate, Long.class.getClassLoader());
        this.txtDate = in.createStringArrayList();
        this.temperature = new ArrayList<>();
        in.readList(this.temperature, Double.class.getClassLoader());
        this.weather = in.createStringArrayList();
    }

    public static final Parcelable.Creator<ShortWeatherModel> CREATOR = new Parcelable.Creator<ShortWeatherModel>() {
        @Override
        public ShortWeatherModel createFromParcel(Parcel source) {
            return new ShortWeatherModel(source);
        }

        @Override
        public ShortWeatherModel[] newArray(int size) {
            return new ShortWeatherModel[size];
        }
    };
}
