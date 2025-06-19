package vcmsa.ci.practicumexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge
import vcmsa.ci.practicumexam.R.id.main

class PlayListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_playlist)

        val ListView = findViewById<ListView>(R.id.ListView)
        val exitButton = findViewById<Button>(R.id.exitButton)

        val songs = arrayOf("Song 1", "Song 2", "Song 3", "Song 4")
        val artists = arrayOf("Artist 1", "Artist 2", "Artist 3", "Artist 4")
        val ratings = arrayOf("Rating 1", "Rating 2", "Rating 3", "Rating 4")
        val comments = arrayOf("Comment 1", "Comment 2", "Comment 3", "Comment 4")

        val filteredsongs = MainActivity.PracticumExam2.filter { it.second == ("Artist 1") }
        val displayname = filteredsongs.map { "${it.first} - ${it.second}" }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, songs)
        ListView.adapter = adapter
        
        val calculaterating = findViewById<Button>(R.id.calculateRatingButton)
        calculaterating.setOnClickListener {
            Toast.makeText(this, "Rating calculated", Toast.LENGTH_SHORT).show()
        }

        exitButton.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}