package cc.httpsdesignstudio.aparna.Feed;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Design Studio IITR on 12-03-2018.
 */

// Class that stores fragments for tabs

public class SectionsPagerAdapter extends FragmentStatePagerAdapter{

    private static final String TAG = "SectionsPagerAdapter";

    final List<Fragment> fragmentList = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(SearchFragment fragment) {
        fragmentList.add(fragment);
    }

    public void addFragment(FeedFragment feedFragment) {
        fragmentList.add(feedFragment);
    }
}
