package cafe.oda.cafelist;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cafe.oda.menulist.MenuVO;
@Controller
public class CafelistController {
	
	@Autowired
	CafelistService service;
	
	//Onwer로그인
	@RequestMapping(value = "/cafelogin.do" , method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody String cafelogin(HttpServletRequest req, HttpServletResponse res ) {
		String tel = req.getParameter("tel");
		String cafepass = req.getParameter("pass");
		
		System.out.println("tel"+tel);
		System.out.println("pass"+cafepass);
		try {
			JSONObject jo = new JSONObject();
			CafeVO cafeinfo = service.cafe_login(tel);
			jo.put("cafeid", cafeinfo.getCafeid());
			jo.put("cafename", cafeinfo.getCafename());
			jo.put("address", cafeinfo.getAddress());
			jo.put("latitude", cafeinfo.getLatitude());
			jo.put("logitude", cafeinfo.getLogitude());
			jo.put("weekend_opentime", cafeinfo.getWeekend_opentime());
			jo.put("weekend_closetime", cafeinfo.getWeekend_closetime());
			jo.put("weekday_opentime", cafeinfo.getWeekday_opentime());
			jo.put("weekday_closetime", cafeinfo.getWeekday_closetime());
			jo.put("regday", cafeinfo.getRegday());
			jo.put("mostpick1", cafeinfo.getMostpick1());
			jo.put("mostpick2", cafeinfo.getMostpick2());
			jo.put("mostpick3", cafeinfo.getMostpick3());
			jo.put("nearstation1", cafeinfo.getNearstation1());
			jo.put("nearstation2",cafeinfo.getNearstation2());
			jo.put("tel", cafeinfo.getTel());
			jo.put("pass", cafeinfo.getPass());
			
			System.out.println("카페 로긴 성공, 로그인된 카페정보"+jo);
			if(cafeinfo.getPass().equals(cafepass)) {
				return jo.toString();
			}else {
				System.out.println("로그인실패"+ tel+","+cafepass);
				return "0";
			}
		}catch (Exception e) {
			System.out.println("no data");
			return "0";
		}
	}
	
	//Guest가 매장 볼 때 컨트롤러
	@RequestMapping(value = "/entercafe.do" , method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody CafeVO entercafe(HttpServletRequest req, HttpServletResponse res ) {
		int cafeid = Integer.parseInt(req.getParameter("cafeid"));
		System.out.println("카페진입:"+cafeid);
			
			CafeVO cafeinfo = service.entercafe(cafeid);		
			System.out.println("매장정보보기 성공, 매장정보"+cafeinfo);
			return cafeinfo;
			
		
	}
	
	
	
	
	//즐겨찾는매장 확인
	@RequestMapping(value = "/mycafe.do" , method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody CafeVO mycafe(HttpServletRequest req, HttpServletResponse res ) {
		int cafeid = Integer.parseInt(req.getParameter("cafeid"));
		
		System.out.println("get cafeid:"+cafeid);
		CafeVO cafevo = service.mycafe(cafeid);
		System.out.println("mapper거친 spring data:"+cafevo);
		
		
	
	return cafevo;

}
	
	
	
}
