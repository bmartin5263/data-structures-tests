package dev.bdon;

import dev.bdon.interfaces.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

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
        assert list.head() != null;
        assert list.size() == 1;
        assert !list.isEmpty();

        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        assert list.size() == 5;

        SinglyLinkedList.Node<Integer> current = list.head();
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
        list.pushFront(2);
        list.pushFront(3);
        list.pushFront(4);
        list.pushFront(5);
        assert list.head() != null;
        assert list.size() == 5;
        assert !list.isEmpty();

        SinglyLinkedList.Node<Integer> current = list.head();
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
    void should_insert_items_into_arbitrary_positions_of_list() {
        SinglyLinkedList<String> list = createList();

        list.insert(0, "Banana");
        assert Arrays.deepEquals(list.toArray(), arrayOf("Banana"));

        list.insert(1, "Egg");
        assert Arrays.deepEquals(list.toArray(), arrayOf("Banana", "Egg"));

        list.insert(0, "Apple");
        assert Arrays.deepEquals(list.toArray(), arrayOf("Apple", "Banana", "Egg"));

        list.insert(2, "Daikon");
        assert Arrays.deepEquals(list.toArray(), arrayOf("Apple", "Banana", "Daikon", "Egg"));

        list.insert(2, "Cherry");
        assert Arrays.deepEquals(list.toArray(), arrayOf("Apple", "Banana", "Cherry", "Daikon", "Egg"));

        assert !list.isEmpty();
        assert list.size() == 5;
    }

    @Test
    void should_clear_list_after_adding_items() {
        SinglyLinkedList<String> list = createList();

        list.pushBack("1");
        list.pushBack("2");
        list.pushBack("3");
        list.clear();

        assert list.isEmpty();
        assert list.size() == 0;
        assert list.head() == null;
    }

    @Test
    void should_remove_items_from_list_one_by_one() {
        SinglyLinkedList<String> list = createList();

        list.pushBack("1");
        list.pushBack("2");
        list.pushBack("3");
        list.pushBack("4");
        list.pushBack("5");

        assert list.remove("1");
        assert !list.remove("1");
        assert list.remove("4");
        assert list.remove("5");
        assert list.remove("3");
        assert list.remove("2");

        assert list.isEmpty();
        assert list.size() == 0;
        assert list.head() == null;
    }

    @Test
    void should_return_the_max_and_min_items_in_the_list() {
        SinglyLinkedList<Integer> list = createList();

        list.pushFront(12);
        list.pushFront(0);
        list.pushFront(140);
        list.pushFront(-333);
        list.pushFront(38);

        assert list.max() == 140;
        assert list.min() == -333;
    }

    @SafeVarargs
    private <T> T[] arrayOf(T... items) {
        return items;
    }
}