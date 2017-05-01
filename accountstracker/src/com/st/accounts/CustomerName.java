package com.st.accounts;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.sqlite.helper.DatabaseHelper;
import com.table.Customer;
import com.util.MySharedPref;

public class CustomerName extends Activity implements OnClickListener {
	private Button balEnqBtn, trasacBtn, fundTransBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_name);

		custNameInitMethod();
		TextView textCustomerName = (TextView) findViewById(R.id.txtView_customername);
		String cust = MySharedPref.getInstance(this).getString("customer_name");
		textCustomerName.setText("Hello " + cust);
		
	}

	

	public void custNameInitMethod() {
		balEnqBtn = (Button) findViewById(R.id.balEnqBtn);
		trasacBtn = (Button) findViewById(R.id.trasacBtn);
		fundTransBtn = (Button) findViewById(R.id.fundTransBtn);

		balEnqBtn.setOnClickListener(this);
		trasacBtn.setOnClickListener(this);
		fundTransBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.balEnqBtn:
			Intent balIntent = new Intent(CustomerName.this, BalanceDetails.class);
			startActivity(balIntent);

			break;

		case R.id.trasacBtn:
			Intent trasIntent = new Intent(CustomerName.this, NoOfTrans.class);
			startActivity(trasIntent);

			break;

		case R.id.fundTransBtn:
			Intent fundIntent = new Intent(CustomerName.this, FundTransfer.class);
			startActivity(fundIntent);

			break;

		default:
			break;
		}
	}

}
