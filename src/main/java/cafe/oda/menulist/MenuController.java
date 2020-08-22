package cafe.oda.menulist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MenuController {
	
	@Autowired
	MenuService service;
	
	//메뉴 항목 추가
	@RequestMapping(value = "/menuinsert.do" , method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody void menuinsert(HttpServletRequest req, HttpServletResponse res, @RequestBody String str) {
		System.out.println("getFromAndroid"+str);
		
		MenuVO menuvo = new MenuVO();
		ObjectMapper mapper = new ObjectMapper();	
		try {
			System.out.println("str"+str);
			System.out.println("str class "+ str.getClass());
			menuvo = mapper.readValue(str,MenuVO.class);			
			service.menu_insert(menuvo);
			System.out.println("mapper결과:"+menuvo);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	
	//메뉴 목록 불러오기
	@RequestMapping(value="/menulist.do" , method=RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody List<MenuVO> menulistall(HttpServletRequest req, HttpServletResponse res) {
		
		int cafeid = Integer.parseInt(req.getParameter("cafeid"));
		System.out.println("get cafeee id:"+cafeid);
		List<MenuVO> menulist = service.menulistall(cafeid);
		System.out.println("mapper거친 spring data:"+menulist);
	
		return menulist;
	}
	
	//메뉴 삭제
	@RequestMapping(value="/menudelete.do" , method=RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody void menudelete(HttpServletRequest req, HttpServletResponse res) {
		
		int menunum = Integer.parseInt(req.getParameter("menunum"));
		System.out.println("get menunum:"+menunum);
		service.menudelete(menunum);
		System.out.println("delete에서 mapper거치고service실행된 상태");
		
	}
	
}
