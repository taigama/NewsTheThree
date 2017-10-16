package nhom3.i12.se215.uit.newsthethree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by taiga on 10/14/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabTiles = new ArrayList<>();

    public void addFragment(Fragment fragment, String title) {
        this.fragments.add(fragment);
        this.tabTiles.add(title);
    }




    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public CharSequence getPageTitle (int position) {
        return tabTiles.get(position);
    }
}
