package com.qadicorp.islamic_midnight_calc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends Activity implements OnTimeChangedListener {

    private TimePicker fromTime, toTime;
    private TextView midTimeView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.fromTime = (TimePicker) findViewById(R.id.fromTime);
        this.fromTime.setIs24HourView(Boolean.TRUE);
        this.fromTime.setOnTimeChangedListener(this);

        this.toTime = (TimePicker) findViewById(R.id.toTime);
        this.toTime.setIs24HourView(Boolean.TRUE);
        this.toTime.setOnTimeChangedListener(this);

        this.midTimeView = (TextView) findViewById(R.id.midTimeView);
    }

    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        GregorianCalendar from = new GregorianCalendar(1, Calendar.JANUARY, 1, this.fromTime.getCurrentHour(), this.fromTime.getCurrentMinute());
        GregorianCalendar to = new GregorianCalendar(1, Calendar.JANUARY, 2, this.toTime.getCurrentHour(), this.toTime.getCurrentMinute());

        long midPointInMillis = (to.getTimeInMillis() - from.getTimeInMillis())/2;

        GregorianCalendar mid = (GregorianCalendar) from.clone();
        mid.add(Calendar.MILLISECOND, (int) midPointInMillis);

        this.midTimeView.setText("Mid point is " + mid.get(Calendar.HOUR) + ":" + mid.get(Calendar.MINUTE));
    }
}
