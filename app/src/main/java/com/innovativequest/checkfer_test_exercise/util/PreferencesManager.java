package com.innovativequest.checkfer_test_exercise.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


import com.innovativequest.checkfer_test_exercise.BuildConfig;

import java.util.Map;

/**
 * Created by Ghous on 2020-02-27.
 */
public class PreferencesManager 
{

    private final SharedPreferences mPref;
    
    public PreferencesManager(Context context)
    {
        mPref = context.getSharedPreferences("com.innovativequest.base_arch_comp_app", Context.MODE_PRIVATE);
    }

    public boolean remove(String key)
    {
        return mPref.edit().remove(key).commit();
    }
    
    /**
     * Removes all values from SharedPreferences.
     */
    public boolean clear()
    {
        return mPref.edit().clear().commit();
    }
    
    
    // ---------------- STRING ---------------- //
    // String - Set
    public boolean setString(String key, String value)
    {
    	if (!mPref.edit().putString(key, value).commit())
	    {
    		if (BuildConfig.DEBUG)
    		{
    			Log.d("[Preferences Manager]", "Failed to add: " + key + " with value: " + value);
    		}
	    	return false;
	    }

	    Log.d("[Preferences Manager]", "Succeed adding: " + key + " with value: " + value);
    	return true;
    }

    // ---------------- INT ---------------- //
    // Int - Set
    public boolean setInt(String key, int value)
    {
        if (!mPref.edit().putInt(key, value).commit())
        {
            if (BuildConfig.DEBUG)
            {
                Log.d("[Preferences Manager]", "Failed to add: " + key + " with value: " + value);
            }
            return false;
        }

        Log.d("[Preferences Manager]", "Succeed adding: " + key + " with value: " + value);
        return true;
    }

    // ---------------- LONG ---------------- //
    // Int - Set
    public boolean setLong(String key, long value)
    {
        if (!mPref.edit().putLong(key, value).commit())
        {
            if (BuildConfig.DEBUG)
            {
                Log.d("[Preferences Manager]", "Failed to add: " + key + " with value: " + value);
            }
            return false;
        }

        Log.d("[Preferences Manager]", "Succeed adding: " + key + " with value: " + value);
        return true;
    }

    // ---------------- INT ---------------- //
    // Float - Set
    public boolean setFloat(String key, float value)
    {
        if (!mPref.edit().putFloat(key, value).commit())
        {
            if (BuildConfig.DEBUG)
            {
                Log.d("[Preferences Manager]", "Failed to add: " + key + " with value: " + value);
            }
            return false;
        }

        Log.d("[Preferences Manager]", "Succeed adding: " + key + " with value: " + value);
        return true;
    }

    public boolean saveArray(String[] array, String arrayName)
    {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putInt(arrayName + "_size", array.length);
        for(int i=0;i<array.length;i++) {
            editor.putString(arrayName + "_" + i, array[i]);
        }
        return editor.commit();
    }

    public String[] loadArray(String arrayName)
    {
        int size = mPref.getInt(arrayName + "_size", 0);
        String array[] = new String[size];
        for(int i=0;i<size;i++) {
            array[i] = mPref.getString(arrayName + "_" + i, null);
        }
        return array;
    }

    // String - Set Array
    public boolean setStrings(Map<String, String> key)
    {
    	for (Map.Entry<String, String> entry : key.entrySet())
    	{
    	    String mapKey = entry.getKey();
    	    String mapValue = entry.getValue();
    	    
    	    if (!mPref.edit().putString(mapKey, mapValue).commit())
    	    {
    	    	if (BuildConfig.DEBUG)
        		{
    	    		Log.d("[Preferences Manager]", "Failed to add: " + mapKey + " with value: " + mapValue);
        		}
    	    	return false;
    	    }
    	    else
    	    {
    	    	if (BuildConfig.DEBUG)
        		{
    	    		Log.d("[Preferences Manager]", "Succeed adding: " + mapKey + " with value: " + mapValue);
        		}
    	    }
    	}
    	
    	return true;
    }
    
    // String - Get
    public String getString(String key)
    {
        return mPref.getString(key, null);
    }
    
    
    // ---------------- BOOLEAN ---------------- //
    // Boolean - Set
    public boolean setBoolean(String key, Boolean value)
    {
    	if (!mPref.edit().putBoolean(key, value).commit())
	    {
    		if (BuildConfig.DEBUG)
    		{
    			Log.d("[Preferences Manager]", "Failed to add: " + key + " with value: " + value);
    		}
	    	return false;
	    }
    	if (BuildConfig.DEBUG)
		{
    		Log.d("[Preferences Manager]", "Succeed adding: " + key + " with value: " + value);
		}
    	return true;
    }
    
    // Boolean - Get
    public boolean getBoolean(String key)
    {
        return getBoolean(key, false);
    }

    // Boolean - Get default
    public boolean getBoolean(String key, boolean defValue)
    {
        return mPref.getBoolean(key, defValue);
    }

    // Integer - Get
    public int getInt(String key)
    {
        return mPref.getInt(key, -1);
    }

    // Long - Get
    public long getLong(String key)
    {
        return mPref.getLong(key, -1);
    }

    // Float - Get
    public float getFloat(String key)
    {
        return mPref.getFloat(key, -1);
    }
}
