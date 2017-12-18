package nhom3.i12.se215.uit.newsthethree;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class CategoryClicker implements View.OnClickListener {
    private Context mContext;
    public CategoryClicker(Context context){
        mContext = context;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mContext, CategoryActivity.class);
        mContext.startActivity(intent);
    }
}