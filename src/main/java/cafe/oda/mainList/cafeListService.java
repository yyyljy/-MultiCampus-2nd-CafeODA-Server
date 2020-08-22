package cafe.oda.mainList;

import java.util.List;

public interface cafeListService {
	public List<cafeListDTO> newcafeList();
	public List<cafeListDTO> recentList();
	public List<cafeListDTO> randomList();
	//public List<cafeListDTO> aroundList();
}
