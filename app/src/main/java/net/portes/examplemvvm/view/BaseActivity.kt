package net.portes.examplemvvm.view

import android.support.v7.app.AppCompatActivity

/**
 * Created by portes on 28/01/18.
 */
abstract class BaseActivity : AppCompatActivity() {
    abstract fun initializeView()
}