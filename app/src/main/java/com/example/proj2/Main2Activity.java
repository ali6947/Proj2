package com.example.proj2;

import androidx.appcompat.app.AppCompatActivity;
//import android.database.sqlite;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private int mYear, mMonth, mDay;
    Button btnDatePicker , btn1;
    EditText txtDate,btitle,bdesc;
    private TaskDbHelper dbHelper ;
    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        else if(v==btn1){
           // Log.d("MyApp","I am here");
          //  SQLiteDatabase mydatabase = openOrCreateDatabase("TaskReader.db",MODE_PRIVATE,null);
           // mydatabase.execSQL("INSERT INTO "+TaskManager.TaskEntry.TABLE_NAME1+" ( " +TaskManager.TaskEntry.COLUMN_1_TITLE+","+TaskManager.TaskEntry.COLUMN_1_DESC+","+TaskManager.TaskEntry.COLUMN_1_DATE+ ") VALUES('admin','admin','admin');");
            //mydatabase.close();
            //dbHelper.ins1(btitle.getText().toString(),bdesc.getText().toString(),txtDate.getText().toString());
        }
}

    protected void onCreate(Bundle savedInstanceState) {

        dbHelper = new TaskDbHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnDatePicker=(Button)findViewById(R.id.btn_date);
        txtDate=(EditText)findViewById(R.id.in_date);
        btnDatePicker.setOnClickListener(this);
        btn1 = (Button) findViewById(R.id.subm);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { Log.d("MyApp","I am here"); Log.i("MyApp","I am here");
                btitle = (EditText) findViewById(R.id.title);
                bdesc = (EditText) findViewById(R.id.desc);
                txtDate = (EditText) findViewById(R.id.in_date);
             //   SQLiteDatabase mydatabase = openOrCreateDatabase("TaskReader.db",MODE_PRIVATE,null);
               // mydatabase.execSQL("INSERT INTO Level1(" +TaskManager.TaskEntry.COLUMN_1_TITLE+","+TaskManager.TaskEntry.COLUMN_1_DESC+","+TaskManager.TaskEntry.COLUMN_1_DATE+ ") VALUES('admin','admin','admin');");

                dbHelper.ins1(btitle.getText().toString(),bdesc.getText().toString(),txtDate.getText().toString());
               // mydatabase.close();
               // Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
                //Main2Activity.this.startActivity(myIntent);
            }
        });
    }

}
