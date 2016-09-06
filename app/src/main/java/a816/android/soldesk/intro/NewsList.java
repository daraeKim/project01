package a816.android.soldesk.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newslist);

        txtDate = (TextView) findViewById(R.id.txtDate);

        //txtDate.setText(currentDateTimeString);



        txtDate.setText(Calendar.getInstance().get(Calendar.YEAR) +

                "년" + (Calendar.getInstance().get(Calendar.MONTH) + 1) +

                "월" + Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"일");


        final String[] data = {"Today's News", "Politics News", "Economy News", "Inter-Korea News", "International News"};

        listView = (ListView) findViewById(R.id.listView01);

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, data);

        listView.setAdapter(adapter);

        //이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if(data[position] == "Today's News"){
                    Intent intent = new Intent(getApplicationContext(), main.class);
                    startActivity(intent);
                }
                else if(data[position]=="Politics News"){

                }
                else if(data[position]=="Economy News"){

                }
                else if(data[position]=="Inter-Korea News"){

                }
            }
        });
    }
}

