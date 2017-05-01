# Yo_App
Title: Mobile Banking Application



Technical Details:
	This is an simple Java based Android application for mobile banking by existing customers.
	
Softwares used: Android SDK 21, Java SDK 1.7, Eclipse Juno, Genymotion.
 
Description: 

This project is aimed at developing a Banking Application from the perspectives of customers to facilitate some of the core financial activities such as balance enquiry, last transactions, funds transfer, etc. related to a bank account.

It provides for four basic operations :

Activating mobile banking
Funds Transfer
Balance Enquiry
View Last Transactions



Usage:
	
Import the cloned project in Eclipse for Android and run. 
Alternatively, install using the BankDemo.apk file on an Android device. 
For initialization of the SQLite database, tap on the . (dot) below the 'Next' button on 'Details' activity. 



The initial fields of the database (accounts' records) are:



Transactiontable

transac_id	transfer_amt	transict_date		from_accountno	to_accountno

1		10000.0		2015-05-16 08:23:19	1234567891	1234567890

2		7000.0		2015-05-16 08:30:09	1234567890	1234567894

3		3000.0		2015-05-17 11:15:17	1234567893	1234567892

4		8000.0		2015-05-17 07:26:13	1234567894	1234567891

5		5500.0		2015-05-18 05:53:22	1234567890	1234567894

6		7000.0		2015-05-18 06:05:34	1234567894	1234567890

7		4000.0		2015-05-19 10:24:11	1234567890	1234567893

8		6000.0		2015-05-19 08:29:37	1234567892	1234567891

9		2000.0		2015-05-20 04:24:26	1234567893	1234567893

10		5000.0		2015-05-20 11:43:18	1234567893	1234567892



Customertable

account_no	curr_bal	cur_name	login_pin	atm_pin

1234567890	7000.0		Bhushan		   null		6027

1234567891	6000.0		Lalit		   null		6040

1234567892	4000.0		Lakhim		   null		6039

1234567893	5000.0		Mahir		   null		6042

1234567894	5500.0		Aanchal		   null		6001

