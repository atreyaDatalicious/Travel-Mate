package Analytics;

import android.content.Context;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

import tie.hackathon.travelguide.login.LoginActivity;

/**
 * Created by apple on 26/04/18.
 */

public class GTM {

//    clicks
//    screenviews
//    events
//    custom dimenetions
//    custom matric

    public static void pushOpenScreenEvent(Context context, String screenName) {
        DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();
        dataLayer.pushEvent("openScreen", DataLayer.mapOf("screenName", screenName));

    }

    public static  void pushEvent(Context context,String eventName ){
        DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();
        dataLayer.pushEvent(eventName, DataLayer.mapOf("screenName", "LoginScreen"));

    }

    public static void pushCustomDiemention(Context context,String customDimenationName,String value){
        DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();

        String dimensionValue = "SOME_DIMENSION_VALUE";
//        dataLayer.set(Fields.customDimension(6), dimensionValue);
    }





}
