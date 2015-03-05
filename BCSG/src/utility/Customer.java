package utility;

import utility.ConvertMonthToIntger.MonthEnum;

public class Customer implements Comparable<Customer> {
	private final String bankName;
	private final String accountName;
	private final String sortCode;
	
	public Customer(String bankName, String accountName, String sortCode) {
		this.bankName = bankName;
		this.accountName = accountName;
		this.sortCode = sortCode;
	}

	@Override
	public int compareTo(Customer customer) {
		return (Integer.parseInt(ConvertMonthToInteger(this).trim()) - 
				Integer.parseInt(ConvertMonthToInteger(customer).trim()));
	}

	private String ConvertMonthToInteger(Customer customer) {
		String sortCode = customer.getSortCode();
		String [] split = sortCode.split("-");
		int monthInt = MonthEnum.valueOf((split[0]).toUpperCase()).getId();
		return  ""+monthInt+split[1];
	}
	
	public String getBankName() {
		return bankName;
	}

	@Override
	public String toString() {
		return "Customer [bankName=" + bankName + ", accountName="
				+ accountName + ", sortCode=" + sortCode + "]";
	}

	public String getAccountName() {
		return accountName;
	}

	public String getSortCode() {
		return sortCode;
	}
}
