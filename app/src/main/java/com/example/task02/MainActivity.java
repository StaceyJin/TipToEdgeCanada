package com.example.task02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener {
    private ImageView imageView;
    private Button nwtBtn, nsBtn, peiBtn;
    private Intent intent;
    private Button showdate;
    private TextView txtViewDate;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nwtBtn = findViewById(R.id.btnNwt);
        nsBtn = findViewById(R.id.btnNs);
        peiBtn = findViewById(R.id.btnPei);

        nwtBtn.setOnClickListener(MainActivity.this);
        nsBtn.setOnClickListener(MainActivity.this);
        peiBtn.setOnClickListener(MainActivity.this);

        intent = new Intent(MainActivity.this, display.class);

        showdate = findViewById(R.id.btnShowdate);
        txtViewDate = findViewById(R.id.txtViewDate);
        showdate.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alBuilder;
        alBuilder = new AlertDialog.Builder(MainActivity.this);
        alBuilder.setIcon(R.drawable.question_icon1);
        alBuilder.setTitle("Alert");
        alBuilder.setMessage("Are you sure you want to exit?");
        alBuilder.setCancelable(false);

        alBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { finish(); }
        });

        alBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { dialog.cancel(); }
        });

        AlertDialog alertDialog = alBuilder.create();
        alBuilder.show();
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.btnShowdate){
            DatePicker datePicker = new DatePicker(this);
            int currentDay = datePicker.getDayOfMonth();
            int currentMonth = (datePicker.getMonth())+1;
            int currentYear = datePicker.getYear();

            datePickerDialog = new DatePickerDialog(this,

                    new DatePickerDialog.OnDateSetListener(){

                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            txtViewDate.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                        }
                    }, currentYear, currentMonth, currentDay);

            datePickerDialog.show();
        }
        else if (v.getId()==R.id.btnNwt) {
            intent.putExtra("name", "nwt");
            startActivity(intent);
        }
        else if (v.getId()==R.id.btnNs){
            intent.putExtra("name", "ns");
            startActivity(intent);
        }
        else if (v.getId()==R.id.btnPei){
            intent.putExtra("name", "pei");
            startActivity(intent);
        }

        //startActivity(intent);
    }

    }
