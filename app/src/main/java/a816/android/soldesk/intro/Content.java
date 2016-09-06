package a816.android.soldesk.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by soldesk on 2016-09-01.
 */
public class Content extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //이전 엑티비티에서 넘어온 데이터를 받음
        Intent intent = getIntent();

        //데이터 저장
        String data = intent.getExtras().getString("content");

        System.out.println("data : " + data);

        //텍스트뷰 객체 선언
        TextView tv = new TextView(this);

        //텍스트뷰에 데이터를 붙임
        tv.setText(data);

        //보여질 내용이 많아질 경우를 위해 스크롤뷰 생성
        ScrollView sv = new ScrollView(this);

        //스크롤뷰에 텍스트뷰를 붙임
        sv.addView(tv);

        //스크롤뷰를 엑티비티에 붙임
        setContentView(sv);
    }
}
