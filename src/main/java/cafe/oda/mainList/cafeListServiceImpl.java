package cafe.oda.mainList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class cafeListServiceImpl implements cafeListService{
	@Autowired
	@Qualifier("cafelistDAO")
	 cafeListDAO dao;
	@Override
	public List<cafeListDTO> newcafeList() {
			
		return dao.newcafeList();
	}
	@Override
	public List<cafeListDTO> recentList() {
	
		return dao.recentList();
	}
	@Override
	public List<cafeListDTO> randomList() {
		
		return dao.randomList();
	}
	/*@Override
	public List<cafeListDTO> aroundList() {
		
		return dao.aroundList();
	}*/

}
