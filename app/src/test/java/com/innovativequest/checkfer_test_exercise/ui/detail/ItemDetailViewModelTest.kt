//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.ui.detail

//@RunWith(JUnit4::class)
class ItemDetailViewModelTest {
//
//    @Rule
//    @JvmField
//    val instantExecutorRule = InstantTaskExecutorRule()
//
//    private val repository = mock(DataListItemsRepository::class.java)
//    private var repoViewModel = ItemDetailViewModel(repository)
//
//    @Test
//    fun testNull() {
//        assertThat(repoViewModel.dataListItemResponseById, notNullValue())
//        assertThat(repoViewModel.contributors, notNullValue())
//        verify(repository, never()).loadRepo(anyString(), anyString())
//    }
//
//    @Test
//    fun dontFetchWithoutObservers() {
//        repoViewModel.setId("a", "b")
//        verify(repository, never()).loadRepo(anyString(), anyString())
//    }
//
//    @Test
//    fun fetchWhenObserved() {
//        repoViewModel.setId("a", "b")
//        repoViewModel.dataListItemResponseById.observeForever(mock())
//        verify(repository).loadRepo("a", "b")
//    }
//
//    @Test
//    fun changeWhileObserved() {
//        repoViewModel.dataListItemResponseById.observeForever(mock())
//
//        repoViewModel.setId("a", "b")
//        repoViewModel.setId("c", "d")
//
//        verify(repository).loadRepo("a", "b")
//        verify(repository).loadRepo("c", "d")
//    }
//
//    @Test
//    fun contributors() {
//        val observer = mock<Observer<Resource<List<Contributor>>>>()
//        repoViewModel.contributors.observeForever(observer)
//        verifyNoMoreInteractions(observer)
//        verifyNoMoreInteractions(repository)
//        repoViewModel.setId("foo", "bar")
//        verify(repository).loadContributors("foo", "bar")
//    }
//
//    @Test
//    fun resetId() {
//        val observer = mock<Observer<ItemDetailViewModel.RepoId>>()
//        repoViewModel.repoId.observeForever(observer)
//        verifyNoMoreInteractions(observer)
//        repoViewModel.setId("foo", "bar")
//        verify(observer).onChanged(ItemDetailViewModel.RepoId("foo", "bar"))
//        reset(observer)
//        repoViewModel.setId("foo", "bar")
//        verifyNoMoreInteractions(observer)
//        repoViewModel.setId("a", "b")
//        verify(observer).onChanged(ItemDetailViewModel.RepoId("a", "b"))
//    }
//
//    @Test
//    fun retry() {
//        repoViewModel.retry()
//        verifyNoMoreInteractions(repository)
//        repoViewModel.setId("foo", "bar")
//        verifyNoMoreInteractions(repository)
//        val observer = mock<Observer<Resource<Repo>>>()
//        repoViewModel.dataListItemResponseById.observeForever(observer)
//        verify(repository).loadRepo("foo", "bar")
//        reset(repository)
//        repoViewModel.retry()
//        verify(repository).loadRepo("foo", "bar")
//    }
//
//    @Test
//    fun blankRepoId() {
//        repoViewModel.setId("", "")
//        val observer1 = mock<Observer<Resource<Repo>>>()
//        val observer2 = mock<Observer<Resource<List<Contributor>>>>()
//        repoViewModel.dataListItemResponseById.observeForever(observer1)
//        repoViewModel.contributors.observeForever(observer2)
//        verify(observer1).onChanged(null)
//        verify(observer2).onChanged(null)
//    }
}