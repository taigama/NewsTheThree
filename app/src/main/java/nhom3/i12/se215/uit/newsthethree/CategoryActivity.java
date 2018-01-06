package nhom3.i12.se215.uit.newsthethree;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    ArrayList<ItemNewsList> mItems = new ArrayList<>();
    NewsListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setTitle("Nhịp sống trẻ");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        fakeData(mItems);

        mAdapter = new NewsListAdapter(this, mItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);





    }

    private void fakeData(ArrayList<ItemNewsList> items) {
        items.add( new ItemNewsList(
                "Chuyến phượt xe máy của Trần Đặng Đăng Khoa lên báo Hà Lan"
                , "nhịp sống trẻ"
                , "Khi tới thành phố Oene, chàng trai nhận được sự chú ý của một tờ báo nước này nhờ khuôn mặt châu Á, chiếc xe máy lỉnh kỉnh đồ đạc và câu chuyện phi thường"
                , R.drawable.news_phuot, ItemNewsList.TYPE.HEAD));

        items.add( new ItemNewsList(
                "\'Ngày Chủ nhật cho em\' mang nụ cười, tiếng hát đến với bệnh nhi"
                , "nhịp sống trẻ", ""
                , R.drawable.news_chunhat_choem, ItemNewsList.TYPE.TAIL));

        items.add( new ItemNewsList(
                "Chung tay cho những chuyến xe ân tình mùa Tết"
                , "nhịp sống trẻ", ""
                , R.drawable.chuyen_xe, ItemNewsList.TYPE.TAIL));
        items.add( new ItemNewsList(
                "Vợ chồng chàng trai mù với chuyện tình như cổ tích đi du học"
                , "nhịp sống trẻ", ""
                , R.drawable.chang_trai_mu, ItemNewsList.TYPE.TAIL));
        items.add( new ItemNewsList(
                "Học sinh Mỹ được dạy phân biệt tin thật - giả"
                , "nhịp sống trẻ", ""
                , R.drawable.tin_gia, ItemNewsList.TYPE.TAIL));
        items.add( new ItemNewsList(
                "Vẽ khủng long như thật trên màng nhựa trong suốt"
                , "nhịp sống trẻ", ""
                , R.drawable.ve_khung_long, ItemNewsList.TYPE.TAIL));
        items.add( new ItemNewsList(
                "Người trẻ gửi ảnh nhạy cảm: không phải chuyện tồi tệ?"
                , "nhịp sống trẻ", ""
                , R.drawable.anh_khoa_than, ItemNewsList.TYPE.TAIL));
    }
}
