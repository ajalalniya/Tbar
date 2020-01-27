package co.tara.tarabari.driver;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;

/*import com.google.android.gms.maps.model.LatLng;
import com.shamanland.fonticon.FontIconTypefaceHolder;*/

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Ali on 2/21/2017.
 */

public class Config extends Application {

    public static Context context;
    public static Typeface typeface;
    public static Typeface typefaceShape;
    public static Typeface typefaceShape2;
    public static SharedPreferences preferences;
    public static String BASE_URL = "http://192.168.0.11:9001/rs/";
    public static String BASE_URL_GEO = "https://maps.googleapis.com/maps/api/";
   // public static ArrayList<LatLng> mytarh = new ArrayList<LatLng>();

    public static  boolean inMain=false;
    @Override
    public void onCreate() {
        super.onCreate();


        String languageToLoad = "fa_";
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);

        context = getApplicationContext();
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
      //  FontIconTypefaceHolder.init(getAssets(), "font/fontshape2.ttf");
        typeface = Typeface.createFromAsset(context.getAssets(), "font/MyFont.ttf");
        typefaceShape = Typeface.createFromAsset(context.getAssets(), "font/fontshape.ttf");
        typefaceShape2 = Typeface.createFromAsset(context.getAssets(), "font/fontshape2.ttf");


    }
}
