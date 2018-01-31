package net.portes.examplemvvm.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_film.view.*
import net.portes.examplemvvm.R
import net.portes.examplemvvm.pojos.Item
import net.portes.examplemvvm.utils.inflate

/**
 * Created by portes on 28/01/18.
 */
class GitHubAdapter(val mFilmsList: ArrayList<Item>) : RecyclerView.Adapter<GitHubAdapter.ItemViewHolder>() {
    companion object {
        val TAG = "GitHubAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val mView: View = parent.inflate(R.layout.item_film)
        return ItemViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return mFilmsList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val mFilm = mFilmsList[position]
        holder.bind(mFilm)
    }

    fun loadItems(mFilmsList: List<Item>) {
        this.mFilmsList.addAll(mFilmsList)
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object {
            val TAG = "ViewHolder"
        }

        fun bind(mItem: Item) = with(itemView) {
            val mLanguaje  = mItem.language?: "S/L"
            lblFullName.text = mItem.fullName
            lblLanguaje.text = "Lang: $mLanguaje"
            lblWatchers.text = "Watchers: ${mItem.watchers}"
            lblScore.text = "Score: ${mItem.score}"
        }
    }
}