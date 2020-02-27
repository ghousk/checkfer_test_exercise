//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.util

import com.innovativequest.checkfer_test_exercise.model.BadgeCounts
import com.innovativequest.checkfer_test_exercise.model.DataListItem
import com.innovativequest.checkfer_test_exercise.model.DataListItemResponse


object TestUtil {

    fun createRepos(count: Int, id: Int, name: String, accountId : Int,
                    userType: String,
                    reputation: Int,
                    profileImage: String): DataListItemResponse {
        val dataListItemArray = ArrayList<DataListItem>()

        for (i in 0..count) {
            dataListItemArray.add( createRepo(
                id = id,
                name = name + i,
                accountId = accountId,
                userType = userType,
                reputation = reputation,
                profileImage = profileImage
            ) )
        }

        return DataListItemResponse(count, 100, true, dataListItemArray)

    }

//    fun createRepo(owner: String, name: String, description: String) = createRepo(
//        id = DataListItem.UNKNOWN_ID,
//        owner = owner,
//        name = name,
//        description = description
//    )

    fun createRepo(id: Int, name: String, accountId : Int,
                   userType: String,
                   reputation: Int,
                   profileImage: String) = DataListItem(
        userId = id,
        displayName = name,
        accountId = accountId,
        userType = userType,
        badgeCounts = BadgeCounts(4, 15, 100),
        reputation = reputation,
        profileImage = profileImage
    )
}