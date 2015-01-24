package markoidzan.mojtvzandroid;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;


public class GlavnoSucelje extends ActionBarActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView listaDrawer;
    private RelativeLayout relativeDrawer;
    private ArrayAdapter<String> navDrawerAdapter;
    private String[] sliderData;
    private CharSequence mDrawerTitle;
    @SuppressWarnings("unused")
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prikaz_weba);

        relativeDrawer = (RelativeLayout) findViewById(R.id.left_drawer);
        listaDrawer = (ListView) findViewById(R.id.left_drawer_child);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        mTitle = mDrawerTitle = getTitle();

        sliderData = getResources().getStringArray(R.array.imenaLinkova);

        navDrawerAdapter = new ArrayAdapter<>(GlavnoSucelje.this, android.R.layout.simple_list_item_1, sliderData);
        listaDrawer.setAdapter(navDrawerAdapter);
        listaDrawer.setOnItemClickListener(new DrawerItemClickerListener());


        if (toolbar != null) {
            toolbar.setTitle("Moj TVZ za Android");
            selectItem(0);
            setSupportActionBar(toolbar);
        }


        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
            }

        };
        drawerLayout.setDrawerListener(drawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prikaz_weba, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return false;
    }

    private class DrawerItemClickerListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    selectItem(position);
                case 1:
                    selectItem(position);
                case 2:
                    selectItem(position);
            }
        }
    }

    private void selectItem(int position) {
        switch (position) {
            case 0:
                Fragment fragment = new MojeVijesti();
                Bundle argumenti = new Bundle();
                fragment.setArguments(argumenti);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.activity_prikaz_weba, fragment).commit();
                listaDrawer.setItemChecked(position, true);
                drawerLayout.closeDrawer(relativeDrawer);
                return;
            case 1:
                Fragment fragment1 = new MojiPredmeti();
                Bundle argumenti1 = new Bundle();
                fragment1.setArguments(argumenti1);
                FragmentManager fragmentManager1 = getFragmentManager();
                fragmentManager1.beginTransaction().replace(R.id.activity_prikaz_weba, fragment1).commit();
                listaDrawer.setItemChecked(position, true);
                drawerLayout.closeDrawer(relativeDrawer);
                return;
            case 2:
                Fragment fragment2 = new MojeVijesti();
                Bundle argumenti2 = new Bundle();
                fragment2.setArguments(argumenti2);
                FragmentManager fragmentManager2 = getFragmentManager();
                fragmentManager2.beginTransaction().replace(R.id.activity_prikaz_weba, fragment2).commit();
                listaDrawer.setItemChecked(position, true);
                drawerLayout.closeDrawer(relativeDrawer);
                return;

        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration novaKonfiguracija) {
        super.onConfigurationChanged(novaKonfiguracija);
        drawerToggle.onConfigurationChanged(novaKonfiguracija);
    }
}


