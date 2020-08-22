package cafe.oda.getEventSalesJson;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("nearbyDao")
public class salesNearbyDAOImpl implements salesNearbyDAO {
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<salesNearbyDTO> select(String road) {
		return sqlsession.selectList("cafe.oda.salesNearby.getNearby",road);
	}

}
