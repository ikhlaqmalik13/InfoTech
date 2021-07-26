package com.inkquoir.infotech;

import androidx.appcompat.app.AppCompatActivity;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        setUpTheHorizontalCalendar();


    }

    private void setUpTheHorizontalCalendar() {

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        int fontColor = getResources().getColor(R.color.font_color);
        int selectedColor = getResources().getColor(R.color.color_0f8181);
        int semiWhite = getResources().getColor(R.color.colorSemiWhite);


        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(7)                 // Number of Dates cells shown on screen (default to 5).
                .configure()                            // starts configuration.
                .textSize(20f, 16f, 16f)
                .colorTextMiddle(semiWhite, fontColor)
                .colorTextBottom(fontColor, selectedColor)
                .formatTopText("MMM")                   // default to "MMM".
                .formatMiddleText("EEE")                 // default to "dd".
                .formatBottomText("dd")                // default to "EEE".
                .showTopText(false)                     // show or hide TopText (default to true).
                .showBottomText(true)                   // show or hide BottomText (default to true).
                //.selectedDateBackground(getResources().getDrawable(R.drawable.ic_baseline_arrow_drop_down_24))             // set selected date cell background.
                .selectorColor(selectedColor)                                                                                 // set selection indicator bar's color (default to colorAccent).
                .end()                                                                                                        // ends configuration.
                .defaultSelectedDate(Calendar.getInstance())                                                                  // Date to be selected at start (default to current day `Calendar.getInstance()`).
                .build();



        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }

            @Override
            public void onCalendarScroll(HorizontalCalendarView calendarView,
                                         int dx, int dy) {

            }

            @Override
            public boolean onDateLongClicked(Calendar date, int position) {
                return true;
            }
        });


    }
}