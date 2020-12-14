package de.ukoeln.idh.teaching.jml.ex06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import weka.core.Instances;

public class TestClassifier {

		private Classifier classifier = new Classifier();
		private Instances data;

	@BeforeEach
	public void setup() {
		data = mock(Instances.class);
	}

	@Test
	public void testEntropy() {
		assertTrue(classifier.entropy(data) >= 0);
	}

	@Test
	public void testEntropyInput() {
		assertThrows(NullPointerException.class, () -> {
			classifier.entropy(null);
		});
	}

	@Test
	public void testInformationGain() {
		assertTrue(classifier.informationGain(data, 0/*data.classIndex()*/) >= 0);
	}
	
	@Test
	public void testInformationGainInputNull() {
		assertThrows(NullPointerException.class, () -> {
			classifier.informationGain(null, 0);
		});
	}
	
	@Test
	public void testInformationGainInputIllegal() {
		assertThrows(IllegalArgumentException.class, () -> {
			classifier.informationGain(data, -1);
		});
	}
	
}