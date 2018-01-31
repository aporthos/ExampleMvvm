package net.portes.examplemvvm.utils

import net.portes.examplemvvm.pojos.Item

/**
 * Created by portes on 28/01/18.
 */
class GitHubFactory {
    fun parserSearch(mArrayList: ArrayList<Item>):List<Item>{
        val mArrayListItem: ArrayList<Item> = ArrayList()
        for (item in mArrayList) {
            /*val mOwner = Owner(
                    item.owner.login,
                    item.owner.id,
                    item.owner.avatarUrl,
                    item.owner.gravatarId,
                    item.owner.url,
                    item.owner.htmlUrl,
                    item.owner.followersUrl,
                    item.owner.followingUrl,
                    item.owner.gistsUrl,
                    item.owner.starredUrl,
                    item.owner.subscriptionsUrl,
                    item.owner.organizationsUrl,
                    item.owner.reposUrl,
                    item.owner.eventsUrl,
                    item.owner.receivedEventsUrl,
                    item.owner.type,
                    item.owner.siteAdmin
            ) */
            mArrayListItem.add(Item(item.id,
                    item.name,
                    item.fullName,
                    //mOwner,
                    item.language,
                    item.watchers,
                    item.score))
        }

        return mArrayListItem
    }
}