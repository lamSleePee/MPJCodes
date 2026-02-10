class Main {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle();
		
		r1.length = 10;
		r1.breadth = 22;
	
		r2.length = 12;
		r2.breadth = 34;
		
		double area1 = r1.Area();
		double area2 = r2.Area();
		
		System.out.println("area = " + r1.Area());
		System.out.println("area = " + r2.Area());
	}
}

class Rectangle {
	double length, breadth, ar;
	
	double Area() {
		ar = length * breadth;
		return ar;
	}
}
