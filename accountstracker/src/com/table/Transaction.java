package com.table;

public class Transaction {
	int transac_id;
	double transfer_amt;
	String transict_date;
	long from_accountNo;
	long to_accountNO;
	
	

	public Transaction(int transac_id, double transfer_amt, String transict_date, long to_accountNo, long from_accountNo)
	{
		this.transac_id=transac_id;
		this.transfer_amt=transfer_amt;
		this.transict_date=transict_date;
		this.from_accountNo = from_accountNo;
		this.to_accountNO = to_accountNo;
	}

	public Transaction( double transfer_amt, String transict_date, long to_accountNo, long from_accountNo)
	{
	
		this.transfer_amt=transfer_amt;
		this.transict_date=transict_date;
		this.from_accountNo = from_accountNo;
		this.to_accountNO = to_accountNo;
	}

	public Transaction() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @return the transac_id
	 */
	public int getTransac_id() {
		return transac_id;
	}



	/**
	 * @param transac_id the transac_id to set
	 */
	public void setTransac_id(int transac_id) {
		this.transac_id = transac_id;
	}



	/**
	 * @return the transfer_amt
	 */
	public double getTransfer_amt() {
		return transfer_amt;
	}



	/**
	 * @param transfer_amt the transfer_amt to set
	 */
	public void setTransfer_amt(double transfer_amt) {
		this.transfer_amt = transfer_amt;
	}



	/**
	 * @return the transict_date
	 */
	public String getTransict_date() {
		return transict_date;
	}



	/**
	 * @param transict_date the transict_date to set
	 */
	public void setTransict_date(String transict_date) {
		this.transict_date = transict_date;
	}



	/**
	 * @return the from_accountNo
	 */
	public long getFrom_accountNo() {
		return from_accountNo;
	}



	/**
	 * @param from_accountNo the from_accountNo to set
	 */
	public void setFrom_accountNo(long from_accountNo) {
		this.from_accountNo = from_accountNo;
	}



	/**
	 * @return the to_accountNO
	 */
	public long getTo_accountNO() {
		return to_accountNO;
	}



	/**
	 * @param to_accountNO the to_accountNO to set
	 */
	public void setTo_accountNO(long to_accountNO) {
		this.to_accountNO = to_accountNO;
	}
	

	

}
