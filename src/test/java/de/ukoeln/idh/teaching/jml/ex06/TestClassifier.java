package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.ukoeln.idh.teaching.jml.ex06.Classifier;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class TestClassifier {

	private Classifier classifier = new Classifier();
	private Instances instances;
	private Tree output;
	
	@BeforeEach
	public void setup() throws IOException {
		ArffLoader loader = new ArffLoader();
		loader.setFile(new File("src/main/resources/amazon/train.arff.gz"));		
		instances = loader.getDataSet();
		System.out.println(instances.numAttributes());
		
		output = classifier.train(instances);
	}
	
	@Test
	public void testTrain() {
		// test null param input
		assertThrows(Exception.class, () -> classifier.train(null));
	}
	
	@Test
	public void testTrainOutput() {
		// test output
		assertFalse(output.isLeaf());
	}

	@Test
	public void testEntropy() {
		// test empty input 
		assertThrows(Exception.class, () -> classifier.entropy(null));
		
		// test entropy value
		double e = classifier.entropy(instances);
		assertTrue(0.0 <= e && e <= 1.0);
	}

	@Test
	public void testInformationGain() {
		// test empty instances parameter
		assertThrows(Exception.class, () -> classifier.informationGain(null, 0));
		
		// test bad attributeIndex value
		assertThrows(Exception.class, () -> classifier.informationGain(instances, -1));
		assertThrows(Exception.class, () -> classifier.informationGain(instances, instances.numAttributes() + 1));
		
		// test output
		double i = classifier.informationGain(instances, 0);
		assertTrue(0.0 <= i && i <= 1.0);
		
	}
}
