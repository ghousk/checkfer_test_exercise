//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.repository

//@RunWith(JUnit4::class)
class UserRepositoryTest {
//    private val userDao = mock(UserDao::class.java)
//    private val githubService = mock(GithubService::class.java)
//    private val dataListItems = UserRepository(InstantAppExecutors(), userDao, githubService)
//
//    @Rule
//    @JvmField
//    val instantExecutorRule = InstantTaskExecutorRule()
//
//    @Test
//    fun loadUser() {
//        dataListItems.loadUser("abc")
//        verify(userDao).findByLogin("abc")
//    }
//
//    @Test
//    fun goToNetwork() {
//        val dbData = MutableLiveData<User>()
//        `when`(userDao!!.findByLogin("foo")).thenReturn(dbData)
//        val user = TestUtil.createUser("foo")
//        val call = ApiUtil.successCall(user)
//        `when`(githubService!!.getUser("foo")).thenReturn(call)
//        val observer = mock<Observer<Resource<User>>>()
//
//        dataListItems.loadUser("foo").observeForever(observer)
//        verify(githubService, never()).getUser("foo")
//        val updatedDbData = MutableLiveData<User>()
//        `when`(userDao.findByLogin("foo")).thenReturn(updatedDbData)
//        dbData.value = null
//        verify(githubService).getUser("foo")
//    }
//
//    @Test
//    fun dontGoToNetwork() {
//        val dbData = MutableLiveData<User>()
//        val user = TestUtil.createUser("foo")
//        dbData.value = user
//        `when`(userDao!!.findByLogin("foo")).thenReturn(dbData)
//        val observer = mock<Observer<Resource<User>>>()
//        dataListItems.loadUser("foo").observeForever(observer)
//        verify(githubService, never()).getUser("foo")
//        verify(observer).onChanged(Resource.success(user))
//    }
}