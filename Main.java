import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize the scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Specify the audio file path
            File file = new File("C:\\Users\\affaa\\Documents\\Melonpan\\src\\SEVENTEEN - HOT Ringtone.wav");

            // Set up the audio input stream and the clip
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            String response = "";

            // Loop for user commands
            while (!response.equals("Q")) {
                System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
                System.out.println("Enter your choice:");

                response = scanner.next().toUpperCase(); // Convert input to uppercase

                switch (response) {
                    case "P": // Play the audio
                        clip.start();
                        break;
                    case "S": // Stop the audio
                        clip.stop();
                        break;
                    case "R": // Reset the audio position to the start
                        clip.setMicrosecondPosition(0);
                        break;
                    case "Q": // Quit the program
                        clip.close();
                        break;
                    default:
                        System.err.println("Invalid Response");
                        break;
                }
            }

            // Close the scanner
            scanner.close();
            System.out.println("Task Completed");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(); // Print the stack trace if an error occurs
        }
    }
}
