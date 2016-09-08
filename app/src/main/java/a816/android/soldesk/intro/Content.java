package a816.android.soldesk.intro;

import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Created by soldesk on 2016-09-01.
 */
public class Content extends AppCompatActivity implements View.OnLongClickListener, ClipboardManager.OnPrimaryClipChangedListener {

    private WebView wv;
    Button btnSearch;

    private ClipboardManager introClipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        btnSearch = (Button) findViewById(R.id.btnSearch);

        String url = getIntent().getStringExtra("content");
        wv = (WebView) findViewById(R.id.webView01);

        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(url);

        WebSettings ws = wv.getSettings();
        ws.setDefaultFontSize(8);
        wv.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR); // 화면을 유지 set the scale
        wv.setInitialScale(35); // 35%
        wv.getSettings().setUseWideViewPort(true);

        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setSupportZoom(true);


        wv.getSettings().setJavaScriptEnabled(true);
        wv.setLongClickable(true);
        wv.setWebViewClient(new WebViewClient());// 롱 클릭 리스너

        introClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Popupboard.class);
                intent.putExtra("word", introClipboard.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onLongClick(View view) {
      //  Log.d("Debug", "On Long Press Web View");
        return false;
    }

    @Override
    public void onPrimaryClipChanged() {

    }
}



