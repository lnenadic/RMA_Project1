package org.unizd.rma.nenadic

import java.io.Serializable

data class League(
    val idLeague: Int,
    val strLeague: String,
    val strSport: String,
    val strLeagueAlternate: String
) : Serializable
