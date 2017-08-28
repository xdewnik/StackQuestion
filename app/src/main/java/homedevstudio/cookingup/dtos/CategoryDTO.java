package homedevstudio.cookingup.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by xdewnik on 27.08.2017.
 */

public class CategoryDTO {

    @SerializedName("idCategory")
    @Expose
    private long idCategory;

    @SerializedName("recipeListCategory")
    @Expose
    private List<RecipeDTO> recipeListCategory;

    @SerializedName("nameCategory")
    @Expose
    private String nameCategory;

    public CategoryDTO(){
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public List<RecipeDTO> getRecipeListCategory() {
        return recipeListCategory;
    }

    public void setRecipeListCategory(List<RecipeDTO> recipeListCategory) {
        this.recipeListCategory = recipeListCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
