package net.portes.examplemvvm.utils

import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by portes on 28/01/18.
 */
fun ViewGroup.inflate(mResource: Int) = LayoutInflater.from(context).inflate(mResource, this, false)

fun CoordinatorLayout.showSnack(message: String, duration: Int, funcion: Snackbar.() -> Unit) {
    val mSnackBar = Snackbar.make(this, message, duration)
    mSnackBar.funcion()
    mSnackBar.show()
}

fun Snackbar.action(message: String, listener: (View) -> Unit) {
    setAction(message, listener)
}