package cafe.oda.fcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FCMServiceImpl implements FCMService {
	@Autowired
	@Qualifier("fcmdao")
	FCMDAO dao;

	@Override
	public int getToken(FCMDTO info) {
		int result = 0;
		if(dao.getToken(info.fcm_token)==null) {
			System.out.println("토큰없어");
			result = dao.insert(info);
		}
		return result;
	}

	@Override
	public FCMDTO getClientToken(String id) {
		// TODO Auto-generated method stub
		return dao.getClientToken(id);
	}

	
	

}
