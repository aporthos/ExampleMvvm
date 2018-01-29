package net.portes.examplemvvm.pojos

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by portes on 28/01/18.
 */
data class Base(@SerializedName("total_count") val totalCount: Int, //607038
                   @SerializedName("incomplete_results") val incompleteResults: Boolean, //false
                   @SerializedName("items") val items: ArrayList<Item>){

    override fun toString(): String {
        return "Base(totalCount=$totalCount, incompleteResults=$incompleteResults, items=$items)"
    }
}
@Entity(tableName = "Item")
data class Item(
        @PrimaryKey @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("full_name") val fullName: String,
        //@SerializedName("owner") val owner: Owner,
        @SerializedName("language") val language: String?,
        @SerializedName("watchers") val watchers: Int,
        @SerializedName("score") val score: Double)

data class Owner(
        @SerializedName("login") val login: String,
        @SerializedName("id") val id: Int,
        @SerializedName("avatar_url") val avatarUrl: String,
        @SerializedName("gravatar_id") val gravatarId: String,
        @SerializedName("url") val url: String,
        @SerializedName("html_url") val htmlUrl: String,
        @SerializedName("followers_url") val followersUrl: String,
        @SerializedName("following_url") val followingUrl: String,
        @SerializedName("gists_url") val gistsUrl: String,
        @SerializedName("starred_url") val starredUrl: String,
        @SerializedName("subscriptions_url") val subscriptionsUrl: String,
        @SerializedName("organizations_url") val organizationsUrl: String,
        @SerializedName("repos_url") val reposUrl: String,
        @SerializedName("events_url") val eventsUrl: String,
        @SerializedName("received_events_url") val receivedEventsUrl: String,
        @SerializedName("type") val type: String,
        @SerializedName("site_admin") val siteAdmin: Boolean) {
    override fun toString(): String {
        return "Owner(login='$login', id=$id, avatarUrl='$avatarUrl', gravatarId='$gravatarId', url='$url', htmlUrl='$htmlUrl', followersUrl='$followersUrl', followingUrl='$followingUrl', gistsUrl='$gistsUrl', starredUrl='$starredUrl', subscriptionsUrl='$subscriptionsUrl', organizationsUrl='$organizationsUrl', reposUrl='$reposUrl', eventsUrl='$eventsUrl', receivedEventsUrl='$receivedEventsUrl', type='$type', siteAdmin=$siteAdmin)"
    }
}
