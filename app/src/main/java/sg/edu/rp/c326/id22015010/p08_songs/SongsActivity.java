package sg.edu.rp.c326.id22015010.p08_songs;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class SongsActivity extends AppCompatActivity {
     ListView lv;
     Button backButton;
     DBHelper dbHelper;
    ArrayList<Song> Songslist;
    ArrayAdapter<Song> aa;
    int insertCounter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        lv = findViewById(R.id.listview);
        backButton = findViewById(R.id.backbtn);
        Songslist=new ArrayList<>();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        dbHelper = new DBHelper(this);
        ArrayList<Song> songs = dbHelper.getAllSongs();
        Songslist.addAll(songs);
        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Songslist);
        lv.setAdapter(aa);


    }

}