package com.example.ferhat.planner;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import static android.content.Context.NOTIFICATION_SERVICE;


public class RemaindersListFragment extends Fragment {
    EditText notifContent;
    TimePicker timePicker;
    DatePicker datePicker;
    Button finish;
    Button cancel;
    NotificationManager notificationManager;
    int notifID = 102; //dont matter

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.item_remainder, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        notifContent = (EditText) getActivity().findViewById(R.id.notif_Content);
        timePicker = (TimePicker) getActivity().findViewById(R.id.notif_time);
        datePicker = (DatePicker) getActivity().findViewById(R.id.notif_date);
        finish = (Button) getActivity().findViewById(R.id.notif_finish);
        cancel = (Button) getActivity().findViewById(R.id.notif_cancel);

        finish.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                String notifContentString = notifContent.getText().toString();

                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();

                createNotification(notifContentString);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Home.class);
                startActivity(intent);
            }
        });


    }

    @TargetApi(Build.VERSION_CODES.M)
    public void createNotification (String c){

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getContext())
                        .setSmallIcon(R.drawable.yellowpin)
                        .setContentTitle("My notification")
                        .setContentText(c)
                        .setSmallIcon(R.drawable.yellowpin);
        int mNotificationId = 001;
        NotificationManager mNotifyMgr =
                (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

    }
}