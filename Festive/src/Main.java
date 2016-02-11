

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner scanf;
	
	public static void main(String[] args) {
		
		int Cities = 0;
		int Queries = 0;
		ArrayList<City> CityList = new ArrayList<>();
		scanf = new Scanner(System.in);
		
		Cities = scanf.nextInt();
		//Queries = scanf.nextInt();
		
		CityList List = new CityList();
		List.setCityNo(Cities);
		CityList = List.CreateList();
		
		for(int i=0; i<Cities-1; i++){
			int c1 = scanf.nextInt();
			int c2 = scanf.nextInt();
			City C1 = CreateCity(c1);
			City C2 = CreateCity(c2);
			
			CreateRoad(CityList.get(c1-1), C2);
			CreateRoad(CityList.get(c2-1), C1);
		}
		
		for(int i=0; i<Cities; i++){
			PrintEachList(CityList.get(i));
			System.out.println("-------------------");
		}

	}

	
	private static City CreateCity(int number){
		City Dummy = new City();
		Dummy.setAdjacentCitites(null);
		Dummy.setCityNumber(number);
		Dummy.setNature(0);
		
		return Dummy;
	}


	private static void CreateRoad(City c1, City c2){
		
		if(c1.getAdjacentCitites()==null){
			c1.setAdjacentCitites(c2);
		}
		else{
			CreateRoad(c1.getAdjacentCitites(), c2);
		}
	}


	private static void PrintEachList(City C1){
		int i;		
		
		if(C1.getAdjacentCitites()!=null){
		   
			i = C1.getAdjacentCitites().getCityNumber();		   
		    
			System.out.println(i);
			//if(C1.getAdjacentCitites().getAdjacentCitites()!=null){
			PrintEachList(C1.getAdjacentCitites());
			//}
		}
	}
}
