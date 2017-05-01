package com.st.accounts;

import com.sqlite.helper.DatabaseHelper;
import com.util.MySharedPref;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePin extends Activity implements OnClickListener {
	private Button crtBtn;
	private EditText et1, et2;
	private DatabaseHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_pin);

		createPinMeth();
	}

	public void createPinMeth() {
		crtBtn = (Button) findViewById(R.id.create_pin_Btn);
		crtBtn.setOnClickListener(this);
		et1 = (EditText) findViewById(R.id.cp_editText1);
		et2 = (EditText) findViewById(R.id.cp_editText2);
		db = new DatabaseHelper(this);

	}

	@Override
	public void onClick(View v) {
		String ed1_val = et1.getText().toString();
		String ed2_val = et2.getText().toString();

		if (ed1_val.length()!= 4) {
			Toast.makeText(this, " PIN should be four digit long!", Toast.LENGTH_SHORT)
			.show();
		}

		else {
			if (ed1_val.equals(ed2_val)) {
				
				int pin = Integer.parseInt(et1.getText().toString());
				String PinCreateAccountNo = MySharedPref.getInstance(this)
						.getString("PinCreateAccountNo");
				long pinrelatedAcc = Long.parseLong(PinCreateAccountNo);
				db.createPin(pin, pinrelatedAcc);
				Toast.makeText(this, "Login Pin created successfully!", Toast.LENGTH_SHORT).show();
				
				
				Intent pinSuccess = new Intent(CreatePin.this, Yo_Bank.class);
				startActivity(pinSuccess);
				finish();
			} 
			else {
				Toast.makeText(this, "Both values do not match!", Toast.LENGTH_SHORT)
						.show();
			}
		}

	}

}

