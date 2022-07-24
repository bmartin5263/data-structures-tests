package dev.bdon.list;

import dev.bdon.list.linked.doubly.Node;
import dev.bdon.list.linked.doubly.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static dev.bdon.TestUtils.*;
import static org.assertj.core.api.Assertions.fail;

class DoublyLinkedListTest {

    private <T> DoublyLinkedList<T> createList() {
        return null;
    }

    @Test
    void should_insert_items_to_the_back_of_list() {
        DoublyLinkedList<Integer> list = createList();
        assert list.isEmpty();

        list.pushBack(1);
        assert list.head().getData() == 1;
        assert list.tail().getData() == 1;
        assert list.size() == 1;
        assert !list.isEmpty();

        list.pushBack(2);
        assert list.head().getData() == 1;
        assert list.tail().getData() == 2;
        assert list.size() == 2;

        list.pushBack(3);
        assert list.head().getData() == 1;
        assert list.tail().getData() == 3;
        assert list.size() == 3;

        list.pushBack(4);
        assert list.head().getData() == 1;
        assert list.tail().getData() == 4;
        assert list.size() == 4;

        list.pushBack(5);
        assert list.head().getData() == 1;
        assert list.tail().getData() == 5;
        assert list.size() == 5;

        Node<Integer> current = list.head();
        assert current.getData() == 1;
        assert current.getNext() != null;
        assert current.getPrev() == null;

        current = current.getNext();
        assert current.getData() == 2;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getNext();
        assert current.getData() == 3;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getNext();
        assert current.getData() == 4;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getNext();
        assert current.getData() == 5;
        assert current.getNext() == null;
        assert current.getPrev() != null;

        current = list.tail();
        assert current.getData() == 5;
        assert current.getNext() == null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 4;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 3;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 2;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 1;
        assert current.getNext() != null;
        assert current.getPrev() == null;
    }

    @Test
    void should_insert_items_to_the_front_of_list() {
        DoublyLinkedList<Integer> list = createList();
        assert list.isEmpty();

        list.pushFront(1);
        assert list.head().getData() == 1;
        assert list.tail().getData() == 1;
        assert list.size() == 1;
        assert !list.isEmpty();

        list.pushFront(2);
        assert list.head().getData() == 2;
        assert list.tail().getData() == 1;
        assert list.size() == 2;

        list.pushFront(3);
        assert list.head().getData() == 3;
        assert list.tail().getData() == 1;
        assert list.size() == 3;

        list.pushFront(4);
        assert list.head().getData() == 4;
        assert list.tail().getData() == 1;
        assert list.size() == 4;

        list.pushFront(5);
        assert list.head().getData() == 5;
        assert list.tail().getData() == 1;
        assert list.size() == 5;

        Node<Integer> current = list.head();
        assert current.getData() == 5;
        assert current.getNext() != null;
        assert current.getPrev() == null;

        current = current.getNext();
        assert current.getData() == 4;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getNext();
        assert current.getData() == 3;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getNext();
        assert current.getData() == 2;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getNext();
        assert current.getData() == 1;
        assert current.getNext() == null;
        assert current.getPrev() != null;

        current = list.tail();
        assert current.getData() == 1;
        assert current.getNext() == null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 2;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 3;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 4;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 5;
        assert current.getNext() != null;
        assert current.getPrev() == null;
    }

