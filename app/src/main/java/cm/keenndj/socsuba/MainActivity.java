package cm.keenndj.socsuba;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.setWebViewClient(new Callback());
        String host = getIntent().getStringExtra("host");
        String port = getIntent().getStringExtra("port");
        if ((host != null) && (port != null)) {
            String url = "http://" + host + ":" + port + "/web#cids=1&menu_id=252&action=410&model=pos.config&view_type=kanban";
            web.loadUrl(url);
        } else {
            web.loadUrl("http://192.168.1.20:8069/web#cids=1&menu_id=252&action=410&model=pos.config&view_type=kanban");
        }
    }

    private class Callback extends WebViewClient {

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
            int statusCode = errorResponse.getStatusCode();
            // TODO: dou your logic..
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Status code : " + statusCode);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        }


        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}