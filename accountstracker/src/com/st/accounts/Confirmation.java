package com.st.accounts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.util.MySharedPref;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Confirmation extends Activity implements OnClickListener {

	private TextView textView_fromAccn;
	private TextView textView_ToAccn;
	private TextView textView_date;
	private TextView textView_transfamt;
	private Button btn_proceed;
	private Button btn_cancel;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirmation);
		initView();
	}

	private void initView() {
		textView_fromAccn = (TextView) findViewById(R.id.tview_fromAccn);
		textView_fromAccn.setText("From Account:"
				+ MySharedPref.getInstance(this).getString("account_number")
						.toString());

		textView_ToAccn = (TextView) findViewById(R.id.tview_toacc);
		textView_ToAccn.setText("To Account:"
				+ MySharedPref.getInstance(this).getString("to_accnt")
						.toString());

		String current_date = getDateTime();
		MySharedPref.getInstance(this).setString("transfer_date", current_date);
		textView_date = (TextView) findViewById(R.id.tview_date);
		textView_date.setText("Date: " + current_date);

		textView_transfamt = (TextView) findViewById(R.id.tview_transfamt);
		textView_transfamt.setText("Amount: "
				+ MySharedPref.getInstance(this).getString("trans_amt")
						.toString());

		btn_proceed = (Button) findViewById(R.id.proceed);
		btn_proceed.setOnClickListener(this);

		btn_cancel = (Button) findViewById(R.id.cancel);
		btn_cancel.setOnClickListener(this);

	}

	private String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = new Date();
		return dateFormat.format(date);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.proceed:
            startActivity(new Intent(this, AtmPin.class));
            finish();
            break;

		case R.id.cancel:
			startActivity(new Intent(this, CustomerName.class));
			finish();
			break;
		default:
			break;
		}

	}

}