    @Test
    void should_insert_items_to_both_the_front_and_back_of_list() {
        DoublyLinkedList<Integer> list = createList();
        assert list.isEmpty();

        list.pushBack(1);

        assert list.head().getData() == 1;
        assert list.tail().getData() == 1;
        assert list.size() == 1;
        assert !list.isEmpty();

        list.pushFront(2);

        assert list.head().getData() == 2;
        assert list.tail().getData() == 1;
        assert list.size() == 2;

        list.pushFront(3);

        assert list.head().getData() == 3;
        assert list.tail().getData() == 1;
        assert list.size() == 3;

        list.pushBack(4);

        assert list.head().getData() == 3;
        assert list.tail().getData() == 4;
        assert list.size() == 4;

        list.pushFront(5);

        assert list.head().getData() == 5;
        assert list.tail().getData() == 4;
        assert list.size() == 5;

        Node<Integer> current = list.head();
        assert current.getData() == 5;
        assert current.getNext() != null;
        assert current.getPrev() == null;

        current = current.getNext();
        assert current.getData() == 3;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getNext();
        assert current.getData() == 2;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getNext();
        assert current.getData() == 1;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getNext();
        assert current.getData() == 4;
        assert current.getNext() == null;
        assert current.getPrev() != null;

        current = list.tail();
        assert current.getData() == 4;
        assert current.getNext() == null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 1;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 2;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 3;
        assert current.getNext() != null;
        assert current.getPrev() != null;

        current = current.getPrev();
        assert current.getData() == 5;
        assert current.getNext() != null;
        assert current.getPrev() == null;
    }

    @Test
    void should_test_if_list_contains_specified_items() {
        DoublyLinkedList<String> list = createList();
        assert list.isEmpty();

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
        DoublyLinkedList<String> list = createList();
        assert list.isEmpty();

        list.pushBack("Apple");
        list.pushBack("Banana");
        list.pushBack("Cherry");

        assert list.get(0).equals("Apple");
        assert list.get(1).equals("Banana");
        assert list.get(2).equals("Cherry");
    }

    @Test
    void should_fail_to_get_items_by_numeric_index_when_out_of_bounds() {
        DoublyLinkedList<String> list = createList();
        assert list.isEmpty();

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
        DoublyLinkedList<String> list = createList();
        assert list.isEmpty();

        list.pushBack("Apple");
        list.pushBack("Banana");
        list.pushBack("Cherry");

        assertContainsInOrder(list, "Apple", "Banana", "Cherry");

        list.set(0, "A");
        list.set(1, "B");
        list.set(2, "C");

        assertContainsInOrder(list, "A", "B", "C");
    }

    @Test
    void should_fail_to_set_items_by_numeric_index_when_out_of_bounds() {
        DoublyLinkedList<String> list = createList();
        assert list.isEmpty();

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
        DoublyLinkedList<Integer> list = createList();
        assert list.isEmpty();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        assert list.peekFront() == 1;
        assert list.peekBack() == 3;
    }

    @Test
    void should_fail_to_peek_list_when_empty() {
        DoublyLinkedList<Integer> list = createList();
        assert list.isEmpty();
        assertThrows(NoSuchElementException.class, list::peekBack);
        assertThrows(NoSuchElementException.class, list::peekFront);
    }

    @Test
    void should_pop_front_from_list() {
        DoublyLinkedList<Integer> list = createList();
        assert list.isEmpty();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        assert list.popFront() == 1;
        assert list.head().getData() == 2;
        assert list.tail().getData() == 3;

        assert list.popFront() == 2;
        assert list.head().getData() == 3;
        assert list.tail().getData() == 3;

        assert list.popFront() == 3;
        assertEmpty(list);
    }

    @Test
    void should_pop_back_from_list() {
        DoublyLinkedList<Integer> list = createList();
        assert list.isEmpty();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);

        assert list.popBack() == 3;
        assert list.head().getData() == 1;
        assert list.tail().getData() == 2;

        assert list.popBack() == 2;
        assert list.head().getData() == 1;
        assert list.tail().getData() == 1;

