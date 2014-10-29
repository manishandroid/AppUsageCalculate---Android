package com.example.topactivitystack;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity
{
	//private TopActivityReceiver mReceiver;
	//IntentFilter intentFilter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			_CalculateAppTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void _CalculateAppTime() {
		@SuppressWarnings("static-access")
		AlarmManager alarmManager = (AlarmManager) this
				.getSystemService(this.ALARM_SERVICE);
		long when = System.currentTimeMillis();
		Intent intent = new Intent(this, ServiceBase.class);
		PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, 0);
		alarmManager.setRepeating(AlarmManager.RTC, when, 5000, pendingIntent);
	}
}
