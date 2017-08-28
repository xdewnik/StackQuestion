package homedevstudio.cookingup.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdewnik on 28.08.2017.
 */

public class RecipeList {

    @SerializedName("recipes")
    @Expose
    private List<RecipeDTO> recipes = new ArrayList<RecipeDTO>();

    public RecipeList(){
    }

    public List<RecipeDTO> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeDTO> recipes) {
        this.recipes = recipes;
    }
}
