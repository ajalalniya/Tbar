package co.tara.tarabari.driver.myview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.ViewGroup;

import co.tara.tarabari.driver.Config;


/**
 * Created by jalalnia on 2/22/2017.
 */

public class MyTabLayout extends TabLayout {
    public MyTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);


    }
    public MyTabLayout(Context context) {
        super(context);
    }
    public MyTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTabsFromPagerAdapter(@NonNull PagerAdapter adapter) {


        this.removeAllTabs();

        ViewGroup slidingTabStrip = (ViewGroup) getChildAt(0);

        for (int i = 0, count = adapter.getCount(); i < count; i++) {
            Tab tab = this.newTab();
            this.addTab(tab.setText(adapter.getPageTitle(i)));
            MyTextView view = (MyTextView) ((ViewGroup)slidingTabStrip.getChildAt(i)).getChildAt(1);
            view.setTypeface(Config.typeface, Typeface.NORMAL);
        }
    }
}
