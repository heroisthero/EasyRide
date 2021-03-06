package slickstring.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import D5.Control;


public class list_drivers extends Activity {

    public final static String message_key = "slickstring.myapplication.message";
    public Control controller = login.controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_drivers);
        String[] drivers = controller.getDrivers();

        for (String s: drivers){
            driverButtonCreator(s);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_role_select, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_profile:
                openProfile();
        }
        return super.onOptionsItemSelected(item);
    }


    public void openProfile(){
        Bundle bundle = new Bundle();

        Intent intent = new Intent(this, my_profile.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void driverButtonCreator(final String driverName){
        final LinearLayout layout = (LinearLayout) findViewById(R.id.driverListLayout);
        final Button button = new Button(this);
        button.setText(driverName);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Bundle bundle = new Bundle();
                bundle.putString(message_key,driverName);

                Intent intent = new Intent(layout.getContext(), passenger_message.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        layout.addView(button);
    }
}
