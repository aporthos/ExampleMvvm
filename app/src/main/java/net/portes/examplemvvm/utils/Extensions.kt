package net.portes.examplemvvm.utils

import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by portes on 28/01/18.
 */
fun ViewGroup.inflate(mResource: Int)  = LayoutInflater.from(context).inflate(mResource, this, false)