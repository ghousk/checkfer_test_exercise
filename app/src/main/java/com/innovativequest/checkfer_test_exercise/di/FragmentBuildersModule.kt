//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.di

import com.innovativequest.checkfer_test_exercise.ui.detail.ItemDetailFragment
import com.innovativequest.checkfer_test_exercise.ui.datalistitems.DataListItemsFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeRepoFragment(): ItemDetailFragment

    @ContributesAndroidInjector
    abstract fun contributeDataListItemsFragment(): DataListItemsFragment
}
