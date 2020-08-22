package cafe.oda.orderlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class OrderListServiceImpl implements OrderListService{
	@Autowired
	@Qualifier("orderDAO")
	OrderListDAO dao;
	@Override
	public List<OrderDTO> list(String guestphone) {
		System.out.println("phone service-->"+guestphone);
		
		return dao.list(guestphone);
	}
	@Override
	public void order(OrderDTO order) {
		dao.order(order);
		
	}
	@Override
	public List<OrderDTO> guestorderlist(String guestphone) {
		// TODO Auto-generated method stub
		return dao.guestorderlist(guestphone);
	}
	@Override
	public List<OrderDTO> ownerorderlist(String cafeid) {
		// TODO Auto-generated method stub
		return dao.ownerorderlist(cafeid);
	}
	@Override
	public void updatestatus(int ordid) {
		dao.updatestatus(ordid);
		
	}
	@Override
	public List<OrderDTO> ownerhistorylist(String cafeid) {
		// TODO Auto-generated method stub
		return dao.ownerhistorylist(cafeid);
	}

}
