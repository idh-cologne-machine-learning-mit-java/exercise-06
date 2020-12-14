package de.ukoeln.idh.teaching.jml.ex06;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import weka.core.Instances;
import weka.core.converters.ArffLoader;


public class TestClassifier {
	
// 		
//	@Mock 
//	Instances testInstances;
	
	private Classifier classifier = new Classifier();
	private Instances importedData;
	

	@BeforeEach
	public void setup() throws IOException {
		
		ArffLoader loader = new ArffLoader();
		loader.setFile(new File("src/main/ressources/germancredit/train.arff"));		
		importedData = loader.getDataSet();
		 
		
	}

	@Test
	public void testEntropy() {

		assertTrue(0 <= classifier.entropy(importedData) && classifier.entropy(importedData) <= 1);
	}

	
	@Test
	public void testInformationGain() {
		assertThrows(Exception.class, () -> classifier.informationGain(null, 0));
		assertThrows(Exception.class, () -> classifier.informationGain(importedData, -1));
		assertThrows(Exception.class, () -> classifier.informationGain(importedData, importedData.numAttributes() + 1));
		assertTrue(0 <= classifier.informationGain(importedData, 0) && classifier.informationGain(importedData, 0) <= 1);
	}
}
