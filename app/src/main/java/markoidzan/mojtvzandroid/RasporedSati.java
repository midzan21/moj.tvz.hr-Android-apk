package markoidzan.mojtvzandroid;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Marko on 24.1.2015..
 */
public class RasporedSati extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rasporedsati, container, false);

        final WebView webStranica;

        webStranica = (WebView) rootView.findViewById(R.id.stranica);

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
                        "document.getElementsByTagName('a')[0].style.font-size='1.1em';" +
                        "})()");
                webStranica.loadUrl("javascript:(function(){" +
                        "document.getElementsByTagName('body')[0].background='#fff';" +
                        "})()");

            }


        });

        webStranica.loadUrl("https://moj.tvz.hr/prikaz/raspored");

        webStranica.setOnKeyListener( new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) v;

                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if(webView.canGoBack()) {
                                webView.goBack();
                                return true;
                            }
                    }
                }
                return false;
            }
        });


        return rootView;

    }

}
