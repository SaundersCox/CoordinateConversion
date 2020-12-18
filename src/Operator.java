
public class Operator {

	public static void main(String[] args) {
		
		// Test that all conversions cyl->sph->rec->cyl work
		Cylindrical cylA = new Cylindrical(5, Math.PI * Math.sqrt(3) / 2, 3);
		System.out.println(cylA.getPosition());
		
		Spherical sphA;
		sphA = cylA.toSpherical();
		System.out.println(sphA.getPosition());
		
		Rectangular recA = sphA.toRectangular();
		System.out.println(recA.getPosition());
		
		cylA = recA.toCylindrical();
		System.out.println(cylA.getPosition());
		
		
		// Test that all other conversions work cyl->rec->sph->cyl
		Cylindrical cylB = new Cylindrical(5, Math.PI * Math.sqrt(3) / 2, 3);
		System.out.println("\n" + cylB.getPosition());
		
		Rectangular recB = cylB.toRectangular();
		System.out.println(recB.getPosition());
		
		Spherical sphB = recB.toSpherical();
		System.out.println(sphB.getPosition());
		
		cylB = sphB.toCylindrical();
		System.out.println(cylB.getPosition());
	}
	
	

}
