package co.tara.tarabari.passenger.myview.selector;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import co.tara.tarabari.passenger.R;
import co.tara.tarabari.passenger.myview.MyTextView;

/**
 * Created by jalalnia on 6/17/2017.
 */

public class MySelectorAdapter extends PagerAdapter {
    BackToMain backToMain;
    private Context mContext;
    MySelectorPage pages;

    public MySelectorAdapter(Context context, MySelectorPage pages, BackToMain backToMain) {
        mContext = context;
        this.pages = pages;
        this.backToMain = backToMain;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, final int position) {
        //  Pages customPagerEnum = Pages.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.selector_item, collection, false);
        final ImageView img = (ImageView) layout.findViewById(R.id.bike);
        final MyTextView txt = (MyTextView) layout.findViewById(R.id.txt_title);
        img.setImageResource(pages.img[position]);
        txt.setText(pages.title[position]);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                backToMain.onFinish(position);
                // Log.i("-----","aa "+ position);
            }
        });
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return "";
    }

}
