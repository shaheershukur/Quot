package com.shaheershukur.quot;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //create variables to access elements
    protected TextView quote;
    protected TextView author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //reference variables to access elements
        quote = (TextView) findViewById(R.id.id_quote);
        author = (TextView) findViewById(R.id.id_author);

        //set click listener for floating button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(v -> displayNextQuote());

        //display a random quote for first time before button is clicked
        displayNextQuote();
    }

    public void displayNextQuote() {
        //generate a random number between 1 (inc.) and 20 (inc.)
        Random randNumGenerator = new Random();
        int randNum = randNumGenerator.nextInt(20) + 1;

        //using random number, fetch a random quote from file /res/values/strings.xml
        String wholeText = getString(getResources().getIdentifier("quote" + randNum, "string", getPackageName()));

        //split the fetched text into quote and author part w.r.t regex "#"
        String[] splitText = wholeText.split("#");

        //display the quote and author in the textview
        quote.setText(splitText[0]);
        author.setText(splitText[1]);
    }
}
