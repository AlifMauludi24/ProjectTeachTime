package id.sch.smktelkom_mlg.project.xirpl202112029.projectta;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    final static int req = 1;
    Button btStart;
    TextView promptID;
    TimePickerDialog timePickerYeah;
    MediaPlayer mediaPlayer;
    TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            Calendar calNow = Calendar.getInstance();
            Calendar calSet = (Calendar) calNow.clone();

            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);

            if (calSet.compareTo(calNow) <= 0) {
                calSet.add(Calendar.DATE, 1);
            }

            setAlarm(calSet);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        Button btnJwl = (Button) findViewById(R.id.buttonJadwal);
        btnJwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), TabelActivity.class);
                startActivity(i);
            }
        });

        promptID = (TextView) findViewById(R.id.promptID);
        btStart = (Button) findViewById(R.id.btSet);

        btStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptID.setText("");
                openTimePicker(false);
            }
        });
    }

    private void openTimePicker(boolean is24jam) {
        Calendar kalender = Calendar.getInstance();
        timePickerYeah = new TimePickerDialog(
                MainActivity.this,
                timeSetListener,
                kalender.get(Calendar.HOUR_OF_DAY),
                kalender.get(Calendar.MINUTE),
                true);

        timePickerYeah.setTitle("Atur Waktu Mengajar Anda");
        timePickerYeah.show();
    }

    private void setAlarm(Calendar targetCal) {
        mediaPlayer.start();
        promptID.setText("\n\n" + "Waktu Mengajar Anda : " + targetCal.getTime());

        Intent intent = new Intent(getBaseContext(), ReceiverYeah.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), req, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
    }
}



