package cafe.oda.getStationCount;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class stationDataController {
	@Autowired
	stationDataService service;
	
	@RequestMapping(value ="/eventstation.json", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody stationDTO getStationOnOffData(String road) {
		System.out.println("getStationOnOffData");
		List<stationDTO> datalist = service.selectOnOff(road);
		int len = datalist.size();
		System.out.println("len = "+len);
		int t0405on=0;
		int t0405off=0;
		int t0506on=0;
		int t0506off=0;
		int t0607on=0;
		int t0607off=0;
		int t0708on=0;
		int t0708off=0;
		int t0809on=0;
		int t0809off=0;
		int t0910on=0;
		int t0910off=0;
		int t1011on=0;
		int t1011off=0;
		int t1112on=0;
		int t1112off=0;
		int t1213on=0;
		int t1213off=0;
		int t1314on=0;
		int t1314off=0;
		int t1415on=0;
		int t1415off=0;
		int t1516on=0;
		int t1516off=0;
		int t1617on=0;
		int t1617off=0;
		int t1718on=0;
		int t1718off=0;
		int t1819on=0;
		int t1819off=0;
		int t1920on=0;
		int t1920off=0;
		int t2021on=0;
		int t2021off=0;
		int t2122on=0;
		int t2122off=0;
		int t2223on=0;
		int t2223off=0;
		int t2324on=0;
		int t2324off=0;
		int t0001on=0;
		int t0001off=0;
		int t0102on=0;
		int t0102off=0;
		int t0203on=0;
		int t0203off=0;
		int t0304on=0;
		int t0304off=0;
		
		if(len>1) {
			for(int i=0;i<len;i++) {
				t0405on+=datalist.get(i).t0405on;
				t0405off+=datalist.get(i).t0405off;
				t0506on+=datalist.get(i).t0506on;
				t0506off+=datalist.get(i).t0506off;
				t0607on+=datalist.get(i).t0607on;
				t0607off+=datalist.get(i).t0607off;
				t0708on+=datalist.get(i).t0708on;
				t0708off+=datalist.get(i).t0708off;
				t0809on+=datalist.get(i).t0809on;
				t0809off+=datalist.get(i).t0809off;
				t0910on+=datalist.get(i).t0910on;
				t0910off+=datalist.get(i).t0910off;
				t1011on+=datalist.get(i).t1011on;
				t1011off+=datalist.get(i).t1011off;
				t1112on+=datalist.get(i).t1112on;
				t1112off+=datalist.get(i).t1112off;
				t1213on+=datalist.get(i).t1213on;
				t1213off+=datalist.get(i).t1213off;
				t1314on+=datalist.get(i).t1314on;
				t1314off+=datalist.get(i).t1314off;
				t1415on+=datalist.get(i).t1415on;
				t1415off+=datalist.get(i).t1415off;
				t1516on+=datalist.get(i).t1516on;
				t1516off+=datalist.get(i).t1516off;
				t1617on+=datalist.get(i).t1617on;
				t1617off+=datalist.get(i).t1617off;
				t1718on+=datalist.get(i).t1718on;
				t1718off+=datalist.get(i).t1718off;
				t1819on+=datalist.get(i).t1819on;
				t1819off+=datalist.get(i).t1819off;
				t1920on+=datalist.get(i).t1920on;
				t1920off+=datalist.get(i).t1920off;
				t2021on+=datalist.get(i).t2021on;
				t2021off+=datalist.get(i).t2021off;
				t2122on+=datalist.get(i).t2122on;
				t2122off+=datalist.get(i).t2122off;
				t2223on+=datalist.get(i).t2223on;
				t2223off+=datalist.get(i).t2223off;
				t2324on+=datalist.get(i).t2324on;
				t2324off+=datalist.get(i).t2324off;
				t0001on+=datalist.get(i).t0001on;
				t0001off+=datalist.get(i).t0001off;
				t0102on+=datalist.get(i).t0102on;
				t0102off+=datalist.get(i).t0102off;
				t0203on+=datalist.get(i).t0203on;
				t0203off+=datalist.get(i).t0203off;
				t0304on+=datalist.get(i).t0304on;
				t0304off+=datalist.get(i).t0304off;
			}
			t0405on/=len;
			t0405off/=len;
			t0506on/=len;
			t0506off/=len;
			t0607on/=len;
			t0607off/=len;
			t0708on/=len;
			t0708off/=len;
			t0809on/=len;
			t0809off/=len;
			t0910on/=len;
			t0910off/=len;
			t1011on/=len;
			t1011off/=len;
			t1112on/=len;
			t1112off/=len;
			t1213on/=len;
			t1213off/=len;
			t1314on/=len;
			t1314off/=len;
			t1415on/=len;
			t1415off/=len;
			t1516on/=len;
			t1516off/=len;
			t1617on/=len;
			t1617off/=len;
			t1718on/=len;
			t1718off/=len;
			t1819on/=len;
			t1819off/=len;
			t1920on/=len;
			t1920off/=len;
			t2021on/=len;
			t2021off/=len;
			t2122on/=len;
			t2122off/=len;
			t2223on/=len;
			t2223off/=len;
			t2324on/=len;
			t2324off/=len;
			t0001on/=len;
			t0001off/=len;
			t0102on/=len;
			t0102off/=len;
			t0203on/=len;
			t0203off/=len;
			t0304on/=len;
			t0304off/=len;
			stationDTO stationdto = new stationDTO("", "", "", t0405on, t0405off, t0506on, t0506off, t0607on, t0607off, t0708on, t0708off, t0809on, t0809off, t0910on, t0910off, t1011on, t1011off, t1112on, t1112off, t1213on, t1213off, t1314on, t1314off, t1415on, t1415off, t1516on, t1516off, t1617on, t1617off, t1718on, t1718off, t1819on, t1819off, t1920on, t1920off, t2021on, t2021off, t2122on, t2122off, t2223on, t2223off, t2324on, t2324off, t0001on, t0001off, t0102on, t0102off, t0203on, t0203off, t0304on, t0304off);
			datalist.add(stationdto);
		}
		return datalist.get(0);
	}
}
	
	/*@RequestMapping(value="/test.do", method=RequestMethod.GET)
	public String getStationCountData() {
		System.out.println("getStationCountData");
		String address = "";
		List<stationDataVO> datalist = service.select(address);
		System.out.println(datalist);
		return "home";
	}
	
	@RequestMapping(value ="/test.json", method=RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody List<stationDataVO> categoryboardlist(String category) {
		System.out.println("getStationCountData");
		String address = "";
		List<stationDataVO> datalist = service.select(address);
		System.out.println(datalist);
		return datalist;
	}*/