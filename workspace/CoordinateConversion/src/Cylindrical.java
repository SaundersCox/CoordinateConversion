
public class Cylindrical extends Position {

	double r, theta, z;
	
	public Cylindrical(double r, double theta, double z) {
		this.r = r;
		this.theta = theta;
		this.z = z;
	}
	
	public String getPosition() {
		return String.format("%-23s (%.2f, %.2f, %.2f)", "Cylindrical coordinate:", r, theta, z);
	}
	
	public Rectangular toRectangular() {
		// (r, theta, z) -> (x, y, z)
		
		// x = r cos(theta)
		double x = r * Math.cos(theta);
		// y = r cos(theta)
		double y = r * Math.sin(theta);
		return new Rectangular(x, y, z);
	}
	
	public Spherical toSpherical() {
		// (r, theta, z) -> (rho, theta, phi)
		
		// p^2 = r^2 + z^2, p = sqrt(r^2 + z^2)
		double rho = Math.sqrt(Math.pow(r, 2) + Math.pow(z, 2));
		// z = rho cos(phi), phi = arccos(z / rho)
		double phi = Math.acos(z / rho);
		return new Spherical(rho, theta, phi);
	}
}
