package nhom3.i12.se215.uit.newsthethree;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_video, container, false);

        View frameBig1 = v.findViewById(R.id.frame_big);
        View frameBig2 = v.findViewById(R.id.frame_big2);
        View frameBig3 = v.findViewById(R.id.frame_big3);
        View frameBig4 = v.findViewById(R.id.frame_big4);
        View frameBig5 = v.findViewById(R.id.item_left5);

        VideoClicker videoClicker = new VideoClicker(getContext());

        frameBig1.setOnClickListener(videoClicker);
        frameBig2.setOnClickListener(videoClicker);
        frameBig3.setOnClickListener(videoClicker);
        frameBig4.setOnClickListener(videoClicker);
        frameBig5.setOnClickListener(videoClicker);



        return v;
    }

}
