package de.ukoeln.idh.teaching.jml.ex06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import weka.core.Instances;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClassifier {

	private Classifier klassifikator = new Classifier();
	private Instances data;

	@BeforeEach
	public void setup() {

	}

	@Test
	public void testEntropy() {
		
		assertTrue(klassifikator.entropy(data) >= 0);
	}

	@Test
	public void testEntropyInput() {
		assertThrows(NullPointerException.class, () -> {
			klassifikator.entropy(null);
		});
	}

	@Test
	public void testInformationGain() {
		
		assertTrue(klassifikator.informationGain(data, 0/*data.classIndex()*/) >= 0);
	}

	@Test
	public void testInformationGainInputNull() {
		assertThrows(NullPointerException.class, () -> {
			klassifikator.informationGain(null, 0);
		});
	}

	@Test
	public void testInformationGainInputIllegal() {
		assertThrows(IllegalArgumentException.class, () -> {
			klassifikator.informationGain(data, -1);
		});
	}
}
	
	
	
	
	
	
	

