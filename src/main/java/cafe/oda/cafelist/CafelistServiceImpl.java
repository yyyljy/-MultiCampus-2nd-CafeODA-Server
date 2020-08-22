package cafe.oda.cafelist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CafelistServiceImpl implements CafelistService {
	@Autowired
	@Qualifier("cafelistdao")
	CafelistDAO dao;
	


	@Override
	public CafeVO cafe_login(String tel) {
		System.out.println("seviceimple: "+tel);
		return dao.cafe_login(tel);
	}

	@Override
	public CafeVO entercafe(int cafeid) {
		// TODO Auto-generated method stub
		return dao.entercafe(cafeid);
	}
	


	@Override
	public CafeVO mycafe(int cafeid) {
		// TODO Auto-generated method stub
		return dao.mycafe(cafeid);
	}



	
	
}
