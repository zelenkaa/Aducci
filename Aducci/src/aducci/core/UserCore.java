package aducci.core;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.users.User;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.PreparedQuery;

public class UserCore {

	public static boolean IsAuthorizedUser(User user)
	{				
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey("AuthorizedEmail", user.getEmail());
		try
		{		
			datastoreService.get(key);
		}
		catch(Exception e)
		{
			return false;	
		}
		return true;		
	}
	
	public static List<String> GetAuthorizedEmails()
	{
		Query q = new Query("AuthorizedEmail");
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		PreparedQuery pq = datastoreService.prepare(q);
		
		ArrayList<String> authorizedEmails = new ArrayList<String>();
		for (Entity result : pq.asIterable()) {
			  //String kind = KeyFactory.keyToString(result.getKey());
			String email = result.getKey().getName();
			  authorizedEmails.add(email);			  
		}
		
		return authorizedEmails;
		
	}
	
	public static void AddAuthorizedUser(String email)
	{
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		Entity user = new Entity("AuthorizedEmail", email);
		
		datastoreService.put(user);
		
	}
}
