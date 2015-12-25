package com.akhil.clipbackgroundviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.akhil.clipbackgroundviewpager.fragment.FirstFragment;

/**
 * Created by akhil on 08/09/15.
 */
public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    public CustomFragmentPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);

    }
    @Override
    public Fragment getItem(int i) {
        return FirstFragment.newInstance(i);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
