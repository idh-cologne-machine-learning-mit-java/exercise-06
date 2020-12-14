package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class TestClassifier {
	
	private Instances data;
	private Classifier classifier = new Classifier();

	@BeforeEach
	public void setup() throws Exception {
		
		//try to get the data from training.arff
		DataSource loader = new DataSource("src/main/resources/germancredit/train.arff");
		data = loader.getDataSet();
		
		System.out.println(data.numAttributes());

	}

	@Test
	public void testEntropy() {
		assertTrue(classifier.entropy(data) >= 0);
		
		assertEquals(1, classifier.entropy(data));
	}

	@Test
	public void testInformationGain() {
		assertEquals(1, classifier.informationGain(data, 0));	
	}
}
