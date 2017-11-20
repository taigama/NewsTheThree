package nhom3.i12.se215.uit.newsthethree;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {


    Toolbar mToolbar;
    View mBtnSearch;
    TextView mTxtSearch;

    ViewPager mViewPager;

    ViewPagerAdapter mAdapterViewPager;
    HomeFragment mFragmentHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mToolbar = (Toolbar)findViewById(R.id.toolbar_search);
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

        mBtnSearch = (View)findViewById(R.id.btn_cancel);
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTxtSearch.setText("");
            }
        });


        mViewPager = (ViewPager)findViewById(R.id.pager_search);

        mAdapterViewPager = new ViewPagerAdapter(getSupportFragmentManager());

        mFragmentHome = new HomeFragment();
        mAdapterViewPager.addFragment(mFragmentHome, "");

        mViewPager.setAdapter(mAdapterViewPager);

        mTxtSearch = (EditText)findViewById(R.id.txt_search);
        mTxtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    fakeData();
                    return true;
                }
                return false;
            }
        });


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mFragmentHome.addData(""
                , ""
                , "", 0, ItemNewsList.TYPE.TAIL);
        mFragmentHome.NotifyDataSetChanged();
    }



    private void fakeData()
    {
        mFragmentHome.ClearData();

        mFragmentHome.addData("\'Cán bộ đã chạy chức sẽ tính bài thu lại bằng cách tham nhũng\'"
                , "Thời sự"
                , "", R.drawable.news_thamnhung, ItemNewsList.TYPE.TAIL);
        mFragmentHome.addData("Công bố 5 nhóm vấn đề nóng để ĐBQH chọn chất vấn"
                , "Thời sự"
                , "", R.drawable.news_quochoi, ItemNewsList.TYPE.TAIL);
        mFragmentHome.addData("Chuyến phượt xe máy của Trần Đặng Đăng Khoa lên báo Hà Lan"
                , "Nhịp sống trẻ"
                , "", R.drawable.news_phuot, ItemNewsList.TYPE.TAIL);
        mFragmentHome.addData("BHXH VN đề nghị lộ trình điều chỉnh lương hưu cho lao động nữ"
                , "Thời sự"
                , "", R.drawable.news_bhxh, ItemNewsList.TYPE.TAIL);
        mFragmentHome.addData("\'Luật cho dân có khác luật cho cán bộ?\'"
                , "Thời sự"
                , "", R.drawable.news_luatdan_canbo, ItemNewsList.TYPE.TAIL);

        mFragmentHome.NotifyDataSetChanged();
    }



}
