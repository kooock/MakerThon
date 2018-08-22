package hyu.android.kjh.matjib.Views;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import butterknife.BindView;
import hyu.android.kjh.matjib.R;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tabBar)
    TabLayout mTabLayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.titleBar)
    LinearLayout mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
