package homedevstudio.cookingup.service;

import java.util.List;

import homedevstudio.cookingup.dtos.RecipeDTO;
import homedevstudio.cookingup.dtos.RecipeList;
import homedevstudio.cookingup.utils.Urls;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by xdewnik on 27.08.2017.
 */

public interface ApiService {

    @GET(Urls.RESIPES)
    Call<List<RecipeDTO>> getData();

}
