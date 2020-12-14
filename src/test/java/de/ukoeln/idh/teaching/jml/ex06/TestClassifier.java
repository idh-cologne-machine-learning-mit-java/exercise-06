package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class TestClassifier {
	
	private Classifier classifier;

	@BeforeEach
	public void setup() throws IOException{

		DataSource source = new DataSource("src/main/resources/germancredit/train.arff");
		Instances dataset = source.getDataSet();

	}

	@Test
	public void testEntropy() {

		assertTrue(classifier.entropy(dataset) >= 0 && classifier.entropy(dataset) <= 1);
	}

	@Test
	public void testInformationGain() {

		assertTrue(classifier.informationGain(dataset, 0) >= 0) && classifier.informationGain(dataset, 0) <= 1);
	}
}
