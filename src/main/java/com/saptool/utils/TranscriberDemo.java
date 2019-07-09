package com.saptool.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;
import edu.cmu.sphinx.decoder.adaptation.Stats;
import edu.cmu.sphinx.decoder.adaptation.Transform;
import edu.cmu.sphinx.result.WordResult;

public class TranscriberDemo {

    public static void main(String[] args) throws Exception {


        Configuration configuration = new Configuration();

        // Load model from the jar
        configuration
                .setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");

        // You can also load model from folder
        // configuration.setAcousticModelPath("file:en-us");

        configuration
                .setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration
                .setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(
                configuration);
        InputStream stream = TranscriberDemo.class
                .getResourceAsStream("/edu/cmu/sphinx/demo/aligner/10001-90210-01803.wav");
        stream.skip(44);

        // Simple recognition with generic model
        recognizer.startRecognition(stream);
        SpeechResult result;
        while ((result = recognizer.getResult()) != null) {
            for (WordResult r : result.getWords()) {
              //  System.out.println(r);
            }

            for (String s : result.getNbest(3))
                System.out.println(s);

        }
        recognizer.stopRecognition();

        // Live adaptation to speaker with speaker profiles

        stream = TranscriberDemo.class
                .getResourceAsStream("/edu/cmu/sphinx/demo/aligner/10001-90210-01803.wav");
        stream.skip(44);

        // Stats class is used to collect speaker-specific data
        Stats stats = recognizer.createStats(1);
        recognizer.startRecognition(stream);
        while ((result = recognizer.getResult()) != null) {
            stats.collect(result);
        }
        recognizer.stopRecognition();

        // Transform represents the speech profile
        Transform transform = stats.createTransform();
        recognizer.setTransform(transform);

        // Decode again with updated transform
        stream = TranscriberDemo.class
                .getResourceAsStream("/edu/cmu/sphinx/demo/aligner/10001-90210-01803.wav");
        stream.skip(44);
        recognizer.startRecognition(stream);
        while ((result = recognizer.getResult()) != null) {
            System.out.format("Hypothesis: %s\n", result.getHypothesis());
        }
        recognizer.stopRecognition();

    }
}