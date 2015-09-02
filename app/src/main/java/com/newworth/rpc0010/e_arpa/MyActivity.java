package com.newworth.rpc0010.e_arpa;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class MyActivity extends ActionBarActivity {


    private WebView myWebView;

    //public ActionBar.LayoutParams (int gravity);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayShowTitleEnabled(false);

        actionBar.setDisplayUseLogoEnabled(false);
        //actionBar.setLogo(R.drawable.ic_icon);
        actionBar.setDisplayShowHomeEnabled(true);
        //actionBar.hide();
        actionBar.setDisplayHomeAsUpEnabled(false);

        myWebView = (WebView) findViewById(R.id.activity_my_webview);
        //myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new MyWebViewClient());

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://www.e-arpa.jp/sp/");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_my, menu);
//        return true;

        //Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_my, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_settings) {
////            return true;
////        }
//
//        return super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.action_home:
                goHome();
                return true;
            case R.id.action_back:
                goBack();
                return true;
            case R.id.action_next:
                goForward();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goHome(){
        myWebView.loadUrl("http://www.e-arpa.jp/sp/");
        //return true;
    }

    public void goBack(){
        if(myWebView.canGoBack()){
            myWebView.goBack();
            //return true;
        }
    }

    public void goForward(){
        if(myWebView.canGoForward()){
            myWebView.goForward();
            //return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

}
