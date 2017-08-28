package homedevstudio.cookingup.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import homedevstudio.cookingup.R;
import homedevstudio.cookingup.dtos.RecipeDTO;
import homedevstudio.cookingup.dtos.RecipeList;

/**
 * Created by xdewnik on 28.08.2017.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder> {

    List<RecipeDTO> recipeList;
    Context context;


    public RecipesAdapter(Context context, List<RecipeDTO> objectList){
        super();
        this.context = context;
        this.recipeList = objectList;

    }

    @Override
    public RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_item, parent, false);

        return new RecipesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipesViewHolder holder, int position) {
        RecipeDTO item =recipeList.get(position);
        holder.recipeName.setText(item.getNameRecipe());
        holder.recipeDesc.setText(item.getDescriptionRecipe());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }



    public class RecipesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recipePhoto) ImageView recipePhoto;
        @BindView(R.id.recipeName) TextView recipeName;
        @BindView(R.id.reciperDescription) TextView recipeDesc;

        public RecipesViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }



    }
}
