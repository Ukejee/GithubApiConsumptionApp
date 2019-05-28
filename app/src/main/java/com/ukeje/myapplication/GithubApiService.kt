package com.ukeje.myapplication

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author .: Ukeje Emeka
 * @email ..: ukejee3@gmail.com
 * @created : 5/27/19
 */
interface GithubApiService {

    @GET("/repositories?language=&since=daily")
    fun getRepoList() : Observable<List<Repo>>
}