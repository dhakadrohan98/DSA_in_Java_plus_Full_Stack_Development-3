package org.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Contact {
	
	String name;
	Set<String> numbers;
	
	public String getName() {
		return name;
	}

	public Set<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<String> numbers) {
		this.numbers = numbers;
	}
	
	public Contact(String name) {
		this.name = name;
		this.numbers = new HashSet<>();
	}
	
	public Contact(String name, Set<String> numbers) {
		this.name = name;
		//Bug
//		this.numbers = new HashSet<>();
		this.numbers = numbers;
	}
}

class ContactMerger {
	
	public List<Contact> merge(List<Contact> myContact, List<Contact> contact2) {
		Map<String, Contact> map = new HashMap<String, Contact>();
		for(Contact c1: myContact) {
			//loading all my contacts
			map.put(c1.getName(), new Contact(c1.getName(), c1.getNumbers()));
			
		}
		System.out.println("print loaded contacts first");
		//print the map
		for(Map.Entry<String, Contact> hmap: map.entrySet()) {
			System.out.println(hmap.getKey()+ " " + hmap.getValue().getNumbers());
		}
		
		//process incoming contact list
		for(Contact c2: contact2) {
			if(map.containsKey(c2.getName())) {
				Set<String> incomingListOfnumbers = c2.getNumbers();
				//need c1 object
				Contact contact = map.get(c2.getName());
				Set<String>  myNumbers = contact.getNumbers();
				myNumbers.addAll(incomingListOfnumbers);
			}
		}
		//adding merged list into ans contact
		List<Contact> ans = new ArrayList<>();
		for(String name: map.keySet()) {
			Contact contact = map.get(name);
			ans.add(contact);
		}
		return ans;
	}
}



public class MergePhoneDirectory {

	public static void main(String[] args) {
		//phone1
		Set<String> number1 = new HashSet<String>();
		number1.add("89362");
		number1.add("97837");
		Contact c1 = new Contact("Rohan", number1);
		Set<String> number2 = new HashSet<String>();
		number2.add("93898");
		Contact c2 = new Contact("Anil", number2);
		List<Contact> contactList1 = new ArrayList<>();
		contactList1.add(c1);
		contactList1.add(c2);
		
		//phone2
		
		Set<String> number3 = new HashSet<String>();
		number3.add("89362");
		number3.add("77736");
		Contact c3 = new Contact("Rohan", number3);
		List<Contact> contactList2 = new ArrayList<>();
		contactList2.add(c3);
		
		System.out.println("Contact list1: ");
		for(Contact c : contactList1) {
			System.out.println(c.getName() + " " + c.getNumbers());
		}
		
		System.out.println("Contact list2: ");
		for(Contact c : contactList2) {
			System.out.println(c.getName() + " " + c.getNumbers());
		}
		System.out.println("calling merge method");
		
		ContactMerger contactMerger = new ContactMerger();
		List<Contact> mergedList = contactMerger.merge(contactList1, contactList2);
		System.out.println("merged");
		for(Contact c : mergedList) {
			System.out.println(c.getName() + " " + c.getNumbers());
		}
	}

}

//p1     //p2

