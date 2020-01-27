package co.tara.tarabari.driver.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import co.tara.tarabari.driver.Config;


/**
 * Created by Ali on 1/22/2017.
 */
public class MyTextShape2 extends TextView {
    public MyTextShape2(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Config.typefaceShape2);
    }
}
