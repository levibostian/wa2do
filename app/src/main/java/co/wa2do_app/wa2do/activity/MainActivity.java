package co.wa2do_app.wa2do.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import co.wa2do_app.wa2do.R;
import co.wa2do_app.wa2do.application.Wa2DoApplication;
import co.wa2do_app.wa2do.fragment.EventFragment;
import co.wa2do_app.wa2do.fragment.SwipeFragment;
import co.wa2do_app.wa2do.util.UserUtil;

import javax.inject.Inject;

public class MainActivity extends Activity {

    @Inject UserUtil mUserUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Wa2DoApplication.inject(this);

        setupFragment();
    }

    private void setupFragment() {
        if (!mUserUtil.isUserBrowsedTopics()) {
            getFragmentManager().beginTransaction().add(R.id.fragment_container, SwipeFragment.newInstance()).commit();
        } else {
            getFragmentManager().beginTransaction().add(R.id.fragment_container, EventFragment.newInstance()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_reset:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, SwipeFragment.newInstance()).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
