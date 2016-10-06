import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.Test;

public class testBD {
	
	static RepositorioDeporte repo;
	
	@BeforeClass
	public static void setUp() {
		repo = new RepositorioDeporte();
	}
	
	@Test
	public void testFindDesporte() {
		assertEquals(repo.findDeporte("prueba"), "prueba");
	}	
}
