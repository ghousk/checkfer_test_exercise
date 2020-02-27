//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.ui.datalistitems

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.innovativequest.checkfer_test_exercise.repository.DataListItemsRepository
import com.innovativequest.checkfer_test_exercise.testing.OpenForTesting
import com.innovativequest.checkfer_test_exercise.util.AbsentLiveData
import com.innovativequest.checkfer_test_exercise.model.DataListItemResponse
import com.innovativequest.checkfer_test_exercise.model.Resource
import javax.inject.Inject

@OpenForTesting
class DataListItemsViewModel
@Inject constructor(repository: DataListItemsRepository) : ViewModel() {
    private val _dataListItemId: MutableLiveData<DataListItemId> = MutableLiveData()
    val dataListItemId: LiveData<DataListItemId>
        get() = _dataListItemId
    val dataListItems: LiveData<Resource<DataListItemResponse>> =
                repository.loadDataListItemResponses()

    fun retry() {
        val id = _dataListItemId.value?.id
        if (id != null) {
            _dataListItemId.value = DataListItemId(id)
        }
    }

    fun setId(id: String) {
        val update = DataListItemId(id)
        if (_dataListItemId.value == update) {
            return
        }
        _dataListItemId.value = update
    }

    data class DataListItemId(val id: String) {
        fun <T> ifExists(f: (String) -> LiveData<T>): LiveData<T> {
            return if (id.isBlank()) {
                AbsentLiveData.create()
            } else {
                f(id)
            }
        }
    }
}
