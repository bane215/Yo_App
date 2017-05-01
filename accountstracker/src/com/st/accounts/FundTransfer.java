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
import android.widget.TextView;
import android.widget.Toast;

public class FundTransfer extends Activity implements OnClickListener {
	private TextView tv1, tv2;
	private Button transBtn;
	private long col1;
	private double col2;
	private String col3;
	private String col4;
	private int col5;
	private long long_SourceAcn;
	private List<Customer> allcustomer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fund_transfer);
		FundTransferInitMethod();
	}

	public void FundTransferInitMethod() {
		tv1 = (TextView) findViewById(R.id.ft_editText1);
		tv2 = (TextView) findViewById(R.id.ft_editText2);
		transBtn = (Button) findViewById(R.id.transferBtn);
		transBtn.setOnClickListener(this);
		String source_acn = MySharedPref.getInstance(this).getString("account_number");
		//Toast.makeText(this, source_acn +"", Toast.LENGTH_SHORT).show();
		long_SourceAcn = Long.parseLong(source_acn);
	}
	
	public void showCustomer(String s1) {

		DatabaseHelper databaseHelper = new DatabaseHelper(this);
		
		long long_s1 = Long.parseLong(s1);

		Cursor cursor = databaseHelper.getCustomer(long_s1);

		if (cursor != null){
			cursor.moveToFirst();
		Customer customer = new Customer(Long.parseLong(cursor.getString(0)),
				Double.parseDouble(cursor.getString(1)), cursor.getString(2),
				cursor.getString(3), Integer.parseInt(cursor
						.getString(4)));
      
		col1 = customer.getAccount_no();
		col2 = customer.getCurr_bal();
		
		
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

		switch (v.getId()) {

		case R.id.transferBtn:

			if (tv1.getText().toString().length() == 0) {
				tv1.setError("Account number can not be blank!");
			} else if (tv2.getText().toString().length() == 0) {
				tv2.setError("Amount can not be blank!");
				
			}
			else if(long_SourceAcn == Long.parseLong(tv1.getText().toString()))
			{
				tv1.setError("Source and destination account can't be same!");
			}
			else if(checkacc(tv1.getText().toString())== 0)
			{
				tv1.setError("No such account exists!");
			}
			else {
				String str_toacn_no = tv1.getText().toString();
				String str_transfAmt = tv2.getText().toString();
				
				MySharedPref.getInstance(this).setString("to_accnt", str_toacn_no);
				MySharedPref.getInstance(this).setString("trans_amt", str_transfAmt);
				
				
				showCustomer(str_toacn_no);
				MySharedPref.getInstance(this).setString("to_acn_currbal", col2+"");
                Intent transIntent = new Intent(FundTransfer.this,Confirmation.class);
				startActivity(transIntent);
				finish();
			}
			break;

		default:

		}

	}
}
