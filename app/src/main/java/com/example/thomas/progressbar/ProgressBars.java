package com.example.thomas.progressbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;

public class ProgressBars extends AppCompatActivity {

    // Progress Bar is a UI element indicating the progress of a task
    private ProgressBar progressBar;
    private int progress = 0; // Progress Bar begins at value 0

    // With help from Computer Science Tutorials on YouTube, "Android Tutorial 3 - How to Use Progress Bars
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_progress_bars);

        Button advanceToMaps = (Button) findViewById(R.id.button2);
            advanceToMaps.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(ProgressBars.this, MapsActivity.class);
        startActivity(intent);
    }
});

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { // Button with two states, checked and unchecked, when pressed state automatically changes
            progress += isChecked ? 5 : -5; // Uses a Determinate Progress to show how much is completed
            progressBar.setProgress(progress); // Each Checkbox is worth the value of 5 on the progress bar, due to 20 teams in the division, 100 (full progress) divided by 20 means each value increase is 5, whether 5 to increase when checked or -5 to decrease when unchecked
            }
        };

        // Resource Id's for all of the Checkboxes used from "checkBox" being Arsenal to "checkBox20" being NEW White Hart Lane
        int ids[] = {R.id.checkBox, R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5, R.id.checkBox6, R.id.checkBox7, R.id.checkBox8, R.id.checkBox9, R.id.checkBox10, R.id.checkBox11, R.id.checkBox12, R.id.checkBox13, R.id.checkBox14, R.id.checkBox15, R.id.checkBox16, R.id.checkBox17,R.id.checkBox18, R.id.checkBox19, R.id.checkBox20};
        for (int i = 0; i < 20; i++) { // Represents up to the amount of 20, the amount of teams
            CheckBox cb = (CheckBox) findViewById(ids[i]);
            if (prefs.getBoolean("checkbox" + (i + 1), false)) cb.setChecked(true);
            cb.setOnCheckedChangeListener(listener);
        }

    }
}