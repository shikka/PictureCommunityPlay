import play.mvc.Result;


public class LoginTest {
	
	
	@Test
	public void authenticated() {
	    Result result = callAction(
	        controllers.routes.ref.Application.index(),
	        fakeRequest().withSession("username", "bob")
	    );
	    assertEquals(200, status(result));
	}    
	
	
	@Test
	public void notAuthenticated() {
	    Result result = callAction(
	        controllers.routes.ref.Application.index(),
	        fakeRequest()
	    );
	    assertEquals(303, status(result));
	    assertEquals("/login", header("Location", result));
	}

}
