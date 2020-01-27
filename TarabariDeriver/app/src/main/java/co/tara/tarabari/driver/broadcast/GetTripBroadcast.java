package co.tara.tarabari.driver.broadcast;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import co.tara.tarabari.driver.Config;
import co.tara.tarabari.driver.R;
import co.tara.tarabari.driver.activity.MainActivity;
import co.tara.tarabari.driver.model.TripRES;
import co.tara.tarabari.driver.state.StateOfDriver;

/**
 * Created by jalalnia on 5/17/2017.
 */

public class GetTripBroadcast extends BroadcastReceiver {
    TripRES tripRES = null;

    @Override
    public void onReceive(Context context, Intent intent2) {

        if (intent2 != null) {

           tripRES = (TripRES) intent2.getExtras().getSerializable("TRIP");

        }

/*        Intent myIntent =new Intent();
        intent.setClassName("co.tara.tarabari.driver.activity", "co.tara.tarabari.driver.activity.ReciveTripActivity");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(myIntent);*/




    if(Config.inMain) {
        StateOfDriver.goToState1(tripRES);
    }

    else {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context);

//Create the intent that’ll fire when the user taps the notification//

        Intent intent = new Intent(context, MainActivity.class);

        intent.putExtra("TRIP", tripRES);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle("My notification");
        mBuilder.setContentText("Hello World!");
        mBuilder.setSound(alarmSound);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager =

                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(001, mBuilder.build());

    }
    }
}
