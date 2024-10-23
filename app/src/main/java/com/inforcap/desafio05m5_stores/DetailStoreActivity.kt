package com.inforcap.desafio05m5_stores

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.inforcap.desafio05m5_stores.databinding.ActivityDetailStoreBinding
import com.inforcap.desafio05m5_stores.model.Store

class DetailStoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val bundle = intent.extras?.get("bundle") as? Bundle
        val bundle = intent.extras?.getBundle("bundle")
        val store = bundle?.getParcelable<Store>("store")
        val img = bundle?.getInt("img")

        binding.run {
            store?.run {
                /*
                if (img != null) {
                    appCompatImageView.setImageResource(img)
                }*/

                tvStoreName.text = name
                tvStoreName.setOnClickListener {
                    val shareIntent = Intent.createChooser(
                        Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, name)
                            type = "text/plain"
                        }, "Compartiendo ... "
                    )
                    startActivity(shareIntent)
                }

                tvStoreTime.text = time

                tvStoreAddress.text = address
                tvStoreAddress.setOnClickListener {
                    val gmmIntentUri = Uri.parse("geo:0,0?q=$address");
                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps")
                    startActivity(mapIntent)
                }

                tvStoreHistory.text = history


                Glide.with(applicationContext)
                    .load(image)
                    .centerCrop()
                    .error(R.drawable.baseline_error_outline_24)
                    .into(appCompatImageView)


            }
        }


    }
}