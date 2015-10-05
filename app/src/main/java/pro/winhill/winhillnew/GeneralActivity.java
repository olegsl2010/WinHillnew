package pro.winhill.winhillnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pro.winhill.winhillnew.adapters.FragmentAdapter;
import pro.winhill.winhillnew.wallet.FundingSourceList;
import pro.winhill.winhillnew.wallet.RefillMenu;
import pro.winhill.winhillnew.wallet.WalletListMenu;
import pro.winhill.winhillnew.wallet.WithdrawMenu;


public class GeneralActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_activity);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new WalletListMenu(), "WH account");
        adapter.addFragment(new FundingSourceList(), "Funding source");
        adapter.addFragment(new RefillMenu(), "Refill");
        adapter.addFragment(new WithdrawMenu(), "Withdraw");
        viewPager.setAdapter(adapter);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        Intent intent;
                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()){
                            case R.id.nav_transfer:
                                intent = new Intent(GeneralActivity.this, TransferActivity.class);
                                startActivity(intent);
                                return true;
                            case R.id.nav_settings:
                                intent = new Intent(GeneralActivity.this, SettingsActivity.class);
                                startActivity(intent);
                                return true;
                            default:
                                return true;
                        }

                    }
                });
    }


}






