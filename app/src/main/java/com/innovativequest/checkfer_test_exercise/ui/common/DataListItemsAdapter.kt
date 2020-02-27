//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.ui.common

import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.innovativequest.checkfer_test_exercise.AppExecutors
import com.innovativequest.checkfer_test_exercise.R
import com.innovativequest.checkfer_test_exercise.databinding.DataListItemBinding
import com.innovativequest.checkfer_test_exercise.model.DataListItem

/**
 * A RecyclerView adapter for [DataListItem] class.
 */
class DataListItemsAdapter(
    private val dataBindingComponent: DataBindingComponent,
    appExecutors: AppExecutors,
    private val repoClickCallback: ((DataListItem) -> Unit)?
) : DataBoundListAdapter<DataListItem, DataListItemBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<DataListItem>() {
        override fun areItemsTheSame(oldItem: DataListItem, newItem: DataListItem): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: DataListItem, newItem: DataListItem): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.ranking == newItem.ranking
        }
    }
) {

    override fun createBinding(parent: ViewGroup): DataListItemBinding {
        val binding = DataBindingUtil.inflate<DataListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.data_list_item,
            parent,
            false,
            dataBindingComponent
        )
        binding.root.setOnClickListener {
            binding.dataListItem?.let {
                repoClickCallback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: DataListItemBinding, item: DataListItem) {
        binding.dataListItem = item
    }
}
