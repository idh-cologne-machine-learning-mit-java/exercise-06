package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTree {
	
		private Tree tree1, tree2;
	
	@BeforeEach
	public void setup() {
		tree1 = mock(Tree.class);
		
		tree2 = mock(Tree.class);
		tree2.children = mock(Tree[].class);
	}

	@Test
	public void testIsLeaf() {
		assertTrue(tree1.isLeaf());
	}
	
	@Test
	public void testIsNoLeaf() {
		assertFalse(tree2.isLeaf());
	}

}
