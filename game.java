import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Game{
public int playeramt;
public int currentplayerid;
public ArrayList<Questions> Questionlist;
public static Questions Q;
public Textreader reader;
public Player[] players;
public Boolean gamefinished;

public int getplayerpos(int playerid){
return players[playerid].playerpos;
}

public void setplayercolor(int playerid,String color){
	players[playerid].playercolor = color;
}

public void nextplayer(){
	currentplayerid += 1;
	if (currentplayerid > playeramt){
		currentplayerid = 1;
	}
}

public void setplayerfoward(int playerid,int steps){
	players[playerid].playerpos += steps ;
	if (players[playerid].playerpos >= 8){
		gamefinished = true;
	}
}

public void setplayerbackward(int playerid,int steps){
	players[playerid].playerpos -= steps ;
	if (players[playerid].playerpos <= 0){
		players[playerid].playerpos = 0;
	}
}

public static Boolean questioncorrect() throws FileNotFoundException{
	String ans = "";
	ArrayList<Questions> questionlist = Textreader.readtext();
	Random randomGenerator = new Random();
	int index = randomGenerator.nextInt(questionlist.size());
	Q = questionlist.get(index);
	if (Q.ismultiple && Q.ansno == 4){
		ans = questionasker.ansmulti4(Q.qtxt,Q.ans[0],Q.ans[1],Q.ans[2],Q.ans[3]);
	}
	if (Q.ismultiple && Q.ansno == 5){
		ans = questionasker.ansmulti5(Q.qtxt,Q.ans[0],Q.ans[1],Q.ans[2],Q.ans[3],Q.ans[4]);
	}
	if ((!(Q.ismultiple)) && (Q.ansno == 4)){
		ans = questionasker.anssingle4(Q.qtxt,Q.ans[0],Q.ans[1],Q.ans[2],Q.ans[3]);
	}
	if ((!(Q.ismultiple)) && (Q.ansno == 5)){
		ans = questionasker.anssingle5(Q.qtxt,Q.ans[0],Q.ans[1],Q.ans[2],Q.ans[3],Q.ans[4]);
	}
	if (ans.equals(Q.trueans)){
		questionasker.calldialog(true,Q.correctsteps);
		return true;
	}
	else {questionasker.calldialog(false,Q.wrongsteps);
		return false;}
}

public void playgame() throws FileNotFoundException{
	while (!gamefinished){
		Boolean playerans = questioncorrect();
		if (playerans){
		setplayerfoward(currentplayerid,Q.correctsteps);
		}
		else{
		setplayerbackward(currentplayerid,Q.wrongsteps);
		}
		nextplayer();
	}
}

public Game(int playeramount){
	gamefinished = false;
	playeramt = playeramount;
	currentplayerid = 1;
	players = new Player[playeramount+1];
}

public static void main(String[] args) throws FileNotFoundException {
}
}
