package com.example.myweather;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    public static final String QUERY_FOR_FORECAST_BY_ID = "https://www.metaweather.com/api/location/";
    public static final String QUERY_FOR_CITY_ID = "https://www.metaweather.com/api/location/search/?query=";
    Context context;
    public WeatherDataService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onResponse(String cityID);

        void onError(String message);
    }

    public void getID(String cityName, VolleyResponseListener volleyResponseListener) {

        String QUERY = QUERY_FOR_CITY_ID + cityName;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, QUERY, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String cityID = "";
                try {
                    JSONObject cityInfo = response.getJSONObject(0);
                    cityID = String.valueOf(cityInfo.getInt("woeid"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                volleyResponseListener.onResponse(cityID);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onError("an error happened");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public interface ForeCastByNameResponse {
        void OnResponse(List<WeatherReportModel> weatherReportModelList);

        void onError(String message);
    }


    public void getCityForecastByName(String cityName, ForeCastByNameResponse foreCastByNameResponse) {
       getID(cityName, new VolleyResponseListener() {
           @Override
           public void onResponse(String cityID) {
               getCityForecastByID(cityID, new ForeCastByIDResponse() {
                   @Override
                   public void OnResponse(List<WeatherReportModel> weatherReportModelList) {
                       foreCastByNameResponse.OnResponse(weatherReportModelList);
                   }

                   @Override
                   public void onError(String message) {

                   }
               });
           }

           @Override
           public void onError(String message) {

           }
       });
    }

    public interface ForeCastByIDResponse {
        void OnResponse(List<WeatherReportModel> weatherReportModelList);

        void onError(String message);
    }

    public void getCityForecastByID(String cityID, ForeCastByIDResponse foreCastByIDResponse) {
        List<WeatherReportModel> report = new ArrayList<>();
        String url = QUERY_FOR_FORECAST_BY_ID + cityID;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray consolidated_weather_list = response.getJSONArray("consolidated_weather");

                    for (int i = 0; i < consolidated_weather_list.length(); i++) {

                        JSONObject obj = (JSONObject) consolidated_weather_list.get(i);
                        WeatherReportModel wrm = new WeatherReportModel();
                        wrm.setId(obj.getString("id"));
                        wrm.setWeather_state_name(obj.getString("weather_state_name"));
                        wrm.setWeather_state_abbr(obj.getString("weather_state_abbr"));
                        wrm.setWind_direction_compass(obj.getString("wind_direction_compass"));
                        wrm.setCreated(obj.getString("created"));
                        wrm.setApplicable_date(obj.getString("applicable_date"));
                        wrm.setMin_temp(obj.getDouble("min_temp"));
                        wrm.setMax_temp(obj.getDouble("max_temp"));
                        wrm.setThe_temp(obj.getDouble("the_temp"));
                        wrm.setWind_speed(obj.getDouble("wind_speed"));
                        wrm.setAir_pressure(obj.getDouble("air_pressure"));
                        wrm.setHumidity(obj.getDouble("humidity"));
                        wrm.setVisibility(obj.getDouble("visibility"));
                        wrm.setPredictability(obj.getDouble("predictability"));
                        report.add(wrm);

                    }
                    foreCastByIDResponse.OnResponse(report);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                foreCastByIDResponse.onError("an error happened");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }


}
