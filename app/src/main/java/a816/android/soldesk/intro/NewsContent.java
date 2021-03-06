package a816.android.soldesk.intro;

import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.Vector;

/**
 * Created by soldesk on 2016-09-01.
 */
public class NewsContent extends AsyncTask<Void, Void, Void> {

    Vector<String> titlevec = new Vector<String>();
    Vector<String> pubvec = new Vector<String>();
    Vector<String> linkvec = new Vector<String>();

    URL url;//웹사이트에 연결하기 위해서 url클래스를 적용
    String uri;
    String tagname = "", title = "", pubdate = "", link = ""; // xml에서 읽어들여 저장할 변수

    boolean flag = false;// 제대로 데이터가 읽어졌는지를 판단해주는 변수

    public NewsContent(String uri) {
        this.uri = uri;
    }

    //실제 사이트에 접속해서 데이터를 추출하는 부분
    @Override
    protected Void doInBackground(Void... params) {
        try {
            //안드로이드에서 xml문서를 읽고 파싱하는 객체를 선언
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            //네임스페이스 사용여부
            factory.setNamespaceAware(true);
            //실제 sax형태로 데이터를 파싱하는 객체 선언
            XmlPullParser xpp = factory.newPullParser();
            //웹사이트에 접속
            url = new URL(uri);
            //웹사이트를 통해서 읽어드린 xml문서를 안드로이드에 저장
            InputStream in = url.openStream();

            //xml문서를 읽고 파싱하는 객체에 넘겨줌
            xpp.setInput(in, "UTF-8"); // xml 문서의 인코딩 정확히 지정

            //item 태그 내부라면
            boolean isInItemTag = false;

            //이벤트 타입을 얻어옴
            int eventType = xpp.getEventType();

                    //문서의 끝까지 읽어 들이면서 title과 description을 추출해냄
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        if (eventType == XmlPullParser.START_TAG) {
                            //태그명을 읽어들임
                            tagname = xpp.getName();

                    if (tagname.equals("item")) {
                        isInItemTag = true;
                    }
                } else if (eventType == XmlPullParser.TEXT) {
                    if (tagname.equals("title") && isInItemTag) {//태그명이 title이거나 또는 link 읽어옴
                        title += xpp.getText();// text에 해댕하는 모든 텍스트를 읽어들임
                    } else if (tagname.equals("pubDate") && isInItemTag) {
                        pubdate += xpp.getText();
                    } else if (tagname.equals("link") && isInItemTag) {
                        link += xpp.getText();
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    //태그명을 읽어들임
                    tagname = xpp.getName();

                    //endtag일 경우에만 벡터에 저장
                    if (tagname.equals("item")) {
                        //벡터에 저장
                        titlevec.add(title);
                        linkvec.add(link);
                        pubvec.add(pubdate);

                        //변수 초기화
                        title = "";
                        pubdate = "";
                        link = "";

                        isInItemTag = false;
                    }
                }
                //다음 이벤트 타입을 저장
                eventType = xpp.next();
            }
            // 모든 데이터가 저장되었다면.true : 지정된 xml파일을 읽고 필요한 데이터를 추출해서 저장 완료된 상태
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
