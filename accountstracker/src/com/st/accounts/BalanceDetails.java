package com.st.accounts;

import com.sqlite.helper.DatabaseHelper;
import com.table.Customer;
import com.util.MySharedPref;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class BalanceDetails extends Activity{
	
	private Customer customer;
	private long col1;
	private double col2;
	private String login_account;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_balance_details);
		login_account = MySharedPref.getInstance(this)
				.getString("account_number");
		TextView textbalance = (TextView)findViewById(R.id.fetch_bal_textView);
		showCustomer(login_account);
		textbalance.setText("The current amount balance available in your account is INR " +col2);
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

}
