//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.api

import androidx.lifecycle.LiveData
import com.innovativequest.checkfer_test_exercise.model.DataListItem
import com.innovativequest.checkfer_test_exercise.util.AppConstants
import com.innovativequest.checkfer_test_exercise.model.DataListItemResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * REST API access points
 */
interface DataService {

    @GET(AppConstants.GET_LIST_ITEMS)
    fun getDataItems(): LiveData<ApiResponse<DataListItemResponse>>

    @GET(AppConstants.GET_LIST_ITEM_BY_ID)
    fun getDataItemById(
        @Path("userId") userId : String
    ): LiveData<ApiResponse<DataListItemResponse>>
}
