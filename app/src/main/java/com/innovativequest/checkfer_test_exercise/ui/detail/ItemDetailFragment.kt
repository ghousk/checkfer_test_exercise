//*********************************************************************
// Created by Ghous Khan on 2020-02-27.
// Innovative Quest Ltd
// Copyright (C) Innovative Quest Ltd All Rights Reserved
// Any copying or reproduction of this software in strictly prohibited.
//*********************************************************************


package com.innovativequest.checkfer_test_exercise.ui.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.innovativequest.checkfer_test_exercise.AppExecutors
import com.innovativequest.checkfer_test_exercise.R
import com.innovativequest.checkfer_test_exercise.binding.FragmentDataBindingComponent
import com.innovativequest.checkfer_test_exercise.databinding.ItemDetailFragmentBinding
import com.innovativequest.checkfer_test_exercise.di.Injectable
import com.innovativequest.checkfer_test_exercise.testing.OpenForTesting
import com.innovativequest.checkfer_test_exercise.ui.common.RetryCallback
import com.innovativequest.checkfer_test_exercise.util.autoCleared
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import javax.inject.Inject

/**
 * The UI Controller for displaying a App Repo's information with its contributors.
 */
@OpenForTesting
class ItemDetailFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    val itemDetailViewModel: ItemDetailViewModel by viewModels {
        viewModelFactory
    }

    private val params by navArgs<ItemDetailFragmentArgs>()
    private var handler = Handler(Looper.getMainLooper())

    // mutable for testing
    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)
    var binding by autoCleared<ItemDetailFragmentBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding = DataBindingUtil.inflate<ItemDetailFragmentBinding>(
            inflater,
            R.layout.item_detail_fragment,
            container,
            false,
            dataBindingComponent
        )
        dataBinding.retryCallback = object : RetryCallback {
            override fun retry() {
                itemDetailViewModel.retry()
            }
        }
        binding = dataBinding

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.move)
        // When the image is loaded, set the image request listener to start the transaction
        binding.imageRequestListener = object: RequestListener<Drawable> {
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                startPostponedEnterTransition()
                return false
            }

            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                startPostponedEnterTransition()
                return false
            }
        }
        // Animation Watchdog - Make sure we don't wait longer than a second for the Glide image
        handler.postDelayed(1000) {
            startPostponedEnterTransition()
        }
        postponeEnterTransition()

        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(R.transition.move)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        itemDetailViewModel.setId(params.userId)
        binding.setLifecycleOwner(viewLifecycleOwner)
        binding.args = params
        binding.dataListItemResponse = itemDetailViewModel.dataListItemResponseById

        initItemDetail()
//        navController().navigate(
//            ItemDetailFragmentDirections.showUser())
    }


    private fun initItemDetail() {
        binding.listItemIndex = 0

        itemDetailViewModel.dataListItemResponseById.observe(viewLifecycleOwner, Observer {

            // TODO: In a real App the following doesn't need to be done
            it?.data?.items?.let { listItems ->
                for(dataListItem in listItems){
                    if(dataListItem.id == params.userId.toInt()){
                        binding.listItemIndex = listItems.indexOf(dataListItem)
                        break
                    }
                }
            }

        })
    }

    /**
     * Created to be able to override in tests
     */
    fun navController() = findNavController()
}
