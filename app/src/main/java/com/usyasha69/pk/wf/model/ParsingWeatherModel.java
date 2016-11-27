package com.usyasha69.pk.wf.model;

import java.util.ArrayList;

public class ParsingWeatherModel {
    public City city;
    public ArrayList<List> list;
    public String cod;
    public double message;
    public int cnt;

    public static class City {
        public int id;
        public String name;
        public Coord coord;
        public String country;
        public long population;

        public static class Coord {
            public double lon;
            public double lat;
        }
    }

    public static class List {
        public long dt;
        public Temp temp;
        public double pressure;
        public int humidity;
        public ArrayList<Weather> weather;
        public double speed;
        public int deg;
        public int clouds;
        public double rain;

        public static class Temp {
            public double day;
            public double min;
            public double max;
            public double night;
            public double eve;
            public double morn;
        }

        public static class Weather {
            public int id;
            public String main;
            public String description;
            public String icon;
        }
    }
}
