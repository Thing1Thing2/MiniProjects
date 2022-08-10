import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;


public class CaesarCipherFile {
    public final static int KEY = 1; //KEY is constant used to caesar plaintext

    /**
     * Returns Encoded line
     * @param line String to encode
     * @return String encoded String to return
     */
    public static String caesar(String line) {
        char currChar;
        char encodedChar;
        StringBuilder s = new StringBuilder();
        int n = line.length();
        for (int i = 0; i < n; i ++) {
            currChar = line.charAt(i); //access char
            encodedChar = encodeChar(currChar); //encode char
            s.append(encodedChar); //append encoded char
        }
        return s.toString();
    }

    /**
     * Returns Encoded line
     * @param line String to encode
     * @return String encoded String to return
     */
    public static String deCaesar(String line) {
        char currChar;
        char decodedChar;
        StringBuilder s = new StringBuilder();
        int n = line.length();
        for (int i = 0; i < n; i ++) {
            currChar = line.charAt(i); //access char
            decodedChar = decodeChar(currChar); //encode char
            s.append(decodedChar); //append encoded char
        }
        return s.toString();
    }

    private static char encodeChar(char c) {
        return (char) (c + KEY);
    }

    private static char decodeChar(char c) {
        return (char) (c - KEY);
    }

    /**
     * reads in a .txt file and encrypts using caesar cipher
     * output is a new .txt file
     * @param filePath path of file that has to be encrypted
     * @param writeToPath return file
     */
    public static void encodeFile(String filePath, String writeToPath) { //give filePath of file to encode, and writeToPath
        File file = new File(filePath); //access file to read from
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(writeToPath, true); //FileWriter initialised
            if (file.canWrite()) {
                bw = new BufferedWriter(fw);
                Scanner caesarCipherFileScanner = new Scanner(file); //Scan-able file
                String line; //placeholder for line to encode
                while (caesarCipherFileScanner.hasNext()) {
                    line = caesarCipherFileScanner.nextLine();
                    bw.write(caesar(line));
                    bw.write("\n");
                }
            } else {
                System.out.println("Cannot write to file");
            }
        } catch(FileNotFoundException fne) {
        System.out.println("FileNotFoundException");
        } catch (IOException ioe) {
            System.out.println("IOException");
        } finally {
            try {
                if (fw != null && bw != null) {
                    bw.close();
                    fw.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error closing");
            }
        }
    }

    /**
     * reads in a .txt file and encrypts using caesar cipher
     * output is a new .txt file
     * @param filePath path of file that has to be encrypted
     * @param writeToPath return file
     */
    public static void decodeFile(String filePath, String writeToPath) { //give filePath of file to encode, and writeToPath
        File file = new File(filePath); //access file to read from
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(writeToPath, true); //FileWriter initialised
            if (file.canWrite()) {
                bw = new BufferedWriter(fw);
                Scanner caesarCipherFileScanner = new Scanner(file); //Scan-able file
                String line; //placeholder for line to encode
                while (caesarCipherFileScanner.hasNext()) {
                    line = caesarCipherFileScanner.nextLine();
                    bw.write(deCaesar(line));
                    bw.write("\n");
                }
            } else {
                System.out.println("Cannot write to file");
            }
        } catch(FileNotFoundException fne) {
            System.out.println("FileNotFoundException");
        } catch (IOException ioe) {
            System.out.println("IOException");
        } finally {
            try {
                if (fw != null && bw != null) {
                    bw.close();
                    fw.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error closing");
            }
        }
    }



    public static void main(String[] args) {
        //String testString = "Hello World";
        //System.out.println(caesar(testString));
        String path = "C:\\Users\\Tina\\IdeaProjects\\CutRod\\src\\Useless.txt";
        String writeTo = "UselessCipher.txt";
        String deCrypted = "DecryptUselessCipher.txt";
        encodeFile(path, writeTo);
        decodeFile(writeTo, deCrypted);
    }
}
