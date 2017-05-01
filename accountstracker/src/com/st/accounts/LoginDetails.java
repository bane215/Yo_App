package com.st.accounts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sqlite.helper.DatabaseHelper;
import com.table.Customer;
import com.util.MySharedPref;

public class LoginDetails extends Activity implements OnClickListener {

	private Button logBtn;
	private EditText tv1;
	private EditText tv2;
	private long col1;
	private double col2;
	private String col3;
	private String col4;
	private int col5;
	private long long_tv1;

	private int int_tv2;
	private String s1;
	private List<Customer> allcustomer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_details);

		LoginDetailsInitMethod();

	}

	public void LoginDetailsInitMethod() {
		tv1 = (EditText) findViewById(R.id.ld_editText1);

		tv2 = (EditText) findViewById(R.id.ld_editText2);

		logBtn = (Button) findViewById(R.id.login_detail_Btn);
		logBtn.setOnClickListener(this);

	}

	public void showCustomerName(String s1) {

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
			
		}

	}

	
	
	public int checkacc(String s1) {
        long l = Long.parseLong(s1);
		DatabaseHelper databaseHelper = new DatabaseHelper(this);
		allcustomer = databaseHelper.getAllAccountNo();
        int flag = 0;
		for (Customer customerObj : allcustomer) {
			if (l == customerObj.getAccount_no()) {
				flag++;
			} 
		}
		return flag;

	}
	

	@Override
	public void onClick(View v) {
		
		String stv1 = tv1.getText().toString();
		String stv2 = tv2.getText().toString();
		if(stv1.length() == 0 )
		{
			tv1.setError("Please enter the account number!");
		}
		else if(checkacc(stv1)== 0)
		{
			tv1.setError("This account does not exist!");
		}

		else if (checkacc(stv1)!= 0)
		{
			Toast.makeText(this, "This account exists!",Toast.LENGTH_LONG).show();
			showCustomerName(stv1);
			MySharedPref.getInstance(this).setString("customer_balance", col2+"");
			MySharedPref.getInstance(this).setString("customer_name", col3);
			MySharedPref.getInstance(this).setString("account_number", col1+"");
			MySharedPref.getInstance(this).setString("atm_pin", col5 +"");
			if(col4 == null )
			{
				tv2.setError("Create login pin! ");
			}
			else if(!col4.equals(stv2) )
			{
				tv2.setError("Enter correct login pin! ");
			}
			else if(col4.equals(stv2))
			{
					
				startActivity(new Intent(this, CustomerName.class));
				finish();
			}
		}
		
	}
}
