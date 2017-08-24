package homedevstudio.cookingup.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by xdewnik on 25.08.2017.
 */
//Класс от которого наследуются все фрагменты. Для упрощения расширения базового функционала фрагментов
public abstract class AbstractFragment extends Fragment {

    private String title;
    protected Context context;
    protected View view;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContext(Context context){
        this.context=context;
    }


}
