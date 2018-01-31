package net.portes.examplemvvm.interfaces

import net.portes.examplemvvm.pojos.Item

/**
 * Created by portes on 28/01/18.
 */
interface GitHubContract {
    interface View {
        fun vwGitHubList(mFilmsList: List<Item>)
        fun vwGitHubError()
    }

    interface Presenter {
        fun presGitHubList(mPerPage: String, mPage: String, mQuery: String)
        fun presComponentClear()
    }

    interface Interactor {
        fun intGitHubList(mPerPage: String, mPage: String, mQuery: String, mOnGitHubListener: OnGitHubListener)
        fun intComponentClear()
    }
}

interface OnGitHubListener {
    fun onGitHubList(mFilmsList: List<Item>)
    fun onGitHubError()
}