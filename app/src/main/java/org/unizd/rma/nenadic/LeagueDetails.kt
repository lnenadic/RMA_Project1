package org.unizd.rma.nenadic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.bumptech.glide.Glide
import org.unizd.rma.nenadic.databinding.ActivityCharacterDetailsBinding

class LeagueDetails : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val league = intent.getSerializableExtra("leagues") as League
        displayLeagueDetails(league)
    }

    private fun displayLeagueDetails(league: org.unizd.rma.nenadic.League) {

        //  nameTextView.text = Html.fromHtml("<b>Name:</b> ${drinkX.strDrink}")
        //Glide.with(this).load(league.image).into(binding.imageViewCharacter)
        binding.strLeague.text = Html.fromHtml("<b>League:</b> ${league.strLeague}")
        binding.strSport.text = Html.fromHtml("<b>Sport:</b> ${league.strSport}")
        binding.strLeagueAlternate.text = Html.fromHtml("<b>League Alternate:</b> ${league.strLeagueAlternate}")

    }
}