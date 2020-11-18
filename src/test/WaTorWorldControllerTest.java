package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class WaTorWorldControllerTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	//Test for fish below:
	
	//Test Plan
	//Test 1: Current cell should turn blue and fish should move to either: (2,1),(2,2),(1,2) (Color will be green)
	//Fish at point (1,1) Water at point (2,1),(2,2),(1,2)
	@Test
	public void fishTest1() {
		fail("Not yet implemented");
	}
	
	//Test 2: Current cell should turn blue and fish should move to: (1,2) (Color will be green)
	//Fish at point (1,1) Water at point (1,2) Edges at point (2,1), (2,2)
	@Test
	public void fishTest2() {
		fail("Not yet implemented");
	}
	
	//Test for sharks below:
	
	//Test 1: Current cell should turn blue and shark should move to either: (2,1),(2,2),(1,2) (Color will be yellow)
	//shark at point (1,1) Water at point (2,1),(2,2),(1,2)
	@Test
	public void sharkTest1() {
		fail("Not yet implemented");
	}
	
	//Test 2: Current cell should turn blue and shark should move to either: (1,2) (Color will be yellow)
	//shark at point (1,1) Water at point (1,2) Edges at point (2,1), (2,2)
	@Test
	public void sharkTest2() {
		fail("Not yet implemented");
	}
	
	//Test 3: Current cell should stay yellow and fish should turn blue 
	//shark at point (1,1) Water at point (1,2),(2,2) fish at point (2,2)
	@Test
	public void sharkTest3() {
		fail("Not yet implemented");
	}
	
	//Test 4: Current cell should stay yellow and one fish should turn blue 
	//shark at point (1,1) Water at point (1,2) fish at point (2,2),(2,2)
	@Test
	public void sharkTest4() {
		fail("Not yet implemented");
	}
	
}
