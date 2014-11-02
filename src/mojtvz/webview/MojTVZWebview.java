/**
 * moj.tvz.hr Android aplikacija
 * 
 * @author Marko Idžan
 * @version 1.0 beta1
 * 
 */
package mojtvz.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MojTVZWebview extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        final WebView pregled = (WebView)findViewById(R.id.webview);
        pregled.loadUrl("https://moj.tvz.hr/prikaz/mojvijes");
        pregled.getSettings().setJavaScriptEnabled(true);
        pregled.setWebViewClient(new WebViewClient());
        pregled.loadUrl("javascript:document.getElementsByClassName('footer')[0].style.display = 'none';");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.moj_tvzwebview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
