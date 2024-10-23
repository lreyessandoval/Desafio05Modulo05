package com.inforcap.desafio05m5_stores

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.inforcap.desafio05m5_stores.base.BaseActivity
import com.inforcap.desafio05m5_stores.databinding.ActivityMainBinding
import com.inforcap.desafio05m5_stores.model.StoreList

class MainActivity : BaseActivity<ActivityMainBinding>(), View.OnClickListener {

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadDataStores()

        binding.cardView1.setOnClickListener(this)
        binding.cardView2.setOnClickListener(this)
        binding.cardView3.setOnClickListener(this)
        binding.cardView4.setOnClickListener(this)
        binding.cardView5.setOnClickListener(this)
        binding.cardView6.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view) {
            binding.cardView1 -> startActivity(Intent(this, DetailStoreActivity::class.java).apply {
                putExtra("bundle", Bundle().apply {
                    putParcelable("store", StoreList.Store1)
                    putInt("img",R.mipmap.img1)
                })
            })
            binding.cardView2 -> startActivity(Intent(this, DetailStoreActivity::class.java).apply {
                putExtra("bundle", Bundle().apply {
                    putParcelable("store", StoreList.Store2)
                    putInt("img",R.mipmap.img2)
                })
            })
            binding.cardView3 -> startActivity(Intent(this, DetailStoreActivity::class.java).apply {
                putExtra("bundle", Bundle().apply {
                    putParcelable("store", StoreList.Store3)
                    putInt("img",R.mipmap.img3)
                })
            })
            binding.cardView4 -> startActivity(Intent(this, DetailStoreActivity::class.java).apply {
                putExtra("bundle", Bundle().apply {
                    putParcelable("store", StoreList.Store4)
                    putInt("img",R.mipmap.img4)
                })
            })
            binding.cardView5 -> startActivity(Intent(this, DetailStoreActivity::class.java).apply {
                putExtra("bundle", Bundle().apply {
                    putParcelable("store", StoreList.Store5)
                    putInt("img",R.mipmap.img5)
                })
            })
            binding.cardView6 -> startActivity(Intent(this, DetailStoreActivity::class.java).apply {
                putExtra("bundle", Bundle().apply {
                    putParcelable("store", StoreList.Store6)
                })
            })
        }
    }

    private fun loadDataStores() {
        binding.tvStoreName1.text = StoreList.Store1.name
        binding.tvTime1.text = StoreList.Store1.time
        binding.appCompatImageView1.setImageResource(R.mipmap.img1)


        binding.tvStoreName2.text = StoreList.Store2.name
        binding.tvTime2.text = StoreList.Store2.time
        binding.appCompatImageView2.setImageResource(R.mipmap.img2)


        binding.tvStoreName3.text = StoreList.Store3.name
        binding.tvTime3.text = StoreList.Store3.time
        binding.appCompatImageView3.setImageResource(R.mipmap.img3)


        binding.tvStoreName4.text = StoreList.Store4.name
        binding.tvTime4.text = StoreList.Store4.time
        binding.appCompatImageView4.setImageResource(R.mipmap.img4)


        binding.tvStoreName5.text = StoreList.Store5.name
        binding.tvTime5.text = StoreList.Store5.time
        binding.appCompatImageView5.setImageResource(R.mipmap.img5)


        binding.tvStoreName6.text = StoreList.Store6.name
        binding.tvTime6.text = StoreList.Store6.time
        Glide.with(applicationContext)
            .load(StoreList.Store6.image)
            .centerCrop()
            .error(R.drawable.baseline_error_outline_24)
            .into(binding.appCompatImageView6)

    }


}