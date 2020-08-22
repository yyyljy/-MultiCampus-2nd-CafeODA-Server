package cafe.oda.menulist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	@Qualifier("menudao")
	MenuDAO dao;
	


	@Override
	public void menu_insert(MenuVO menu) {
		System.out.println("seviceimple: "+menu);
		dao.menu_insert(menu);
	}



	@Override
	public List<MenuVO> menulistall(int cafeid) {
		return dao.menulistall(cafeid);
	}



	@Override
	public void menudelete(int menunum) {
		dao.menudelete(menunum);
		
	}
	
	
	
}
