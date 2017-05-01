package com.st.accounts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivate extends Activity{
	
	private TextView tv ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help_activate);
		
		tv = (TextView) findViewById(R.id.help_activate_textView);
	}

}
