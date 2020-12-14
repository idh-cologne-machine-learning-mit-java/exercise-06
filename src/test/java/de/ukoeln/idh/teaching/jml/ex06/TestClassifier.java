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

import weka.core.Instances;
import weka.core.converters.ArffLoader;


public class TestClassifier {

//
//	@Mock
//	Instances testInstances;

	private Classifier classifier;
	private Instances testData;


	private Instances loadData(String path) throws IOException {
		FileReader file = new FileReader(path);
		BufferedReader data = new BufferedReader(file);
		return new Instances(data);
	}

	@BeforeEach
	public void setup() throws IOException {
		testData = loadData("src/resources/test.arff"); // not in git, so one needs to specify an own dataset
		classifier = new Classifier();
	}


	@Test
	public void testEntropy() {
		double entropy = classifier.entropy(testData);
		assertTrue(0 <= entropy && entropy <= 1);
	}


	@Test
	public void testInformationGain() {

		double informationGain = classifier.informationGain(testData, testData.numAttributes() - 1);

		assertTrue(0 <= informationGain && informationGain <= 1);
	}
}
