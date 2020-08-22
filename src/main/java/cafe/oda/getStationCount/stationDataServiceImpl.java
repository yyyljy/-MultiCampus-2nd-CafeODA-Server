package cafe.oda.getStationCount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class stationDataServiceImpl implements stationDataService {
	@Autowired
	@Qualifier("stationDao")
	stationDataDAO dao;
	
	@Override
	public List<stationDataVO> select(String address) {
		// TODO Auto-generated method stub
		return dao.select(address);
	}

	@Override
	public List<stationDTO> selectOnOff(String address) {
		// TODO Auto-generated method stub
		return dao.selectOnOff(address);
	}

}
