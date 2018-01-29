package net.portes.examplemvvm.interfaces.services

import io.reactivex.Observable
import net.portes.examplemvvm.pojos.Base
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by portes on 28/01/18.
 */
interface GitHubInterface {
    @GET("/search/repositories")
    fun getRepositories(
            @Query("per_page") per_page: String,
            @Query("page") page: String,
            @Query("q") q: String): Observable<Base>
}