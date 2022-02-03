package com.mas.ewallet.uiItems.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mas.ewallet.data.moduel.UserItems
import com.mas.ewallet.databinding.ItemsDialogBinding
import com.mas.ewallet.utils.Extensions.setFullDialog

class ItemDialog(private var cardId : Int) : BottomSheetDialogFragment() {
    private var itemData: MutableLiveData<UserItems> = MutableLiveData()
    private lateinit var binding: ItemsDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ItemsDialogBinding.inflate(layoutInflater)
        context?.setFullDialog(binding.root, dialog!!)

        binding.btnSave.setOnClickListener {
            if (!binding.txtAmount.text.isNullOrEmpty()) {
                val note: String = if (!binding.txtNote.text.isNullOrEmpty()) "" else binding.txtNote.text.toString()
                itemData.postValue(
                    UserItems(
                        amount = binding.txtAmount.text.toString().toDouble(),
                        note = note,
                        date = System.currentTimeMillis(),
                        cardId = cardId
                    )
                )
            } else {
                binding.txtAmount.error = "!"
            }
        }

        return binding.root
    }

    fun getNewItems(): MutableLiveData<UserItems> = itemData
}