package aducci.core;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class AuthorizedEmailCore {

	public static boolean IsAuthorizedEmail(String email) {
		DatastoreService datastoreService = DatastoreServiceFactory
				.getDatastoreService();
		Key key = KeyFactory.createKey("AuthorizedEmail", email);
		try {
			datastoreService.get(key);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static List<String> GetAuthorizedEmails() {
		Query q = new Query("AuthorizedEmail");
		DatastoreService datastoreService = DatastoreServiceFactory
				.getDatastoreService();
		PreparedQuery pq = datastoreService.prepare(q);

		ArrayList<String> authorizedEmails = new ArrayList<String>();
		for (Entity result : pq.asIterable()) {
			String email = result.getKey().getName();
			authorizedEmails.add(email);
		}

		return authorizedEmails;

	}

	public static void AddAuthorizedEmail(String email) {
		DatastoreService datastoreService = DatastoreServiceFactory
				.getDatastoreService();
		Entity user = new Entity("AuthorizedEmail", email);

		datastoreService.put(user);

	}
}
