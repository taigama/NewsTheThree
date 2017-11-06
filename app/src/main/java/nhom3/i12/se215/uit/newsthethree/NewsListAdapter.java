package nhom3.i12.se215.uit.newsthethree;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;



public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.DataViewHolder> {

    Context mContext;
    ArrayList<ItemNewsList> mNewsItems;

    public NewsListAdapter(Context context, ArrayList<ItemNewsList> newsItems) {
        this.mContext = context;
        this.mNewsItems = newsItems;
    }

    @Override
    public int getItemViewType(int position) {

        if(mNewsItems.get(position).mType == ItemNewsList.TYPE.HEAD) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        if(viewType == 1) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_hot, parent, false);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.getOverView().setText(mNewsItems.get(position).mOverview);
        holder.getTitle().setText( mNewsItems.get(position).mTitle );
        holder.getCategory().setText( mNewsItems.get(position).mCategory );
        holder.getImg().setImageResource(mNewsItems.get(position).mImage);
    }


    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public int getItemCount() {
        return mNewsItems == null? 0 : mNewsItems.size();
    }

    // NEWS LIST VIEW HOLDER
    public class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView txtOverview;
        private final TextView txtTitle;
        private final TextView txtCategory;
        private final ImageView img;

        public DataViewHolder(View itemView) {
            super(itemView);

            txtOverview = (TextView) itemView.findViewById(R.id.news_overview);
            txtTitle = (TextView) itemView.findViewById(R.id.news_title);
            txtCategory = (TextView) itemView.findViewById(R.id.news_category);
            img = (ImageView) itemView.findViewById(R.id.news_image);

            itemView.setOnClickListener(this);
        }

        public TextView getOverView() {
            return txtOverview;
        }
        public TextView getTitle() {
            return txtTitle;
        }
        public TextView getCategory() {
            return txtCategory;
        }
        public ImageView getImg() {
            return img;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, NewsActivity.class);
            mContext.startActivity(intent);
        }
    }
}
