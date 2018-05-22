package com.konstantiniiv.baseproject.presentation.ui.global.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 18.05.2018.
 */
abstract class HeaderFooterAdapter<in T>(withHeader: Boolean, withFooter: Boolean)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
        const val TYPE_FOOTER = 2
    }

    private var data = ArrayList<T>()
    private var withHeader: Boolean
    private var withFooter: Boolean

    init {
        this.withHeader = withHeader
        this.withFooter = withFooter
    }

    fun showHeader(showHeader: Boolean) {
        this.withHeader = showHeader
        notifyDataSetChanged()
    }

    fun showFooter(showFooter: Boolean) {
        this.withFooter = showFooter
        notifyDataSetChanged()
    }

    fun addItems(items: List<T>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    protected abstract fun getItemViewHolder(
            inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder

    protected abstract fun getHeaderViewHolder(
            inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder

    protected abstract fun getFooterViewHolder(
            inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder

    override fun getItemViewType(position: Int): Int {
        if (withHeader && isPositionHeader(position)) return TYPE_HEADER
        if (withFooter && isPositionFooter(position)) return TYPE_FOOTER
        return TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        when (viewType) {
            TYPE_ITEM -> return getItemViewHolder(inflater, parent)
            TYPE_HEADER -> return getHeaderViewHolder(inflater, parent)
            TYPE_FOOTER -> return getFooterViewHolder(inflater, parent)
            else -> throw UnsupportedOperationException("there is no type that matches the type "
                    + viewType + " + make sure your using types correctly")
        }
    }

    override fun getItemCount(): Int {
        var itemCount = data.size
        if (withHeader) itemCount++;
        if (withFooter) itemCount++;
        return itemCount
    }

    private fun isPositionHeader(position: Int) = position == 0
    private fun isPositionFooter(position: Int) = position == itemCount - 1
}