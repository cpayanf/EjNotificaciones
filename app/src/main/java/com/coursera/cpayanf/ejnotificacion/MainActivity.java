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
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void CrearNotificacion(View v)
	{
		String lsToken = FirebaseInstanceId.getInstance().getToken();

		enviarToken(lsToken);
	}

	private void enviarToken(String psToken)
	{
		Toast.makeText(this, psToken, Toast.LENGTH_SHORT).show();
	}
}
