package cafe.oda.orderlist;

import java.util.List;

import cafe.oda.menulist.MenuVO;

public interface OrderListService {
	List<OrderDTO> list(String guestphone);
	void order(OrderDTO order);
	List<OrderDTO> guestorderlist(String guestphone);
	List<OrderDTO> ownerorderlist(String cafeid);
	List<OrderDTO> ownerhistorylist(String cafeid);
	void updatestatus(int ordid);
}
