//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.repository

//@RunWith(JUnit4::class)
class DataListItemsRepositoryTest {
//    private lateinit var repository: DataListItemsRepository
//    private val dao = mock(DataListItemResponseDao::class.java)
//    private val service = mock(GithubService::class.java)
//    @Rule
//    @JvmField
//    val instantExecutorRule = InstantTaskExecutorRule()
//
//    @Before
//    fun init() {
//        val db = mock(GithubDb::class.java)
//        `when`(db.dataListItemDao()).thenReturn(dao)
//        `when`(db.runInTransaction(ArgumentMatchers.any())).thenCallRealMethod()
//        repository = DataListItemsRepository(InstantAppExecutors(), db, dao, service)
//    }
//
//    @Test
//    fun loadRepoFromNetwork() {
//        val dbData = MutableLiveData<Repo>()
//        `when`(dao.load("foo", "bar")).thenReturn(dbData)
//
//        val dataListItems = TestUtil.createRepo("foo", "bar", "desc")
//        val call = successCall(dataListItems)
//        `when`(service.getDataListItems("foo", "bar")).thenReturn(call)
//
//        val data = repository.loadRepo("foo", "bar")
//        verify(dao).load("foo", "bar")
//        verifyNoMoreInteractions(service)
//
//        val observer = mock<Observer<Resource<Repo>>>()
//        data.observeForever(observer)
//        verifyNoMoreInteractions(service)
//        verify(observer).onChanged(Resource.loading(null))
//        val updatedDbData = MutableLiveData<Repo>()
//        `when`(dao.load("foo", "bar")).thenReturn(updatedDbData)
//
//        dbData.postValue(null)
//        verify(service).getDataListItems("foo", "bar")
//        verify(dao).insert(dataListItems)
//
//        updatedDbData.postValue(dataListItems)
//        verify(observer).onChanged(Resource.success(dataListItems))
//    }
//
//    @Test
//    fun loadContributors() {
//        val dbData = MutableLiveData<List<Contributor>>()
//        `when`(dao.loadContributors("foo", "bar")).thenReturn(dbData)
//
//        val data = repository.loadContributors(
//            "foo",
//            "bar"
//        )
//        verify(dao).loadContributors("foo", "bar")
//
//        verify(service, never()).getContributors(anyString(), anyString())
//
//        val dataListItems = TestUtil.createRepo("foo", "bar", "desc")
//        val contributor = TestUtil.createContributor(dataListItems, "log", 3)
//        // network does not send these
//        val contributors = listOf(contributor)
//        val call = successCall(contributors)
//        `when`(service.getContributors("foo", "bar"))
//            .thenReturn(call)
//
//        val observer = mock<Observer<Resource<List<Contributor>>>>()
//        data.observeForever(observer)
//
//        verify(observer).onChanged(Resource.loading(null))
//
//        val updatedDbData = MutableLiveData<List<Contributor>>()
//        `when`(dao.loadContributors("foo", "bar")).thenReturn(updatedDbData)
//        dbData.value = emptyList()
//
//        verify(service).getContributors("foo", "bar")
//        val inserted = argumentCaptor<List<Contributor>>()
//        // empty list is a workaround for null capture return
//        verify(dao).insertContributors(inserted.capture() ?: emptyList())
//
//
//        assertThat(inserted.value.size, `is`(1))
//        val first = inserted.value[0]
//        assertThat(first.repoName, `is`("bar"))
//        assertThat(first.repoOwner, `is`("foo"))
//
//        updatedDbData.value = contributors
//        verify(observer).onChanged(Resource.success(contributors))
//    }
//
//    @Test
//    fun searchNextPage_null() {
//        `when`(dao.findSearchResult("foo")).thenReturn(null)
//        val observer = mock<Observer<Resource<Boolean>>>()
//        repository.searchNextPage("foo").observeForever(observer)
//        verify(observer).onChanged(null)
//    }
//
//    @Test
//    fun search_fromDb() {
//        val ids = arrayListOf(1, 2)
//
//        val observer = mock<Observer<Resource<List<Repo>>>>()
//        val dbSearchResult = MutableLiveData<RepoSearchResult>()
//        val repositories = MutableLiveData<List<Repo>>()
//
//        `when`(dao.search("foo")).thenReturn(dbSearchResult)
//
//        repository.search("foo").observeForever(observer)
//
//        verify(observer).onChanged(Resource.loading(null))
//        verifyNoMoreInteractions(service)
//        reset(observer)
//
//        val dbResult = RepoSearchResult("foo", ids, 2, null)
//        `when`(dao.loadOrdered(ids)).thenReturn(repositories)
//
//        dbSearchResult.postValue(dbResult)
//
//        val repoList = arrayListOf<Repo>()
//        repositories.postValue(repoList)
//        verify(observer).onChanged(Resource.success(repoList))
//        verifyNoMoreInteractions(service)
//    }
//
//    @Test
//    fun search_fromServer() {
//        val ids = arrayListOf(1, 2)
//        val repo1 = TestUtil.createRepo(1, "owner", "dataListItemResponseById 1", "desc 1")
//        val repo2 = TestUtil.createRepo(2, "owner", "dataListItemResponseById 2", "desc 2")
//
//        val observer = mock<Observer<Resource<List<Repo>>>>()
//        val dbSearchResult = MutableLiveData<RepoSearchResult>()
//        val repositories = MutableLiveData<List<Repo>>()
//
//        val repoList = arrayListOf(repo1, repo2)
//        val apiResponse = RepoSearchResponse(2, repoList)
//
//        val callLiveData = MutableLiveData<ApiResponse<RepoSearchResponse>>()
//        `when`(service.searchRepos("foo")).thenReturn(callLiveData)
//
//        `when`(dao.search("foo")).thenReturn(dbSearchResult)
//
//        repository.search("foo").observeForever(observer)
//
//        verify(observer).onChanged(Resource.loading(null))
//        verifyNoMoreInteractions(service)
//        reset(observer)
//
//        `when`(dao.loadOrdered(ids)).thenReturn(repositories)
//        dbSearchResult.postValue(null)
//        verify(dao, never()).loadOrdered(anyList())
//
//        verify(service).searchRepos("foo")
//        val updatedResult = MutableLiveData<RepoSearchResult>()
//        `when`(dao.search("foo")).thenReturn(updatedResult)
//        updatedResult.postValue(RepoSearchResult("foo", ids, 2, null))
//
//        callLiveData.postValue(ApiResponse.create(Response.success(apiResponse)))
//        verify(dao).insertDataListItemResponses(repoList)
//        repositories.postValue(repoList)
//        verify(observer).onChanged(Resource.success(repoList))
//        verifyNoMoreInteractions(service)
//    }
//
//    @Test
//    fun search_fromServer_error() {
//        `when`(dao.search("foo")).thenReturn(AbsentLiveData.create())
//        val apiResponse = MutableLiveData<ApiResponse<RepoSearchResponse>>()
//        `when`(service.searchRepos("foo")).thenReturn(apiResponse)
//
//        val observer = mock<Observer<Resource<List<Repo>>>>()
//        repository.search("foo").observeForever(observer)
//        verify(observer).onChanged(Resource.loading(null))
//
//        apiResponse.postValue(ApiResponse.create(Exception("idk")))
//        verify(observer).onChanged(Resource.error("idk", null))
//    }
}