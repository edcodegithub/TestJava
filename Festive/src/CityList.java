

import java.util.ArrayList;

public class CityList {

	private int CityNo;
	private ArrayList<City> CityList = new ArrayList<>();
	
	
	public int getCityNo() {
		return CityNo;
	}


	public void setCityNo(int cityNo) {
		CityNo = cityNo;
	}


	public ArrayList<City> CreateList(){
		
		for(int i = 0; i < this.CityNo; i++){
			City CityDetail = new City();
			CityDetail.setCityNumber(i+1);
			CityDetail.setNature(0);
			CityDetail.setAdjacentCitites(null);
			
			this.CityList.add(CityDetail);
		}
		
		return CityList;
	}

}
