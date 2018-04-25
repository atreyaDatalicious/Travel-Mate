package tie.hackathon.travelguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectModeOfTransport extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.car)     LinearLayout car;
    @BindView(R.id.train)   LinearLayout train;
    @BindView(R.id.bus)     LinearLayout bus;
    DataLayer dataLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mode_of_transport);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        car.setOnClickListener(this);
        train.setOnClickListener(this);
        bus.setOnClickListener(this);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Select Mode of Transport");
        dataLayer = TagManager.getInstance(SelectModeOfTransport.this).getDataLayer();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void onResume() {
        super.onResume();
        dataLayer.pushEvent("openScreen", DataLayer.mapOf("screenName", "SelectModeOfTransportPage"));

    }
    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.car:
                dataLayer.pushEvent("ClickedOn", DataLayer.mapOf("element", "CarInTransport"));
                i = new Intent(SelectModeOfTransport.this, CarDirections.class);
                startActivity(i);
                break;
            case R.id.bus:
                dataLayer.pushEvent("ClickedOn", DataLayer.mapOf("element", "BusInTransport"));
                i = new Intent(SelectModeOfTransport.this, BusList.class);
                startActivity(i);
                break;
            case R.id.train:
                dataLayer.pushEvent("ClickedOn", DataLayer.mapOf("element", "TrainInTransport"));
                i = new Intent(SelectModeOfTransport.this, TrainList.class);
                startActivity(i);
                break;
        }
    }
}
