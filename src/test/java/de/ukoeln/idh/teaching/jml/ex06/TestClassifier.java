package de.ukoeln.idh.teaching.jml.ex06;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import weka.core.Instances;

public class TestClassifier {
	
	Classifier classifier = new Classifier();
	@Mock
	Instances testInstances;

	@BeforeEach
	public void setup() {
		this.testInstances = mock(Instances.class);
		System.out.println(testInstances.numAttributes());
	}
	
	@Test
	public void testEntropy() {
		double entropy = classifier.entropy(testInstances);
		assertTrue(entropy >= 0.0);
	}
	
	@Test
	public void testEntropyNullPointer() {
		assertThrows(NullPointerException.class, () -> {
			classifier.entropy(null);
		});
	}
	
	@Test
	public void testInformationGain() {
		// TODO index of attribute
		double ig = classifier.informationGain(testInstances, 0);
		assertTrue(ig >= 0.0);
	}
	
	@Test
	public void testIGNullPointer() {
		assertThrows(NullPointerException.class, () -> {
			classifier.informationGain(null, 0);
		});
	}
	
	@Test
	public void testIGAttributeIndex() {
		// TODO classIndex > attributes.size()
		assertThrows(IllegalArgumentException.class, () -> {
			classifier.informationGain(testInstances, -1);	
		});
	}
}
