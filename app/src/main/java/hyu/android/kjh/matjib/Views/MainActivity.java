package hyu.android.kjh.matjib.Views;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import hyu.android.kjh.matjib.R;

import butterknife.BindView;
import hyu.android.kjh.matjib.Views.Fragments.CategoryFragment;
import hyu.android.kjh.matjib.Views.Fragments.HomeFragment;
import hyu.android.kjh.matjib.Views.Fragments.MyFragment;
import hyu.android.kjh.matjib.Views.Fragments.UserFragment;

import

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tabBar)
    TabLayout mTabLayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.titleBar)
    LinearLayout mTitleBar;

    ViewPagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTabLayout.setupWithViewPager(mViewPager);
        setupViewPager();

    }

    private void setupViewPager() {
        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(new HomeFragment(), getResources().getString(R.string.home_name));
        mPagerAdapter.addFragment(new CategoryFragment(), getResources().getString(R.string.category_name));
        mPagerAdapter.addFragment(new MyFragment(), getResources().getString(R.string.my_name));
        mPagerAdapter.addFragment(new UserFragment(), getResources().getString(R.string.user_name));
        mViewPager.setAdapter(mPagerAdapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> fragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fragment_manager) {
            super(fragment_manager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }



        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }
    }
}
