package cl.clarochile.intranet.bootstrap;

//import java.util.HashSet;
//import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//import cl.clarochile.intranet.rests.UserRest;

/**
 * 
 * @author migamipe
 * 
 * Esta clase registra los servicios REST
 *
 */
@ApplicationPath("api")
public class ApplicationConfig extends Application {

	/*@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(UserRest.class);
		return classes;
	}*/
}
