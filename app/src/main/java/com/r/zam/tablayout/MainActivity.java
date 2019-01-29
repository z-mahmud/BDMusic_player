package com.r.zam.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionBar;
    TabLayout tabLayout;
    ViewPager viewPager;

    private  int[] tabIcons = {
      R.drawable.ic_call, R.drawable.ic_person, R.drawable.ic_group
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("WhatsApp");
        actionBar.setIcon(R.drawable.whatsapp);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setUpViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }



    public void setUpViewPager(ViewPager upViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CallFragment(),"Call");
        adapter.addFragment(new PersonFragment(),"Person");
        adapter.addFragment(new GroupFragment(),"Group");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }
}
