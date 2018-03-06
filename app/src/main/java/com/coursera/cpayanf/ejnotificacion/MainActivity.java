package com.coursera.cpayanf.ejnotificacion;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void CrearNotificacion(View v)
	{
		Intent myIntent = new Intent(this, MainActivity.class);
		PendingIntent myPendingInt = PendingIntent.getActivity(this, 0, myIntent, PendingIntent.FLAG_ONE_SHOT);

		Uri NotifSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

		NotificationCompat.Builder myNotif = new NotificationCompat.Builder(this)
				.setSmallIcon(R.mipmap.ic_launcher)
				.setContentTitle("Atencion")
				.setContentText("Hay cosas por ver")
				.setSound(NotifSound)
				.setContentIntent(myPendingInt)
				.setAutoCancel(true);

		NotificationManager myNotifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		myNotifManager.notify(0, myNotif.build());
	}
}
