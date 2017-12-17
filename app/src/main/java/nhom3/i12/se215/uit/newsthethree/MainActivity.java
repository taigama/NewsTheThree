package nhom3.i12.se215.uit.newsthethree;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
//import android.app.Fragment;
//import android.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {





    private static String TAG = MainActivity.class.getSimpleName();

    // region HAMBURGER
    RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    View mPnMenu;
    EditText mTxtSearch;
    View mBtnSearch;
    View mBtnBookmark;
    View mBtnAbout;


    // endregion

    // region TAB
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    ViewPagerAdapter viewPagerAdapter;




    HomeFragment mFragmentHome;
    HomeFragment[] mFragmentSub;
    // endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // region TAB
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mFragmentHome = new HomeFragment();
        viewPagerAdapter.addFragment(mFragmentHome, "Home");
//        viewPagerAdapter.addFragment(new HomeFragment(), "Home");

        mFragmentSub = new HomeFragment[3];
        for(int i = 0; i < mFragmentSub.length; i++)
            mFragmentSub[i] = new HomeFragment();

        viewPagerAdapter.addFragment(mFragmentSub[0], "Thời sự");
        viewPagerAdapter.addFragment(mFragmentSub[1], "Pháp luật");
        viewPagerAdapter.addFragment(mFragmentSub[2], "Nhịp sống trẻ");
        viewPagerAdapter.addFragment(new TheSecondFragment(), "Tin tức của tôi");
        //viewPagerAdapter.addFragment(new TheThirdFragment(), "t third");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        // endregion

        // region HAMBURGER

        // drawer layout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // populate Navigation Drawer with options
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.toolBar);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, myToolbar,R.string.drawer_open, R.string.drawer_close){
          @Override
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
          }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mPnMenu = (View)findViewById(R.id.panel_menu);
        mTxtSearch = (EditText)findViewById(R.id.txt_menu_search);
        mBtnSearch = (View) findViewById(R.id.btn_menu_search);
        mBtnBookmark = (View)findViewById(R.id.item_menu_bookmark);
        mBtnAbout = (View)findViewById(R.id.item_menu_about);

        mPnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBtnBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, BookmarkActivity.class);
                context.startActivity(intent);
            }
        });

        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, SearchActivity.class);
                context.startActivity(intent);
            }
        });

        mBtnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, AboutActivity.class);
                context.startActivity(intent);
            }
        });

        // endregion

        // region MENU

        // endregion


    }

    // region HAMBURGER




    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();

        fakeData();
    }

    // endregion

    private void fakeData()
    {
        // region HOME
        mFragmentHome.addData("Vào lúc 3 giờ sáng hôm nay (20/10), siêu bão Conga bắt đầu đổ bộ vào đất liền"
                , "Tin giờ chót"
                , "Siêu bão Conga mạnh cấp 20, gió giật cấp 20, vùng gần tâm bão giật cấp 25 đang tàn phá khắp mọi miền đất nước"
                , R.drawable.news_sieubao, ItemNewsList.TYPE.HEAD);

        mFragmentHome.addData("Một lần nữa Apple phải hướng dẫn cách sử dụng iPhone"
                , "Nhịp sống số"
                , "", R.drawable.news_apple, ItemNewsList.TYPE.TAIL);

        mFragmentHome.addData("BHXH VN đề nghị lộ trình điều chỉnh lương hưu cho lao động nữ"
                , "Thời sự"
                , "", R.drawable.news_bhxh, ItemNewsList.TYPE.TAIL);

        mFragmentHome.addData("Công bố 5 nhóm vấn đề nóng để ĐBQH chọn chất vấn"
                , "Thời sự"
                , "", R.drawable.news_quochoi, ItemNewsList.TYPE.TAIL);

        mFragmentHome.addData("\'Cán bộ đã chạy chức sẽ tính bài thu lại bằng cách tham nhũng\'"
                , "Thời sự"
                , "", R.drawable.news_thamnhung, ItemNewsList.TYPE.TAIL);





        mFragmentHome.NotifyDataSetChanged();
        // endregion


        mFragmentSub[0].addData("Bỏ sổ hộ khẩu, giao dịch hành chính chỉ cần 3 thông tin"
                , "Thời sự"
                , "", R.drawable.news_bohokhau, ItemNewsList.TYPE.TAIL);
        mFragmentSub[0].addData("\'Luật cho dân có khác luật cho cán bộ?\'"
                , "Thời sự"
                , "", R.drawable.news_luatdan_canbo, ItemNewsList.TYPE.TAIL);
        mFragmentSub[0].addData("BHXH VN đề nghị lộ trình điều chỉnh lương hưu cho lao động nữ"
                , "Thời sự"
                , "", R.drawable.news_bhxh, ItemNewsList.TYPE.TAIL);
        mFragmentSub[0].addData("Công bố 5 nhóm vấn đề nóng để ĐBQH chọn chất vấn"
                , "Thời sự"
                , "", R.drawable.news_quochoi, ItemNewsList.TYPE.TAIL);
        mFragmentSub[0].addData("\'Cán bộ đã chạy chức sẽ tính bài thu lại bằng cách tham nhũng\'"
                , "Thời sự"
                , "", R.drawable.news_thamnhung, ItemNewsList.TYPE.TAIL);


        mFragmentSub[1].addData("Hoãn phiên tòa vì xuất hiện ‘văn bản lạ’"
                , "Pháp luật"
                , "", R.drawable.news_hoan_phien_toa, ItemNewsList.TYPE.TAIL);
        mFragmentSub[1].addData("Cán bộ thú y không tiếp tay thương lái"
                , "Pháp luật"
                , "", R.drawable.news_canbo_thuy, ItemNewsList.TYPE.TAIL);
        mFragmentSub[1].addData("Mảnh đất phá tình người…"
                , "Pháp luật"
                , "", R.drawable.news_manhdat_tinhnguoi, ItemNewsList.TYPE.TAIL);
        mFragmentSub[1].addData("Đèn đỏ rẽ phải không được, đâm người trọng thương"
                , "Pháp luật"
                , "", R.drawable.news_dendo_rephai, ItemNewsList.TYPE.TAIL);



        mFragmentSub[2].addData("Chuyến phượt xe máy của Trần Đặng Đăng Khoa lên báo Hà Lan"
            , "Nhịp sống trẻ"
            , "", R.drawable.news_phuot, ItemNewsList.TYPE.TAIL);
        mFragmentSub[2].addData("Con sợ một ngày phải nghỉ học"
                , "Nhịp sống trẻ"
                , "", R.drawable.news_so_nghihoc, ItemNewsList.TYPE.TAIL);
        mFragmentSub[2].addData("\'Ngày Chủ nhật cho em\' mang nụ cười, tiếng hát đến với bệnh nhi"
                , "Nhịp sống trẻ"
                , "", R.drawable.news_chunhat_choem, ItemNewsList.TYPE.TAIL);
    }

    // region MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

