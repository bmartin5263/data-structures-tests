package dev.bdon;

import dev.bdon.list.List;
import dev.bdon.list.linked.singly.Node;
import dev.bdon.list.linked.singly.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

import static org.assertj.core.api.Assertions.fail;

@SuppressWarnings("ConstantConditions")
class SinglyLinkedListTest {

    private <T extends Comparable<T>> SinglyLinkedList<T> createList() {
        // TODO - replace with your implementation
        return null;
    }

    @Test
    void should_insert_items_to_the_back_of_list() {
        SinglyLinkedList<Integer> list = createList();
        assert list.isEmpty();
        assert list.size() == 0;
        assert list.head() == null;

        list.pushBack(1);
        assert list.head().getData() == 1;
        assert list.tail().getData() == 1;
        assert list.size() == 1;
        assert !list.isEmpty();

        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        assert list.size() == 5;
        assert list.tail().getData() == 5;

        Node<Integer> current = list.head();
        assert current.getData() == 1;
        assert current.getNext() != null;

        current = current.getNext();
        assert current.getData() == 2;
        assert current.getNext() != null;

        current = current.getNext();
        assert current.getData() == 3;
        assert current.getNext() != null;

        current = current.getNext();
        assert current.getData() == 4;
        assert current.getNext() != null;

        current = current.getNext();
        assert current.getData() == 5;
        assert current.getNext() == null;
    }

    @Test
    void should_insert_items_to_the_front_of_list() {
        SinglyLinkedList<Integer> list = createList();
        assert list.isEmpty();
        assert list.size() == 0;
        assert list.head() == null;

        list.pushFront(1);
        assert list.head().getData() == 1;
        assert list.tail().getData() == 1;

        list.pushFront(2);
        list.pushFront(3);
        list.pushFront(4);
        list.pushFront(5);
        assert list.tail().getData() == 1;
        assert list.size() == 5;
        assert !list.isEmpty();

        Node<Integer> current = list.head();
        assert current.getData() == 5;
        assert current.getNext() != null;

        current = current.getNext();
        assert current.getData() == 4;
        assert current.getNext() != null;

        current = current.getNext();
        assert current.getData() == 3;
        assert current.getNext() != null;

        current = current.getNext();
        assert current.getData() == 2;
        assert current.getNext() != null;

        current = current.getNext();
        assert current.getData() == 1;
        assert current.getNext() == null;
    }

    @Test
    void should_test_if_list_contains_specified_items() {
        SinglyLinkedList<String> list = createList();

        assert !list.contains("Apple");
        assert !list.contains("Daikon");

        list.pushBack("Apple");
        list.pushBack("Banana");
        list.pushBack("Cherry");

        assert list.contains("Apple");
        assert !list.contains("Daikon");
    }

    @Test
    void should_get_items_by_numeric_index() {
        SinglyLinkedList<String> list = createList();

        list.pushBack("Apple");
        list.pushBack("Banana");
        list.pushBack("Cherry");

        assert list.get(0).equals("Apple");
        assert list.get(1).equals("Banana");
        assert list.get(2).equals("Cherry");
    }

