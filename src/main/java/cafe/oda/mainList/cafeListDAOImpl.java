package cafe.oda.mainList;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("cafelistDAO")
public class cafeListDAOImpl implements cafeListDAO{
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<cafeListDTO> newcafeList() {
		
		return sqlsession.selectList("cafe.oda.mainList.newcafe");
	}

	@Override
	public List<cafeListDTO> recentList() {

		return sqlsession.selectList("cafe.oda.mainList.recentlist");
	}

	@Override
	public List<cafeListDTO> randomList() {
		return sqlsession.selectList("cafe.oda.mainList.randomlist");
	}

	/*@Override
	public List<cafeListDTO> aroundList() {

		return null;
	}*/
}
