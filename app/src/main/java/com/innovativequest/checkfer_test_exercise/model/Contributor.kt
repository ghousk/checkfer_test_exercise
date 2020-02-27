//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.model

import androidx.room.Entity
import androidx.room.ForeignKey
import com.google.gson.annotations.SerializedName

@Entity(
    primaryKeys = ["dataListItemResponseHasMore", "dataListItemResponseQuotaMax", "quotaRemaining"],
    foreignKeys = [ForeignKey(
        entity = DataListItemResponse::class,
        parentColumns = ["quotaRemaining"],
        childColumns = ["dataListItemResponseHasMore"],
        onUpdate = ForeignKey.CASCADE,
        deferred = true
    )]
)
data class Contributor(
    @field:SerializedName("quotaRemaining")
    val quotaRemaining: Int
) {

    // does not show up in the response but set in post processing.
    lateinit var dataListItemResponseHasMore: String
    // does not show up in the response but set in post processing.
    lateinit var dataListItemResponseQuotaMax: String
}
