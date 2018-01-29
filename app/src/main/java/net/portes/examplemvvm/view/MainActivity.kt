package net.portes.examplemvvm.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.portes.examplemvvm.R
import net.portes.examplemvvm.interfaces.GitHubContract
import net.portes.examplemvvm.pojos.Item
import net.portes.examplemvvm.presenters.GitHubPresenter
import net.portes.examplemvvm.view.adapters.GitHubAdapter
import net.portes.examplemvvm.view.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity(), GitHubContract.View {
    companion object {
        val TAG = "MainActivity"
    }

    lateinit var mViewModel: MainActivityViewModel
    private val mFilmAdapterm: GitHubAdapter by lazy {
        GitHubAdapter(ArrayList())
    }

    val mPresenter: GitHubContract.Presenter by lazy {
        GitHubPresenter(this, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.presComponentClear()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        getObserverViewModel()
        initializeView()
    }


    override fun initializeView() {
        rViewFilm.setHasFixedSize(true)
        rViewFilm.layoutManager = LinearLayoutManager(this)
        rViewFilm.adapter = mFilmAdapterm
    }

    fun getObserverViewModel() {
        if (null != mViewModel.getGitHubList()) {
            Log.i(TAG, "getObserverViewModel: fromViewModel")
            mFilmAdapterm.loadItems(mViewModel.getGitHubList()!!)
        } else {
            Log.i(TAG, "getObserverViewModel: fromNetwork")
            mPresenter.presGitHubList("10", "1", "android")
        }
    }


    override fun vwGitHubList(mGiHubList: ArrayList<Item>) {
        mViewModel.setGitHubList(mGiHubList)
        mFilmAdapterm.loadItems(mGiHubList)
    }

    override fun vwGitHubError() {
        Log.e(TAG, "Ocurrio un error alv :v ")
    }
}
