package de.ukoeln.idh.teaching.jml.ex06;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class TestClassifier {

	Classifier classifier = new Classifier();
	Instances data;
	Tree results;


	@BeforeEach
	public void setup() throws Exception{
		DataSource source = new DataSource("src/resources/germancredit/train.arff");
		data = source.getDataSet();
		if(data.classIndex() == -1){
			data.setClassIndex(data.numAttributes() - 1);
		}
		System.out.println(data.numAttributes());
	}

	@Test
	public void testTrain(){
		results = classifier.train(data);
		assertThrows(IllegalArgumentException.class,()->{classifier.train(null);});
	}

	@Test
	public void testEntropy() {
		//illegal input
		assertThrows(IllegalArgumentException.class, ()->{classifier.entropy(null);});

		double H = classifier.entropy(data);
		//this is not really correct, as entropy could be greater than 1
		//but deciding on another limiting case is difficult without actual values
		assertTrue(0.0 <= H && H <= 1.0);

	}

	@Test
	public void testInformationGain() {
		assertThrows(IllegalArgumentException.class, () -> {classifier.informationGain(null, Integer.MIN_VALUE);});
		assertThrows(IllegalArgumentException.class, () -> {classifier.informationGain(data, -1);});
		assertThrows(IllegalArgumentException.class, ()->{classifier.informationGain(data, data.numAttributes()+1);});

		double ig = classifier.informationGain(data, 0);
		assertTrue(0.0 <= ig && ig <= 1.0);
	}
}
