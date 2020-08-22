package cafe.oda.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {
	@Autowired
	@Qualifier("guestdao")
	GuestDAO dao;
	


	@Override
	public GuestVO guest_login(String guestphone) {
		System.out.println("seviceimple: "+guestphone);
		return dao.guest_login(guestphone);
	}
	
	
	
}
