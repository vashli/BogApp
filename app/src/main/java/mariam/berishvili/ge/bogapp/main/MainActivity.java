package mariam.berishvili.ge.bogapp.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

import mariam.berishvili.ge.bogapp.R;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MainViewPagerAdapter mainViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setBackground();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.activity_main_view_pager);
        tabLayout = findViewById(R.id.activity_main_tab_layout);
        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    private void setBackground(){
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if(hour >= 18 || hour < 6) {
            setTheme(R.style.AppThemeEvening);
        }
    }
}
