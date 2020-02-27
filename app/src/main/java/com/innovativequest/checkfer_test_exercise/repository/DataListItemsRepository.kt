//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.repository

import androidx.lifecycle.LiveData
import com.innovativequest.checkfer_test_exercise.AppExecutors
import com.innovativequest.checkfer_test_exercise.api.ApiResponse
import com.innovativequest.checkfer_test_exercise.api.DataService
import com.innovativequest.checkfer_test_exercise.db.DataListItemResponseDao
import com.innovativequest.checkfer_test_exercise.testing.OpenForTesting
import com.innovativequest.checkfer_test_exercise.util.RateLimiter
import com.innovativequest.checkfer_test_exercise.model.*
import com.innovativequest.checkfer_test_exercise.util.AppConstants
import com.innovativequest.checkfer_test_exercise.util.AppConstants.REFRESH_TIME_OUT_IN_MILLIS
import com.innovativequest.checkfer_test_exercise.util.PreferencesManager
import com.innovativequest.checkfer_test_exercise.util.Utils
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository that handles Repo instances.
 *
 * unfortunate naming :/ .
 * Repo - value object name
 * Repository - type of this class.
 */
@Singleton
@OpenForTesting
class DataListItemsRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val preferencesManager: PreferencesManager,
    private val dataListItemDao: DataListItemResponseDao,
    private val dataService: DataService
) {

    private val repoListRateLimit = RateLimiter<String>(10, TimeUnit.MINUTES)

    fun loadDataListItemResponses(): LiveData<Resource<DataListItemResponse>> {
        return object : NetworkBoundResource<DataListItemResponse, DataListItemResponse>(appExecutors) {
            override fun saveCallResult(item: DataListItemResponse) {
                dataListItemDao.insertDataListItemResponses(item)
            }

            override fun shouldFetch(data: DataListItemResponse?): Boolean {
                return data?.items == null ||data.items.isEmpty() ||
                        isOutdated(preferencesManager.getLong(AppConstants.GET_LIST_ITEMS))/*|| repoListRateLimit.shouldFetch()*/  // TODO: Enable this
            }

            override fun loadFromDb() = dataListItemDao.loadAllDataListItemResponses()

            override fun createCall()  : LiveData<ApiResponse<DataListItemResponse>> {
                preferencesManager.setLong(AppConstants.GET_LIST_ITEMS, Utils.getCurrentTime())
                return dataService.getDataItems()
            }

            override fun onFetchFailed() {
                //repoListRateLimit.reset() // TODO: Enable this
            }
        }.asLiveData()
    }

    fun loadDataListItemResponseById(userId: String): LiveData<Resource<DataListItemResponse>> {
        return object : NetworkBoundResource<DataListItemResponse, DataListItemResponse>(appExecutors) {
            override fun saveCallResult(item: DataListItemResponse) {
                dataListItemDao.insertDataListItemResponses(item)
            }

            override fun shouldFetch(data: DataListItemResponse?): Boolean {
                return data?.items == null ||data.items.isEmpty() ||
                        isOutdated(preferencesManager.getLong(AppConstants.GET_LIST_ITEM_BY_ID + userId))/*|| repoListRateLimit.shouldFetch()*/  // TODO: Enable this
            }

            override fun loadFromDb() = dataListItemDao.loadAllDataListItemResponses()

            override fun createCall() : LiveData<ApiResponse<DataListItemResponse>> {
                preferencesManager.setLong(AppConstants.GET_LIST_ITEM_BY_ID + userId, Utils.getCurrentTime())

                return dataService.getDataItemById(userId)
            }

            override fun onFetchFailed() {
                //repoListRateLimit.reset() // TODO: Enable this
            }
        }.asLiveData()
    }

    /**
     * Check if a time stamp from prefs is outdated
     */
    private fun isOutdated(lastUpdateTime: Long): Boolean = Utils.getCurrentTime() > lastUpdateTime + REFRESH_TIME_OUT_IN_MILLIS
}
