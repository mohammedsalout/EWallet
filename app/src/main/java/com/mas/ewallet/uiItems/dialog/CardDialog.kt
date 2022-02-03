package com.mas.ewallet.uiItems.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mas.ewallet.data.moduel.UserCards
import com.mas.ewallet.databinding.CardDialogBinding
import com.mas.ewallet.utils.Extensions.setFullDialog

class CardDialog : BottomSheetDialogFragment() {
    private lateinit var binding: CardDialogBinding
    private var userCards: MutableLiveData<UserCards> = MutableLiveData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = CardDialogBinding.inflate(layoutInflater)
        context?.setFullDialog(binding.root, dialog!!)

        binding.btnSave.setOnClickListener {
            val title: String = binding.txtTitle.text.toString()
            if (title.isNotEmpty()) {
                userCards.postValue(UserCards(title = title))
            } else {
                if (title.isEmpty())
                    binding.txtTitle.error = "!"
            }
        }
        return binding.root
    }

    fun getData(): MutableLiveData<UserCards> = userCards
}