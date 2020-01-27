package co.tara.tarabari.driver.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import co.tara.tarabari.driver.Config;


/**
 * Created by Ali on 1/22/2017.
 */
public class MyTextView extends TextView {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Config.typeface);
    }
}
