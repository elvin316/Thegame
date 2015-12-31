
public class Questions {
String qtxt;
int ansno;
String trueans;
String[] ans;
Boolean ismultiple;
int correctsteps;
int wrongsteps;

public Questions(){
	qtxt = "";
	ansno = 0;
	trueans = "";
	ans = new String[5];
	ismultiple = false;
	correctsteps = 0;
	wrongsteps = 0;
}

public Questions(String txt,int no,String truea,String[] anses,Boolean multiple,int correct,int wrong){
	qtxt = txt;
	ansno = no;
	trueans = truea;
	ans = anses;
	ismultiple = multiple;
	correctsteps = correct;
	wrongsteps = wrong;
}

public void setQ(String q){
	qtxt = q;
}

public void setIsmultiple(Boolean multi){
	ismultiple = multi;
}

public void setCorrectstep(int corr){
	correctsteps = corr;
}

public void setWrongstep(int wrong){
	wrongsteps = wrong;
}

public String getQ(){
	return qtxt;
}

}
