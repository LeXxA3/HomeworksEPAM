import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class Comparison {

    
    public static void main(String[] args) {
        try {
            List<String> List1 = getFileContent("G:\\textfile1.txt");
            List<String> List2 = getFileContent("G:\\textfile2.txt");
            List<String> arr = differencesOfFiles(List1, List2);
            createCSV(arr);
        }
        catch (IOException e){
            System.out.println ("Некорретный файл!");
        }
    }

    private static List<String> differencesOfFiles(List<String> List1, List<String> List2) {
        List<String> listOfDifferences = new ArrayList<String>();
        if (List1.size() > List2.size()) {
            for (int i = List2.size(); i < List1.size(); i++) {
                List2.add("пустая строка");
            }
            for (int i = 0; i < List1.size(); i++) {
                if (!List1.get(i).equals(List2.get(i))) {
                    listOfDifferences.add(List1.get(i));
                    listOfDifferences.add(List2.get(i));
                }
            }
        } else {
            for (int i = List1.size(); i < List2.size(); i++) {
                List1.add("пустая строка");
            }
            for (int i = 0; i < List2.size(); i++) {
                if (!List1.get(i).equals(List2.get(i))) {
                    listOfDifferences.add(List1.get(i));
                    listOfDifferences.add(List2.get(i));
                }
            }
        }
        return listOfDifferences;
    }

    private static void createCSV(List<String> myList) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("G:\\diffirences.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("list1");
        sb.append(';');
        sb.append("list2");
        sb.append('\n');
        for (int i = 0; i < myList.size(); i++) {
            sb.append(myList.get(i));
            sb.append(';');
            i++;
            sb.append(myList.get(i));
            sb.append('\n');
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("CSV created");
    }

    private static List<String> getFileContent(String filePath) throws IOException {
        BufferedReader br = null;
        List<String> arrayListOfFile = new ArrayList<String>();

        String sCurrentLine;

        br = new BufferedReader(new FileReader(filePath));

        while ((sCurrentLine = br.readLine()) != null) {
            arrayListOfFile.add(sCurrentLine);
        }
        return arrayListOfFile;
    }
}