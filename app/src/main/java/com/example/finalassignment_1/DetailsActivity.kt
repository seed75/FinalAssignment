package com.example.finalassignment_1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        val assetType = intent.getStringExtra("assetType")?.takeIf { it != "N/A" } ?: ""
        val ticker = intent.getStringExtra("ticker") ?: "N/A"
        val price = intent.getStringExtra("price") ?: "0.0"
        val yield = intent.getStringExtra("yield") ?: "0.0"
        val description = intent.getStringExtra("description") ?: "No description provided."
        val keypass = intent.getStringExtra("keypass") ?: ""

        val assetTypeTextView = findViewById<TextView>(R.id.assetTypeTextView)
        val tickerTextView = findViewById<TextView>(R.id.tickerTextView)
        val priceTextView = findViewById<TextView>(R.id.priceTextView)
        val yieldTextView = findViewById<TextView>(R.id.yieldTextView)
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)

        assetTypeTextView.text = assetType
        assetTypeTextView.visibility = if (assetType.isNotBlank()) View.VISIBLE else View.GONE
        descriptionTextView.text = description

        if (keypass == "investments") {
            tickerTextView.text = "Ticker: $ticker"
            priceTextView.text = "Price: $$price"
            yieldTextView.text = "Yield: $yield%"
            tickerTextView.visibility = View.VISIBLE
            priceTextView.visibility = View.VISIBLE
            yieldTextView.visibility = View.VISIBLE
        } else {
            tickerTextView.visibility = View.GONE
            priceTextView.visibility = View.GONE
            yieldTextView.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            R.id.action_logout -> {
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
