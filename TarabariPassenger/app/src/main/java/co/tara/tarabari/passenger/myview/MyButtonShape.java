package co.tara.tarabari.passenger.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import co.tara.tarabari.passenger.Config;


/**
 * Created by Ali on 1/22/2017.
 */
public class MyButtonShape extends Button {
    public MyButtonShape(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Config.typefaceShape);
    }
}
