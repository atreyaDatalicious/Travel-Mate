package tie.hackathon.travelguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

import butterknife.ButterKnife;

public class Checklist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new ChecklistFragment();
        fragmentManager.beginTransaction().replace(R.id.inc, fragment).commit();

        setTitle("Check List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        DataLayer dataLayer = TagManager.getInstance(Checklist.this).getDataLayer();
        dataLayer.pushEvent("openScreen", DataLayer.mapOf("screenName", "ChecklistPage"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //menu item selected
        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
