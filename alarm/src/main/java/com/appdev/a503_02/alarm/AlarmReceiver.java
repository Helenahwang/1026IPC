package com.appdev.a503_02.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

public class AlarmReceiver extends BroadcastReceiver {

    //Receiver 클래스와 메소드는 하나밖에 생성을 못한다.
    //따라서 음악을 멈추게 하려면, 공유 클래스를 만들어서 Alarm.java에서 불러서 Receive로 보내주거나
    //Alarm.java에서 intent로 넘겨주어서 onReceive에서 값을 받아 음악을 꺼주거나 해야한다.
    @Override
    public void onReceive(Context context, Intent intent) {
        Sample.player = MediaPlayer.create(context.getApplicationContext(), R.raw.didididi);

        Sample.player.start();

    }
}
