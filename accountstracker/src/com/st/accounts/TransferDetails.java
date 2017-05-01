package com.st.accounts;

import com.sqlite.helper.DatabaseHelper;
import com.table.Customer;
import com.util.MySharedPref;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TransferDetails extends Activity implements OnClickListener{

	private long col1;
	private Button btn_home;
	private Button btn_service;
	private double col2;
	private String str_curBal;
	private double dou_curBal;
	private Customer customer;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transfer_details);
		TextView textView = (TextView) findViewById(R.id.general_info_tv);
		DatabaseHelper db = new DatabaseHelper(this);
		String s123 = MySharedPref.getInstance(this)
				.getString("account_number");
		long accountno = Long.parseLong(s123);

		btn_home = (Button) findViewById(R.id.home);
		btn_service = (Button) findViewById(R.id.services);
		
		btn_home.setOnClickListener(this);
		btn_service.setOnClickListener(this);
		
		String transfer_AMT = MySharedPref.getInstance(this)
				.getString("trans_amt").toString();
		int tr_amt = Integer.parseInt(transfer_AMT);
		str_curBal = MySharedPref.getInstance(this).getString(
				"customer_balance");
		dou_curBal = Double.parseDouble(str_curBal);

		if (dou_curBal < tr_amt) {
			textView.setText("Transfer Unsuccessful!!\n Not enogh balance!");
		}

		else {
			db.getCustomer(accountno);
			showCustomer(s123);

			textView.setText("Transfer Successful!!\nUpdated amount after transfer is INR "
					+ col2 + "");
			String str1234 = MySharedPref.getInstance(this).getString(
					"to_accnt");
			Long acc_todetail = Long.parseLong(str1234);
			
			showCustomer(str1234);
			db.updateCustomer(customer);
		}
	}

	public void showCustomer(String s123) {

		DatabaseHelper databaseHelper = new DatabaseHelper(this);

		long long_s1 = Long.parseLong(s123);

		Cursor cursor = databaseHelper.getCustomer(long_s1);

		if (cursor != null) {
			cursor.moveToFirst();
			 customer = new Customer(
					Long.parseLong(cursor.getString(0)),
					Double.parseDouble(cursor.getString(1)),
					cursor.getString(2), cursor.getString(3),
					Integer.parseInt(cursor.getString(4)));

			col1 = customer.getAccount_no();
			col2 = customer.getCurr_bal();

		}
	}
	

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub

	switch (v.getId()) {
	case R.id.home:
		startActivity(new Intent(TransferDetails.this,Yo_Bank.class));
		finish();
		break;

    case R.id.services:
		startActivity(new Intent(TransferDetails.this,CustomerName.class));
		finish();
		break;
		
	default:
		break;
	}
}

}
