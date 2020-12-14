package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTree {

	private Tree baum_eins;
	private Tree baum_zwei;

@BeforeEach
public void setup() {

	baum_eins = mock(Tree.class);

	baum_zwei = mock(Tree.class);
	baum_zwei.children = mock(Tree[].class);
}

@Test
public void testIsLeaf() {

	assertTrue(baum_eins.isLeaf());
}

@Test
public void testIsNoLeaf() {
	assertFalse(baum_zwei.isLeaf());
}
}

