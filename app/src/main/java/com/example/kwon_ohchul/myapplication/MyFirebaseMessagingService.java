package com.example.kwon_ohchul.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String bodyStrFromServer = remoteMessage.getNotification().getBody();


        //Resources res = getResources();

        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.putExtra("notificationId", 9999); //전달할 값
        //PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());

        builder.setContentTitle("상태바 드래그시 보이는 타이틀") // 제목
                .setContentText("상태바 드래그시 보이는 서브타이틀") // 내용
                .setPriority(0) // 중요도
                .setDefaults(Notification.DEFAULT_SOUND); // 노티받는 방법 : 빛, 진동, 사운드

//                .setTicker("상태바 한줄 메시지")
//                .setLargeIcon(BitmapFactory.decodeResource(res, R.mipmap.ic_launcher)) // 왼쪽의 큰 아이콘
//                .setContentIntent(contentIntent)
//                .setAutoCancel(true) // 노티를 유저가 눌렀을때 사라질 것에 대한 여
//                .setWhen(System.currentTimeMillis())
//                .setDefaults(Notification.DEFAULT_ALL)
//                .setSmallIcon(R.mipmap.ic_launcher) // 노티바의 작은 아이콘 설정;



        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            builder.setCategory(Notification.CATEGORY_MESSAGE)
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setVisibility(Notification.VISIBILITY_PUBLIC);
        }

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1234, builder.build());


    }


}
