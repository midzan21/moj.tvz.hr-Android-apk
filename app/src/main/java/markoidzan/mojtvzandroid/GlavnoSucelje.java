package markoidzan.mojtvzandroid;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import static markoidzan.mojtvzandroid.R.id.activity_prikaz_weba;


public class GlavnoSucelje extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prikaz_weba);

        final WebView webStranica;

        webStranica = (WebView) findViewById(activity_prikaz_weba);

        WebSettings javascriptUkljucen = webStranica.getSettings();

        javascriptUkljucen.setJavaScriptEnabled(true);

        webStranica.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                webStranica.loadUrl("javascript:(function(){" +
                                    "document.getElementsByClassName('navigacija')[0].style.display='none';" +
                                    "})()");
                webStranica.loadUrl("javascript:(function(){" +
                        "document.getElementsByClassName('potpis')[0].style.display='none';" +
                        "})()");
                webStranica.loadUrl("javascript:(function(){" +
                        "document.getElementsByClassName('footer')[0].style.display='none';" +
                        "})()");
                webStranica.loadUrl("javascript:(function(){" +
                        "document.getElementsByTagName('img')[0].style.display='none';" +
                        "})()");
                webStranica.loadUrl("javascript:(function(){" +
                        "document.getElementsByTagName('body')[0].background='#fff';" +
                        "})()");

            }
        });

        webStranica.loadUrl("https://moj.tvz.hr/prikaz/mojvijes");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prikaz_weba, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


