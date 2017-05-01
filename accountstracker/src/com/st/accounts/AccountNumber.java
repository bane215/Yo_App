package com.st.accounts;

import java.util.List;

import com.sqlite.helper.DatabaseHelper;
import com.table.Customer;
import com.util.MySharedPref;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AccountNumber extends Activity implements OnClickListener {
	private Button nextBtn;
	private EditText ac_editText;
	private long col1;
	private double col2;
	private String col3;
	private String col4;
	private int col5;
	private long enterAccNo;

	@Override
	protected void onCreate(Bundle b) {

		super.onCreate(b);
		setContentView(R.layout.layout_accountnumber);
		acntNo();
	}

	public void acntNo() {
		nextBtn = (Button) findViewById(R.id.nextBtn);
		nextBtn.setOnClickListener(this);
		ac_editText = (EditText) findViewById(R.id.ac_editText);

	}
	
	public void saveCustomer(String s1) {

		DatabaseHelper databaseHelper = new DatabaseHelper(this);

		long long_s1 = Long.parseLong(s1);

		Cursor cursor = databaseHelper.getCustomer(long_s1);

		if (cursor != null) {
			cursor.moveToFirst();
			Customer customer = new Customer(
					Long.parseLong(cursor.getString(0)),
					Double.parseDouble(cursor.getString(1)),
					cursor.getString(2),cursor.getString(3),
					Integer.parseInt(cursor.getString(4)));

			col1 = customer.getAccount_no();
			col2 = customer.getCurr_bal();
			col3 = customer.getCur_name();
			col4 = customer.getLogin_pin();
			col5 = customer.getAtm_pin();
			
			MySharedPref.getInstance(this).setString("activate_atm_pin",col5+"");
			
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.nextBtn:
			DatabaseHelper databaseHelper = new DatabaseHelper(this);
			List<Customer> allcustomer = databaseHelper.getAllAccountNo();
			
			MySharedPref.getInstance(this).setString("PinCreateAccountNo",
					ac_editText.getText().toString());

			if (ac_editText.getText().length() == 0) {
				ac_editText.setError("Account Number can't be blank!");
			} 
			else {
				enterAccNo = Long.parseLong(ac_editText.getText()
						.toString());
				int flag=0;
				for (Customer customerObj : allcustomer) {
					    if (enterAccNo == customerObj.getAccount_no()) {
						flag++;
					}
				}
				
				if (flag==1) {
	
						saveCustomer(enterAccNo+"");
						
						Intent acntNoIntent = new Intent(AccountNumber.this,
								AtmLoginPin.class);
						startActivity(acntNoIntent);
						finish();
						
				} 
				else {
						ac_editText.setError("Account Number doesn't exist!!");
					}
				}
			

			break;

		default:
			break;
		}
		
		}
	}


