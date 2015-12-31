import java.io.FileNotFoundException;
import java.util.ArrayList;


public class test {

	public static void main(String[] args) throws FileNotFoundException {
			ArrayList<Questions> questionlist =Textreader.readtext();
			for (Questions q : questionlist) {
			    System.out.println(q.trueans);
			}
}
}
