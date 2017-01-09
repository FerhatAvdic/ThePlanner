package com.example.ferhat.planner;

import android.app.Fragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static android.content.Context.NOTIFICATION_SERVICE;


public class RemaindersListFragment extends Fragment {
    EditText notifContent;
    EditText notifTitle;
    Button finish;
    Button cancel;
    private static String notifTitleString="nothing";
    private static String notifContentString="nothing";
    int mNotificationId = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.item_remainder, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        notifContent = (EditText) view.findViewById(R.id.edit_notif_content);
        notifTitle = (EditText) view.findViewById(R.id.edit_notif_title);
        finish = (Button) view.findViewById(R.id.notif_finish);
        cancel = (Button) view.findViewById(R.id.notif_cancel);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);


        notifContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                notifContentString = s.toString();
            }
        });

        notifTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                notifTitleString = s.toString();
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNotificationId++;
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(getActivity())
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle(notifTitleString)
                                .setContentText(notifContentString);
                Intent notificationIntent = new Intent(getActivity(), NotificationDetails.class);
                PendingIntent contentIntent = PendingIntent.getActivity(getActivity(), 0, notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(contentIntent);

                NotificationManager mNotifyMgr =
                        (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);
                mNotifyMgr.notify(mNotificationId, mBuilder.build());
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });


    }


}