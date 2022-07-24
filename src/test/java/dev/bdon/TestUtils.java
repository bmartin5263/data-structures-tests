package dev.bdon;

import dev.bdon.list.List;
import dev.bdon.list.linked.doubly.DoublyLinkedList;
import dev.bdon.list.linked.singly.SinglyLinkedList;
import dev.bdon.map.Map;

import java.util.Arrays;
import java.util.Objects;

import static org.assertj.core.api.Assertions.fail;

public class TestUtils {

    @SuppressWarnings("SameParameterValue")
    public static void assertThrows(Class<? extends RuntimeException> clazz, Runnable code) {
        try {
            code.run();
            fail("Expected exception of type " + clazz.getSimpleName() + " to be thrown");
        }
        catch (RuntimeException ex) {
            assert ex.getClass().equals(clazz) : "Expected exception of type " + clazz.getSimpleName() + " to be thrown, but instead found: " + ex.getClass().getSimpleName();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> void assertContainsInOrder(List<T> list, T... thatArr) {
        T[] thisArr = list.toArray();
        assert thisArr.length == thatArr.length : "" +
                "Expected list to have " + thatArr.length
                + " items, instead has " + thisArr.length +
                " items. " + Arrays.toString(thisArr);
        for (int i = 0; i < thisArr.length; ++i) {
            assert Objects.equals(thisArr[i], thatArr[i]) : "Expected value " + thatArr[i] + " at position " + i +", but instead found: " + thisArr[i];
        }
    }

    public static <T> void assertEmpty(SinglyLinkedList<T> list) {
        assert list.isEmpty();
        assert list.size() == 0;
        assert list.head() == null;
        assert list.tail() == null;
    }

    public static <T> void assertEmpty(DoublyLinkedList<T> list) {
        assert list.isEmpty();
        assert list.size() == 0;
        assert list.head() == null;
        assert list.tail() == null;
    }

    public static void assertEmpty(Map<?, ?> map) {
        assert map.isEmpty();
        assert map.size() == 0;
    }
}
