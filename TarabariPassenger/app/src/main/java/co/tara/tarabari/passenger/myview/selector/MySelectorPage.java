package co.tara.tarabari.passenger.myview.selector;

import co.tara.tarabari.passenger.R;

/**
 * Created by jalalnia on 6/17/2017.
 */

public class MySelectorPage {
    public int[] img = new int[3];

public String[] title =new String[3];



    public int fill() {
        img[2] = R.drawable.ico_motorcycle;
        img[0] = R.drawable.ico_taxi;
        img[1] = R.drawable.ico_vanet;
        title[2]="موتورسیکلت";
        title[0]="تاکسی";
        title[1]="وانت";
        return 2;
    }

}
