
public class Spherical {

	double rho, theta, phi;
	
	public Spherical(double rho, double theta, double phi) {
		this.rho = rho;
		this.theta = theta;
		this.phi = phi;
	}
	
	public String getPosition() {
		return String.format("%-23s (%.2f, %.2f, %.2f)", "Spherical coordinate:", rho, theta, phi);
	}
	
	public Rectangular toRectangular() {
		// (rho, theta, phi) -> (x, y, z)
		
		// x = p sin(phi) cos(theta)
		double x = rho * Math.sin(phi) * Math.cos(theta);
		// y = p sin(phi) sin(theta)
		double y = rho * Math.sin(phi) * Math.sin(theta);
		// z = p cos(phi)
		double z = rho * Math.cos(phi);
		return new Rectangular(x, y, z);
	}
	
	public Cylindrical toCylindrical() {
		// (rho, theta, phi) -> (r, theta, z)
		
		// r = p sin(phi)
		double r = rho * Math.sin(phi);
		// z = p cos(phi)
		double z = rho * Math.cos(phi);
		return new Cylindrical(r, theta, z);
	}
}
