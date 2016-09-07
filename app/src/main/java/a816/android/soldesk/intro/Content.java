package a816.android.soldesk.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by soldesk on 2016-09-01.
 */
public class Content extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        String url = getIntent().getStringExtra("content");
        wv = (WebView) findViewById(R.id.webView01);

        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(url);

        // set the font size

        WebSettings ws = wv.getSettings();
        ws.setDefaultFontSize(8);
        wv.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR); // 화면을 유지
// set the scale
        wv.setInitialScale(35); // 35%
        wv.getSettings().setUseWideViewPort(true);

    }

  /*      //이전 엑티비티에서 넘어온 데이터를 받음
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
        setContentView(sv);*/
}


