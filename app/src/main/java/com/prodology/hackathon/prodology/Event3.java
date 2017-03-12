package com.prodology.hackathon.prodology;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by Gadhvi on 12/03/2017.
 */

public class Event3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events3);
        final EditText e1, e2;
        Button b1;
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button);
        final ToggleButton t1 = (ToggleButton) findViewById(R.id.toggleButton);
        CheckBox c1, c2;
        c1 = (CheckBox) findViewById(R.id.checkBox);
        c2 = (CheckBox) findViewById(R.id.checkBox2);

        t1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                result.append("toggleButton: ").append(t1.getText());
                Toast.makeText(Event3.this, result.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tittle = e1.getText().toString().trim();
                NotificationManager notif = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notify = new Notification.Builder
                        (getApplicationContext()).setContentTitle(tittle).setContentText("Prodology Welecomes You").setSmallIcon(R.drawable.ic_menu_gallery).build();

                notify.flags |= Notification.FLAG_AUTO_CANCEL;
                notif.notify(0, notify);

                e1.getText().clear();
                e2.getText().clear();
                Toast.makeText(getApplicationContext(), "Login Done", Toast.LENGTH_SHORT).show();
            }

        });

    }
}
