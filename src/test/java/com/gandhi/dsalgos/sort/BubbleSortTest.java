package com.gandhi.dsalgos.sort;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

@Test
public class BubbleSortTest {

	@Test
	public void testBubbleSort() {
		BubbleSort bubbleSort = new BubbleSort();

		int[] result = bubbleSort.sort(new int[] { 2, 5, 7, 4, 3, 10, 15, 5, 6, });
		assertEquals(result, new int[] { 2, 3, 4, 5, 5, 6, 7, 10, 15 });

		result = bubbleSort.sort(new int[] { 2, 3, 4, 5, 7, 10 });
		assertEquals(result, new int[] { 2, 3, 4, 5, 7, 10 });
	}

}
