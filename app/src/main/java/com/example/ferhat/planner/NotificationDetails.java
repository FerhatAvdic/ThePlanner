package com.example.ferhat.planner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationDetails extends Activity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.n_details);

        btn = (Button) findViewById(R.id.btn_details_back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
