package net.portes.examplemvvm.interactors

import android.content.Context
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import net.portes.examplemvvm.dao.AppDatabase
import net.portes.examplemvvm.dao.ItemDao
import net.portes.examplemvvm.interfaces.GitHubContract
import net.portes.examplemvvm.interfaces.OnGitHubListener
import net.portes.examplemvvm.interfaces.services.GitHubInterface
import net.portes.examplemvvm.net.RetrofitService
import net.portes.examplemvvm.utils.GitHubFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors



/**
 * Created by portes on 28/01/18.
 */
class GitHubInteractor(val mContext: Context) : RetrofitService(), GitHubContract.Interactor {
    companion object {
        val TAG = "GitHubInteractor"
    }

    val mComponentDisp: CompositeDisposable by lazy { CompositeDisposable() }
    val mFactorym: GitHubFactory by lazy { GitHubFactory() }
    val mItemDao: ItemDao by lazy {
        AppDatabase.getInstance(mContext).itemDao()
    }
    val mExecutor: Executor by lazy {
        Executors.newFixedThreadPool(3)
    }
    override fun intGitHubList(mPerPage: String, mPage: String, mQuery: String, mOnGitHubListener: OnGitHubListener) {
        Log.i(TAG, "intGitHubList:")


        val mDisposable = getRetrofitInstance(mContext)
                .create(GitHubInterface::class.java)
                .getRepositories(mPerPage, mPage, mQuery)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ basic ->
                    mExecutor.execute {
                        mItemDao.saveItem(basic.items)
                    }
                    Log.i(TAG, "intGitHubList: ${basic.items}")
                    localFromDb(mOnGitHubListener)
                }, { e ->
                    e.printStackTrace()
                    localFromDb(mOnGitHubListener)
                    mOnGitHubListener.onGitHubError()
                })
        mComponentDisp.add(mDisposable)
    }

    private fun localFromDb(mOnGitHubListener: OnGitHubListener) {
        mItemDao.getItemAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { items -> mOnGitHubListener.onGitHubList(items)}
    }

    override fun intComponentClear() {
        mComponentDisp.clear()
    }

}