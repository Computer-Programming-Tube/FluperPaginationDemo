package com.infoskillstechnology.fluperpaginationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.infoskillstechnology.fluperpaginationdemo.ui.second.SecondFragment
import com.infoskillstechnology.fluperpaginationdemo.ui.second.SecondViewModel
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity : AppCompatActivity() {
    private lateinit var viewModel: SecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        viewModel = ViewModelProviders.of(this).get(SecondViewModel::class.java)
        main_layout_recycler_view.layoutManager = LinearLayoutManager(this)
       val notiifcationAdapter = NotificationAdapter(this)
        main_layout_recycler_view.adapter = notiifcationAdapter
        viewModel.initialization(application)
        viewModel.getPageList().observe(this, Observer {
            notiifcationAdapter.submitList(it)
        })
    }

}
