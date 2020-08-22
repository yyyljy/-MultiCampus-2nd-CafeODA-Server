package cafe.oda.getEventSalesJson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class salesNearbyServiceImpl implements salesNearbyService {
	@Autowired
	@Qualifier("nearbyDao")
	salesNearbyDAO dao;
	
	@Override
	public List<salesNearbyDTO> select(String road) {
		return dao.select(road);
	}

}
