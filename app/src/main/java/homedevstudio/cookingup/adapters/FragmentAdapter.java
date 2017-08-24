package homedevstudio.cookingup.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.HashMap;
import java.util.Map;

import homedevstudio.cookingup.fragments.AbstractFragment;
import homedevstudio.cookingup.fragments.allrecipies.fragments.AllRecipiesFragment;
import homedevstudio.cookingup.fragments.allrecipies.fragments.AllRecipiesSearchFragment;

/**
 * Created by xdewnik on 25.08.2017.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter{
    private Map<Integer, AbstractFragment> tabs;
    private Context context;


    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabsMap(context);
    }



    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, AllRecipiesFragment.getInstance(context));
        tabs.put(1, AllRecipiesSearchFragment.getInstance(context));

    }
}