    @Test
    void should_fail_to_get_items_by_numeric_index_when_out_of_bounds() {
        SinglyLinkedList<String> list = createList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));

        list.pushBack("Apple");
        list.pushBack("Banana");
        list.pushBack("Cherry");

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));
    }

    @Test
    void should_set_items_by_numeric_index() {
        SinglyLinkedList<String> list = createList();

        list.pushBack("Apple");
        list.pushBack("Banana");
        list.pushBack("Cherry");

        list.set(0, "A");
        list.set(1, "B");
        list.set(2, "C");

        assert containsAll(list, "A", "B", "C");
    }

    @Test
    void should_fail_to_set_items_by_numeric_index_when_out_of_bounds() {
        SinglyLinkedList<String> list = createList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, "hehe"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "hehe"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, "hehe"));

        list.pushBack("Apple");
        list.pushBack("Banana");
        list.pushBack("Cherry");

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, "hehe"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(4, "hehe"));
    }

    @Test
    void should_peek_list() {
        SinglyLinkedList<Integer> list = createList();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        assert list.peekFront() == 1;
        assert list.peekBack() == 3;
    }

    @Test
    void should_fail_to_peek_list_when_empty() {
        SinglyLinkedList<Integer> list = createList();
        assertThrows(NoSuchElementException.class, list::peekBack);
        assertThrows(NoSuchElementException.class, list::peekFront);
    }

    @Test
    void should_pop_from_list() {
        SinglyLinkedList<Integer> list = createList();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        assert list.popFront() == 1;
        assert list.popBack() == 3;
        assert list.popBack() == 2;

        assert list.isEmpty();
        assert list.head() == null;
        assert list.tail() == null;
    }

    @Test
    void should_fail_to_pop_from_list_when_empty() {
        SinglyLinkedList<Integer> list = createList();
        assertThrows(NoSuchElementException.class, list::popBack);
        assertThrows(NoSuchElementException.class, list::popFront);
    }

    @Test
    void should_insert_items_into_arbitrary_positions_of_list() {
        SinglyLinkedList<String> list = createList();

        list.insert(0, "Banana");
        assert containsAll(list, "Banana");

        list.insert(1, "Egg");
        assert containsAll(list, "Banana", "Egg");

        list.insert(0, "Apple");
        assert containsAll(list, "Apple", "Banana", "Egg");

        list.insert(2, "Daikon");
        assert containsAll(list, "Apple", "Banana", "Daikon", "Egg");

        list.insert(2, "Cherry");
        assert containsAll(list, "Apple", "Banana", "Cherry", "Daikon", "Egg");

        assert !list.isEmpty();
        assert list.size() == 5;
    }

    @Test
    void should_fail_to_insert_items_when_index_is_out_of_bounds() {
        SinglyLinkedList<String> list = createList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(-1, "Apple"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(1, "Apple"));

        list.insert(0, "Apple");

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(-2, "Banana"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(2, "Banana"));
    }

    @Test
    void should_clear_list_after_adding_items() {
        SinglyLinkedList<Integer> list = createList();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        assert containsAll(list, 1, 2, 3);

        list.clear();

        assert list.isEmpty();
        assert list.size() == 0;
        assert list.head() == null;

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        assert containsAll(list, 1, 2, 3);
    }

    @Test
    void should_remove_items_from_list_one_by_one_by_value() {
        SinglyLinkedList<String> list = createList();

        list.pushBack("Apple");
        list.pushBack("Banana");
        list.pushBack("Cherry");
        list.pushBack("Daikon");
        list.pushBack("Cherry");
        list.pushBack("Egg");

        assert list.remove("Apple");
        assert containsAll(list, "Banana", "Cherry", "Daikon", "Cherry", "Egg");

        assert !list.remove("Apple") : "Apple cannot be removed twice, there is only one in the list";

        assert list.remove("Cherry");
        assert containsAll(list, "Banana", "Daikon", "Cherry", "Egg");

        assert list.remove("Daikon");
        assert containsAll(list, "Banana", "Cherry", "Egg");

        assert list.remove("Egg");
        assert containsAll(list, "Banana", "Cherry");

        assert list.remove("Cherry") : "Cherry should be able to be removed twice, since there were two in the list";
        assert containsAll(list, "Banana");

        assert list.remove("Banana");
        assert list.isEmpty();
        assert list.size() == 0;
        assert list.head() == null;
    }

    @Test
    void should_remove_items_from_list_one_by_one_by_index() {
        SinglyLinkedList<String> list = createList();

        list.pushBack("Apple");
        list.pushBack("Banana");
        list.pushBack("Cherry");
        list.pushBack("Daikon");
        list.pushBack("Egg");

        list.removeAt(0);
        assert containsAll(list, "Banana", "Cherry", "Daikon", "Egg");

        list.removeAt(2);
        assert containsAll(list, "Banana", "Cherry", "Egg");

        list.removeAt(2);
        assert containsAll(list, "Banana", "Cherry");

        list.removeAt(1);
        assert containsAll(list, "Banana");

        list.removeAt(0);
        assert list.isEmpty();
        assert list.size() == 0;
        assert list.head() == null;
    }

    @Test
    void should_fail_to_remove_items_from_list_by_index_if_index_is_out_of_bounds() {
        SinglyLinkedList<String> list = createList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(0));

        list.pushBack("1");
        list.pushBack("2");
        list.pushBack("3");

        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(3));
    }

    @SuppressWarnings("SameParameterValue")
    private void assertThrows(Class<? extends RuntimeException> clazz, Runnable code) {
        try {
            code.run();
            fail("Expected exception of type " + clazz.getSimpleName() + " to be thrown");
        }
        catch (RuntimeException ex) {
            assert ex.getClass().equals(clazz);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> boolean containsAll(List<T> list, T... thatArr) {
        T[] thisArr = list.toArray();
        if (thisArr.length != thatArr.length) {
            return false;
        }
        for (int i = 0; i < thisArr.length; ++i) {
            if (!Objects.equals(thisArr[i], thatArr[i])) {
                return false;
            }
        }
        return true;
    }
}