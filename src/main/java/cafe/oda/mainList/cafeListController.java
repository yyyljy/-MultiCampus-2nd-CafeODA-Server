package cafe.oda.mainList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class cafeListController {
	@Autowired
	cafeListService service;
	
	
	@RequestMapping(value ="/newcafe.do", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody List<cafeListDTO> newCafeList() {
		System.out.println("getStationCountData");
		List<cafeListDTO> datalist = service.newcafeList();
		System.out.println(datalist);
		return datalist;
	}
	
	@RequestMapping(value ="/recentcafe.do", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody List<cafeListDTO> recentVisitCafe() {
		System.out.println("getStationCountData");
		List<cafeListDTO> datalist = service.recentList();
		System.out.println(datalist);
		return datalist;
	}
	
	@RequestMapping(value ="/randomcafe.do", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody List<cafeListDTO> randomcafeList() {
		System.out.println("getStationCountData");
		List<cafeListDTO> datalist = service.randomList();
		System.out.println(datalist);
		return datalist;
	}
	/*
	@RequestMapping(value ="/aroundcafe.do", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody List<cafeListDTO> myAroundCafe() {
		System.out.println("getStationCountData");
		List<cafeListDTO> datalist = service.aroundList();
		System.out.println(datalist);
		return datalist;
	}*/
}
