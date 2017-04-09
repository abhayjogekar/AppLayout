package com.example.abhay.applayout;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final cus_msg_elements[] cus = {(cus_msg_elements) getApplicationContext()};
        final saved_data_elements sde;
        final contact_elements con;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //database object
        final DatabaseConnectivity dc = new DatabaseConnectivity(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SetCustomText.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //SETTING THE VALUES FOR VIEW FROM DATABASES


        TextView msg = (TextView) findViewById(R.id.text_msg);
        TextView dest = (TextView) findViewById(R.id.dest);
        TextView contact = (TextView) findViewById(R.id.contact);

        cus[0] = dc.showMsg();
        sde = dc.showDetails();
        con = dc.showContact();
        if(cus[0]!=null)
            msg.setText((CharSequence) cus[0].getMsg());
        if(sde != null)
            dest.setText((CharSequence) sde.getDest());
        if(con!=null)
            contact.setText((CharSequence) con.getContact());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.set_dest) {
            // Handle the camera action
            startActivity(new Intent(this, SetDestinationActivity.class));
        } else if (id == R.id.set_contact) {
            startActivity(new Intent(this, SetContact.class));
        } else if (id == R.id.set_text) {
            startActivity(new Intent(this, SetCustomText.class));

        } else if (id == R.id.info) {

        } else if (id == R.id.dev) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
