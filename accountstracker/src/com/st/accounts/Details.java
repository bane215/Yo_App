package com.st.accounts;

import java.util.List;

import com.sqlite.helper.DatabaseHelper;
import com.table.Customer;
import com.table.Transaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Details extends Activity implements OnClickListener {

	Button nextBtn;
	private Button hiddenBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_details);
		nextMethod(); 
	}

	public void nextMethod() {
		nextBtn = (Button) findViewById(R.id.nextBtn);
		nextBtn.setOnClickListener(this);
		hiddenBtn = (Button) findViewById(R.id.hiddenBtn);
		hiddenBtn.setOnClickListener(this);
	
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.nextBtn:

			Intent nextINtent = new Intent(Details.this, AccountNumber.class);
			startActivity(nextINtent);
			finish();
			break;

		case R.id.hiddenBtn:
			
			Customer customer0  = new Customer(1234567890, 70000, "Bhushan", 6027);
			Customer customer1  = new Customer(1234567891, 60000, "Lalit", 6040);
			Customer customer2  = new Customer(1234567892, 40000, "Lakhim", 6039);
			Customer customer3  = new Customer(1234567893, 50000, "Mahir", 6042);
			Customer customer4  = new Customer(1234567894, 55000, "Aanchal", 6001);
			
			Transaction transac0 = new Transaction(1,10000,"2015-05-16 08:23:19",1234567890,1234567891); 
			Transaction transac1 = new Transaction(2,7000,"2015-05-16 08:30:09",1234567894,1234567890);
			Transaction transac2 = new Transaction(3,3000,"2015-05-17 11:15:17",1234567892,1234567893);
			Transaction transac3 = new Transaction(4,8000,"2015-05-17 07:26:13",1234567891,1234567894);
			Transaction transac4 = new Transaction(5,5500,"2015-05-18 05:53:22",1234567894,1234567890);
			Transaction transac5 = new Transaction(6,7000,"2015-05-18 06:05:34",1234567890,1234567894);
			Transaction transac6 = new Transaction(7,4000,"2015-05-19 10:24:11",1234567893,1234567890);
			Transaction transac7 = new Transaction(8,6000,"2015-05-19 08:29:37",1234567891,1234567892);
			Transaction transac8 = new Transaction(9,2000,"2015-05-20 04:24:26",1234567893,1234567893);
			Transaction transac9 = new Transaction(10,5000,"2015-05-20 11:43:18",1234567892,1234567893);
			
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
			databaseHelper.addCustomer(customer0);
			databaseHelper.addCustomer(customer1);
			databaseHelper.addCustomer(customer2);
			databaseHelper.addCustomer(customer3);
			databaseHelper.addCustomer(customer4);
			databaseHelper.addtransaction(transac0);
			databaseHelper.addtransaction(transac1);
			databaseHelper.addtransaction(transac2);
			databaseHelper.addtransaction(transac3);
			databaseHelper.addtransaction(transac4);
			databaseHelper.addtransaction(transac5);
			databaseHelper.addtransaction(transac6);
			databaseHelper.addtransaction(transac7);
			databaseHelper.addtransaction(transac8);
			databaseHelper.addtransaction(transac9);
			Toast.makeText(this, ".", Toast.LENGTH_SHORT).show();
			
			 
			break;

		default:
			break;
		}

	}

}
