package com.mas.ewallet.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mas.ewallet.databinding.ActivityMainBinding
import com.mas.ewallet.uiItems.adapters.CardAdapter
import com.mas.ewallet.uiItems.dialog.CardDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var cardDialog: CardDialog
    private lateinit var cardAdapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cardDialog = CardDialog()
        setupAdapter();

        //
        viewModel.getUserCards().observe(this) {
            cardAdapter.updateAdapter(it)
        }

        // add new cards ======
        binding.btnAdd.setOnClickListener {
            cardDialog.show(supportFragmentManager, "card")
        }

        // if adding a new card
        cardDialog.getData().observe(this) {
            viewModel.insertNewCard(it)
            cardDialog.dismiss()
        }
    }

    private fun setupAdapter() {
        cardAdapter = CardAdapter(this)
        binding.rvCards.layoutManager = LinearLayoutManager(this)
        binding.rvCards.adapter = cardAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        if (cardDialog.isVisible)
            cardDialog.dismiss()
    }
}