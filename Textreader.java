import java.util.*;
import java.io.*;

class Textreader {

public static ArrayList<Questions> readtext() throws FileNotFoundException{
	ArrayList questionlist = new ArrayList();
	File qFile = new File("questions.txt");
	FileReader fileReader = new FileReader(qFile);
	Scanner scanner = new Scanner(fileReader);
	String str;
	while(scanner.hasNextLine()){
		String qtxt = "";
		int ansno = 0;
		String trueans = "";
		String[] ans = new String[5];
		boolean ismultiple = false;
		int correctsteps = 0;
		int wrongsteps = 0;		
		if (scanner.nextLine() == "Multiple Choice")
		ismultiple = true;
		qtxt = scanner.nextLine();
	    System.out.println(qtxt);
		ansno = Integer.parseInt(scanner.nextLine());
		for(int i=0; i<ansno; i++){
            ans[i] = scanner.nextLine();
    	    System.out.println(ans[i]);
       }
		str = scanner.nextLine();
		str = str.replace(",", "");
		trueans = str;
		correctsteps = Integer.parseInt(scanner.nextLine());
		wrongsteps = Integer.parseInt(scanner.nextLine());
		Questions temp = new Questions(qtxt,ansno,trueans,ans,ismultiple,correctsteps,wrongsteps);
		questionlist.add(temp);
	}
	return questionlist;
	}
}

