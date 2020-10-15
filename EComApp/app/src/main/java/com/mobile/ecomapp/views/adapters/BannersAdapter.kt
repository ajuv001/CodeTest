package com.mobile.ecomapp.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.ecomapp.R
import com.mobile.ecomapp.models.Banner
import kotlinx.android.synthetic.main.banner_layout.view.*

class BannersAdapter: RecyclerView.Adapter<BannersAdapter.BannersViewHolder>() {

    private var banners: List<Banner> = listOf()

    class BannersViewHolder(private val mView: View) : RecyclerView.ViewHolder(mView) {

        fun bind(banner: Banner) {
            Glide.with(mView.context).load(banner.image).into(mView.banner_img);
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannersViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.banner_layout, parent, false)
        return BannersViewHolder(v)
    }

    override fun getItemCount(): Int {
        return banners.size
    }

    override fun onBindViewHolder(holder: BannersViewHolder, position: Int) {
        holder.bind(banners[position])
    }

    fun setData(banners: List<Banner>){
        this.banners = banners
        notifyDataSetChanged()
    }
}