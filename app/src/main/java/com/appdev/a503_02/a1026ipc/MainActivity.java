package com.appdev.a503_02.a1026ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btn;
    MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //서비스 객체 생성
        myService = new MyService();

        //인텐트 생성 Activity
        Intent intent = new Intent(this, MyService.class);

        //서비스와 바인드된 경우와 바인드가 해제된 경우에 호출되는 메소드를 소유한 ServiceConnection 객체 생성
        ServiceConnection myConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

                MyService.MyLocalBinder binder =(MyService.MyLocalBinder)service;
                myService = binder.getService();

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };


        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);//서비스=>bindService, 화면 출력=>startActivity

        textView = (TextView)findViewById(R.id.result);

        btn=(Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = myService.remoteMothod();
                textView.setText(result);
            }
        });

    }
}
