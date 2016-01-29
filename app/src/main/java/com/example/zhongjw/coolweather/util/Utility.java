package com.example.zhongjw.coolweather.util;

import android.text.TextUtils;

import com.example.zhongjw.coolweather.db.CoolWeatherDB;
import com.example.zhongjw.coolweather.model.City;
import com.example.zhongjw.coolweather.model.County;
import com.example.zhongjw.coolweather.model.Province;

/**
 * Created by zhongjw on 2016/1/29.
 */
public class Utility {
    public synchronized static boolean handlerProvincesResponse(CoolWeatherDB coolWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    coolWeatherDB.savedProvince(province);
                }
                return true;
            }
        }
        return false;
    }
    public static boolean handlerCitiesResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            String [] allCities = response.split(",");
            if(allCities!=null&&allCities.length>0){
                for (String c:allCities){
                    String [] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    coolWeatherDB.savedCity(city);
                }
                return true;
            }
        }
        return false;
    }
    public static boolean handlerCountiesResponse(CoolWeatherDB coolWeatherDB,String response,int CityId){
        if(!TextUtils.isEmpty(response)){
            String [] allCounties = response.split(",");
            if(allCounties!=null&&allCounties.length>0){
                for (String c:allCounties){
                    String [] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(CityId);
                    coolWeatherDB.savedCounty(county);
                }
                return  true;
            }
        }
        return false;
    }
}