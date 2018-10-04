
public class PersonMain {

	public static void main(String[] args) {
		PersonClass personClass=new PersonClass("Rishabh","Gupta",'M');
		personClass.setPhoneNo("6767698776");
		PersonMain personMain=new PersonMain();
		personMain.printDetails(personClass);
	}
	void printDetails(PersonClass personClass){
		System.out.println("Person Details:\n");
		System.out.println("-------------------");
		System.out.println("\n");
		System.out.println("First Name: "+personClass.getFirstName());
		System.out.println("\nLast Name: "+personClass.getLastName());
		System.out.println("\nGender: "+personClass.getGender());
		System.out.println("\nPhone No: "+personClass.getPhoneNo());
	}

}
