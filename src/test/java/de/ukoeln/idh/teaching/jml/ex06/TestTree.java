package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import weka.core.DenseInstance;
import de.ukoeln.idh.teaching.jml.ex06.Tree;

public class TestTree {
	
	private Tree tree = new Tree();
	
	@BeforeEach
	public void setup() {
	
	}

	@Test
	public void testIsLeaf() {
		tree.children = null;
		assertTrue(tree.isLeaf(), "isLeaf() returns false for leaf node");
		Tree child = new Tree();
		tree.children = new Tree[] {child};
		assertFalse(tree.isLeaf(), "isLeaf() isLeaf() returns true for non-leaf node");
	}
	
	
	@Test
	public void testPredict() {
		// test null param input
		assertThrows(Exception.class, () -> tree.predict(null));
		
		// test instance that has no attribute matching attributeIndex
		tree.attributeIndex = 2;
		assertThrows(Exception.class, () -> tree.predict(new DenseInstance(1)));
		
		// test prediciotn is in range 0-1 (incl.)
		tree.attributeIndex = 0;
		double prediction = tree.predict(new DenseInstance(1));
		assertTrue(0.0 <= prediction && prediction <= 1.0);
	}

}
