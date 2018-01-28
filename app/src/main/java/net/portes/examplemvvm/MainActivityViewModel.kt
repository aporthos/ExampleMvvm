package net.portes.examplemvvm

import android.arch.lifecycle.ViewModel
import android.util.Log

/**
 * Created by portes on 25/01/18.
 */
class MainActivityViewModel : ViewModel() {
    companion object {
        val TAG = "MainActivityViewModel"
    }

    private var mMessage: String
    private var mCounter: Int
    init {
        mMessage = ""
        mCounter = 0
    }

    fun getMessage(): String {
        return mMessage
    }

    fun setMessage(mMessage: String) {
        this.mMessage = mMessage
    }

    fun getCounter(): Int {
        return mCounter
    }

    fun setCounter(mCounter: Int) {
        this.mCounter =+ mCounter
    }

}