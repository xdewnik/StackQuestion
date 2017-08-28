package homedevstudio.cookingup.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by xdewnik on 27.08.2017.
 */

public class RecipeDTO {

    @SerializedName("idRecipe")
    @Expose
    private long idRecipe;

    @SerializedName("nameRecipe")
    @Expose
    private String nameRecipe;

    @SerializedName("category")
    @Expose
    private CategoryDTO category;

    @SerializedName("descriptionRecipe")
    @Expose
    private String descriptionRecipe;

    @SerializedName("tutorialRecipe")
    @Expose
    private String tutorialRecipe;

    @SerializedName("image")
    @Expose
    private byte[] image;

    @SerializedName("ingridientRecipe")
    @Expose
    private List<IngredientDTO> ingridientRecipe;


    public RecipeDTO(){

    }

    public long getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(long idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getNameRecipe() {
        return nameRecipe;
    }

    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getDescriptionRecipe() {
        return descriptionRecipe;
    }

    public void setDescriptionRecipe(String descriptionRecipe) {
        this.descriptionRecipe = descriptionRecipe;
    }

    public String getTutorialRecipe() {
        return tutorialRecipe;
    }

    public void setTutorialRecipe(String tutorialRecipe) {
        this.tutorialRecipe = tutorialRecipe;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<IngredientDTO> getIngridientRecipe() {
        return ingridientRecipe;
    }

    public void setIngridientRecipe(List<IngredientDTO> ingridientRecipe) {
        this.ingridientRecipe = ingridientRecipe;
    }
}
