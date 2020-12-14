package de.ukoeln.idh.teaching.jml.ex06;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTree {
	
	Tree leafTree;
	Tree noLeafTree;
	
	@BeforeEach
	public void setup() {
		this.leafTree = new Tree();
		this.noLeafTree = new Tree();
		this.noLeafTree.children = new Tree[] {new Tree()};
	}

	@Test
	public void testIsLeaf() {
		assertTrue(leafTree.isLeaf());
	}
	
	@Test
	public void testIsNoLeaf() {
		assertFalse(noLeafTree.isLeaf());
	}

}