        assert list.popBack() == 1;
        assertEmpty(list);
    }

    @Test
    void should_fail_to_pop_from_list_when_empty() {
        DoublyLinkedList<Integer> list = createList();
        assert list.isEmpty();
        assertThrows(NoSuchElementException.class, list::popBack);
        assertThrows(NoSuchElementException.class, list::popFront);
    }

    @Test
    void should_insert_items_into_arbitrary_positions_of_list() {
        DoublyLinkedList<String> list = createList();
        assert list.isEmpty();

        list.insert(0, "Banana");
        assertContainsInOrder(list, "Banana");

        list.insert(1, "Egg");
        assertContainsInOrder(list, "Banana", "Egg");

        list.insert(0, "Apple");
        assertContainsInOrder(list, "Apple", "Banana", "Egg");

        list.insert(2, "Daikon");
        assertContainsInOrder(list, "Apple", "Banana", "Daikon", "Egg");

        list.insert(2, "Cherry");
        assertContainsInOrder(list, "Apple", "Banana", "Cherry", "Daikon", "Egg");

        assert !list.isEmpty();
        assert list.size() == 5;
    }

    @Test
    void should_fail_to_insert_items_when_index_is_out_of_bounds() {
        DoublyLinkedList<String> list = createList();
        assert list.isEmpty();

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(-1, "Apple"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(1, "Apple"));

        list.insert(0, "Apple");

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(-2, "Banana"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(2, "Banana"));
    }

    @Test
    void should_clear_list_after_adding_items() {
        DoublyLinkedList<Integer> list = createList();
        assert list.isEmpty();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        assertContainsInOrder(list, 1, 2, 3);

        list.clear();

        assert list.isEmpty();
        assert list.size() == 0;
        assert list.head() == null;

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        assertContainsInOrder(list, 1, 2, 3);
    }

    @Test
    void should_remove_items_from_list_one_by_one_by_value() {
        DoublyLinkedList<String> list = createList();
        assert list.isEmpty();

        list.pushBack("Apple");
        list.pushBack("Banana");
        list.pushBack("Cherry");
        list.pushBack("Daikon");
        list.pushBack("Cherry");
        list.pushBack("Egg");

        assert list.remove("Apple");
        assertContainsInOrder(list, "Banana", "Cherry", "Daikon", "Cherry", "Egg");
        assert list.head().getData().equals("Banana");
        assert list.tail().getData().equals("Egg");

        assert !list.remove("Apple") : "Apple cannot be removed twice, there is only one in the list";

        assert list.remove("Cherry");
        assertContainsInOrder(list, "Banana", "Daikon", "Cherry", "Egg");
        assert list.head().getData().equals("Banana");
        assert list.tail().getData().equals("Egg");

        assert list.remove("Daikon");
        assertContainsInOrder(list, "Banana", "Cherry", "Egg");
        assert list.head().getData().equals("Banana");
        assert list.tail().getData().equals("Egg");

        assert list.remove("Egg");
        assertContainsInOrder(list, "Banana", "Cherry");
        assert list.head().getData().equals("Banana");
        assert list.tail().getData().equals("Cherry");

        assert list.remove("Cherry") : "Cherry should be able to be removed twice, since there were two in the list";
        assertContainsInOrder(list, "Banana");

        assert list.remove("Banana");
        assertEmpty(list);
    }

    @Test
    void should_remove_items_from_list_one_by_one_by_index() {
        DoublyLinkedList<String> list = createList();
        assert list.isEmpty();

        list.pushBack("Apple");
        list.pushBack("Banana");
        list.pushBack("Cherry");
        list.pushBack("Daikon");
        list.pushBack("Egg");

        list.removeAt(0);
        assertContainsInOrder(list, "Banana", "Cherry", "Daikon", "Egg");

        list.removeAt(2);
        assertContainsInOrder(list, "Banana", "Cherry", "Egg");

        list.removeAt(2);
        assertContainsInOrder(list, "Banana", "Cherry");

        list.removeAt(1);
        assertContainsInOrder(list, "Banana");

        list.removeAt(0);
        assertEmpty(list);
    }

    @Test
    void should_fail_to_remove_items_from_list_by_index_if_index_is_out_of_bounds() {
        DoublyLinkedList<String> list = createList();
        assert list.isEmpty();

        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(0));

        list.pushBack("1");
        list.pushBack("2");
        list.pushBack("3");

        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(3));
    }

    @Test
    void should_allow_duplicate_items() {
        DoublyLinkedList<String> list = createList();
        assert list.isEmpty();

        list.pushBack("hello");
        list.pushBack("hello");
        list.pushBack("hello");

        assert list.size() == 3;
        assertContainsInOrder(list, "hello", "hello", "hello");
    }
}

