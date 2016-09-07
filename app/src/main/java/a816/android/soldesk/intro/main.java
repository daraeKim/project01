package a816.android.soldesk.intro;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

public class main extends ListActivity implements AdapterView.OnItemClickListener {

    //뉴스의 title 부분을 저장하기 위한 객체 선언
    Vector<String> titlevec = new Vector<String>();

    //뉴스의 pubdate 가져오기
    // Vector<String> pubvec = new Vector<String>();

    //뉴스의 descrition을 저장하기 위한 객체 선언
    Vector<String> descvec = new Vector<String>();

    Vector<String> linkvec = new Vector<String>();

    // 뉴스의 데이터들을 뽑아 오는 클래스 선언
    NewsContent newscontent = new NewsContent();

    ListView listView02;
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webview = (WebView) findViewById(R.id.webView01);

        //doInBackground 메소드를 호출
        newscontent.execute(null, null, null);

        while (true) {
            try {
                Thread.sleep(1000); // 1.0초마다 실행
                if (newscontent.flag == true) {
                    titlevec = newscontent.titlevec;
                    linkvec = newscontent.linkvec;
                    //pubvec = newscontent.pubvec;
                    descvec = newscontent.descvec;
                    break;
                }
            } catch (Exception e) {
            }
        }

        //어뎁터 클래스 생성후 타이틀 벡터를 붙임
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.textitem, titlevec);

        setListAdapter(adapter); // 생성된 어댑터를 리스트뷰에 붙임

        ListView lv = getListView();//리스트뷰 객체를 생성

        lv.setOnItemClickListener(this); //이벤트 부착
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // <?> 제너릭 자료형을 쓰고 싶으나 실제형 인자가 무엇인지를 모르거나 신경쓰고 싶지 않을때 사용

        // 클릭한 데이터를 읽어들임
        String content = linkvec.get(position).toString();
        // 새로운화면을 띄우기 위한 클래스 작성
        Intent intent = new Intent().setClass(this, Content.class);
        // 새로운 화면에 데이터를 전달
        intent.putExtra("content", content);
        // 새로운 화면으로 전환
        startActivity(intent);
    }
}
