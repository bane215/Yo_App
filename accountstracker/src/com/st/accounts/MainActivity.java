package com.st.accounts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.sqlite.helper.DatabaseHelper;

public class MainActivity extends Activity implements OnClickListener{
	
	Button threeDButton ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		threeDButton = (Button) findViewById(R.id.three_D_button);
		threeDButton.setOnClickListener(this);
		initMethod();
	}

	private void initMethod() {
		
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.three_D_button:
			
			Intent i = new Intent(MainActivity.this, Yo_Bank.class);
			startActivity(i);
			break;

		default:
			break;
		}
		
	}

}
