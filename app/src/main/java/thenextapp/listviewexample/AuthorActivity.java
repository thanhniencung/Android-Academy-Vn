package thenextapp.listviewexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import thenextapp.listviewexample.helper.ImageHelper;

public class AuthorActivity extends AppCompatActivity {

    public static final String AUTHOR_AVATAR = "AUTHOR_AVATAR";
    public static final String AUTHOR_TITLE = "AUTHOR_TITLE";
    public static final String AUTHOR_WEBSITE = "AUTHOR_WEBSITE";

    private ImageView ivAuthor;
    private TextView tvAuthorTitle;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        ivAuthor = (ImageView) findViewById(R.id.author_avatar);
        tvAuthorTitle = (TextView) findViewById(R.id.author_title);
        webView = (WebView) findViewById(R.id.webview);

        Intent intent = getIntent();

        final String avatar = intent.getStringExtra(AUTHOR_AVATAR);
        String title = intent.getStringExtra(AUTHOR_TITLE);
        String website = intent.getStringExtra(AUTHOR_WEBSITE);

        new AsyncTask<Void, Void, Void>() {

            Bitmap bm;

            @Override
            protected Void doInBackground(Void... params) {
                bm = ImageHelper.getBitmapFromURL(avatar);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if (bm != null) {
                    ivAuthor.setImageBitmap(bm);
                } else {
                    ivAuthor.setImageResource(R.drawable.avatar_default);
                }
            }

        }.execute();

        tvAuthorTitle.setText(title);
        webView.loadUrl(website);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
