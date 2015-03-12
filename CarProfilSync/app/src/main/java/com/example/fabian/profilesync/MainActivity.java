package com.example.fabian.profilesync;

import android.app.ActivityManager;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.fabian.profilesync.view.AirCoolingFragment;
import com.example.fabian.profilesync.view.CarSyncFragment;
import com.example.fabian.profilesync.view.ChassisFragment;
import com.example.fabian.profilesync.view.EmergencyNumbersFragment;
import com.example.fabian.profilesync.view.GPSFavoriteFragment;
import com.example.fabian.profilesync.view.HeadsUpFragment;
import com.example.fabian.profilesync.view.MusicFragment;
import com.example.fabian.profilesync.view.NavigationDrawerFragment;
import com.example.fabian.profilesync.view.SeatPositionFragment;
import com.example.fabian.profilesync.view.SteeringWheelFragment;
import com.example.fabian.profilesync.view.TemperatureFragment;

import roboguice.activity.RoboActionBarActivity;


public class MainActivity extends RoboActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "main constructor");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_frontend_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        startService(new Intent(this, CardService.class));

        Log.d("MainActivity", isMyServiceRunning(CardService.class) ? "yes" : "no");

    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

        FragmentManager fragmentManager = getFragmentManager();
        Fragment frag;
        if(position==4)
            frag = new HeadsUpFragment();
        else if(position == 1)
            frag = new SteeringWheelFragment();
        else if(position == 2)
            frag = new MusicFragment();
        else if(position == 3)
            frag = new GPSFavoriteFragment();
        else if(position == 5)
            frag = new CarSyncFragment();
        else if(position == 0)
            frag = new SeatPositionFragment();
        else if(position == 7)
            frag = new AirCoolingFragment();
        else if(position == 8)
            frag = new TemperatureFragment();
        else if(position == 9)
            frag = new ChassisFragment();
        else if (position == 6)
            frag = new EmergencyNumbersFragment();
        else
            frag = new CarSyncFragment();

        fragmentManager.beginTransaction()
                .replace(R.id.container, frag).addToBackStack(null)
                .commit();
        onSectionAttached(position);
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 0:
                mTitle = getString(R.string.title_section1);
                break;
            case 1:
                mTitle = getString(R.string.title_section2);
                break;
            case 2:
                mTitle = getString(R.string.title_section3);
                break;
            case 3:
                mTitle = getString(R.string.title_section4);
                break;
            case 4:
                mTitle = getString(R.string.title_section5);
                break;
            case 5:
                mTitle = "Carsync";
                break;
            case 6:
                mTitle = "Notfallnummern";
                break;
            default:
                mTitle = getResources().getString(R.string.app_name);
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.frontend_main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
