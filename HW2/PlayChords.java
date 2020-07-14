package assignment2;
import algs4.*;
/*
 * <Ximan Liu>
 * <PlayChords>
 */


public class PlayChords {
	
	public static void main(String[] args) {
		
		BST<String, Double> notes = new BST<>();
        double duration = 0.5;
        StdIn.fromFile("data/notes_frequencies.txt");  
        while (!StdIn.isEmpty()) {
            String string = StdIn.readLine();
            String[] arrFrequencies = string.split("\\s+");
            notes.put(arrFrequencies[0], Double.parseDouble(arrFrequencies[1]));
        }

        StdIn.fromFile("data/chords.txt");
        while (!StdIn.isEmpty()) {
        	String string = StdIn.readLine();
            String[] words = string.split("\\s+");
            double[] file = new double[words.length];
            
            int count = 0;
            for (String word : words) {
            	double frequency = notes.get(word);
            	file[count] = frequency;
            	count++;
            }
            playChordOneSecond(file);
        }
	}
		
	
	public static void playChordOneSecond(double... frequencies) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * 1.0);
		final double[] slices = new double[sliceCount+1];
		for (double frequency: frequencies) {
			for (int i = 0; i <= sliceCount; i++) {
				slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
			}
		}
		StdAudio.play(slices);
	}

}
