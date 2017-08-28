package homedevstudio.cookingup.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

/**
 * Created by xdewnik on 27.08.2017.
 */

public class InternetConnection {
    public static boolean checkConnection(@NonNull Context context){
        return((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo() != null;

    }

}
