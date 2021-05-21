import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FileUtils fileUtils = new FileUtils();

        /*
        String text = "hello , how are you ?";

        String fileName = "test1.txt";
        String fileName1 = "test2.txt";

        fileUtils.makeNewNote(fileName,text);
        fileUtils.readFile(fileName);

        fileUtils.makeNewNote(fileName1,text+"11");
        fileUtils.readFile(fileName1);

        fileUtils.showFileList();
        fileUtils.removeFile("test2.txt");
        fileUtils.showFileList();
        fileUtils.readFile(fileName1);
        */

        Note note = new Note("firstNote","hello \n this is note Object",new Date());

        fileUtils.objectFileWriter("noteTest.txt",note);
        fileUtils.objectFileReader("noteTest.txt");


    }
}
