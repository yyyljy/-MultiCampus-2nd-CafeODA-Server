package cafe.oda.guest;

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
@Controller
public class GuestController {
	
	@Autowired
	GuestService service;
	
	@RequestMapping(value = "/guestlogin.do" , method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody String cafelogin(HttpServletRequest req, HttpServletResponse res ) {
		String guestphone = req.getParameter("guestphone");
		String guestpass = req.getParameter("guestpass");
		
		System.out.println("guestphone"+guestphone);
		System.out.println("guestpass"+guestpass);
		try {
			JSONObject jo = new JSONObject();
			GuestVO guestinfo = service.guest_login(guestphone);
			jo.put("guestphone", guestinfo.getGuestphone());
			jo.put("guestpass", guestinfo.getPass());
			jo.put("guestnickname", guestinfo.getNickname());
			jo.put("guestpoint", guestinfo.getPoint());
			jo.put("mycafe1", guestinfo.getMycafe1());
			jo.put("mycafe2", guestinfo.getMycafe2());
			jo.put("mycafe3", guestinfo.getMycafe3());
			jo.put("mycafe4", guestinfo.getMycafe4());
			jo.put("mycafe5", guestinfo.getMycafe5());
			
	
			System.out.println("게스트 로긴 성공, 로그인된 정보"+jo);
			if(guestinfo.getPass().equals(guestpass)) {
				return jo.toString();
			}else {
				System.out.println("게스트로그인실패"+ guestphone+","+guestpass);
				return "0";
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("no data");
			return "0";
		}
	}

}
