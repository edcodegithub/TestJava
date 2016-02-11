
public class City {

	private int CityNumber;
	private int Nature;
	private City AdjacentCitites;
	
	public int getCityNumber() {
		return CityNumber;
	}
	public void setCityNumber(int cityNumber) {
		CityNumber = cityNumber;
	}
	public int getNature() {
		return Nature;
	}
	public void setNature(int nature) {
		Nature = nature;
	}
	public City getAdjacentCitites() {
		return AdjacentCitites;
	}
	public void setAdjacentCitites(City adjacentCitites) {
		AdjacentCitites = adjacentCitites;
	}
	
}
