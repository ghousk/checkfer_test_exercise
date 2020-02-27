package com.innovativequest.checkfer_test_exercise.util;

/**
 * Created by Ghous on 2020-02-27.
 */
public class AppConstants {

    private static final String TAG = "AppConstants";


    // ENV DEPENDENT BASE URLs
    public static final String BASE_URL_DEV = "https://my-json-server.typicode.com/ghousk/fake_lawyers_json_data/";
    private static final String DEFAULT_LOCALE = "en-GB";

    public static String getLocale()
    {
        return DEFAULT_LOCALE;
    }

    public static final String GET_LIST_ITEMS = "db";

    public static final String GET_LIST_ITEM_BY_ID = "lawyers_list/{userId}";

    public static final int REFRESH_TIME_OUT_IN_MILLIS = 600000;
}

