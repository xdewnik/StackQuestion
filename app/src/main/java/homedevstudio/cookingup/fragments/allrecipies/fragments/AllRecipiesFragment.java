package homedevstudio.cookingup.fragments.allrecipies.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import homedevstudio.cookingup.MainActivity;
import homedevstudio.cookingup.R;
import homedevstudio.cookingup.adapters.RecipesAdapter;
import homedevstudio.cookingup.dtos.RecipeDTO;
import homedevstudio.cookingup.dtos.RecipeList;
import homedevstudio.cookingup.fragments.AbstractFragment;
import homedevstudio.cookingup.service.ApiService;
import homedevstudio.cookingup.utils.InternetConnection;
import homedevstudio.cookingup.utils.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xdewnik on 24.08.2017.
 */

public class AllRecipiesFragment extends AbstractFragment {

    private static final int FRAGMENT_LAYOUT = R.layout.allrecipies_layout;

    @BindView(R.id.allRecipiesRecycleView) RecyclerView recyclerView;

    //временная кнопка, пока не сделаем все карсиво
    @BindView(R.id.temporallyRefreshButton) FloatingActionButton refreshButton;
    private Context context;

    private RecipesAdapter adapterRecipes;
    private List<RecipeDTO> recipeList;



    //Позволяет получить экземпляр фрагмента. Нужен для передачи данных например из бд в другие фрагменты
    public static AllRecipiesFragment getInstance(Context context) {
        Bundle args = new Bundle();
        AllRecipiesFragment fragment = new AllRecipiesFragment();
        fragment.setArguments(args);
        fragment.setContext(context);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(FRAGMENT_LAYOUT, container, false);
        ButterKnife.bind(this, view);

        context = getActivity().getApplicationContext();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Проверка на соеденение с интернетом

                if(InternetConnection.checkConnection(context)){
                    final ProgressDialog dialog;

                    //Диалог с пользователем

                    dialog = new ProgressDialog(context);
                    dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                    dialog.setTitle(getString(R.string.gettin_Gson_dialog_title));
                    dialog.setMessage(getString(R.string.gettin_Gson_dialog_message));
                    dialog.show();

                    //Создаем объект нашего апи
                    ApiService api = RetrofitClient.getApiService();

                    //Вызываем джесон
                    Call<List<RecipeDTO>> call = api.getData();

                    // кол бэк будет вызван как только получит ответ
                    call.enqueue(new Callback<List<RecipeDTO>>() {
                        @Override
                        public void onResponse(Call<List<RecipeDTO>> call, Response<List<RecipeDTO>> response) {
                            //Dismiss Dialog
                            dialog.dismiss();

                            if (response.isSuccessful()) {


                                recipeList.addAll(response.body());


                                adapterRecipes = new RecipesAdapter(context, recipeList);
                                recyclerView.setAdapter(adapterRecipes);
                                adapterRecipes.notifyDataSetChanged();

                            } else {
                                Toast toast = Toast.makeText(context, R.string.something_wrong, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<RecipeDTO>> call, Throwable t) {
                            Toast toast = Toast.makeText(context, R.string.something_wrong, Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });
                }
            }});



        return view;
    }

}
