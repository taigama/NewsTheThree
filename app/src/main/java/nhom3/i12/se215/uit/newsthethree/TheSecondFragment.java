package nhom3.i12.se215.uit.newsthethree;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TheSecondFragment extends Fragment {


    public class CategoryClicker implements View.OnClickListener {
        private Context mContext;
        public CategoryClicker(Context context){
            mContext = context;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, NewsActivity.class);
            mContext.startActivity(intent);
        }
    }

    public class NewsClicker implements View.OnClickListener {
        private Context mContext;
        public NewsClicker(Context context){
            mContext = context;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, NewsActivity.class);
            mContext.startActivity(intent);
        }
    }

    public TheSecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_the_second, container, false);

        View txt1 = v.findViewById(R.id.txt1);
        View txt2 = v.findViewById(R.id.txt2);
        View txt3 = v.findViewById(R.id.txt3);
        View txt4 = v.findViewById(R.id.txt4);

        CategoryClicker myClick = new CategoryClicker(getContext());

        txt1.setOnClickListener(myClick);
        txt2.setOnClickListener(myClick);
        txt3.setOnClickListener(myClick);
        txt4.setOnClickListener(myClick);




        View box1 = v.findViewById(R.id.relati1);
        View box2 = v.findViewById(R.id.relati2);
        View box3 = v.findViewById(R.id.relati3);
        View box4 = v.findViewById(R.id.relati4);
        View box5 = v.findViewById(R.id.relati5);
        View box6 = v.findViewById(R.id.relati6);
        View box7 = v.findViewById(R.id.relati7);
        View box8 = v.findViewById(R.id.relati8);
        View box9 = v.findViewById(R.id.relati9);
        View box10 = v.findViewById(R.id.relati10);
        View box11 = v.findViewById(R.id.relati11);
        View box12 = v.findViewById(R.id.relati12);
        View box13 = v.findViewById(R.id.relati13);

        NewsClicker my2Click = new NewsClicker(getContext());

        box1.setOnClickListener(my2Click);
        box2.setOnClickListener(my2Click);
        box3.setOnClickListener(my2Click);
        box4.setOnClickListener(my2Click);
        box5.setOnClickListener(my2Click);
        box6.setOnClickListener(my2Click);
        box7.setOnClickListener(my2Click);
        box8.setOnClickListener(my2Click);
        box9.setOnClickListener(my2Click);
        box10.setOnClickListener(my2Click);
        box11.setOnClickListener(my2Click);
        box12.setOnClickListener(my2Click);
        box13.setOnClickListener(my2Click);

        return v;
    }

}
