package com.example.proj2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TaskDbHelper dbHelper = new TaskDbHelper(this);
        /* SQLiteDatabase mydatabase = openOrCreateDatabase("your database name",MODE_PRIVATE,null); */
        dbHelper.cc();
        dbHelper.checker();

        Button btn1 = (Button) findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { Log.d("MyApp","I am here");
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });




    }
}
