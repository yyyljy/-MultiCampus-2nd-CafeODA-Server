package cafe.oda.fcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class FCMController {
	@Autowired
	FCMService service;
	@RequestMapping(value = "/fcm/fcm_check", method = RequestMethod.GET)
	public String getToken(String id, String token) {
		FCMDTO fcmdto = new FCMDTO(id, token);
		int result = service.getToken(fcmdto);
		if(result==1) {
			System.out.println("저장완료");
		}
		return "home";
	}
	@RequestMapping(value = "/fcm/sendClient", method = RequestMethod.GET)
	public String sendMessage(String sendId, String recvId) {
		FCMDTO result = service.getClientToken(recvId);
		String apiKey = "AAAAn5OfDAA:APA91bF8NUjGQc3MjD29Zsj1_R_8xuy-Dg_Wvto_WMEOZsghEK6ifRZtk9Po4xCPJSIssSyMr_GqTXbRGhI4V_WY-ce82dej-MNa6L06JfP_71yE9qHxNi8_7bEm4z1oFP-vXi5DKt54";
		try {
			URL url = new URL("https://fcm.googleapis.com/fcm/send");
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type","application/json");
			connection.setRequestProperty("Authorization","key="+apiKey);
			
			MessageDTO msg = new MessageDTO("Cafe 주문 접수",sendId+"님 주문 요청이 있습니다.");
			SendDataDTO senddto = new SendDataDTO(msg, result.getFcm_token());
			//메시지 정보를 셋팅한다.
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(senddto);
			System.out.println("변환===> "+jsonString);
			//서버로 데이터 전달하기
			OutputStream os = connection.getOutputStream();
			os.write(jsonString.getBytes("UTF-8"));
			os.flush();
			os.close();
			
			//firebase서버가 전달하는 응답메시지 받기
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			System.out.println("br====>"+br);
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				sb.append(line);
			}
			br.close();
			System.out.println(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "home";
	}
	
	@RequestMapping(value = "/fcm/sendCompleteClient", method = RequestMethod.GET)
	public String sendCompleteMessage(String sendId, String recvId) {
		FCMDTO result = service.getClientToken(recvId);
		String apiKey = "AAAAn5OfDAA:APA91bF8NUjGQc3MjD29Zsj1_R_8xuy-Dg_Wvto_WMEOZsghEK6ifRZtk9Po4xCPJSIssSyMr_GqTXbRGhI4V_WY-ce82dej-MNa6L06JfP_71yE9qHxNi8_7bEm4z1oFP-vXi5DKt54";
		System.out.println("카페:"+sendId+"고객:"+recvId);
		try {
			URL url = new URL("https://fcm.googleapis.com/fcm/send");
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type","application/json");
			connection.setRequestProperty("Authorization","key="+apiKey);
			
			MessageDTO msg = new MessageDTO("CafeODA",recvId+"님 제작 완료됐습니다.");
			SendDataDTO senddto = new SendDataDTO(msg, result.getFcm_token());
			//메시지 정보를 셋팅한다.
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(senddto);
			System.out.println("변환===> "+jsonString);
			//서버로 데이터 전달하기
			OutputStream os = connection.getOutputStream();
			os.write(jsonString.getBytes("UTF-8"));
			os.flush();
			os.close();
			
			//firebase서버가 전달하는 응답메시지 받기
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			System.out.println("br====>"+br);
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				sb.append(line);
			}
			br.close();
			System.out.println(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "home";
	}
}
//AAAAn5OfDAA:APA91bF8NUjGQc3MjD29Zsj1_R_8xuy-Dg_Wvto_WMEOZsghEK6ifRZtk9Po4xCPJSIssSyMr_GqTXbRGhI4V_WY-ce82dej-MNa6L06JfP_71yE9qHxNi8_7bEm4z1oFP-vXi5DKt54
//AAAxztBgH4:APA91bFt--sFVZlNmQkTMLQ0olTwZu38vnkPtYlYCGG7U2syFnxWFphzHHmDuNE-7UN_Rlz6mZ-6Sc09QM-nh0kXvPM5rKK4WpCd8fN-wyGMPXvCLF6WmqpZfC_JmHAgdoHkicqFZysW





