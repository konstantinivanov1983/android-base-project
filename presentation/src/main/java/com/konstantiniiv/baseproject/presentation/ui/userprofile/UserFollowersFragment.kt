package com.konstantiniiv.baseproject.presentation.ui.userprofile

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.konstantiniiv.baseproject.domain.model.FollowerEntity
import com.konstantiniiv.baseproject.presentation.R

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
class UserFollowersFragment : MvpAppCompatFragment(), UserFollowersView {

    lateinit var rvFollowers: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_followers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFollowers = view.findViewById(R.id.recycler_view_followers)
        val lm = LinearLayoutManager(activity)
        rvFollowers.layoutManager = lm
    }

    override fun showFollowers(followers: List<FollowerEntity>) {
        throw UnsupportedOperationException("not implemented")
    }
}