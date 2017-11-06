package nhom3.i12.se215.uit.newsthethree;

public class ItemNewsList {
    public enum TYPE
    {
        HEAD,
        TAIL
    }

    // title of the news_list_item
    String mTitle;
    // category of the news_list_item
    String mCategory;
    // overview of the news_list_item (only news_list_hot has this)
    String mOverview;
    // image of the news_list_item
    int mImage;

    // type: news_list_item or news_list_hot ???
    TYPE mType;

    public ItemNewsList(String title, String category, String overview, int image, TYPE type)
    {
        mTitle = title;
        mCategory = category;
        mOverview = overview;
        mImage = image;
        mType = type;
    }
}