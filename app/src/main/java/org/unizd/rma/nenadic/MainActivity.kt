package org.unizd.rma.nenadic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Make API call
        val url = "https://www.thesportsdb.com/api/v1/json/3/all_leagues.php"
        val request = Request.Builder().url(url).build()

        OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                try {
                    val responseJson = JSONObject(responseBody)
                    val resultsJsonArray = responseJson.getJSONArray("leagues")

                    val leagues = Gson().fromJson(resultsJsonArray.toString(), Array<League>::class.java).toList()

                    runOnUiThread {
                        // Populate the RecyclerView with the characters
                        val adapter = LeagueAdapter(this@MainActivity, leagues)
                        recyclerView.adapter = adapter
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }
        })
    }
}
