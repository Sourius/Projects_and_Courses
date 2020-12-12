package module1;

import demos.SimpleLocation;

public class MemoryModels {
	public static void main(String[] args) {
		memoryModelWithIntegers();
		memoryModelWithObjects();
	}
	
	public static void memoryModelWithIntegers() {
		int v1 = 12;
		int v2 = v1;
		System.out.println("Before change: V1 is "+v1+", V2 is "+v2);
		v1 = 34;
		System.out.println("After change: V1 is "+v1+", V2 is "+v2);
	}
	
	public static void memoryModelWithObjects() {
		SimpleLocation ucsd;
		ucsd = new SimpleLocation(32.9, -117.2);
		SimpleLocation lima = new SimpleLocation(-12.0, -77.0);
		
		System.out.println("Before Change: Uccd is "+ucsd.latitude+", "+ucsd.longitude);
		System.out.println("Before Change: Lima is "+lima.latitude+", "+lima.longitude);
		
		lima.latitude = -12.04;
		System.out.println("After Change: Ucsd is "+ucsd.latitude+", "+ucsd.longitude);
		System.out.println("After Change: Lima is "+lima.latitude+", "+lima.longitude);
		
		ucsd = lima;
		lima = ucsd;
		System.out.println("After Second Change: Ucsd is "+ucsd.latitude+", "+ucsd.longitude);
		System.out.println("After Second Change: Lima is "+lima.latitude+", "+lima.longitude);
		
		lima.longitude = 84;
		System.out.println("After Third Change: Ucsd is "+ucsd.latitude+", "+ucsd.longitude);
		System.out.println("After Third Change: Lima is "+lima.latitude+", "+lima.longitude);
	}
}

