package id.sch.smktelkom_mlg.project.xirpl202112029.projectta;

/**
 * Created by nofita on 11/20/2016.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiverYeah extends BroadcastReceiver
{
    @Override
    public void onReceive(Context c, Intent arg1)
    {
        Toast.makeText(c, "Waktu Mengajar Anda Telah Tiba", Toast.LENGTH_LONG).show();
    }
}
