package net.portes.examplemvvm.view.viewmodel

import android.arch.lifecycle.ViewModel
import net.portes.examplemvvm.pojos.Item

/**
 * Created by portes on 28/01/18.
 */
class MainActivityViewModel : ViewModel() {
    companion object {
        val TAG = "MainActivityViewModel"
    }
    var mGitHubList: ArrayList<Item>? = null

    fun getGitHubList(): ArrayList<Item>? {
        return mGitHubList
    }

    fun setGitHubList(mGiHubList: ArrayList<Item>) {
        mGitHubList = mGiHubList
    }

}