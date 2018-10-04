public class RootsOfQuadratic {

	public static void main(String[] args) {
		double a=1, b=2, c=1;
		double discriminant, root1, root2, realPart, imaginaryPart;
		discriminant = b*b-4*a*c;
		if (discriminant>=0) {
				root1 = (-b+Math.sqrt(discriminant))/(2*a);
				root2 = (-b-Math.sqrt(discriminant))/(2*a);
				System.out.println("Root 1 is "+root1+" and root 2 is "+root2);
		}
		else{
	        realPart = -b/(2*a);
	        imaginaryPart = Math.sqrt(-discriminant)/(2*a);
	        System.out.println("Root 1 is "+ realPart+" "+ imaginaryPart);
	        System.out.print(" and root 2 is "+ realPart+" "+imaginaryPart);
	    }
	}
}
