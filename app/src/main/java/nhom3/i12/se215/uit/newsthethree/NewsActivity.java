package nhom3.i12.se215.uit.newsthethree;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;

public class NewsActivity extends AppCompatActivity {
    private static String TAG = NewsActivity.class.getSimpleName();


    Toolbar mToolbar;
    ScrollView mScrollView;

    View mContentEntire;

    EditText mTxtAuthor;
    EditText mTxtComment;
    View mBtnComment;
    AlertDialog mDialogCommented;

    boolean isBookmarked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mToolbar = (Toolbar)findViewById(R.id.toolbar_news);
        setSupportActionBar(mToolbar);
        setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mScrollView = (ScrollView)findViewById(R.id.scroll_news);
        mContentEntire = (View)findViewById(R.id.news_entire_content);


        mTxtAuthor = (EditText) findViewById(R.id.txt_comment_author);
        mTxtComment = (EditText) findViewById(R.id.txt_comment);

        mBtnComment = (View)findViewById(R.id.btn_comment);

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Cám ơn bạn đã đóng góp ý kiến, thông điệp của bạn sẽ được hiển thị trong chốc lát."
                + "\n\n\np/s: nó không bao giờ hiển thị ra đâu");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        mTxtAuthor.setText("");
                        mTxtAuthor.clearFocus();

                        mTxtComment.setText("");
                        mTxtComment.setHintTextColor(Color.GRAY);
                        mTxtComment.clearFocus();

                        dialog.cancel();
                    }
                });
        mDialogCommented = builder1.create();


        mBtnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mTxtComment.getText().toString().trim().length() > 0 )
                    mDialogCommented.show();
                else {
                    mTxtComment.setHintTextColor(Color.parseColor("#AAFF0000"));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu){
        getMenuInflater().inflate(R.menu.menu_news, menu);

        // comment clicked
        menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                mScrollView.smoothScrollTo(0,mContentEntire.getHeight());
                return true;
            }
        });

        // bookmark clicked
        menu.getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(isBookmarked)
                {
                    menuItem.setIcon(R.drawable.ic_star_white);
                    isBookmarked = false;
                }
                else {
                    menuItem.setIcon(R.drawable.ic_star_full);
                    isBookmarked = true;
                }
                return true;
            }
        });
        return true;
    }

}
