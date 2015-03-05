package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class ReadFromCSVFile {
	
	private List<Customer> csvList = new ArrayList<Customer>();
	@SuppressWarnings("resource")
	public List<Customer> getInput() {
		BufferedReader in = null;
		try {
			File currentDirectory = new File(new File(".").getAbsolutePath());
			System.out.println(currentDirectory.getCanonicalPath());
			String path = currentDirectory.getAbsolutePath();
			
			in = new BufferedReader(new FileReader(path + "//bankDetails.txt"));	
			
		    String line;
		    Customer customer = null;
		    while ((line = in.readLine()) != null && line.length() != 0) {
			  System.out.println(line);
			  String [] splitList = line.split(",");
			  String bankName = splitList[0];
			  String accountNumber =  splitList[1];
			  accountNumber = replaceNumbersWithX(accountNumber);
			  String accountSortCode = splitList[2];
			  
			  customer = new Customer(bankName, accountNumber, accountSortCode);
			  csvList.add(customer);
			}
		}  catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Collections.sort(csvList);
		return csvList;
	}
	
	private String replaceNumbersWithX(String accountNum) {
		String[] strs = accountNum.split("-", 2);
		String REGEX = "[1-9]";
		String INPUT = strs[1];
		String REPLACE = "x";
	 
	    Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        java.util.regex.Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        return strs[0] + "-" + INPUT;
	}
	@Override
	public String toString() {
		return "ReadFromCSVFile [csvList=" + csvList + "]";
	}
}
