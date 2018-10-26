package com.appdev.a503_02.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class Alarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        //알람 매니저 생성
        final AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        //알람이 수행할 일을 작성
        Intent intent = new Intent(this, AlarmReceiver.class);
        //intent.putExtra("play", "start");

        final PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent, 0);

        Button btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //알람 시간 설정
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 10);

                //알람 등록
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), sender);
            }
        });

        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Sample.player.stop();
            }
        });


    }
}
