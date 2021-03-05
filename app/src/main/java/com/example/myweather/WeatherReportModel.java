package com.example.myweather;

public class WeatherReportModel {

    private String id, weather_state_name, weather_state_abbr, wind_direction_compass, created, applicable_date;
    private double min_temp, max_temp, the_temp, wind_speed, air_pressure, humidity, visibility, predictability;

    public WeatherReportModel(String id, String weather_state_name,
                              String weather_state_abbr, String wind_direction_compass, String created,
                              String applicable_date, double min_temp, double max_temp, double the_temp,
                              double wind_speed, double air_pressure, double humidity, double visibility, double predictability) {
        this.id = id;
        this.weather_state_name = weather_state_name;
        this.weather_state_abbr = weather_state_abbr;
        this.wind_direction_compass = wind_direction_compass;
        this.created = created;
        this.applicable_date = applicable_date;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.the_temp = the_temp;
        this.wind_speed = wind_speed;
        this.air_pressure = air_pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.predictability = predictability;
    }

    public WeatherReportModel() {

    }

    @Override
    public String toString() {
        return " " + weather_state_name + '\n' +
                " wind_direction_compass = " + wind_direction_compass + '\n' +
                " applicable_date = " + applicable_date + '\n' +
                " min_temp = " + min_temp + '\n' +
                " max_temp = " + max_temp + '\n' +
                " the_temp = " + the_temp + '\n' +
                " wind_speed = " + wind_speed + '\n' +
                " air_pressure = " + air_pressure + '\n' +
                " humidity = " + humidity + '\n' +
                " visibility = " + visibility + '\n' +
                " predictability = " + predictability
                ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(double min_temp) {
        this.min_temp = min_temp;
    }

    public double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(double max_temp) {
        this.max_temp = max_temp;
    }

    public double getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(double the_temp) {
        this.the_temp = the_temp;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(double air_pressure) {
        this.air_pressure = air_pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getPredictability() {
        return predictability;
    }

    public void setPredictability(double predictability) {
        this.predictability = predictability;
    }
}
