package info.yelinhtun.notebook;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static final String NOTE_ID_EXTRA = "info.yelinhtun.notebook.Identifier";
    public static final String NOTE_TITLE_EXTRA = "info.yelinhtun.notebook.Title";
    public static final String NOTE_MESSAGE_EXTRA = "info.yelinhtun.notebook.Message";
    public static final String NOTE_CATEGORY_EXTRA = "info.yelinhtun.notebook.Category";
    public static final String NOTE_FRAGMENT_T0_LOAD_EXTRA = "info.yelinhtun.notebook.FRAGMENT_TO_LOAD";

    public enum FragmentToLaunch { VIEW, EDIT }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
