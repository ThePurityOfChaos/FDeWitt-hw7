import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class ArrayDictionaryTest {
    @Test
    public void demo() {
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        assertTrue(dict.add(2, 82));
        assertTrue(dict.add(4, 84));
        assertTrue(dict.add(7, 87));
        System.out.println(dict);
    }

    @Test
    public void remove() {
        ArrayDictionary emptyDictionary = new ArrayDictionary(0);
        assertFalse(emptyDictionary.remove(0));
        int DictionarySize=9;
        ArrayDictionary noCollisionDictionary = new ArrayDictionary(DictionarySize);
        for(int i=0; i<DictionarySize; i++){
            noCollisionDictionary.add(i,i*2);
        }
        assertTrue(noCollisionDictionary.remove(5));
        assertFalse(noCollisionDictionary.remove(DictionarySize*2));
        ArrayDictionary collisionDictionary = new ArrayDictionary(DictionarySize);
        for(int i=0; i<DictionarySize; i++){
            collisionDictionary.add(i,i*2);
        }
        collisionDictionary.add(0,1);
        collisionDictionary.add(6,16);
        assertTrue(collisionDictionary.remove(0));
        assertTrue(collisionDictionary.remove(5));
        assertFalse(collisionDictionary.remove(DictionarySize*2));
    }

    @Test
    public void contains() {
        int set1testSize=0;
        ArrayDictionary set1 = new ArrayDictionary(set1testSize);
        assertFalse(set1.contains(-1));
        assertFalse(set1.contains(0));
        assertFalse(set1.contains(1));


        int set2testSize=1;
        ArrayDictionary set2 = new ArrayDictionary(set2testSize);
        set2.add(0,103);
        assertFalse(set2.contains(2));
        assertTrue(set2.contains(0));

        int set3testSize = 2;
        ArrayDictionary set3 = new ArrayDictionary(set3testSize);
        set3.add(0, 103); set3.add(1,105);
        for(int i=0; i<4; i++){
            if(i<2){
                assertTrue(set3.contains(i));
            }else{
                assertFalse(set3.contains(i));
            }
        }
        int set4testSize = 3;
        ArrayDictionary set4 = new ArrayDictionary(set4testSize);
        set4.add(0,103); set4.add(1,105);
        assertFalse(set4.contains(3));
        set4.add(2,206);
        assertTrue(set4.contains(1));

        int set5testSize = 3;
        ArrayDictionary set5 = new ArrayDictionary(set5testSize);
        set5.add(0,103); set5.add(1,105); set5.add(2,206); set5.add(4,407);
        assertTrue(set5.contains(1));
        assertTrue(set5.contains(4));
        assertFalse(set5.contains(7));
        assertFalse(set5.contains(8));
    }
}