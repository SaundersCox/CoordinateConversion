
public class Rectangular {

	double x, y, z;
	
	public Rectangular(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String getPosition() {
		return String.format("%-23s(%.2f, %.2f, %.2f)", "Rectangular coordinate: ", x, y, z);
	}
	
	public Cylindrical toCylindrical() {
		// (x, y, z) -> (r, theta, z)
		
		// r^2 = x^2 + y^2, r = sqrt(x^2 + y^2)
		double r = xyToR(x, y);
		// x = r cos(theta), arccos(x / r)
		double theta = Math.acos(x / r);
		return new Cylindrical(r, theta, z);
	}
	
	public Spherical toSpherical() {
		// (x, y, z) -> (rho, theta, phi)
		
		// p^2 = x^2 + y^2 + z^2, p = sqrt(x^2 + y^2 + z^2)
		double rho = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
		// z = rho cos(phi), phi = arccos(z / rho)
		double phi = Math.acos(z / rho);
		// r^2 = x^2 + y^2, r = sqrt(x^2 + y^2)
		// x = r cos(theta), theta = arccos(x / r)
		double r = xyToR(x, y);
		double theta = Math.acos(x / r);
		return new Spherical(rho, theta, phi);
	}
	
	public double xyToR(double x, double y) {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
}
