package id.sch.smktelkom_mlg.project.xirpl202112029.projectta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnJwl = (Button) findViewById(R.id.buttonJadwal);
        btnJwl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), TabelActivity.class);
                startActivity(i);
            }
        });
    }
}
