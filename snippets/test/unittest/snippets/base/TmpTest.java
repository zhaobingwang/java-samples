package unittest.snippets.base;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import snippets.base.Tmp;

public class TmpTest {
    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void sayHi() {
        String result = Tmp.SayHi();
        Assert.assertEquals(result, "Hi");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegative() {
        Tmp.fact(-1);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testNegative2() {
//        Tmp.fact(-2);
//    }
}