//        Menu menuCategory = menu.getItem(0).getSubMenu();
//        MenuItem item;
//        SpannableString s;
//
//        String[] categories = getResources().getStringArray(R.array.categories);
//
//
//
//        Random rand = new Random();
//        int r, g, b;
//        int color;
//
//        for(int position = 0; position < 15; position++) {
//            item = menuCategory.getItem(position);
//
//            s = new SpannableString(categories[position]);
//            for(int i = 0; i < s.length(); i++) {
//
//
//                r = (int)((rand.nextFloat() / 2f + 0.5f) * 255);
//                g = (int)((rand.nextFloat() / 2f + 0.5f) * 255);
//                b = (int)((rand.nextFloat() / 2f + 0.5f) * 255);
//                color = Color.argb(255, r, g, b);
//
//                s.setSpan(new ForegroundColorSpan(color), i, i+1, 0);
//            }
//            s.setSpan(new RelativeSizeSpan(2f), 0, s.length(), 0);
//
//            item.setTitle(s);
//        }






        return true;
    }


    public boolean onPrepareOptionsMenu(Menu menu){
        //boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerPane);
        //menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Pass the event to ActionBarDrawerToggle
        // If it returns true, then it has handled
        // the nav drawer indicator touch event
        if(mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        // handler your other action bar items
        return super.onOptionsItemSelected(item);
    }
    // endregion
}
