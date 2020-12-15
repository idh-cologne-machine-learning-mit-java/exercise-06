package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTree {
	
	Tree testTree = new Tree();
	
	@BeforeEach
	public void setup() {
		
	}

	@Test
	public void testIsLeaf() {
		assertTrue(testTree.isLeaf()); // <-- this needs to be changed
		
		testTree.children = new Tree[] {};
		assertTrue(testTree.isLeaf());
		
		testTree.children = new Tree[] {new Tree(), new Tree()};
		assertFalse(testTree.isLeaf());
	}

}
