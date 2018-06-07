package other;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMyArrayTest {
    @Test
    public void testFindArray() throws Exception {
        FindArray findArray = new FindMyArray();
        int array = findArray.findArray(null, null);
        assertEquals(-1, array);
    }

    @Test
    public void testFindArraySubArrayIsNull() throws Exception {
        FindArray findArray = new FindMyArray();
        int array = findArray.findArray(new int[]{4,9,3,7,8}, null);
        assertEquals(-1, array);
    }
    
    @Test
    public void test1() {
        FindArray findArray = new FindMyArray();
        int array = findArray.findArray(new int[]{4,9,3,7,8}, new int[]{3,7});
        assertEquals(2, array);
    }

    @Test
    public void testSize() {
        FindArray findArray = new FindMyArray();
        int array = findArray.findArray(new int[]{4,9}, new int[]{4,9,10});
        assertEquals(-1, array);
    }

    @Test
    public void test2() {
        FindArray findArray = new FindMyArray();
        int array = findArray.findArray(new int[]{1,3,5}, new int[]{1});
        assertEquals(0, array);
    }

    @Test
    public void test3() {
        FindArray findArray = new FindMyArray();
        int array = findArray.findArray(new int[]{7,8,9}, new int[]{8,9,10});
        assertEquals(-1, array);
    }

    @Test
    public void test4() {
        FindArray findArray = new FindMyArray();
        int array = findArray.findArray(new int[]{4,9,3,7,8,3,7,1}, new int[]{3,7});
        assertEquals(5, array);
    }

    @Test
    public void test6() {
        FindArray findArray = new FindMyArray();
        int array = findArray.findArray(new int[]{4,9,3,7,8,3,7,8}, new int[]{3,7,8});
        assertEquals(5, array);
    }

    @Test
    public void test7() {
        FindArray findArray = new FindMyArray();
        int array = findArray.findArray(new int[]{1,2,3,4,5}, new int[]{4,5});
        assertEquals(3, array);
    }


}
