package com.coursera.cpayanf.ejnotificacion;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by cpayan on 06/03/18.
 */

public class InstanceIDService extends FirebaseInstanceIdService {
	@Override
	public void onTokenRefresh() {
		String refreshedToken = FirebaseInstanceId.getInstance().getToken();
		enviarToken(refreshedToken);
	}

	private void enviarToken(String psToken)
	{
		//
	}

}
