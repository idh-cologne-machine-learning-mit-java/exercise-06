package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTree {
	Tree tree = new Tree();
	
	@BeforeEach
	public void setup() {
		
	}

	@Test
	public void testIsLeaf() {
		assertTrue(tree.isLeaf());
	}

}
