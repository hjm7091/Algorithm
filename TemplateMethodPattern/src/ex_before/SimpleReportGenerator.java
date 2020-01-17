package ex_before;

import java.util.List;

public class SimpleReportGenerator {

	public String generate(List<Customer> customers) {
		String report = String.format("고객 수: %d명\n", customers.size());
		for(Customer customer : customers) 
			report += String.format("%s: %d\n", customer.getName(), customer.getPoint());
		return report;
	}
	
}
