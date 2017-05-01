package com.st.accounts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelpServices extends Activity{
	
	protected Button locateBtn, applyBtn ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help_services);
		helpServicesInitMethod();
		
	}
	
	public void helpServicesInitMethod()
	{
		locateBtn = (Button) findViewById(R.id.locateBtn);
		applyBtn = (Button) findViewById(R.id.applyBtn);
		
		locateBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent locateIntent = new Intent(HelpServices.this, HelpLocateUs.class);
				startActivity(locateIntent);
			}
		});
		
		applyBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			

				Intent applyIntent = new Intent(HelpServices.this, HelpApplyNow.class);
				startActivity(applyIntent);
				
			}
		});
	}


}
