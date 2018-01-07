package nhom3.i12.se215.uit.newsthethree;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;


public class AboutActivity extends AppCompatActivity {
    private static String TAG = AboutActivity.class.getSimpleName();

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);

        mToolbar = (Toolbar)findViewById(R.id.toolbar_about);
        setSupportActionBar(mToolbar);
        setTitle("Về chúng tôi");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        TextView t = (TextView) findViewById(R.id.txt_forgotten);
        t.setPaintFlags(t.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
