package nhom3.i12.se215.uit.newsthethree;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class BookmarkActivity extends AppCompatActivity {

    Toolbar mToolbar;

    ViewPager mViewPager;

    ViewPagerAdapter mAdapterViewPager;
    HomeFragment mFragmentHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        mToolbar = (Toolbar)findViewById(R.id.toolbar_bookmark);
        setSupportActionBar(mToolbar);
        setTitle("Tin đã lưu");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mViewPager = (ViewPager)findViewById(R.id.pager_bookmark);

        mAdapterViewPager = new ViewPagerAdapter(getSupportFragmentManager());

        mFragmentHome = new HomeFragment();
        mAdapterViewPager.addFragment(mFragmentHome, "");

        mViewPager.setAdapter(mAdapterViewPager);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        fakeData();
    }

    private void fakeData()
    {
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
        mFragmentHome.addData(
                "Học sinh Mỹ được dạy phân biệt tin thật - giả"
                , "nhịp sống trẻ", ""
                , R.drawable.tin_gia, ItemNewsList.TYPE.TAIL);
        mFragmentHome.addData("Đèn đỏ rẽ phải không được, đâm người trọng thương"
            , "Pháp luật"
            , "", R.drawable.news_dendo_rephai, ItemNewsList.TYPE.TAIL);

        mFragmentHome.shuffle();
        mFragmentHome.NotifyDataSetChanged();
    }
}
