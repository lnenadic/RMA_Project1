package org.unizd.rma.nenadic

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class LeagueAdapter(private val context: Context, private val leagues: List<League>) :
    RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    inner class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewCharacter: ImageView = itemView.findViewById(R.id.imageViewCharacter)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return LeagueViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val league = leagues[position]
        holder.textViewName.text = league.strLeague
        //Picasso.get().load(character.image).into(holder.imageViewCharacter)
        //Glide.with(context).load(league.image).into(holder.imageViewCharacter)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, LeagueDetails::class.java)
            intent.putExtra("leagues", league)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return leagues.size
    }
}
