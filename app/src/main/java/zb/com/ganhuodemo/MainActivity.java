package zb.com.ganhuodemo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import zb.com.ganhuodemo.View.TabEntity;
import zb.com.ganhuodemo.adapter.MainPagerAdapter;
import zb.com.ganhuodemo.fragments.AboutFragment;
import zb.com.ganhuodemo.fragments.BounsFragment;
import zb.com.ganhuodemo.fragments.DailyFragment;
import zb.com.ganhuodemo.fragments.SortFragment;
import zb.com.ganhuodemo.utils.Constant;

public class MainActivity extends AppCompatActivity {
    private int mIconUnselectIds[] = {
            R.mipmap.tab_daily_unselect,R.mipmap.tab_sort_unselect,
            R.mipmap.tab_bonus_unselect,R.mipmap.tab_about_unselect};
    private int mIconSelectIds [] = {
            R.mipmap.tab_daily_select,R.mipmap.tab_sort_select,
            R.mipmap.tab_bonus_select,R.mipmap.tab_about_select};
    private CommonTabLayout mTabLayout;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MainPagerAdapter mainPagerAdapter = null;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(mToolbar);

        mViewPager =findViewById(R.id.vp_main);
        for (int i = 0 ; i < Constant.sTabTitles.length ; i ++){
            mTabEntities.add(new TabEntity(Constant.sTabTitles[i],mIconSelectIds[i],mIconUnselectIds[i]));
        }
        mTabLayout = findViewById(R.id.t2_2);
        mTabLayout.setTabData(mTabEntities);
        mFragments.add(new DailyFragment());
        mFragments.add(new SortFragment());
        mFragments.add(new BounsFragment());
        mFragments.add(new AboutFragment());
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),mFragments);
        mViewPager.setAdapter(mainPagerAdapter);

        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }
}
