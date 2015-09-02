package com.newworth.rpc0010.e_arpa;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by RPC0010 on 6/3/2015.
 */
public class MyWebViewClient extends WebViewClient{
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        //tel:
        if (url.indexOf("tel:") > -1) {
            view.getContext().startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(url)));
            return true;
        }
        //internal links
        if(Uri.parse(url).getHost().endsWith("www.e-arpa.jp")) {
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}
