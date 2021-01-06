package com.sarid.urmov.wallet

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sarid.urmov.R
import com.sarid.urmov.wallet.adapter.WalletAdapter
import com.sarid.urmov.wallet.model.Wallet
import kotlinx.android.synthetic.main.activity_my_wallet.*

class MyWalletActivity : AppCompatActivity() {

    private var dataList = ArrayList<Wallet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_wallet)

        loadDummyData()
        imageView3.setOnClickListener {
            finish()
        }

    }

    private fun initListener() {
        rv_transaksi.layoutManager = LinearLayoutManager(this)
        rv_transaksi.adapter = WalletAdapter(dataList){

        }

        btn_top_up.setOnClickListener {
            startActivity(Intent(this, MyWalletTopUpActivity::class.java))
        }
    }

    private fun loadDummyData() {
        dataList.add(
            Wallet(
                "Avengers Returns",
                "Sabtu 12 Jan, 2020",
                700000.0,
                "0"
            )
        )
        dataList.add(
            Wallet(
                "Top Up",
                "Sabtu 12 Jan, 2020",
                1700000.0,
                "1"
            )
        )
        dataList.add(
            Wallet(
                "Avengers Returns",
                "Sabtu 12 Jan, 2020",
                700000.0,
                "0"
            )
        )

        initListener()
    }
}
