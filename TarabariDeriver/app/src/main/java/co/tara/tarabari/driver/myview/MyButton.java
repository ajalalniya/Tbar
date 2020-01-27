package co.tara.tarabari.driver.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

import co.tara.tarabari.driver.Config;


/**
 * Created by Ali on 1/22/2017.
 */
public class MyButton extends Button {
    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Config.typeface);
    }
}
