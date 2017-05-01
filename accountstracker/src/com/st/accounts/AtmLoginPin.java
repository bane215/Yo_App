package com.st.accounts;

import com.sqlite.helper.DatabaseHelper;
import com.table.Customer;
import com.table.Transaction;
import com.util.MySharedPref;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AtmLoginPin extends Activity implements OnClickListener {
	
	private Button btn_nextBtnPin;
	private EditText editText_atmpin;
	private String s_atm;
	private int int_atm;
	private int int_atmpin;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_atm_login_pin);
		
		btn_nextBtnPin = (Button) findViewById(R.id.next2BtnPin);
		btn_nextBtnPin.setOnClickListener(this);
		editText_atmpin = (EditText)findViewById(R.id.edit_atmloginpin);
		
		s_atm = MySharedPref.getInstance(this).getString("activate_atm_pin");
		int_atm = Integer.parseInt(s_atm);
	    
	}

		public void check(int int_atmpin2, int int_atm2){
			if(int_atmpin2 != int_atm2)
			{
				editText_atmpin.setError("Please enter a valid pin!");
			}
			
			else
			{
				startActivity(new Intent(AtmLoginPin.this,CreatePin.class)); 
				finish();
			}
				}
		
	
	@Override
	public void onClick(View v) {
		
		String atm_pin = editText_atmpin.getText().toString();
		if(atm_pin.length() == 0)
		{
			editText_atmpin.setError("Please enter the atm pin!");
		}
		else 
		{
			 int_atmpin = Integer.parseInt(atm_pin);
			 check(int_atmpin,int_atm);
		}
		
	
		
	}

}

