package com.st.accounts;

import com.util.MySharedPref;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NoOfTrans extends Activity implements OnClickListener{

	private TextView textMaxTrans;
	private EditText edt;
	private Button btNext;
		
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_no_of_trans);

		init();
	}
		private void init() {
		// TODO Auto-generated method stub
			 textMaxTrans = (TextView) findViewById(R.id.inpMaxNo);
			 edt = (EditText) findViewById(R.id.edit_maxTrans);
			 btNext = (Button) findViewById(R.id.nextMaxTrans);
			 btNext.setOnClickListener(this);
	}
		
	
	@Override
	public void onClick(View v) {
		String no_of_trans = edt.getText().toString();
		if(no_of_trans.length() == 0)
		{
			edt.setError("Field can't be empty!");
		}
		else 
		{
			 MySharedPref.getInstance(this).setString("prevTrans", no_of_trans+"");
			 Intent i = new Intent(NoOfTrans.this,LastTransactions.class);
			 startActivity(i);
			 
		}
		
	}

}
