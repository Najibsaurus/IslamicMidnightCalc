package com.qadicorp.islamic_midnight_calc;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends android.app.Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TimePicker fromTime = (TimePicker) findViewById(R.id.fromTime);
        fromTime.setIs24HourView(Boolean.TRUE);

        TimePicker toTime = (TimePicker) findViewById(R.id.toTime);
        toTime.setIs24HourView(Boolean.TRUE);

        TextView midTime = (TextView) findViewById(R.id.midTime);
        midTime.setText("Billa");
    }
}
