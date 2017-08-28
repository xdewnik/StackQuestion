package homedevstudio.cookingup.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by xdewnik on 27.08.2017.
 */

public class IngredientDTO {

    @SerializedName("idIngredient")
    @Expose
    private long idIngredient;

    @SerializedName("ingredientName")
    @Expose
    private String ingredientName;

    @SerializedName("recipe")
    @Expose
    private RecipeDTO recipe;


    public IngredientDTO(){

    }

    public long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public RecipeDTO getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDTO recipe) {
        this.recipe = recipe;
    }
}
