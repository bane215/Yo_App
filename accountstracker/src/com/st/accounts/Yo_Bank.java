package com.st.accounts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews.ActionException;

@SuppressWarnings("unused")
public class Yo_Bank extends Activity implements OnClickListener {
	Button activate, login, help, locate_us, apply_now;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_yo_bank);

		initMethod();

	}

	private void initMethod() {
		activate = (Button) findViewById(R.id.activateBtn);
		login = (Button) findViewById(R.id.loginBtn);
		help = (Button) findViewById(R.id.helpBtn);
		locate_us = (Button) findViewById(R.id.locate_usBtn);
		apply_now = (Button) findViewById(R.id.apply_nowBtn);

		activate.setOnClickListener(this);
		login.setOnClickListener(this);
		help.setOnClickListener(this);
		locate_us.setOnClickListener(this);
		apply_now.setOnClickListener(this);

	}

	
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.activateBtn:

			Intent activateIntent = new Intent(Yo_Bank.this, Details.class);
			startActivity(activateIntent);

			break;

		case R.id.loginBtn:

			Intent loginIntent = new Intent(Yo_Bank.this, LoginDetails.class);
			startActivity(loginIntent);
			break;

		case R.id.helpBtn:

			Intent helpIntent = new Intent(Yo_Bank.this, HelpPage.class);
			startActivity(helpIntent);
			break;

		case R.id.locate_usBtn:
			
			Intent locateIntent = new Intent(Yo_Bank.this, ContactDetails.class);
			startActivity(locateIntent);
			break;
			
		case R.id.apply_nowBtn:
			
			Intent applyIntent = new Intent(Yo_Bank.this, ApplyNow.class);
			startActivity(applyIntent);
			break;

		default:
			break;
		}
	}

}
