package sii.maroc;

import java.util.HashMap;

public class Vehicles {
 private HashMap<String , String> vehiclesInfo = new HashMap<String, String>();
 
 public  Vehicles(String info ) {
	 String [] vehicule =info.split(",");
	 for(String v : vehicule) {
		 vehiclesInfo.put(v.split(":")[0], v.split(":")[1]);
	 }
	
 }
 public String move(String vehicule ,String carburon ,String door ,String distance ) {
	 String t = CheckDoor(vehicule,door);
	 String c = CalculeConsomation( carburon,distance);
	 
	 return t + ", MOVING. The " + vehicule +" will consume " + c  ;
 }
 private String CheckDoor(String vehicule , String doors){
	 if("CAR".equals(vehicule)){
		 if(doors.split(" ").length == 4) {
			 return "DOORS OK";
		 }
		/*else {
			 String result ="";
			 String [] d = doors.split(" ");
			 for(int i = 1 ;i <= d.length; i ++) {
				 if(i != Integer.parseInt(d[i])) {
					 result = String.valueOf(i);
					 return result;
				
				 }
			 }
		 }*/
	 }else if ("TRUCK".equals(vehicule)) {
			 if(doors.split(" ").length == 2) {
				 return "DOORS OK";
			 }
	 }
	 else if ("MOTORCYCLE".equals(vehicule)) {
			 if(doors.equals("")) {
				 return "DOORS OK";
			 }
	 }
	 return null;
 }
 private String CalculeConsomation(String carburon,String distance) {
	 int d = Integer.parseInt(distance.split(" ")[0]);
	 int c = Integer.parseInt(vehiclesInfo.get(carburon).substring(0, vehiclesInfo.get(carburon).length()-1));
	 
	 double result = d*c/100 ;
	 
	
	 return result+"0 L";
 }
 
}
