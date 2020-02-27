//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.ui.detail

//@RunWith(AndroidJUnit4::class)
class ItemDetailFragmentTest {
//    @Rule
//    @JvmField
//    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)
//    @Rule
//    @JvmField
//    val executorRule = TaskExecutorWithIdlingResourceRule()
//    @Rule
//    @JvmField
//    val countingAppExecutors = CountingAppExecutorsRule()
//    @Rule
//    @JvmField
//    val dataBindingIdlingResourceRule = DataBindingIdlingResourceRule(activityRule)
//
//    private val repoLiveData = MutableLiveData<Resource<Repo>>()
//    private val contributorsLiveData = MutableLiveData<Resource<List<Contributor>>>()
//    private lateinit var viewModel: ItemDetailViewModel
//    private lateinit var mockBindingAdapter: FragmentBindingAdapters
//
//    private val repoFragment = TestItemDetailFragment().apply {
//        arguments = RepoFragmentArgs("a", "b").toBundle()
//    }
//
//    @Before
//    fun init() {
//        viewModel = mock(ItemDetailViewModel::class.java)
//        mockBindingAdapter = mock(FragmentBindingAdapters::class.java)
//        doNothing().`when`(viewModel).setId(anyString(), anyString())
//        `when`(viewModel.dataListItemResponseById).thenReturn(repoLiveData)
//        `when`(viewModel.contributors).thenReturn(contributorsLiveData)
//        repoFragment.appExecutors = countingAppExecutors.appExecutors
//        repoFragment.viewModelFactory = ViewModelUtil.createFor(viewModel)
//        repoFragment.dataBindingComponent = object : DataBindingComponent {
//            override fun getFragmentBindingAdapters(): FragmentBindingAdapters {
//                return mockBindingAdapter
//            }
//        }
//        activityRule.activity.setFragment(repoFragment)
//        EspressoTestUtil.disableProgressBarAnimations(activityRule)
//    }
//
//    @Test
//    fun testLoading() {
//        repoLiveData.postValue(Resource.loading(null))
//        onView(withId(R.id.progress_bar)).check(matches(isDisplayed()))
//        onView(withId(R.id.retry)).check(matches(not(isDisplayed())))
//    }
//
//    @Test
//    fun testValueWhileLoading() {
//        val dataListItems = TestUtil.createRepo("yigit", "foo", "foo-bar")
//        repoLiveData.postValue(Resource.loading(dataListItems))
//        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
//        onView(withId(R.id.name)).check(
//            matches(
//                withText(getString(R.string.repo_full_name, "yigit", "foo"))
//            )
//        )
//        onView(withId(R.id.description)).check(matches(withText("foo-bar")))
//    }
//
//    @Test
//    fun testLoaded() {
//        val dataListItems = TestUtil.createRepo("foo", "bar", "buzz")
//        repoLiveData.postValue(Resource.success(dataListItems))
//        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
//        onView(withId(R.id.name)).check(
//            matches(
//                withText(getString(R.string.repo_full_name, "foo", "bar"))
//            )
//        )
//        onView(withId(R.id.description)).check(matches(withText("buzz")))
//    }
//
//    @Test
//    fun testError() {
//        repoLiveData.postValue(Resource.error("foo", null))
//        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
//        onView(withId(R.id.retry)).check(matches(isDisplayed()))
//        onView(withId(R.id.retry)).perform(click())
//        verify(viewModel).retry()
//        repoLiveData.postValue(Resource.loading(null))
//
//        onView(withId(R.id.progress_bar)).check(matches(isDisplayed()))
//        onView(withId(R.id.retry)).check(matches(not(isDisplayed())))
//        val dataListItems = TestUtil.createRepo("owner", "name", "desc")
//        repoLiveData.postValue(Resource.success(dataListItems))
//
//        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
//        onView(withId(R.id.retry)).check(matches(not(isDisplayed())))
//        onView(withId(R.id.name)).check(
//            matches(
//                withText(getString(R.string.repo_full_name, "owner", "name"))
//            )
//        )
//        onView(withId(R.id.description)).check(matches(withText("desc")))
//    }
//
//    @Test
//    fun testContributors() {
//        setContributors("aa", "bb")
//        onView(listMatcher().atPosition(0))
//            .check(matches(hasDescendant(withText("aa"))))
//        onView(listMatcher().atPosition(1))
//            .check(matches(hasDescendant(withText("bb"))))
//    }
//
//    private fun listMatcher(): RecyclerViewMatcher {
//        return RecyclerViewMatcher(R.id.contributor_list)
//    }
//
//    @Test
//    fun testContributorClick() {
//        setContributors("aa", "bb", "cc")
//        onView(withText("cc")).perform(click())
//        verify(repoFragment.navController).navigate(
//                eq(RepoFragmentDirections.showUser("cc")),
//                any(FragmentNavigator.Extras::class.java)
//        )
//    }
//
//    @Test
//    fun nullRepo() {
//        repoLiveData.postValue(null)
//        onView(withId(R.id.name)).check(matches(not(isDisplayed())))
//    }
//
//    @Test
//    fun nullContributors() {
//        setContributors("a", "b", "c")
//        onView(listMatcher().atPosition(0)).check(matches(hasDescendant(withText("a"))))
//        contributorsLiveData.postValue(null)
//        onView(listMatcher().atPosition(0)).check(doesNotExist())
//    }
//
//    private fun setContributors(vararg names: String) {
//        val dataListItems = TestUtil.createRepo("foo", "bar", "desc")
//        val contributors = names.mapIndexed { index, name ->
//            TestUtil.createContributor(
//                dataListItems = dataListItems,
//                login = name,
//                contributions = 100 - index
//            )
//        }
//        contributorsLiveData.postValue(Resource.success(contributors))
//    }
//
//    private fun getString(@StringRes id: Int, vararg args: Any): String {
//        return ApplicationProvider.getApplicationContext<Context>().getString(id, *args)
//    }
//
//    class TestItemDetailFragment : ItemDetailFragment() {
//        val navController = mock<NavController>()
//        override fun navController() = navController
//    }
}