//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.runner.AndroidJUnit4
import com.innovativequest.checkfer_test_exercise.util.LiveDataTestUtil.getValue
import com.innovativequest.checkfer_test_exercise.util.TestUtil
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DataListItemResponseDaoTest : DbTest() {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun insertAndRead() {
        val repo = TestUtil.createRepos(2, 29407, "BalusC", 14332,
            "registered", 4,
            "https://www.gravatar.com/avatar/e3a181e9cdd4757a8b416d93878770c5?s=128&d=identicon&r=PG")
        db.dataListItemResponseDao().insert(repo)
        val loaded = getValue(db.dataListItemResponseDao().load(true))
        assertThat(loaded, notNullValue())
        assertThat(loaded.items?.get(0)?.displayName, `is`("BalusC0"))
    }
}
