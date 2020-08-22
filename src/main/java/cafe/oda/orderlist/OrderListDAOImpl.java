package cafe.oda.orderlist;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("orderDAO")
public class OrderListDAOImpl implements OrderListDAO{
	@Autowired
	SqlSession sqlsession;
	@Override
	public List<OrderDTO> list(String guestphone) {
		//System.out.println("dao--->"+guestphone);	
		return sqlsession.selectList("cafe.oda.orderlist.order",guestphone);
	}
	@Override
	public void order(OrderDTO order) {
		sqlsession.insert("cafe.oda.orderlist.orderinsert",order);
		
	}
	@Override
	public List<OrderDTO> guestorderlist(String guestphone) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("cafe.oda.orderlist.guestorderlist", guestphone);
	}
	@Override
	public List<OrderDTO> ownerorderlist(String cafeid) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("cafe.oda.orderlist.ownerorderlist", cafeid);
	}
	@Override
	public void updatestatus(int ordid) {
		sqlsession.update("cafe.oda.orderlist.updatestatus",ordid);
		
	}
	@Override
	public List<OrderDTO> ownerhistorylist(String cafeid) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("cafe.oda.orderlist.ownerhistorylist",cafeid);
	}
	
	
}
