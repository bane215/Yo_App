package com.st.accounts;

import java.util.List;

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

public class AtmPin extends Activity implements OnClickListener{
	
	private Button btn;
	private Button btn_nextBtnPin;
	private EditText editText_atmpin;
	private String s_atm;  
	private int int_atm;
	private int int_atmpin;
	private String str_curBal;
	
	private String str_transferAmt;
	
	private double dou_curBal;
	private double dou_transferAmt;
	private double updated_bal_from;
	private long long_acn_from;
	private long long_acn_To;
	private String to_acn_curBAl;
	
	private double updated_bal_to;
	private double dou_toacn_CURBAL;
	
		
		protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_atm_pin);
		btn_nextBtnPin = (Button) findViewById(R.id.nextBtnPin);
		btn_nextBtnPin.setOnClickListener(this);
		editText_atmpin = (EditText)findViewById(R.id.edit_atmpin);
		s_atm = MySharedPref.getInstance(this).getString("atm_pin");
		
	    int_atm = Integer.parseInt(s_atm);
	    String acn_from =  MySharedPref.getInstance(this).getString("account_number").toString();
	     long_acn_from = Long.parseLong(acn_from); 
	    String acn_TO = MySharedPref.getInstance(this).getString("to_accnt");
	    long_acn_To = Long.parseLong(acn_TO);
		
	}

		public void check(int int_atmpin2, int int_atm2){
			if(int_atmpin2 != int_atm2)
			{
				editText_atmpin.setError("Please enter a valid pin");
			}
			
			else{
				
				if(dou_curBal<dou_transferAmt)
				{
					startActivity(new Intent(this,TransferDetails.class));
					finish();
				}
				
				else
				{
				updated_bal_from = dou_curBal - dou_transferAmt;
				updated_bal_to = dou_toacn_CURBAL + dou_transferAmt;
				
				
				Customer customer = new Customer(updated_bal_from,long_acn_from);
				
				DatabaseHelper db = new DatabaseHelper(this);
				db.updateCustomer(customer);
				Customer customer2 = new Customer(updated_bal_to, long_acn_To);
				db.updateCustomer(customer2);
			    double trans_amt = Double.parseDouble(MySharedPref.getInstance(this).getString("trans_amt").toString());
			    String transfer_date = MySharedPref.getInstance(this).getString("transfer_date");
			    long from_accountNo = Long.parseLong(MySharedPref.getInstance(this).getString("account_number").toString());
				long to_accountNo = Long.parseLong(MySharedPref.getInstance(this).getString("to_accnt").toString());
				Transaction transaction = new Transaction(trans_amt, transfer_date, to_accountNo, from_accountNo);
				db.addtransaction(transaction);
			
				startActivity(new Intent(this,TransferDetails.class));
				finish();
				}
			}
		}
	
	@Override
	public void onClick(View v) {
		str_curBal =  MySharedPref.getInstance(this).getString("customer_balance");
	    dou_curBal = Double.parseDouble(str_curBal);
	    str_transferAmt = MySharedPref.getInstance(this).getString("trans_amt").toString();
	    dou_transferAmt = Double.parseDouble(str_transferAmt);
	    to_acn_curBAl =  MySharedPref.getInstance(this).getString("to_acn_currbal");
	    dou_toacn_CURBAL = Double.parseDouble(to_acn_curBAl);
	  
	   
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

