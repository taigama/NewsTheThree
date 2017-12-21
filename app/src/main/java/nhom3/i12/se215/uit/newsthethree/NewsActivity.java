package nhom3.i12.se215.uit.newsthethree;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

public class NewsActivity extends AppCompatActivity {
    private static String TAG = NewsActivity.class.getSimpleName();


    Context mContext;

    Toolbar mToolbar;
    //ScrollView mScrollView;

    //View mContentEntire;

    //EditText mTxtAuthor;
    //EditText mTxtComment;
    //View mBtnComment;
    //AlertDialog mDialogCommented;

    boolean isLiked = false;
    boolean isBookmarked = false;


    //ImageView btnLike1;
    //ImageView btnLike2;
    //ImageView btnDislike1;
    //ImageView btnDislike2;
    //boolean mIsLike1 = false;
    //boolean mIsLike2 = true;
    //boolean mIsDislike1 = false;
    //boolean mIsDislike2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mContext = this;

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

        //mScrollView = (ScrollView)findViewById(R.id.scroll_news);
        //mContentEntire = (View)findViewById(R.id.news_entire_content);


        //mTxtAuthor = (EditText) findViewById(R.id.txt_comment_author);
        //mTxtComment = (EditText) findViewById(R.id.txt_comment);

        //mBtnComment = findViewById(R.id.btn_comment);

//        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//        builder1.setMessage("Cám ơn bạn đã đóng góp ý kiến, thông điệp của bạn sẽ được hiển thị trong chốc lát."
//                + "\n\n\np/s: nó không bao giờ hiển thị ra đâu");
//        builder1.setCancelable(true);
//
//        builder1.setPositiveButton(
//                "OK",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//
//                        mTxtAuthor.setText("");
//                        mTxtAuthor.clearFocus();
//
//                        mTxtComment.setText("");
//                        mTxtComment.setHintTextColor(Color.GRAY);
//                        mTxtComment.clearFocus();
//
//                        dialog.cancel();
//                    }
//                });
//        mDialogCommented = builder1.create();
//
//
//        mBtnComment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(mTxtComment.getText().toString().trim().length() > 0 )
//                    mDialogCommented.show();
//                else {
//                    mTxtComment.setHintTextColor(Color.parseColor("#AAFF0000"));
//                }
//            }
//        });


//        View.OnClickListener reactsListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                ImageView imgTarget = (ImageView)view;
//                int super_id = imgTarget.getId();
//
//
//                switch (super_id)
//                {
//                    case R.id.img_comment_like:
//                    {
//                        if(mIsLike1)
//                        {
//                            mIsLike1 = false;
//                            imgTarget.setImageResource(R.drawable.ic_like_empty);
//                        }
//                        else
//                        {
//                            mIsLike1 = true;
//                            imgTarget.setImageResource(R.drawable.ic_like);
//                        }
//                    }
//                    break;
//                    case R.id.img_comment_like2:
//                    {
//                        if(mIsLike2)
//                        {
//                            mIsLike2 = false;
//                            imgTarget.setImageResource(R.drawable.ic_like_empty);
//                        }
//                        else
//                        {
//                            mIsLike2 = true;
//                            imgTarget.setImageResource(R.drawable.ic_like);
//                        }
//                    }
//                    break;
//                    case R.id.img_comment_dislike:
//                    {
//                        if(mIsDislike1)
//                        {
//                            mIsDislike1 = false;
//                            imgTarget.setImageResource(R.drawable.ic_dislike_empty);
//                        }
//                        else
//                        {
//                            mIsDislike1 = true;
//                            imgTarget.setImageResource(R.drawable.ic_dislike);
//                        }
//                    }
//                    break;
//                    case R.id.img_comment_dislike2:
//                    {
//                        if(mIsDislike2)
//                        {
//                            mIsDislike2 = false;
//                            imgTarget.setImageResource(R.drawable.ic_dislike_empty);
//                        }
//                        else
//                        {
//                            mIsDislike2 = true;
//                            imgTarget.setImageResource(R.drawable.ic_dislike);
//                        }
//                    }
//                    break;
//                }
//            }
//        };
//
//        btnLike1 = (ImageView)findViewById(R.id.img_comment_like);
//        btnLike1.setOnClickListener(reactsListener);

//        btnLike2 = (ImageView)findViewById(R.id.img_comment_like2);
//        btnLike2.setOnClickListener(reactsListener);
//        btnDislike1 = (ImageView) findViewById(R.id.img_comment_dislike);
//        btnDislike1.setOnClickListener(reactsListener);
//
//        btnDislike2 = (ImageView)findViewById(R.id.img_comment_dislike2);
//        btnDislike2.setOnClickListener(reactsListener);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu){
        getMenuInflater().inflate(R.menu.menu_news, menu);

        // comment clicked
        menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //mScrollView.smoothScrollTo(0,mContentEntire.getHeight());

                Intent intent = new Intent(mContext, CommentActivity.class);
                mContext.startActivity(intent);

                return true;
            }
        });

        // heart clicked
        menu.getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(isLiked)
                {
                    menuItem.setIcon(R.drawable.ic_like_empty_white);
                    isLiked = false;
                }
                else {
                    menuItem.setIcon(R.drawable.ic_like_white);
                    isLiked = true;
                }
                return true;
            }
        });

        // bookmark clicked
        menu.getItem(2).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(isBookmarked)
                {
                    menuItem.setIcon(R.drawable.ic_bookmark_empty);
                    isBookmarked = false;
                }
                else {
                    menuItem.setIcon(R.drawable.bookmark_fill);
                    isBookmarked = true;
                }
                return true;
            }
        });
        return true;
    }

}
