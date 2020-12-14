package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ArffLoader.ArffReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class TestClassifier {
	
	private Classifier classifier = new Classifier();
	private Instances data;

	@BeforeEach
	public void setup(String[] args) throws Exception {
		
		ArffLoader loader = new ArffLoader();
		loader.setFile(new File("src/main/resources/germancredit/train.arff"));
		data = loader.getDataSet();

	}

	@Test
	public void testEntropy() {
		assertThrows(IllegalArgumentException.class, () -> {
			classifier.entropy(null);
		});
		assertTrue(classifier.entropy(data) >= 0);
		
		assertEquals(1, classifier.entropy(data));
	}

	@Test
	public void testInformationGain() {
		assertThrows(IllegalArgumentException.class, () -> {
			classifier.informationGain(null, 0);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			classifier.informationGain(data, -1);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			classifier.informationGain(data, data.numAttributes() + 1);
		});
		
		assertEquals(1, classifier.informationGain(data, 0));
	}
}
