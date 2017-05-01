package com.st.accounts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class SplashActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
			Intent splashIntent = new Intent(SplashActivity.this, Yo_Bank.class);
			startActivity(splashIntent);
			finish();
				
			}
		}, 3000);
	}

	

}
