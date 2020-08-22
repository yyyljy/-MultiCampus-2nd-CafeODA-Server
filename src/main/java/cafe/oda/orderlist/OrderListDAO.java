package cafe.oda.orderlist;

import java.util.List;

public interface OrderListDAO {
	List<OrderDTO> list(String guestphone);
	void order(OrderDTO order);
	List<OrderDTO> guestorderlist(String guestphone);
	List<OrderDTO> ownerorderlist(String cafeid);
	List<OrderDTO> ownerhistorylist(String cafeid);
	void updatestatus(int ordid);
}
