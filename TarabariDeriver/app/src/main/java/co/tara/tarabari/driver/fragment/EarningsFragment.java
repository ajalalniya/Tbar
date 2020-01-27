package co.tara.tarabari.driver.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.myview.MyTabLayout;
import co.tara.tarabari.driver.myview.MyTextShape2;
import co.tara.tarabari.driver.utils.IdGenerator;


/**
 * Created by Ali on 2/21/2017.
 */

public class EarningsFragment extends Fragment {


    private MyTabLayout tabLayout;

    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private String[] viewPagerTitles = new String[2];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_earnings,container,false);



        viewPagerTitles[1] = getString(R.string.daily);
        viewPagerTitles[0] = getString(R.string.weekly);

        viewPager = (ViewPager) view.findViewById(R.id.viewpagerEarnings);
        tabLayout = (MyTabLayout) view.findViewById(R.id.tabsAppEarnings);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);




        return view;
    }


    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());


        viewPager.setAdapter(adapter);
      //  viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(1);

    }


    class ViewPagerAdapter extends PagerAdapter {

        RelativeLayout weeklyEarningsFragmentLayout = null;
        RelativeLayout dailyEarningsFragmentLayout = null;
        WeeklyEarningsFragment weeklyEarningsFragment = new WeeklyEarningsFragment();
        DailyEarningsFragment dailyEarningsFragment = new DailyEarningsFragment();

        FragmentManager fragmentManager = null;
        FragmentTransaction fragmentTransaction = null;


        private ViewPagerAdapter() {
            weeklyEarningsFragmentLayout = new RelativeLayout(getActivity().getApplicationContext());
            weeklyEarningsFragmentLayout.setId(IdGenerator.getId("weeklyEarningsFragmentLayout"));
            weeklyEarningsFragmentLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            dailyEarningsFragmentLayout = new RelativeLayout(getActivity().getApplicationContext());
            dailyEarningsFragmentLayout.setId(IdGenerator.getId("dailyEarningsFragmentLayout"));
            dailyEarningsFragmentLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));




        }

        public ViewPagerAdapter(FragmentManager manager) {
            this();
            this.fragmentManager = manager;

        }

        @Override
        public int getCount() {
            return 2;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return viewPagerTitles[position];
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (View) object == view;
        }

        @Deprecated
        public Object instantiateItem(View container, int position) {
            fragmentTransaction = fragmentManager.beginTransaction();

             if (position == 1) {

                fragmentTransaction.add(dailyEarningsFragmentLayout.getId(), dailyEarningsFragment);
                fragmentTransaction.commit();
                ((ViewPager) container).addView(dailyEarningsFragmentLayout, 0);
                return dailyEarningsFragmentLayout;
            } else if (position == 0) {

                fragmentTransaction.add(weeklyEarningsFragmentLayout.getId(), weeklyEarningsFragment);
                fragmentTransaction.commit();
                ((ViewPager) container).addView(weeklyEarningsFragmentLayout, 0);
                return weeklyEarningsFragmentLayout;
            }

            return null;
        }


    }
}
