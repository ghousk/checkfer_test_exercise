package com.innovativequest.checkfer_test_exercise.util;


import com.innovativequest.checkfer_test_exercise.BuildConfig;

/**
 * Created by Ghous on 2020-02-27.
 */
public class EnvironmentParameters {
    private String mBaseUrl;
    private String mCurrentEnv;

    public EnvironmentParameters(){
        if(BuildConfig.FLAVOR == "baseDev"){
           setBaseDevEnvironment();
        }
        else if (BuildConfig.FLAVOR == "baseUat") {
           setBaseUatEnvironment();
        }
        else if (BuildConfig.FLAVOR == "baseLive") {
            setBaseLiveEnvironment();
        }
        else{
            setBaseDevEnvironment();
        }
    }

    public void setBaseDevEnvironment(){
        mCurrentEnv = "BaseDev";
        mBaseUrl        = AppConstants.BASE_URL_DEV;
    }

    public void setBaseUatEnvironment(){
        mCurrentEnv = "BaseUat";
    }

    public void setBaseLiveEnvironment(){
        mCurrentEnv = "BaseLive";

    }

    public String getBaseURL(){ return mBaseUrl; }

    //Sets
    // Add any Late Initialised Sets here

}
