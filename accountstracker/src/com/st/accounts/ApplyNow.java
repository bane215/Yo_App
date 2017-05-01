package com.st.accounts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ApplyNow extends Activity implements OnClickListener {
	private Button btn_yoaccnt;
	private Button btn_homeloan;
	private Button btn_carloan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apply_now);
		initview();

	}

	private void initview() {
		btn_yoaccnt = (Button) findViewById(R.id.yoaccnt);
		btn_yoaccnt.setOnClickListener(this);
		btn_homeloan = (Button) findViewById(R.id.homeloan);
		btn_homeloan.setOnClickListener(this);
		btn_carloan = (Button) findViewById(R.id.carloan);
		btn_carloan.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.yoaccnt:

			Intent accIntent = new Intent(ApplyNow.this, Apply.class);
			startActivity(accIntent);

			break;

		case R.id.homeloan:

			Intent homeIntent = new Intent(ApplyNow.this, Apply.class);
			startActivity(homeIntent);
			break;

		case R.id.carloan:

			Intent carIntent = new Intent(ApplyNow.this, Apply.class);
			startActivity(carIntent);
			break;

		default:
			break;
		}

	}

}
