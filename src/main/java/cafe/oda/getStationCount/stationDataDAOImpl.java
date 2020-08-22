package cafe.oda.getStationCount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("stationDao")
public class stationDataDAOImpl implements stationDataDAO {
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<stationDataVO> select(String address) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("cafe.oda.stationCountData.getStationCnt",address);
	}

	@Override
	public List<stationDTO> selectOnOff(String address) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("cafe.oda.stationCountData.getStationOnOff",address);
	}

}
