package homedevstudio.cookingup;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import homedevstudio.cookingup.adapters.RecipesAdapter;
import homedevstudio.cookingup.dtos.RecipeDTO;
import homedevstudio.cookingup.dtos.RecipeList;
import homedevstudio.cookingup.fragments.allrecipies.fragments.AllRecipiesMainFragment;
import homedevstudio.cookingup.service.ApiService;
import homedevstudio.cookingup.utils.InternetConnection;
import homedevstudio.cookingup.utils.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static homedevstudio.cookingup.R.styleable.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.TestRw) RecyclerView recyclerView;

    //временная кнопка, пока не сделаем все карсиво
    @BindView(R.id.temporallyRefreshButton) FloatingActionButton refreshButton;

    private RecipesAdapter adapterRecipes;
    private List<RecipeDTO> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);





        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Проверка на соеденение с интернетом

                if(InternetConnection.checkConnection(getApplicationContext())){
                    final ProgressDialog dialog;

                    //Диалог с пользователем

                    dialog = new ProgressDialog(MainActivity.this);
                    dialog.setTitle(getString(R.string.gettin_Gson_dialog_title));
                    dialog.setMessage(getString(R.string.gettin_Gson_dialog_message));
                    dialog.show();

                    //Создаем объект нашего апи
                    ApiService api = RetrofitClient.getApiService();

                    //Вызываем джесон
                    Call<RecipeList> call = api.getMyGson();

                    // кол бэк будет вызван как только получит ответ
                    call.enqueue(new Callback<RecipeList>() {
                        @Override
                        public void onResponse(Call<RecipeList> call, Response<RecipeList> response) {
                            //Dismiss Dialog
                            dialog.dismiss();

                            if (response.isSuccessful()) {
                                /**
                                 * Got Successfully
                                 */
                                recipeList= response.body().getRecipes();

                                /**
                                 * Binding that List to Adapter
                                 */
                                adapterRecipes = new RecipesAdapter(MainActivity.this, recipeList);
                                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                                recyclerView.setLayoutManager(mLayoutManager);
                                recyclerView.setItemAnimator(new DefaultItemAnimator());
                                recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
                                recyclerView.setAdapter(adapterRecipes);
                                adapterRecipes.notifyDataSetChanged();

                            } else {
                                Toast toast = Toast.makeText(getApplicationContext(), R.string.something_wrong, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }

                        @Override
                        public void onFailure(Call<RecipeList> call, Throwable t) {
                            dialog.dismiss();
                        }
                    });
            }
    }});


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new AllRecipiesMainFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Bundle arguments = new Bundle();
        // Создадим новый фрагмент
        Fragment fragment = null;
        Class fragmentClass = null;


        int id = item.getItemId();

        if (id == R.id.nav_all_categories) {
            fragmentClass = AllRecipiesMainFragment.class;


        } else if (id == R.id.nav_drink) {

        } else if (id == R.id.nav_firstmeal) {

        } else if (id == R.id.nav_garnish) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_sauce) {

        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            fragment.setArguments(arguments);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Вставляем фрагмент, заменяя текущий фрагмент
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        // Выделяем выбранный пункт меню в шторке
        item.setChecked(true);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

