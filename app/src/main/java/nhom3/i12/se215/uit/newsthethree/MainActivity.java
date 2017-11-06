package nhom3.i12.se215.uit.newsthethree;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
//import android.app.Fragment;
//import android.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {





    private static String TAG = MainActivity.class.getSimpleName();

    // region HAMBURGER
    ListView mDrawerList;
    RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    ArrayList<NavItem> mNavItems = new ArrayList<>();

    // endregion

    // region TAB
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    ViewPagerAdapter viewPagerAdapter;
    // endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // region TAB
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HomeFragment(), "Home");
        viewPagerAdapter.addFragment(new TheSecondFragment(), "t Second");
        viewPagerAdapter.addFragment(new TheThirdFragment(), "t third");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        // endregion

        // region HAMBURGER
        mNavItems.add(new NavItem("The First", "ahaha", R.drawable.ic_action_menu));
        mNavItems.add(new NavItem("The Sec_d", "fuck second", R.drawable.ic_action_menu));
        mNavItems.add(new NavItem("The THIRD", "lol third", R.drawable.ic_action_menu));

        // drawer layout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // populate Navigation Drawer with options
        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerList = (ListView) findViewById(R.id.navList);
        DrawerListAdapter drawerListAdapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setAdapter(drawerListAdapter);

        // drawer items click listener
        mDrawerList.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }
        });

        Toolbar myToolbar = (Toolbar)findViewById(R.id.toolBar);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, myToolbar,R.string.drawer_open, R.string.drawer_close){
          @Override
            public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
          }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // endregion

        // region MENU

        // endregion


    }

    // region HAMBURGER
    private void selectItemFromDrawer(int position) {
        Fragment fragment = new PreferencesFragment();

        //FragmentManager fragmentManager = getFragmentManager();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContent,fragment).commit();

        mDrawerList.setItemChecked(position, true);
        setTitle(mNavItems.get(position).mTitle);

        // close the drawer
        mDrawerLayout.closeDrawer(mDrawerPane);
    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    // endregion


    // region MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        Menu menuCategory = menu.getItem(0).getSubMenu();
        MenuItem item;
        SpannableString s;

        String[] categories = getResources().getStringArray(R.array.categories);



        Random rand = new Random();
        int r, g, b;
        int color;

        for(int position = 0; position < 15; position++) {
            item = menuCategory.getItem(position);

            s = new SpannableString(categories[position]);
            for(int i = 0; i < s.length(); i++) {


                r = (int)((rand.nextFloat() / 2f + 0.5f) * 255);
                g = (int)((rand.nextFloat() / 2f + 0.5f) * 255);
                b = (int)((rand.nextFloat() / 2f + 0.5f) * 255);
                color = Color.argb(255, r, g, b);

                s.setSpan(new ForegroundColorSpan(color), i, i+1, 0);
            }
            s.setSpan(new RelativeSizeSpan(2f), 0, s.length(), 0);

            item.setTitle(s);
        }






        return true;
    }


    public boolean onPrepareOptionsMenu(Menu menu){
        //boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerPane);
        //menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Pass the event to ActionBarDrawerToggle
        // If it returns true, then it has handled
        // the nav drawer indicator touch event
        if(mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        // handler your other action bar items
        return super.onOptionsItemSelected(item);
    }
    // endregion
}