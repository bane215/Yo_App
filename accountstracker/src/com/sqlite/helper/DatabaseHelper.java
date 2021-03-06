package com.sqlite.helper;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import com.table.Customer;
import com.table.Transaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "BankDataBase";
	private static final String TABLE_CUSTOMER = "Customertable";
	private static final String TABLE_TRANSACTION = "Transactiontable";
	private static final int version = 2;
	private static final String KEY_ACCOUNT_NO = "account_no";
	private static final String KEY_CURR_BAL = "curr_bal";
	private static final String KEY_CUR_NAME = "cur_name";
	private static final String KEY_LOGIN_PIN = "login_pin";
	private static final String KEY_ATM_PIN = "atm_pin";
	private static final String KEY_FROM_ACCOUNTNO = "from_accountno";
	private static final String KEY_TO_ACCOUNTNO = "to_accountno";

	private static final String KEY_TRANSAC_ID = "transac_id";
	private static final String KEY_TRANSFER_AMT = "transfer_amt";
	private static final String KEY_TRANSICT_AT = "transict_date";
	
	
	private final String CREATE_TABLE_CUSTOMER = "CREATE TABLE "
            + TABLE_CUSTOMER + "(" + KEY_ACCOUNT_NO + " LONG PRIMARY KEY," + KEY_CURR_BAL
            + " DOUBLE," + KEY_CUR_NAME + " TEXT," + KEY_LOGIN_PIN
            + " INTEGER," + KEY_ATM_PIN + " INTEGER" + ")";
	
	private final String CREATE_TABLE_TRANSACTION = "CREATE TABLE "
            + TABLE_TRANSACTION + "(" + KEY_TRANSAC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_TRANSFER_AMT
            + " DOUBLE," + KEY_TRANSICT_AT + " DATETIME," + KEY_FROM_ACCOUNTNO
            + " LONG,"  + KEY_TO_ACCOUNTNO + " LONG" +")";
	
	

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_CUSTOMER);
		db.execSQL(CREATE_TABLE_TRANSACTION);
		System.out.printf("Create Table Customer", db);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}
	
	 public void addCustomer(Customer customer) {
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_ACCOUNT_NO, customer.getAccount_no());
		values.put(KEY_CURR_BAL, customer.getCurr_bal());
		values.put(KEY_CUR_NAME, customer.getCur_name());
		values.put(KEY_ATM_PIN, customer.getAtm_pin());
		database.insert(TABLE_CUSTOMER, null, values);
		database.close();
	}
	 
	 
	 public void addtransaction(Transaction transaction) {
			SQLiteDatabase database = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			//values.put(KEY_TRANSAC_ID, transaction.getTransac_id()) ;
			values.put(KEY_TRANSFER_AMT, transaction.getTransfer_amt()) ;
			values.put(KEY_TRANSICT_AT, transaction.getTransict_date()) ;
			values.put(KEY_TO_ACCOUNTNO, transaction.getTo_accountNO());
			values.put(KEY_FROM_ACCOUNTNO, transaction.getFrom_accountNo());
			database.insert(TABLE_TRANSACTION, null, values);
			database.close();
		}
	 
	 public List<Customer> getAllAccountNo() {
		 List<Customer> customers = new ArrayList<Customer>();
		 String selectQuery = "SELECT  * FROM " + TABLE_CUSTOMER;
		 
		 SQLiteDatabase db = this.getReadableDatabase();
	        Cursor c = db.rawQuery(selectQuery, null);
	        
	        if (c.moveToFirst()) {
	            do {
	            	Customer cust = new Customer();
	            	cust.setAccount_no(c.getLong((c.getColumnIndex(KEY_ACCOUNT_NO))));
	            	
	            	customers.add(cust);
	            } while (c.moveToNext());
	        }
		return customers;
		
	}
	 
	 public void createPin(int pin, long pinrelatedAcc)
	 {
		 SQLiteDatabase db = this.getWritableDatabase();
		 ContentValues values = new ContentValues();
		
	        values.put(KEY_LOGIN_PIN,pin );
	        db.update(TABLE_CUSTOMER, values, KEY_ACCOUNT_NO+ " = ?",
	                new String[] { String.valueOf(pinrelatedAcc) });
	 }
	 
	public Cursor getCustomer(long account_no) {
			SQLiteDatabase database = this.getReadableDatabase();
			Cursor cursor = database.query(TABLE_CUSTOMER, new String[] { KEY_ACCOUNT_NO,
					KEY_CURR_BAL, KEY_CUR_NAME,KEY_LOGIN_PIN,KEY_ATM_PIN }, KEY_ACCOUNT_NO + "=?",
					new String[] { String.valueOf(account_no) }, null, null, null, null);
			return cursor;

		}
	
	public Transaction getFVtrans(long accnt_no) {
		
		SQLiteDatabase db = getReadableDatabase();
		String selectquery = "SELECT * FROM " + TABLE_TRANSACTION + " WHERE " + KEY_FROM_ACCOUNTNO + " = " + accnt_no;

		Cursor c = db.rawQuery(selectquery, null);
		if(c != null)
		c.moveToFirst();
			
				Transaction transaction = new Transaction();
				transaction.setTransac_id(c.getInt(c.getColumnIndex(KEY_TRANSAC_ID)));
				transaction.setTransfer_amt(c.getDouble(c.getColumnIndex(KEY_TRANSFER_AMT)));
				
			
		
		return transaction;
		
	}
	
	public int updateCustomer(Customer customer) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(KEY_ACCOUNT_NO, customer.getAccount_no());
	    values.put(KEY_CURR_BAL, customer.getCurr_bal());
	 
	    // updating row
	    return db.update(TABLE_CUSTOMER, values, KEY_ACCOUNT_NO + " = ?",
	            new String[] { String.valueOf(customer.getAccount_no()) });
	}
	
	
	public List<Transaction> getAllTransactionByAcc(long accNo) {
	    List<Transaction> list_transactions = new ArrayList<Transaction>();
	 
	    String selectQuery = "SELECT * FROM " + TABLE_TRANSACTION + " WHERE " + KEY_FROM_ACCOUNTNO + " = " + accNo;
	 
	  	 
	    SQLiteDatabase db = this.getReadableDatabase();
	    Cursor c = db.rawQuery(selectQuery, null);
	 
	    
	    if (c.moveToFirst()) {
	        do {
	            Transaction  transaction = new Transaction();
	            transaction.setTransac_id(c.getInt((c.getColumnIndex(KEY_TRANSAC_ID))));
	            transaction.setTransfer_amt(c.getDouble(c.getColumnIndex(KEY_TRANSFER_AMT)));
	            transaction.setTransict_date(c.getString(c.getColumnIndex(KEY_TRANSICT_AT)));
	            transaction.setFrom_accountNo(c.getLong(c.getColumnIndex(KEY_FROM_ACCOUNTNO)));
	            transaction.setTo_accountNO(c.getLong(c.getColumnIndex(KEY_TO_ACCOUNTNO)));
	 
	            // adding to todo list
	            list_transactions.add(transaction);
	        } while (c.moveToNext());
	    }
	 
	    return list_transactions;
	}
	

}
