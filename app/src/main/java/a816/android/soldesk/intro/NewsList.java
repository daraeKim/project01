package a816.android.soldesk.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by soldesk on 2016-09-05.
 */
public class NewsList extends AppCompatActivity {

    ListView listView;
    TextView txtDate;
    Button btnend;
    String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newslist);

        // 종료버튼에 이벤트
        btnend = (Button) findViewById(R.id.btnend);
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        // 날짜 출력하기
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtDate.setTextSize(20);
        txtDate.setText(Calendar.getInstance().get(Calendar.YEAR) +
                "년  " + (Calendar.getInstance().get(Calendar.MONTH) + 1) +
                "월  " + Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "일");

        // 뉴스카테고리 리스트뷰에 붙이기
        final String[] data = {"Today's News", "Politics News", "Economy News",
                "Inter-Korea News", "International News"};
        listView = (ListView) findViewById(R.id.listView01);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        // 카테고리 클릭시 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Bundle 객체에 저장
                Bundle bundle = new Bundle();

                if (data[position] == "Today's News") {

                    Intent intent = new Intent(getApplicationContext(), main.class);
                    startActivity(intent);

                } else if (data[position] == "Politics News") {

                } else if (data[position] == "Economy News") {

                } else if (data[position] == "Inter-Korea News") {

                }


            }
        });
    }
}

