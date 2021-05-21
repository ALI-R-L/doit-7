import com.sun.javafx.iio.ios.IosDescriptor;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class FileUtils {

    private ArrayList<String> files ;
    private String fileLists = "FileList.txt";
    private String line;

    public FileUtils(){
        files = new ArrayList<String>();
    }


    public void addNewNote(String fileName){

        try {
            FileReader fr = new FileReader(fileLists);
            BufferedReader br = new BufferedReader(fr);

            while( (line = br.readLine() ) != null ) {
//                System.out.println(line);
                files.add(line);
            }
            br.close();

            FileWriter fw = new FileWriter(fileLists,true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (files.contains(fileName)){
                return;
            }
            files.add(fileName);
            bw.append(fileName);
            bw.newLine();
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }


    public void makeNewNote(String fileName,String text){
        addNewNote(fileName);
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.newLine();
            bw.close();
//            System.out.println("enter your text :");

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFile(String fileName){

        if (!files.contains(fileName)){
            System.out.println("there is not a file with this name");
            return;
        }
        System.out.println("**file content :");
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            while( (line = br.readLine() ) != null ) {
                System.out.println(line);
            }
            br.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void removeFile(String fileName){
        System.out.println("remove a file :");
        ArrayList<String> tempFiles = new ArrayList<String>();
        int i = 0;
        try {
            FileReader fr = new FileReader(fileLists);
            BufferedReader br = new BufferedReader(fr);
            while( (line = br.readLine() ) != null ) {
//                System.out.println(line);
                tempFiles.add(line);
//

            }
            br.close();

            Iterator<String> it = tempFiles.iterator();
            while (it.hasNext()){
                String t = it.next();
                if (t.equals(fileName)){
                    it.remove();
                }
            }

            FileWriter fw = new FileWriter(fileLists);
            BufferedWriter bw = new BufferedWriter(fw);
            files = tempFiles;
//            System.out.println("tempFiles are :");
            for (String fName : files){
//                System.out.println(fName);
                System.out.println(files.get(i));
                bw.write(fName);
                bw.newLine();
                i++;
            }

            bw.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }



    }

    public void showFileList() {

        System.out.println("**your notes :");
//        Iterator<String> it = files.iterator();

        try {
            FileReader fr = new FileReader(fileLists);
            BufferedReader br = new BufferedReader(fr);

            while( (line = br.readLine() ) != null ) {
                System.out.println(line);
            }
            br.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }



//        try {
//            FileWriter fwList = new FileWriter( fileLists,true);
//            BufferedWriter bwList = new BufferedWriter(fwList);
//
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
    }

    public void objectFileWriter(String fileName, Object object){
        addNewNote(fileName);
        try {
           FileOutputStream fs = new FileOutputStream(fileName);
           ObjectOutputStream os = new ObjectOutputStream(fs);

           os.writeObject(object);


        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void objectFileReader(String fileName){
        if (!files.contains(fileName)){
            System.out.println("there is not a file with this name");
            return;
        }
        System.out.println("**file content :");
        try {
            FileInputStream fs = new FileInputStream(fileName);
            ObjectInputStream os = new ObjectInputStream(fs);

            Note note1 = (Note)os.readObject();
            System.out.println("note title : "+note1.getTitle());
            System.out.println("note content : "+note1.getContent());
            System.out.println("noter date : "+note1.getDate());

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
