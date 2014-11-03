/**
 * moj.tvz.hr Android aplikacija
 * 
 * @author Marko Idžan
 * @version 1.0 beta1
 * 
 */

/**
 * Name of package in Android settings
 */
package mojtvz.webview;

//Importing some libraries which are needed to app work
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class MojTVZWebview extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        final WebView pregled = (WebView)findViewById(R.id.webview);
        pregled.getSettings().setJavaScriptEnabled(true);
        
        pregled.setWebViewClient(new WebViewClient());
        
        
        /*String varanjeKoda = "<html lang=\"en\">"
        					+"<head>"
        					+"<link rel=\"stylesheet\" href=\"http://markoidzan.me/zamjena_css_webview/zamjenjeniStil.css\">"
        					+"</head>"
        					+"<body>"
        					+"</body>"
        					+"</html>";*/
        
        


          
        
        pregled.loadUrl("https://moj.tvz.hr/prikaz/mojvijes");
        
        
        //pregled.loadData(varanjeKoda, "text/html", null);
        
        /*{
        
        	
        	
        	@Override
        	public void onPageFinished(WebView view, String url)  {
        		pregled.loadUrl("javascript:document.getElementsByTagName(img)[0].style.visibility = hidden;");
        		
        		
        		
        	}
        	
        	String varanjeKoda = "<html lang='en'>"+"#shadowroot";
        	
        	   
        
        
        
        });*/
        
        
        
    }

    /**
     * If back button is pressed, app should go one link back
     */
    @Override
    public void onBackPressed() {
    	final WebView pregled = (WebView)findViewById(R.id.webview);
        if(pregled.canGoBack()) {
            pregled.goBack();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Menu icon, ready to add some options like About and Refresh
     */
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
        //int id = item.getItemId();
    	//case R.id.action_refresh:
        //Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
         //   .show();
        //break;
        //if (id == R.id.action_settings) {
         //   return true;
        //}
        //return super.onOptionsItemSelected(item);
    	
    	switch (item.getItemId()) {
        // action with ID action_refresh was selected
        case R.id.action_settings:
          Toast.makeText(this, "Moj TVZ verzija 1.01", Toast.LENGTH_LONG)
              .show();
          break;
        default:
          break;
        }

        return true;
    }
}
