package cafe.oda.fcm;


public interface FCMService {
	int getToken(FCMDTO info);

	FCMDTO getClientToken(String id);
}
