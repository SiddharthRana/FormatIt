package lib.siddharth.formatit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import lib.siddharth.formatitlib.FormatIt;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtView = findViewById(R.id.txtView);
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        String changeFormatStr = FormatIt.changeFormat("1999/08/18", "yyyy/MM/dd", "dd-MM-yyyy");
        Log.d("changeFormat", changeFormatStr);

        String changeTimeZone = FormatIt.changeTimeZone("1999-08-18 12:00", "+5.30",
            "yyyy-MM-dd hh:mm", "dd-MM-yyyy 10:46");
        Log.d("changeTimeZone", changeTimeZone);

        String changeZone = FormatIt.changeTimeZone("1999-08-18 10:46", "+5.30",
            "yyyy-MM-dd hh:mm");
        Log.d("changeZone", changeZone);
    }
}
