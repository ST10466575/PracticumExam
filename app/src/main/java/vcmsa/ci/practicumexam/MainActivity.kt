package vcmsa.ci.practicumexam

import android.os.Bundle
import android.content.Intent
import android.telecom.Call.Details
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {

    companion object {
        val PracticumExam2 = arrayListOf<Pair<String, String>>()
    }

    val Details = arrayListOf<String>("Song Title", "Artist", "Rating(1-5)", "Comments")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val Details = findViewById<TextView>(R.id.Details)
        Details.text = "SongTitle"; "Artist"; "Rating(1-5)"; "Comments"
        val SongTitle = findViewById<EditText>(R.id.SongTitle)
        val Artist = findViewById<EditText>(R.id.Artist)
        val Rating = findViewById<EditText>(R.id.Rating)
        val Comments = findViewById<EditText>(R.id.Comments)
        val AddtoPlaylistButton = findViewById<Button>(R.id.addtoPlaylistButton)
        val goToPlaylistButton = findViewById<Button>(R.id.goToPlaylistButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        var songtitle = ""
        var artist = ""
        var rating = ""
        var comments = ""
        songtitle += "${songtitle[1]}\n"
        songtitle += "${songtitle[2]}\n"
        songtitle += "${songtitle[3]}\n"
        songtitle += "${songtitle[4]}\n"

        artist += "${artist[1]}\n"
        artist += "${artist[2]}\n"
        artist += "${artist[3]}\n"
        artist += "${artist[4]}\n"

        rating += "${rating[1]}\n"
        rating += "${rating[2]}\n"
        rating += "${rating[3]}\n"
        rating += "${rating[4]}\n"

        comments += "${comments[1]}\n"
        comments += "${comments[2]}\n"
        comments += "${comments[3]}\n"
        comments += "${comments[4]}\n"




        AddtoPlaylistButton.setOnClickListener {
            val songTitle = SongTitle.text.toString()
            val artist = Artist.text.toString()
            val rating = Rating.text.toString().toIntOrNull()
            val comments = Comments.text.toString()

            if (songTitle.isNotEmpty() && artist.isNotEmpty() && (rating != null) && comments.isNotEmpty()) {
                Toast.makeText(this, "Song added to playlist", Toast.LENGTH_SHORT).show()
            } else {
                PracticumExam2.add(Pair(SongTitle, Artist) as Array<String,String>)
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                SongTitle.text.clear()
                Artist.text.clear()
                Rating.text.clear()
                Comments.text.clear()
            }

            goToPlaylistButton.setOnClickListener {
                val intent = Intent(this, PlayListActivity::class.java)
                startActivity(intent)
            }

            exitButton.setOnClickListener {
                finish()
            }

        }






    }
}








































































































































































































































































































































