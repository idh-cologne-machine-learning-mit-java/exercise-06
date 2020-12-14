package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class TestClassifier {
	private Classifier classifier = new Classifier();
	private Instances instances;

	@BeforeEach
	public void setup() throws IOException {
		//Mockito missing in pom.xml
		ArffLoader loader = new ArffLoader();
		loader.setFile(new File("src/main/resources/germancredit/train.arff"));
		instances = loader.getDataSet();		
	}

	@Test
	public void testEntropy() {
		//test if entropy value is between 0 and 1.0
		double entr = classifier.entropy(instances);
		assertTrue(entr >= 0.0 && entr <= 1.0);
	}

	@Test
	public void testInformationGain() {
		//test if InformationGain is between 0 and 1.0
		double ig = classifier.informationGain(instances, 0);
		assertTrue(ig >= 0.0 && ig <= 1.0);
		
		//test for valid int attributeIndex
		assertThrows(Exception.class, () -> classifier.informationGain(instances, -1));
		assertThrows(Exception.class, () -> classifier.informationGain(instances, instances.numAttributes() +1));
	}
}
