package com.st.accounts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Apply extends Activity implements OnClickListener{
	
	private EditText et1;
	private EditText et2;
	private EditText et3;
	private EditText et4;
	private Button btn_apl;

	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apply);
	initB();
	}
	
	
	
	private void initB() {
		btn_apl = (Button) findViewById(R.id.apply);
		btn_apl.setOnClickListener(this);
		
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		et1 = (EditText) findViewById(R.id.apply_edt1);
		et2 = (EditText) findViewById(R.id.apply_edt2);
		et3 = (EditText) findViewById(R.id.apply_edt3);
		et4 = (EditText) findViewById(R.id.apply_edt4);
		
		
		if(et1.getText().length()!=10)
		{
			et1.setError("Mobile number must be ten digit long!"); 
		}
		else if(et2.getText().length()==0)
		{
			et2.setError("Name can not be left blank!"); 
		}
		else if(et3.getText().length()==0)
		{
			et3.setError("City can not be left blank!"); 
		}
		else if(et4.getText().length()==0)
		{
			et4.setError("Age can not be left blank!"); 
		}
		else
		{
			Toast.makeText(this, "Our executives will contact you in the next 24 hours.", Toast.LENGTH_LONG).show();
			Intent home = new Intent(Apply.this, Yo_Bank.class);
			startActivity(home);
		}
	}

}
