package net.portes.examplemvvm

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.portes.examplemvvm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var mDataBinding: ActivityMainBinding
    private lateinit var mViewModel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        btnAccept.setOnClickListener{
            setTextMessage()
            mViewModel.setCounter(1)
        }

        setTextMessage()
        createData()

    }

    private fun setTextMessage() {
        if (mViewModel.getMessage().isEmpty()) {
            mViewModel.setMessage("Hola pinche putita")
            lblMessage.text = "${mViewModel.getMessage()} ${mViewModel.getCounter()}"
        } else {
            lblMessage.text = "${mViewModel.getMessage()} ${mViewModel.getCounter()}"
        }
    }

    private fun createData() {
        val mUser = User("Amadeus","Portes")
        mDataBinding.setVariable(BR.user, mUser)
        mDataBinding.executePendingBindings()
    }
}
