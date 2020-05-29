package unittest.snippets.base;


import org.junit.Assert;
import org.junit.Test;
import snippets.base.Tmp;

public class TmpTest {
    @Test
    public void sayHi() {
        String result = Tmp.SayHi();
        Assert.assertEquals(result, "Hi");
    }
}
