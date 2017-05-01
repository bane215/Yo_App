package com.st.accounts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelpPage extends Activity implements OnClickListener {

	protected Button activateBtn, servicesBtn, wcu_Btn, linkDetailBtn,
			termOfUseBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help_page);

		helpInitMethod();
	}

	public void helpInitMethod() {
		activateBtn = (Button) findViewById(R.id.activateBtn);
		servicesBtn = (Button) findViewById(R.id.servicesBtn);
		wcu_Btn = (Button) findViewById(R.id.wcu_Btn);
		linkDetailBtn = (Button) findViewById(R.id.linkDetailBtn);
		termOfUseBtn = (Button) findViewById(R.id.termOfUseBtn);

		activateBtn.setOnClickListener(this);
		servicesBtn.setOnClickListener(this);
		wcu_Btn.setOnClickListener(this);
		linkDetailBtn.setOnClickListener(this);
		termOfUseBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.activateBtn:

			Intent activateIntent = new Intent(HelpPage.this, HelpActivate.class);
			startActivity(activateIntent);
			break;

		case R.id.servicesBtn:

			Intent servicesIntent = new Intent(HelpPage.this, HelpServices.class);
			startActivity(servicesIntent);
			break;

		case R.id.wcu_Btn:

			Intent wcuIntent = new Intent(HelpPage.this, HelpWCU.class);
			startActivity(wcuIntent);
			break;

		case R.id.linkDetailBtn:

			Intent linkDetailIntent = new Intent(HelpPage.this, HelpLinkDetail.class);
			startActivity(linkDetailIntent);
			break;
		case R.id.termOfUseBtn:

			Intent termIntent = new Intent(HelpPage.this, HelpTermOfuse.class);
			startActivity(termIntent);

			break;

		default:
			break;
		}
	}

}
