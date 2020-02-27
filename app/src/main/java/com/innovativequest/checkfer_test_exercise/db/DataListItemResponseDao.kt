//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.innovativequest.checkfer_test_exercise.testing.OpenForTesting
import com.innovativequest.checkfer_test_exercise.model.*

/**
 * Interface for database access on Repo related operations.
 */
@Dao
@OpenForTesting
abstract class DataListItemResponseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg dataListItemResponse: DataListItemResponse)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertContributors(contributors: List<Contributor>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertDataListItemResponses(dataListItemResponse: DataListItemResponse)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun createDataListItemResponseIfNotExists(dataListItemResponse: DataListItemResponse): Long

    @Query("SELECT * FROM dataListItemResponse WHERE hasMore = :hasMore")
    abstract fun load(hasMore: Boolean): LiveData<DataListItemResponse>

    @Query(
        """
        SELECT * FROM DataListItemResponse
        ORDER BY quotaRemaining DESC"""
    )
    abstract fun loadAllDataListItemResponses(): LiveData<DataListItemResponse>

}
