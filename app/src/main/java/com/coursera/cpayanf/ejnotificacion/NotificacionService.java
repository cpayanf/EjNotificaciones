package com.coursera.cpayanf.ejnotificacion;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by cpayan on 06/03/18.
 */

public class NotificacionService extends FirebaseMessagingService {

	@Override
	public void onMessageReceived(RemoteMessage remoteMessage) {
		String lsMensaje;
		lsMensaje ="De: " + remoteMessage.getFrom();
		lsMensaje += ". Msj:" + remoteMessage.getNotification().getBody();
		Intent myIntent = new Intent(this, MainActivity.class);
		PendingIntent myPendingInt = PendingIntent.getActivity(this, 0, myIntent, PendingIntent.FLAG_ONE_SHOT);

		Uri NotifSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

		NotificationCompat.Builder myNotif = new NotificationCompat.Builder(this)
				.setSmallIcon(R.mipmap.ic_launcher)
				.setContentTitle("Atencion")
				.setContentText(lsMensaje)
				.setSound(NotifSound)
				.setContentIntent(myPendingInt)
				.setAutoCancel(true);

		NotificationManager myNotifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		myNotifManager.notify(0, myNotif.build());
	}
}
