package nhom3.i12.se215.uit.newsthethree;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/**
 * Created by Khang on 12/18/2017.
 */

public class VideoClicker implements View.OnClickListener
{
    Context mContext;
    public VideoClicker(Context context){
        mContext = context;
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, VideoActivity.class);
        mContext.startActivity(intent);
    }
}
