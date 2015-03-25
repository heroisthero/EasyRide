package slickstring.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class role_select extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_select);
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
        startActivity( new Intent(this, edit_profile.class));
    }

    public void amDriver(View view){
        startActivity( new Intent(this, waiting.class));
    }

    public void amPassenger(View view){
        startActivity( new Intent(this, list_drivers.class));
    }
}
