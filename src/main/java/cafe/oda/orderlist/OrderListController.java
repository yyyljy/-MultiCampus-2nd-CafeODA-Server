package cafe.oda.orderlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cafe.oda.menulist.MenuVO;

@Controller
public class OrderListController {
	@Autowired
	OrderListService service;
	
	
	@RequestMapping(value ="/order.do", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody List<OrderDTO> orderList(String guestphone) {
		System.out.println("getStationCountData");
		OrderDTO dto = new OrderDTO();
		dto.setGuestphone("01074965575");
		guestphone = dto.getGuestphone();
		System.out.println("phone-->"+guestphone);
		List<OrderDTO> datalist = service.list(guestphone);
		System.out.println(datalist);
		return datalist;
	}
	@RequestMapping(value ="/guestorderlist.do", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody List<OrderDTO> guestorderlist(HttpServletRequest req, HttpServletResponse res) {
		String guestphone = req.getParameter("guestphone");
		System.out.println("get guestphone from guestorderlist:"+guestphone);
		List<OrderDTO> guestorderlist = service.guestorderlist(guestphone);
		System.out.println("guestorderlist mapper거침:"+guestorderlist);
		return guestorderlist;
	}
	
	//owner가 주문현황 볼 때 
	@RequestMapping(value ="/ownerorderlist.do", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody List<OrderDTO> ownerorderlist(HttpServletRequest req, HttpServletResponse res) {
		String cafeid = req.getParameter("cafeid");
		System.out.println("get cafeid from ownerorderlist:"+cafeid);
		List<OrderDTO> ownerorderlist = service.ownerorderlist(cafeid);
		System.out.println("ownerorderlist mapper거침:"+ownerorderlist);
		return ownerorderlist;
	}
	
	//owner가 매출리스트 볼 때  
		@RequestMapping(value ="/ownerhistorylist.do", method=RequestMethod.GET, produces="application/json;charset=utf-8")
		public @ResponseBody List<OrderDTO> ownerhistorylist(HttpServletRequest req, HttpServletResponse res) {
			String cafeid = req.getParameter("cafeid");
			System.out.println("get cafeid from ownerhistorylist:"+cafeid);
			List<OrderDTO> ownerhistorylist = service.ownerorderlist(cafeid);
			System.out.println("ownerhistorylist mapper거침:"+ownerhistorylist);
			return ownerhistorylist;
		}
		
	
	//owner가 픽업요청 했을 때 주문상태가 바뀐다.
	@RequestMapping(value ="/updatestatus.do", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody void updatestatus(HttpServletRequest req, HttpServletResponse res) {
		int ordid = Integer.parseInt(req.getParameter("ordid"));
		System.out.println("get ordid from 주문현황:"+ordid);
		service.updatestatus(ordid);
		System.out.println("update status mapper를 거쳤다.");
		
	}
	
	
	
	
	//메뉴 항목 추가
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/orderinsert.do" , method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody void order(HttpServletRequest req, HttpServletResponse res, @RequestBody String str) {
		System.out.println("getFromAndroid"+str);
		
		ArrayList<OrderDTO> orderlist = new ArrayList<OrderDTO>();
		OrderDTO orderdto = new OrderDTO();
		ObjectMapper mapper = new ObjectMapper();	
		JSONObject jo = new JSONObject();
		//JSONParser parser = new JSONParser();
		JSONArray data=new JSONArray();
		
		System.out.println("str"+str);
		System.out.println("str class "+ str.getClass());
		
		
		try {
			JSONParser parser = new JSONParser();
			JSONObject list =  (JSONObject) parser.parse(str);
			JSONArray array = (JSONArray) list.get("orderdata");
			System.out.println(list+":======================"+array);
			orderlist = (ArrayList<OrderDTO>)mapper.readValue(array.toJSONString(), new TypeReference<List<OrderDTO>>() {} );
		
			
			System.out.println("mapper를 거친 orderlist:"+orderlist);
			
			for(int i=0; i<orderlist.size();i++) {
				orderdto = orderlist.get(i);
				System.out.println("쪼갬!"+orderdto);
				
				service.order(orderdto);
				
			}
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	
	
	
}
