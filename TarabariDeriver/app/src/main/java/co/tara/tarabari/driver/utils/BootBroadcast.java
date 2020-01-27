package co.tara.tarabari.driver.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import co.tara.tarabari.driver.servise.SendLocationService;


/**
 * Created by Ali on 2/21/2017.
 */

public class BootBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context ctx, Intent intent) {
        ctx.startService(new Intent(ctx, SendLocationService.class));
    }
}
