package com.usyasha69.pk.wf.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class FullWeatherModel implements Parcelable {
    public City city;
    public ArrayList<City.List> list;
    public String cod;
    public double message;
    public int cnt;

    @Override
    public String toString() {
        return "FullWeatherModel{" +
                "city=" + city.toString() +
                ", list=" + list.toString() +
                ", cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                '}';
    }

    public static class City implements Parcelable {
        public int id;
        public String name;
        public Coord coord;
        public String country;
        public long population;

        @Override
        public String toString() {
            return "City{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", coord=" + coord.toString() +
                    ", country='" + country + '\'' +
                    ", population=" + population +
                    '}';
        }

        public static class Coord implements Parcelable {
            public double lon;
            public double lat;

            @Override
            public String toString() {
                return "Coord{" +
                        "lon=" + lon +
                        ", lat=" + lat +
                        '}';
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeDouble(this.lon);
                dest.writeDouble(this.lat);
            }

            public Coord() {
            }

            public Coord(Parcel in) {
                this.lon = in.readDouble();
                this.lat = in.readDouble();
            }

            public static final Creator<Coord> CREATOR = new Creator<Coord>() {
                @Override
                public Coord createFromParcel(Parcel source) {
                    return new Coord(source);
                }

                @Override
                public Coord[] newArray(int size) {
                    return new Coord[size];
                }
            };
        }

        public static class List implements Parcelable {
            public long dt;
            public Temp temp;
            public double pressure;
            public int humidity;
            public ArrayList<Weather> weather;
            public double speed;
            public int deg;
            public int clouds;
            public double rain;

            @Override
            public String toString() {
                return "List{" +
                        "dt=" + dt +
                        ", temp=" + temp.toString() +
                        ", pressure=" + pressure +
                        ", humidity=" + humidity +
                        ", weather=" + weather.toString() +
                        ", speed=" + speed +
                        ", deg=" + deg +
                        ", clouds=" + clouds +
                        ", rain=" + rain +
                        '}';
            }

            public static class Temp implements Parcelable {
                public double day;
                public double min;
                public double max;
                public double night;
                public double eve;
                public double morn;

                @Override
                public String toString() {
                    return "Temp{" +
                            "day=" + day +
                            ", min=" + min +
                            ", max=" + max +
                            ", night=" + night +
                            ", eve=" + eve +
                            ", morn=" + morn +
                            '}';
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeDouble(this.day);
                    dest.writeDouble(this.min);
                    dest.writeDouble(this.max);
                    dest.writeDouble(this.night);
                    dest.writeDouble(this.eve);
                    dest.writeDouble(this.morn);
                }

                public Temp() {
                }

                public Temp(Parcel in) {
                    this.day = in.readDouble();
                    this.min = in.readDouble();
                    this.max = in.readDouble();
                    this.night = in.readDouble();
                    this.eve = in.readDouble();
                    this.morn = in.readDouble();
                }

                public static final Creator<Temp> CREATOR = new Creator<Temp>() {
                    @Override
                    public Temp createFromParcel(Parcel source) {
                        return new Temp(source);
                    }

                    @Override
                    public Temp[] newArray(int size) {
                        return new Temp[size];
                    }
                };
            }

            public static class Weather implements Parcelable {
                public int id;
                public String main;
                public String description;
                public String icon;

                @Override
                public String toString() {
                    return "Weather{" +
                            "id=" + id +
                            ", main='" + main + '\'' +
                            ", description='" + description + '\'' +
                            ", icon='" + icon + '\'' +
                            '}';
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.id);
                    dest.writeString(this.main);
                    dest.writeString(this.description);
                    dest.writeString(this.icon);
                }

                public Weather() {
                }

                public Weather(Parcel in) {
                    this.id = in.readInt();
                    this.main = in.readString();
                    this.description = in.readString();
                    this.icon = in.readString();
                }

                public static final Creator<Weather> CREATOR = new Creator<Weather>() {
                    @Override
                    public Weather createFromParcel(Parcel source) {
                        return new Weather(source);
                    }

                    @Override
                    public Weather[] newArray(int size) {
                        return new Weather[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(this.dt);
                dest.writeParcelable(this.temp, flags);
                dest.writeDouble(this.pressure);
                dest.writeInt(this.humidity);
                dest.writeList(this.weather);
                dest.writeDouble(this.speed);
                dest.writeInt(this.deg);
                dest.writeInt(this.clouds);
                dest.writeDouble(this.rain);
            }

            public List() {
            }

            public List(Parcel in) {
                this.dt = in.readLong();
                this.temp = in.readParcelable(Temp.class.getClassLoader());
                this.pressure = in.readDouble();
                this.humidity = in.readInt();
                this.weather = new ArrayList<Weather>();
                in.readList(this.weather, Weather.class.getClassLoader());
                this.speed = in.readDouble();
                this.deg = in.readInt();
                this.clouds = in.readInt();
                this.rain = in.readDouble();
            }

            public static final Creator<List> CREATOR = new Creator<List>() {
                @Override
                public List createFromParcel(Parcel source) {
                    return new List(source);
                }

                @Override
                public List[] newArray(int size) {
                    return new List[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.name);
            dest.writeParcelable(this.coord, flags);
            dest.writeString(this.country);
            dest.writeLong(this.population);
        }

        public City() {
        }

        protected City(Parcel in) {
            this.id = in.readInt();
            this.name = in.readString();
            this.coord = in.readParcelable(Coord.class.getClassLoader());
            this.country = in.readString();
            this.population = in.readLong();
        }

        public static final Creator<City> CREATOR = new Creator<City>() {
            @Override
            public City createFromParcel(Parcel source) {
                return new City(source);
            }

            @Override
            public City[] newArray(int size) {
                return new City[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.city, flags);
        dest.writeList(this.list);
        dest.writeString(this.cod);
        dest.writeDouble(this.message);
        dest.writeInt(this.cnt);
    }

    public FullWeatherModel() {
    }

    public FullWeatherModel(Parcel in) {
        this.city = in.readParcelable(City.class.getClassLoader());
        this.list = new ArrayList<City.List>();
        in.readList(this.list, City.List.class.getClassLoader());
        this.cod = in.readString();
        this.message = in.readDouble();
        this.cnt = in.readInt();
    }

    public static final Creator<FullWeatherModel> CREATOR = new Creator<FullWeatherModel>() {
        @Override
        public FullWeatherModel createFromParcel(Parcel source) {
            return new FullWeatherModel(source);
        }

        @Override
        public FullWeatherModel[] newArray(int size) {
            return new FullWeatherModel[size];
        }
    };
}
