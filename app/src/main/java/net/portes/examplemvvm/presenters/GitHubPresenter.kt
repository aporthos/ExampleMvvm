package net.portes.examplemvvm.presenters

import android.content.Context
import net.portes.examplemvvm.interactors.GitHubInteractor
import net.portes.examplemvvm.interfaces.GitHubContract
import net.portes.examplemvvm.interfaces.OnGitHubListener
import net.portes.examplemvvm.pojos.Item

/**
 * Created by portes on 28/01/18.
 */
class GitHubPresenter(val mContext: Context, val mView: GitHubContract.View) : GitHubContract.Presenter, OnGitHubListener {


    val mInteractorm: GitHubContract.Interactor by lazy {
        GitHubInteractor(mContext)
    }

    override fun presGitHubList(mPerPage: String, mPage: String, mQuery: String) {
        mInteractorm.intGitHubList(mPerPage,mPage,  mQuery,this)
    }
    override fun onGitHubList(mFilmsList: ArrayList<Item>) {
        mView.vwGitHubList(mFilmsList)
    }

    override fun onGitHubError() {
        mView.vwGitHubError()
    }
    override fun presComponentClear() {
        mInteractorm.intComponentClear()
    }
}