package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertTrue;

import weka.core.Instances;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClassifier {
	Classifier classifier = new Classifier();
	Instances instances;

	@BeforeEach
	public void setup() {

	}

	@Test
	public void testEntropy() {
		assertTrue(classifier.entropy(instances) >= 0);
	}

	@Test
	public void testInformationGain() {
		assertTrue(classifier.informationGain(instances, 0) >= 0);
	}
}
