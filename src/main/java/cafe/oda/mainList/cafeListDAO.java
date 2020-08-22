package cafe.oda.mainList;

import java.util.List;


public interface cafeListDAO {
	public List<cafeListDTO> newcafeList();
	public List<cafeListDTO> recentList();
	public List<cafeListDTO> randomList();
	//public List<cafeListDTO> aroundList();
}
