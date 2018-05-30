package tie.hackathon.travelguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import com.eftimoff.androipathview.PathView;

import tie.hackathon.travelguide.login.LoginActivity;

public class Splash extends AppCompatActivity {

    Button openKnoitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().hide();
        openKnoitBtn=(Button)findViewById(R.id.openKnoitBtn);
        openKnoitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getPackageManager().getLaunchIntentForPackage("com.appiness.knoit");

                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setAction("com.appstore.MyBroadcastReceiver");
                    intent.putExtra("from","Sample app");
                    startActivity(intent);
                }
            }
        });


        final PathView pathView = (PathView) findViewById(R.id.pathView);
        pathView.getPathAnimator()
                .delay(1000)
                .duration(1000)
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();

        pathView.useNaturalColors();
        pathView.setFillAfter(true);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
//                Intent i = new Intent(Splash.this, LoginActivity.class);
//                startActivity(i);
//                finish();

            }
        }, 5000);

    }

}
