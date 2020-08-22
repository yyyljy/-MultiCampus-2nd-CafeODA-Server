package cafe.oda.fcm;


public interface FCMDAO {
	FCMDTO getToken(String token);
	int insert(FCMDTO info);
	FCMDTO getClientToken(String id);
}