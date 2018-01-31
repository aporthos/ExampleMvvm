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
    var mGitHubList: List<Item>? = null

    fun getGitHubList(): List<Item>? {
        return mGitHubList
    }

    fun setGitHubList(mGiHubList: List<Item>) {
        mGitHubList = mGiHubList
    }

}