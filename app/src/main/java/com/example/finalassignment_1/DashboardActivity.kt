package com.example.finalassignment_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalassignment_1.databinding.ActivityDashboardBinding
import com.example.finalassignment_1.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Dashboard"
        val keypass = intent.getStringExtra("keypass") ?: return
        Log.d("DashboardDebug", "Received keypass: $keypass")

        val adapter = DashboardAdapter(mutableListOf()) { item ->
            val intent = Intent(this@DashboardActivity, DetailsActivity::class.java).apply {
                putExtra("assetType", item["assetType"] as? String ?: item["name"] as? String ?: "N/A")
                putExtra("ticker", item["ticker"] as? String ?: "N/A")
                putExtra("price", item["currentPrice"]?.toString() ?: item["price"]?.toString() ?: "0.0")
                putExtra("yield", item["dividendYield"]?.toString() ?: item["yield"]?.toString() ?: "0.0")
                putExtra("description", item["description"] as? String ?: "No description")
                putExtra("keypass", keypass)
            }
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.loadItems(keypass)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.items.collectLatest { items ->
                    Log.d("DashboardDebug", "Items received: ${items.size}")
                    adapter.updateItems(items)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
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
