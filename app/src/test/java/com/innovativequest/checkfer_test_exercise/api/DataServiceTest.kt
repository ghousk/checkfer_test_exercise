//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.api

//@RunWith(JUnit4::class)
class DataServiceTest {
//    @Rule
//    @JvmField
//    val instantExecutorRule = InstantTaskExecutorRule()
//
//    private lateinit var service: GithubService
//
//    private lateinit var mockWebServer: MockWebServer
//
//    @Before
//    fun createService() {
//        mockWebServer = MockWebServer()
//        service = Retrofit.Builder()
//            .baseUrl(mockWebServer.url("/"))
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(LiveDataCallAdapterFactory())
//            .build()
//            .create(GithubService::class.java)
//    }
//
//    @After
//    fun stopService() {
//        mockWebServer.shutdown()
//    }
//
//    @Test
//    fun getUser() {
//        enqueueResponse("user-yigit.json")
//        val yigit = (getValue(service.getUser("yigit")) as ApiSuccessResponse).body
//
//        val request = mockWebServer.takeRequest()
//        assertThat(request.path, `is`("/users/yigit"))
//
//        assertThat<User>(yigit, notNullValue())
//        assertThat(yigit.avatarUrl, `is`("https://avatars3.githubusercontent.com/u/89202?v=3"))
//        assertThat(yigit.company, `is`("Google"))
//        assertThat(yigit.blog, `is`("birbit.com"))
//    }
//
//    @Test
//    fun getRepos() {
//        enqueueResponse("repos-yigit.json")
//        val repos = (getValue(service.getRepos("yigit")) as ApiSuccessResponse).body
//
//        val request = mockWebServer.takeRequest()
//        assertThat(request.path, `is`("/users/yigit/repos"))
//
//        assertThat(repos.size, `is`(2))
//
//        val dataListItemResponseById = repos[0]
//        assertThat(dataListItemResponseById.fullName, `is`("yigit/AckMate"))
//
//        val owner = dataListItemResponseById.owner
//        assertThat(owner, notNullValue())
//        assertThat(owner.login, `is`("yigit"))
//        assertThat(owner.url, `is`("https://api.github.com/users/yigit"))
//
//        val repo2 = repos[1]
//        assertThat(repo2.fullName, `is`("yigit/android-architecture"))
//    }
//
//    @Test
//    fun getContributors() {
//        enqueueResponse("contributors.json")
//        val value = getValue(service.getContributors("foo", "bar"))
//        val contributors = (value as ApiSuccessResponse).body
//        assertThat(contributors.size, `is`(3))
//        val yigit = contributors[0]
//        assertThat(yigit.login, `is`("yigit"))
//        assertThat(yigit.avatarUrl, `is`("https://avatars3.githubusercontent.com/u/89202?v=3"))
//        assertThat(yigit.contributions, `is`(291))
//        assertThat(contributors[1].login, `is`("guavabot"))
//        assertThat(contributors[2].login, `is`("coltin"))
//    }
//
//    @Test
//    fun search() {
//        val next = """<https://api.github.com/search/repositories?q=foo&page=2>; rel="next""""
//        val last = """<https://api.github.com/search/repositories?q=foo&page=34>; rel="last""""
//        enqueueResponse(
//            "search.json", mapOf(
//                "link" to "$next,$last"
//            )
//        )
//        val response = getValue(service.searchRepos("foo")) as ApiSuccessResponse
//
//        assertThat(response, notNullValue())
//        assertThat(response.body.total, `is`(41))
//        assertThat(response.body.items.size, `is`(30))
//        assertThat<String>(
//            response.links["next"],
//            `is`("https://api.github.com/search/repositories?q=foo&page=2")
//        )
//        assertThat<Int>(response.nextPage, `is`(2))
//    }
//
//    private fun enqueueResponse(fileName: String, headers: Map<String, String> = emptyMap()) {
//        val inputStream = javaClass.classLoader
//            .getResourceAsStream("api-response/$fileName")
//        val source = Okio.buffer(Okio.source(inputStream))
//        val mockResponse = MockResponse()
//        for ((key, value) in headers) {
//            mockResponse.addHeader(key, value)
//        }
//        mockWebServer.enqueue(
//            mockResponse
//                .setBody(source.readString(Charsets.UTF_8))
//        )
//    }
}
