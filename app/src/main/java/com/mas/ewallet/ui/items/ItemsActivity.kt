package com.mas.ewallet.ui.items

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mas.ewallet.databinding.ActivityItemsBinding
import com.mas.ewallet.uiItems.adapters.ItemsAdapter
import com.mas.ewallet.uiItems.dialog.ItemDialog
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ItemsActivity : AppCompatActivity() {
    private val viewModel: ItemsViewModel by viewModels()

    private lateinit var binding: ActivityItemsBinding
    private lateinit var itemsDialog: ItemDialog
    private var cardId: Int = 0

    private lateinit var itemsAdapter: ItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cardId = intent.getIntExtra("cardId", 0)
        itemsDialog = ItemDialog(cardId)

        itemsAdapter = ItemsAdapter()
        binding.rvItems.layoutManager = LinearLayoutManager(this)
        binding.rvItems.adapter = itemsAdapter

        binding.btnAdd.setOnClickListener {
            itemsDialog.show(supportFragmentManager, "items")
        }

        //when item adding
        itemsDialog.getNewItems().observe(this) {
            it.let {
                viewModel.insertNewCardItem(it)
                itemsDialog.dismiss()
            }
        }

        // get all card items
        viewModel.getCardItems(cardId)
            .observe(this) {
                if (it.isNotEmpty()) {
                    itemsAdapter.updateAdapter(it)
                }
            }


        // get the total card item amount
        viewModel.getTheCardItemsTotalAmounts(cardId)
            .observe(this) {
                binding.tvTotal.text = it.toString()
            }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (itemsDialog.isVisible)
            itemsDialog.dismiss()

    }
}