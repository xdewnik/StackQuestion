package homedevstudio.cookingup.fragments.allrecipies.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import homedevstudio.cookingup.R;
import homedevstudio.cookingup.adapters.RecipesAdapter;
import homedevstudio.cookingup.dtos.RecipeDTO;
import homedevstudio.cookingup.fragments.AbstractFragment;

/**
 * Created by xdewnik on 24.08.2017.
 */

public class AllRecipiesSearchFragment extends AbstractFragment {

    private static final int FRAGMENT_LAYOUT = R.layout.all_recipes_search_layout;

    @BindView(R.id.allRecipiesSearchRecycleView) RecyclerView recyclerView;
    private RecipesAdapter adapterRecipes;
    private List<RecipeDTO> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(FRAGMENT_LAYOUT, container, false);
        ButterKnife.bind(this, view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapterRecipes);


        return view;
    }


    public static AllRecipiesSearchFragment getInstance(Context context) {
        Bundle args = new Bundle();
        AllRecipiesSearchFragment fragment = new AllRecipiesSearchFragment();
        fragment.setArguments(args);
        fragment.setContext(context);

        return fragment;
    }
}
