package sp2016.cs310.com.traningtrackingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ScheduleActivity extends AppCompatActivity {

    ArrayList<ScheduledClass> scheduledClasses = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Date date = null;
        try {
            date = sdf.parse("01/05/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Trainer trainer = new Trainer("Onur", User.Gender.Male, 25);
        scheduledClasses.add(new ScheduledClass("Belly Dancing", date, trainer));

        initializeCalendar();
    }

    public void initializeCalendar() {

        final CalendarView calendarView = (CalendarView) findViewById(R.id.scheduleCalendarView);

        assert calendarView != null;
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                TextView showDate = (TextView) findViewById(R.id.resultClassTextView);
                Date selectedDate = sdf.getCalendar().getTime();
                showDate.setText(selectedDate.toString());
            }
        });
    }
}
