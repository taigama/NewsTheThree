package nhom3.i12.se215.uit.newsthethree;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private static String TAG = "Home Fragment";

    public HomeFragment() {
        // Required empty public constructor
    }

    ArrayList<ItemNewsList> mNewItems;
    RecyclerView mRecyclerView;
    NewsListAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        FakeDataSet();
    }

    private void FakeDataSet() {
        mNewItems = new ArrayList<>();

        mNewItems.add(new ItemNewsList("Vào lúc 3 giờ sáng hôm nay (20/10), siêu bão Conga bắt đầu đổ bộ vào đất liền"
                , "Tin giờ chót"
                , "Siêu bão Conga mạnh cấp 20, gió giật cấp 20, vùng gần tâm bão giật cấp 20*10 đang tàn phá khắp mọi miền quê"
                , R.drawable.ava2, ItemNewsList.TYPE.HEAD));

        int i = 1;
        mNewItems.add(new ItemNewsList("Tin thứ " + (++i), "Tin mới khác"
                , "", R.drawable.ava, ItemNewsList.TYPE.TAIL));
        mNewItems.add(new ItemNewsList("Tin thứ " + (++i), "Tin mới khác"
                , "", R.drawable.ava, ItemNewsList.TYPE.TAIL));
        mNewItems.add(new ItemNewsList("Tin thứ " + (++i), "Tin mới khác"
                , "", R.drawable.ava, ItemNewsList.TYPE.TAIL));
        mNewItems.add(new ItemNewsList("Tin thứ " + (++i), "Tin mới khác"
                , "", R.drawable.ava, ItemNewsList.TYPE.TAIL));
        mNewItems.add(new ItemNewsList("Tin thứ " + (++i), "Tin mới khác"
                , "", R.drawable.ava, ItemNewsList.TYPE.TAIL));
        mNewItems.add(new ItemNewsList("Tin thứ " + (++i), "Tin mới khác"
                , "", R.drawable.ava, ItemNewsList.TYPE.TAIL));
        mNewItems.add(new ItemNewsList("Tin thứ " + (++i), "Tin mới khác"
                , "", R.drawable.ava, ItemNewsList.TYPE.TAIL));
        mNewItems.add(new ItemNewsList("Tin thứ " + (++i), "Tin mới khác"
                , "", R.drawable.ava, ItemNewsList.TYPE.TAIL));
        mNewItems.add(new ItemNewsList("Tin thứ " + (++i), "Tin mới khác"
                , "", R.drawable.ava, ItemNewsList.TYPE.TAIL));
        mNewItems.add(new ItemNewsList("Tin thứ " + (++i), "Tin mới khác"
                , "", R.drawable.ava, ItemNewsList.TYPE.TAIL));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        rootView.setTag(TAG);



        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.home_recycler_view);

        mLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);


        mAdapter = new NewsListAdapter(getContext(), mNewItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mAdapter);








        return rootView;
    }

}