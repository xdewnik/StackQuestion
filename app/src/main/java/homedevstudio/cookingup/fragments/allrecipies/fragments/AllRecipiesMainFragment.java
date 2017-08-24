package homedevstudio.cookingup.fragments.allrecipies.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import homedevstudio.cookingup.R;
import homedevstudio.cookingup.adapters.FragmentAdapter;
import homedevstudio.cookingup.fragments.AbstractFragment;

/**
 * Created by xdewnik on 24.08.2017.
 */

public class AllRecipiesMainFragment extends AbstractFragment {

    private static final int FRAGMENT_LAYOUT = R.layout.all_recipies_main_layout;

    @BindView(R.id.allRecipiesViewPager) ViewPager viewPager;
    FragmentAdapter fragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(FRAGMENT_LAYOUT, container, false);
        ButterKnife.bind(this, view);

        fragmentAdapter = new FragmentAdapter(getActivity().getApplicationContext(), getActivity().getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);

        return view;
    }


}



