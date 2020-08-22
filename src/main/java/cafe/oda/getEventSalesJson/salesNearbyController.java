package cafe.oda.getEventSalesJson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class salesNearbyController {
	@Autowired
	salesNearbyService service;
	
	@RequestMapping(value ="/eventsales.json", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody salesNearbyDTO eventSalesJson(String road) {
		System.out.println("eventSalesJson");
		List<salesNearbyDTO> datalist = service.select(road);
		int len = datalist.size();
		int weekdayrate=0;
	    int weekendrate=0;
	    int mondayrate=0;
	    int tuesdayrate=0;
	    int wednesdayrate=0;
	    int thursdayrate=0;
	    int fridayrate=0;
	    int saturdayrate=0;
	    int sundayrate=0;
	    int t0006rate=0;
	    int t0611rate=0;
	    int t1114rate=0;
	    int t1417rate=0;
	    int t1721rate=0;
	    int t2124rate=0;
	    int manrate=0;
	    int womanrate=0;
	    int a10rate=0;
	    int a20rate=0;
	    int a30rate=0;
	    int a40rate=0;
	    int a50rate=0;
	    int a60rate=0;
	    int cafecnt=0;
		if(len>1) {
			for(int i=0;i<len;i++) {
				weekdayrate += datalist.get(i).weekdayrate;
				weekendrate += datalist.get(i).weekendrate;
				mondayrate += datalist.get(i).mondayrate;
				tuesdayrate += datalist.get(i).tuesdayrate;
				wednesdayrate += datalist.get(i).wednesdayrate; 
				thursdayrate += datalist.get(i).thursdayrate;  
				fridayrate += datalist.get(i).fridayrate;    
				saturdayrate += datalist.get(i).saturdayrate;  
				sundayrate += datalist.get(i).sundayrate;    
				t0006rate += datalist.get(i).t0006rate;     
				t0611rate += datalist.get(i).t0611rate;     
				t1114rate += datalist.get(i).t1114rate;     
				t1417rate += datalist.get(i).t1417rate;     
				t1721rate += datalist.get(i).t1417rate;     
				t2124rate += datalist.get(i).t2124rate;     
				manrate += datalist.get(i).manrate;       
				womanrate += datalist.get(i).womanrate;     
				a10rate += datalist.get(i).a10rate;       
				a20rate += datalist.get(i).a20rate;       
				a30rate += datalist.get(i).a30rate;       
				a40rate += datalist.get(i).a40rate;       
				a50rate += datalist.get(i).a50rate;       
				a60rate += datalist.get(i).a60rate;       
				cafecnt += datalist.get(i).cafecnt;       
			}
			salesNearbyDTO dto = new salesNearbyDTO("", 0, road, "", 0, (int)(weekdayrate/len),(int)(weekendrate/len),(int)(mondayrate/len),(int)(tuesdayrate/len),(int)(wednesdayrate/len),(int)(thursdayrate/len),(int)(fridayrate/len),(int)(saturdayrate/len),(int)(sundayrate/len),(int)(t0006rate/len),(int)(t0611rate/len),(int)(t1114rate/len),(int)(t1417rate/len),(int)(t1721rate/len),(int)(t2124rate/len),(int)(manrate/len),(int)(womanrate/len),(int)(a10rate/len),(int)(a20rate/len),(int)(a30rate/len),(int)(a40rate/len),(int)(a50rate/len),(int)(a60rate/len),(int)(cafecnt/len));
			return dto;
		}else {
			return datalist.get(0);
		}
	}
}
