package co.tara.tarabari.passenger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.preference.PreferenceManager;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Locale;

import co.tara.tarabari.passenger.data.TehranArea;

/**
 * Created by jalalnia on 5/3/2017.
 */

public class Config extends Application {

    public static Context context;
    public static SharedPreferences preferences;
    public static final String MyPREFERENCES = "MyPrefs";
    public static ArrayList<LatLng> mytehran = new ArrayList<LatLng>();
    public static ArrayList<LatLng> mytarh = new ArrayList<LatLng>();
    public static int currentVersion;
    public static Typeface typeface;
    public static Typeface typefaceShape;
    public static String BASE_URL = "http://192.168.0.11:9001/rs/";
    public static String BASE_URL_GEO = "https://maps.googleapis.com/maps/api/";
    public String str1 = "51.0651398 35.7582144,51.068573 35.7476268,51.0877991 35.7353657,51.113205 35.7297919,51.1317444 35.714183,51.1509705 35.7041471,51.177063 35.6957829,51.2182617 35.6801674,51.2265015 35.6578542,51.2464142 35.6500431,51.285553 35.6360928,51.3123322 35.6204656,51.3370514 35.5998106,51.3645172 35.6026022,51.3624573 35.5919939,51.3535309 35.5562504,51.3748169 35.5366964,51.3466644 35.5121075,51.3466644 35.4897474,51.3899231 35.4813607,51.457901 35.4925427,51.4826202 35.5059591,51.5464783 35.5713316,51.5512848 35.5880852,51.5306854 35.6065101,51.5196991 35.6210237,51.5279388 35.6316282,51.5512848 35.6528328,51.5512848 35.6612015,51.5361786 35.6740319,51.5190125 35.7052623,51.5657043 35.7091652,51.6281891 35.718643,51.6412354 35.7303493,51.6172028 35.745955,51.5938568 35.7582144,51.5766907 35.7710292,51.5938568 35.8100177,51.5794373 35.8178132,51.5512848 35.8038922,51.5409851 35.8128019,51.5135193 35.8144724,51.49086 35.8205971,51.4716339 35.8194835,51.4324951 35.8139155,51.4009094 35.8061197,51.3521576 35.7944246,51.3006592 35.7855129,51.2786865 35.7743718,51.252594 35.7732576,51.1956024 35.770472,51.1358643 35.7632291,51.0987854 35.7593289,51.0651398 35.7582144";
    public String str2 = "51.3976049 35.6594233,51.3986778 35.6570173,51.4470863 35.6602252,51.4536738 35.7037463,51.4380312 35.6991113,51.4375377 35.6993552,51.4388251 35.7020387,51.4410782 35.7070918,51.4341474 35.7069698,51.4373016 35.7112211,51.4398122 35.7157684,51.4425588 35.7197928,51.4438891 35.7235556,51.4377093 35.724688,51.4347482 35.7246531,51.4268517 35.7243918,51.4237189 35.7242873,51.4149857 35.7240434,51.4103508 35.7239912,51.4083552 35.7212213,51.4058018 35.7202283,51.3892365 35.7143572,51.3893223 35.7129983,51.3901806 35.7070047,51.3907385 35.7021607,51.3915968 35.6966194,51.3920689 35.6919142,51.393013 35.684943,51.394043 35.6772043,51.3949013 35.6699877,51.3961029 35.6624916,51.3964033 35.6610621,51.3976049 35.6594233";

    @Override
    public void onCreate() {
        super.onCreate();

        Locale.setDefault(new Locale("fa_"));
        context = getApplicationContext();
        preferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        currentVersion = Build.VERSION.SDK_INT;
        TehranArea tehranArea = new TehranArea();
        tehranArea.init(str1);

        TehranArea tehranArea2 = new TehranArea();
        tehranArea.initTarh(str2);

        typeface = Typeface.createFromAsset(context.getAssets(), "font/MyFont.ttf");
        typefaceShape = Typeface.createFromAsset(context.getAssets(), "font/fontshape.ttf");


    }
}
