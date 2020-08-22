package cafe.oda.cafeoda;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	
	@Autowired
	TestService service;
	
	
	@RequestMapping(value = "/home.do" , method = RequestMethod.GET, produces="application/json;charset=utf-8" )
	
	
	public @ResponseBody List<TestVO> testlistall(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Server started ");
		/*response.setContentType("String");
		response.setCharacterEncoding("UTF-8");*/		
		JSONObject jsonobj = new JSONObject();
		List<TestVO> tt = new ArrayList<TestVO>();
		
		tt = service.testlistall();	
		//String result = service.testlistall().toString();
		return tt;	
	}	
	
	@RequestMapping(value = "/hometest.do" , method = RequestMethod.GET, produces="application/json;charset=utf-8" )
	public @ResponseBody List<TestVO> categoryboardlist(){
		String result="";
		List<TestVO> prdlist = service.testlistall();
		System.out.println("ajax통신"+prdlist);
		return prdlist;
		
	}

	
}
