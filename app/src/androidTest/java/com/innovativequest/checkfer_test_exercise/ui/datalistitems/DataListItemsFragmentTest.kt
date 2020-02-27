//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.ui.datalistitems

import androidx.lifecycle.MutableLiveData
import androidx.databinding.DataBindingComponent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import androidx.navigation.NavController
import com.innovativequest.checkfer_test_exercise.R
import com.innovativequest.checkfer_test_exercise.binding.FragmentBindingAdapters
import com.innovativequest.checkfer_test_exercise.testing.SingleFragmentActivity
import com.innovativequest.checkfer_test_exercise.util.CountingAppExecutorsRule
import com.innovativequest.checkfer_test_exercise.util.DataBindingIdlingResourceRule
import com.innovativequest.checkfer_test_exercise.util.EspressoTestUtil
import com.innovativequest.checkfer_test_exercise.util.RecyclerViewMatcher
import com.innovativequest.checkfer_test_exercise.util.TaskExecutorWithIdlingResourceRule
import com.innovativequest.checkfer_test_exercise.util.TestUtil
import com.innovativequest.checkfer_test_exercise.util.ViewModelUtil
import com.innovativequest.checkfer_test_exercise.util.mock
import com.innovativequest.checkfer_test_exercise.model.DataListItemResponse
import com.innovativequest.checkfer_test_exercise.model.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class DataListItemsFragmentTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)
    @Rule
    @JvmField
    val executorRule = TaskExecutorWithIdlingResourceRule()
    @Rule
    @JvmField
    val countingAppExecutors = CountingAppExecutorsRule()
    @Rule
    @JvmField
    val dataBindingIdlingResourceRule = DataBindingIdlingResourceRule(activityRule)
    private lateinit var viewModel: DataListItemsViewModel
    private lateinit var mockBindingAdapter: FragmentBindingAdapters
    private val repoListData = MutableLiveData<Resource<DataListItemResponse>>()
    private val testFragment = TestDataListItemsFragment().apply {
    }

    @Before
    fun init() {
        viewModel = mock(DataListItemsViewModel::class.java)
        `when`(viewModel.dataListItems).thenReturn(repoListData)
        mockBindingAdapter = mock(FragmentBindingAdapters::class.java)

        testFragment.appExecutors = countingAppExecutors.appExecutors
        testFragment.viewModelFactory = ViewModelUtil.createFor(viewModel)
        testFragment.dataBindingComponent = object : DataBindingComponent {
            override fun getFragmentBindingAdapters(): FragmentBindingAdapters {
                return mockBindingAdapter
            }
        }
        activityRule.activity.setFragment(testFragment)
        activityRule.runOnUiThread {
            testFragment.binding.repoList.itemAnimator = null
        }
        EspressoTestUtil.disableProgressBarAnimations(activityRule)
    }

    @Test
    fun loadRepos() {
        val repos = setRepos(2)
        repos.items?.let {
            for (pos in repos.items!!.indices) {
                val repo = repos.items!![pos]
                onView(listMatcher().atPosition(pos)).apply {
                    check(matches(hasDescendant(withText(repo.displayName))))
                    check(matches(hasDescendant(withText(repo.userType))))
                    check(matches(hasDescendant(withText(repo.reputation.toString()))))
                }
            }
        }

        setRepos(3).items?.let {
            val repo3 = setRepos(3).items!![2]
            onView(listMatcher().atPosition(2)).check(
                matches(hasDescendant(withText(repo3.displayName)))
            )
        }
    }

    @Test
    fun nullRepoList() {
        repoListData.postValue(null)
        onView(listMatcher().atPosition(0)).check(doesNotExist())
    }

    @Test
    fun nulledRepoList() {
        setRepos(5)
        onView(listMatcher().atPosition(1)).check(matches(isDisplayed()))
        repoListData.postValue(null)
        onView(listMatcher().atPosition(0)).check(doesNotExist())
    }

    private fun listMatcher() = RecyclerViewMatcher(R.id.repo_list)

    private fun setRepos(count: Int): DataListItemResponse {
        val dataListItemResponse =   TestUtil.createRepos(count, 47188524, "name", 56789,
            "User", 5,
            "https://avatars2.githubusercontent.com/u/5959435?v=4")
        repoListData.postValue(Resource.success(dataListItemResponse))
        return dataListItemResponse
    }

    class TestDataListItemsFragment : DataListItemsFragment() {
        val navController = mock<NavController>()
        override fun navController() = navController
    }
}