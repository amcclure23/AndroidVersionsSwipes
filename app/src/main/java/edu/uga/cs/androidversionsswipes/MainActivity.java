package edu.uga.cs.androidversionsswipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    public String[] continents = new String[]{"Africa","Antarctica", "Asia", "Australia", "Europe", "North America", "South America"};

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        // In your application's code:
        dbHelper = new DatabaseHelper(this);
        ReadCSV readCSV = new ReadCSV(this);
        readCSV.execute();

        /*
        ViewPager2 pager = findViewById( R.id.viewpager );
        AndroidVersionsPagerAdapter avpAdapter = new
                AndroidVersionsPagerAdapter(
                getSupportFragmentManager(), getLifecycle() );
        pager.setOrientation(
                ViewPager2.ORIENTATION_HORIZONTAL );
        pager.setAdapter( avpAdapter );*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the database when the activity is destroyed
        dbHelper.close();
    }

}
