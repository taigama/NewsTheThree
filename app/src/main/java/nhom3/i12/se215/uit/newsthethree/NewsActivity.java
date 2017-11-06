package nhom3.i12.se215.uit.newsthethree;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class NewsActivity extends AppCompatActivity {
    private static String TAG = NewsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    }
}
