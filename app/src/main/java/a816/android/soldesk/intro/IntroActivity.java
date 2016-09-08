package a816.android.soldesk.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // 1.TimerTask
        // TimerTask 와 Timer 클래스를 이용해서 안드로이드 첫 화면 (Intro)를 구현
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), NewsList.class);
                startActivity(intent);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        };

        // 2. Timer
        Timer timer = new Timer();
        timer.schedule(task, 4000); //4초뒤에
    }
}

