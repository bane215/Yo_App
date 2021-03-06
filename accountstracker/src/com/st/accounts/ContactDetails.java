package com.st.accounts;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ContactDetails extends Activity implements OnClickListener{
	
	private Button findBtn;
	private Button custBtn;
	
	
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_contact_details);
		initBtn();
		
	}

	private void initBtn() {
		findBtn = (Button) findViewById(R.id.FindBtn);
		custBtn = (Button) findViewById(R.id.custBtn);
		findBtn.setOnClickListener(this);
		custBtn.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		
		
		switch (v.getId()) {
		case R.id.FindBtn:
			final Dialog dialog = new Dialog(this);
			dialog.setContentView(R.layout.dialog_alertdialog);
			dialog.setTitle("Find Branch");
			dialog.show();
			break;

		case R.id.custBtn:
			final Dialog dialog1 = new Dialog(this);
			dialog1.setContentView(R.layout.dialog_layout2);
			dialog1.setTitle("Customer Care");
			dialog1.show();
			break;
		default:
			break;
		}
		
	}

}
