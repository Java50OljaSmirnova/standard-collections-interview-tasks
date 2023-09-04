package telran.standart.collections.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandartListTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		List<Integer> list = List.of(10, -5, 13, 17, 10);
		assertThrowsExactly(UnsupportedOperationException.class, () -> list.remove(0));
		LinkedList<Integer> linkedList = new LinkedList<>(list);
	    linkedList.remove(0);
	    Integer[] expected = {-5, 13, 17, 10};
	    assertArrayEquals(expected, linkedList.toArray(Integer[]:: new));
	}
	@Test
	void sublistTest() {
		LinkedList<Integer> linkedList = new LinkedList<>(List.of(10, -5, 13, 17, 10));
		List<Integer> subList1 = linkedList.subList(1, 3);
//		Integer[] expected1 = {-5, 13};
		Integer[] expected2 = {10, -5, 100, 13, 17, 10};
		subList1.add(1, 100);
		assertArrayEquals(expected2, linkedList.toArray(Integer[]::new));
		List<Integer> subList2 = linkedList.subList(4, linkedList.size());
		Integer[] expected3 = {17, 10};
		assertArrayEquals(expected3, subList2.toArray(Integer[]::new));
		subList2.remove(0);
//		subList2.add(0, 20);
//		linkedList.add(0, 10);
//		Integer[] expected4 = {10, -5, 13, 100, 10};
		Integer[] expected5 = { 10};
		assertArrayEquals(expected5, subList2.toArray(Integer[]::new));
		assertThrowsExactly(ConcurrentModificationException.class, () -> subList1.toArray(Integer[]::new));
		linkedList.add(10);
		assertThrowsExactly(ConcurrentModificationException.class, () -> subList1.toArray(Integer[]::new));
	}

}
