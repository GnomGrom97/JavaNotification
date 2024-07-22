package com.example.javanotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //уведомление
        NotificationChannel channel =null ;
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O) {
         channel =new NotificationChannel(
                 "TEST_CHANNEL",
                 "TEST_DESCRIPTION",
                NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
            Notification notification= new NotificationCompat.Builder(this, "TEST_CHANNEL")
                    //строки с  отображением информации
                    .setContentTitle("Эй овощь")
                    .setContentText("У тебя новое сообщение")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .build();
            notificationManager.notify(42, notification);
            }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}