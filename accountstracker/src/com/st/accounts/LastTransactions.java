package com.st.accounts;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.sqlite.helper.DatabaseHelper;
import com.table.Transaction;
import com.util.MySharedPref;

public class LastTransactions extends Activity {

	private TableLayout tableLayout;
	private ArrayList<String> arr_index;
	private ArrayList<String> arr_transferAmount;
	private ArrayList<String> arr_fromAccount;
	private ArrayList<String> arr_toAccount;
	private ArrayList<String> arr_transactionDate;
	private int maxTrans;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_last_transactions);
		String accntno = MySharedPref.getInstance(this).getString("account_number");
		maxTrans = Integer.parseInt(MySharedPref.getInstance(this).getString("prevTrans"));

		long accnt_no = Long.parseLong(accntno);

		tableLayout = (TableLayout) findViewById(R.id.tbl);
		DatabaseHelper db = new DatabaseHelper(this);
		
	    List<Transaction> tras_list = db.getAllTransactionByAcc(accnt_no);
	    
		arr_index = new ArrayList<String>();
		arr_index.add("Transaction Id");
		arr_transferAmount = new ArrayList<String>();
		arr_transferAmount.add("Transfer Money");
		arr_fromAccount = new ArrayList<String>();
		arr_fromAccount.add("From Account");
		arr_toAccount = new ArrayList<String>();
		arr_toAccount.add("To Account");
		arr_transactionDate = new ArrayList<String>();
		arr_transactionDate.add("Transaction Date");
		
		for(Transaction transaction1 : tras_list) 
		
		{
			arr_index.add(String.valueOf(transaction1.getTransac_id()));
			arr_transferAmount.add(String.valueOf(transaction1.getTransfer_amt()));
			arr_fromAccount.add(String.valueOf(transaction1.getFrom_accountNo()));
			arr_toAccount.add(String.valueOf(transaction1.getTo_accountNO()));
			arr_transactionDate.add(transaction1.getTransict_date());
		}
		
		TableRow defrow = new TableRow(this);
		
		TextView textview_a = new TextView(this);
	    textview_a.setPadding(5, 5, 5, 5);
	    textview_a.setBackgroundResource(R.drawable.textback);
		String ss1 = String.valueOf(arr_index.get(0));
		textview_a.setHeight(80);
		textview_a.setTextSize(20);
		textview_a.setText(ss1);
		
		TextView textView_b = new TextView(this);
		textView_b.setPadding(5, 5, 5, 5);
		String ss2 = String.valueOf(arr_transferAmount.get(0));
		textView_b.setBackgroundResource(R.drawable.textback);
		textView_b.setHeight(80);
		textView_b.setTextSize(20);
		textView_b.setText(ss2);
		
		TextView textView_c = new TextView(this);
		textView_c.setPadding(5, 5, 5, 5);
		String ss3 = arr_fromAccount.get(0);
		textView_c.setBackgroundResource(R.drawable.textback);
		textView_c.setHeight(80);
		textView_c.setTextSize(20);
		textView_c.setText(ss3);
		
		TextView textView_d = new TextView(this);
		textView_d.setPadding(5, 5, 5, 5);
		String ss4 = arr_toAccount.get(0);
		textView_d.setBackgroundResource(R.drawable.textback);
		textView_d.setHeight(80);
		textView_d.setTextSize(20);
		textView_d.setText(ss4);
		
		TextView textView_e = new TextView(this);
		textView_e.setPadding(5, 5, 5, 5);
		String ss5 = arr_transactionDate.get(0);
		textView_e.setBackgroundResource(R.drawable.textback);
		textView_e.setHeight(80);
		textView_e.setTextSize(20);
		textView_e.setText(ss5);
		
		defrow.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		defrow.addView(textview_a);
		defrow.addView(textView_b);
		defrow.addView(textView_c);
		defrow.addView(textView_d);
		defrow.addView(textView_e);
		tableLayout.addView(defrow);
		
		
			for(int i = arr_index.size()-1,j=0; i >0 && j<maxTrans;i--,j++)
			{
								
           TableRow row = new TableRow(this);
			
			TextView textview_Index = new TextView(this);
		    textview_Index.setPadding(5, 5, 5, 5);
		    textview_Index.setBackgroundResource(R.drawable.textback);
			String s1 = String.valueOf(arr_index.get(i));
			
			if(s1==null)
			{
				break;
			}
			
			textview_Index.setHeight(80);
			textview_Index.setTextSize(20);
			textview_Index.setText(s1);
			
			TextView textView_transAmt = new TextView(this);
			textView_transAmt.setPadding(5, 5, 5, 5);
			String s2 = String.valueOf(arr_transferAmount.get(i));
			textView_transAmt.setBackgroundResource(R.drawable.textback);
			textView_transAmt.setHeight(80);
			textView_transAmt.setTextSize(20);
			textView_transAmt.setText(s2);
			
			TextView textView_fromAccn = new TextView(this);
			textView_fromAccn.setPadding(5, 5, 5, 5);
			String s3 = arr_fromAccount.get(i);
			textView_fromAccn.setBackgroundResource(R.drawable.textback);
			textView_fromAccn.setHeight(80);
			textView_fromAccn.setTextSize(20);
			textView_fromAccn.setText(s3);
			
			TextView textView_toAccn = new TextView(this);
			textView_toAccn.setPadding(5, 5, 5, 5);
			String s4 = arr_toAccount.get(i);
			textView_toAccn.setBackgroundResource(R.drawable.textback);
			textView_toAccn.setHeight(80);
			textView_toAccn.setTextSize(20);
			textView_toAccn.setText(s4);
			
			TextView textView_trasDate = new TextView(this);
			textView_trasDate.setPadding(5, 5, 5, 5);
			String s5 = arr_transactionDate.get(i);
			textView_trasDate.setBackgroundResource(R.drawable.textback);
			textView_trasDate.setHeight(80);
			textView_trasDate.setTextSize(20);
			textView_trasDate.setText(s5);
			
			row.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
			row.addView(textview_Index);
			row.addView(textView_transAmt);
			row.addView(textView_fromAccn);
			row.addView(textView_toAccn);
			row.addView(textView_trasDate);
			tableLayout.addView(row);	
			
		}
		}
		
	}


