import java.io.*;
import java.util.*;
/**
 * Replaces all occurrences of a string in a text file with a new string
 * The file name and strings are passed as CL args
 * Example: java ReplaceText sourceFile targetFile oldString newString
 */
public class ReplaceText {
    public static void main(String[] args) throws IOException {
        // check command line param usage
        if(args.length != 4) {
            System.out.println(
                "Usage: java ReplaceText sourceFile targetFile oldStr newStr"
            );
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println(
                "Source file " + args[0] + " does not exist" 
            );
            System.exit(2);
        }

        // Check if target file exists
        File targetFile = new File(args[1]);
        if (!targetFile.exists()) {
            System.out.println(
                "Target file " + args[1] + " does not exist" 
            );
            System.exit(3);
        }

        try (
            // Create IO files
            Scanner input = new Scanner(sourceFile);
            PrintWriter output = new PrintWriter(targetFile);
        ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[2], args[3]);
                output.println(s2);
            }
        }
    }
}
