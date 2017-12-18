package nhom3.i12.se215.uit.newsthethree;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class CommentActivity extends AppCompatActivity {


    public EditText mTxtAuthor;
    public EditText mTxtComment;

    public View mBtnComment;
    public AlertDialog mDialogCommented;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Toolbar mToolbar = (Toolbar)findViewById(R.id.toolbar);
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





        mTxtAuthor = (EditText) findViewById(R.id.txt_comment_author);
        mTxtComment = (EditText) findViewById(R.id.txt_comment);

        mBtnComment = findViewById(R.id.btn_comment);

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
}
