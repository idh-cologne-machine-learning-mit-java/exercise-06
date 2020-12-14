package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestTree {

	Tree testTree;

	@BeforeEach
	public void setup() {
		testTree = new Tree();
	}

	@Test
	public void testIsLeaf() {

		assertTrue(
				testTree.children != null && !testTree.isLeaf() || // tree has no children then its not a tree (explicit)
				testTree.children == null && testTree.isLeaf() // // tree has children then its not a leave here  (explicit)
		);
	}

}
