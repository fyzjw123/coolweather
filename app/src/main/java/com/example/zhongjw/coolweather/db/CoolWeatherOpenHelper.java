package com.example.zhongjw.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zhongjw on 2016/1/27.
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
    private static final String CREATE_PROVINCE="create table Province("
            +"id INT PRIMARY KEY AUTO_INCREMENT,"
            +"province_name TEXT,"
            +"province_code TEXT)";

    private static final String CREATE_CITY="CREATE TABLE City("
            +"id INT PRIMARY KEY AUTO_INCREMENT,"
            +"city_name TEXT,"
            +"city_code TEXT,"
            +"province_id INT)";

    private static final String CREATE_COUNTY = "CREATE TABLE County("
            +"id INT PRIMARY KEY AUTO_INCREMENT,"
            +"county_name TEXT,"
            +"county_code TEXT,"
            +"city_id INT)";

    public CoolWeatherOpenHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTY);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
