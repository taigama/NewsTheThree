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
        // FakeDataSet();

        //mNewItems = new ArrayList<>();
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

    public void addData(String title, String category, String overview, int idImage, ItemNewsList.TYPE type) {
        if(mNewItems == null)
            mNewItems = new ArrayList<>();

        mNewItems.add(new ItemNewsList(title, category, overview, idImage, type));
    }

    public void NotifyDataSetChanged() {
        if(mAdapter != null)
            mAdapter.notifyDataSetChanged();
    }


}