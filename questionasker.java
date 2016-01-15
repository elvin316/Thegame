import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
public class questionasker {
	
public static void calldialog(Boolean correct,int steps){
	if (correct){
		JOptionPane.showMessageDialog(null,"You are correct!Now take "+steps+" steps forward");
	}
	else{
		JOptionPane.showMessageDialog(null,"You are wrong!You have to take "+steps+" steps backward");
	}
}
	
public static String anssingle5(String qtxt,String ans1,String ans2,String ans3,String ans4,String ans5){
	ButtonGroup group = new ButtonGroup();
	JRadioButton option1 = new JRadioButton(ans1);
	JRadioButton option2 = new JRadioButton(ans2);
	JRadioButton option3 = new JRadioButton(ans3);
	JRadioButton option4 = new JRadioButton(ans4);
	JRadioButton option5 = new JRadioButton(ans5);
	group.add(option1);
    group.add(option2);
    group.add(option3);
    group.add(option4);
    group.add(option5);
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Single Choice Question"));
    panel.add(new JLabel(qtxt));
    panel.add(option1);
    panel.add(option2);
    panel.add(option3);
    panel.add(option4);
    panel.add(option5);
    int result = JOptionPane.showConfirmDialog(null, panel, "Please answer",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
        if (option1.isSelected()){
        	return "1";
        }
        else if (option2.isSelected()){
        	return "2";
        }
        else if (option3.isSelected()){
        	return "3";
        }
        else  if (option4.isSelected()){
        	return "4";
        }
        else if (option5.isSelected()){
        	return "5";
        }
        else return "0";
    } else {
        return "0";
    }
}

public static String anssingle4(String qtxt,String ans1,String ans2,String ans3,String ans4){
	ButtonGroup group = new ButtonGroup();
	JRadioButton option1 = new JRadioButton(ans1);
	JRadioButton option2 = new JRadioButton(ans2);
	JRadioButton option3 = new JRadioButton(ans3);
	JRadioButton option4 = new JRadioButton(ans4);
	group.add(option1);
    group.add(option2);
    group.add(option3);
    group.add(option4);
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.add(new JLabel("Single Choice Question"));
    panel.add(new JLabel(qtxt));
    panel.add(option1);
    panel.add(option2);
    panel.add(option3);
    panel.add(option4);
    int result = JOptionPane.showConfirmDialog(null, panel, "Please answer",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
        if (option1.isSelected()){
        	return "1";
        }
        else if (option2.isSelected()){
        	return "2";
        }
        else if (option3.isSelected()){
        	return "3";
        }
        else  if (option4.isSelected()){
        	return "4";
        }
        else return "0";
    } else {
        return "0";
    }
}
	
	public static String ansmulti5(String qtxt,String ans1,String ans2,String ans3,String ans4,String ans5) {
		String ans = "";
		JCheckBox option1 = new JCheckBox(ans1);
		JCheckBox option2 = new JCheckBox(ans2);
		JCheckBox option3 = new JCheckBox(ans3);
		JCheckBox option4 = new JCheckBox(ans4);
		JCheckBox option5 = new JCheckBox(ans5);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Multiple Choice Question"));
        panel.add(new JLabel(qtxt));
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(option4);
        panel.add(option5);
        int result = JOptionPane.showConfirmDialog(null, panel, "Please answer",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            if (option1.isSelected()){
            	ans += "1";
            }
            if (option2.isSelected()){
            	ans += "2";
            }
            if (option3.isSelected()){
            	ans += "3";
            }
            if (option4.isSelected()){
            	ans += "4";
            }
            if (option5.isSelected()){
            	ans += "5";
            }
            return ans;
        } else {
            return ans;
        }
    }
	public static String ansmulti4(String qtxt,String ans1,String ans2,String ans3,String ans4) {
		String ans = "";
		JCheckBox option1 = new JCheckBox(ans1);
		JCheckBox option2 = new JCheckBox(ans2);
		JCheckBox option3 = new JCheckBox(ans3);
		JCheckBox option4 = new JCheckBox(ans4);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Multiple Choice Question"));
        panel.add(new JLabel(qtxt));
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(option4);
        int result = JOptionPane.showConfirmDialog(null, panel, "Please answer",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            if (option1.isSelected()){
            	ans += "1";
            }
            if (option2.isSelected()){
            	ans += "2";
            }
            if (option3.isSelected()){
            	ans += "3";
            }
            if (option4.isSelected()){
            	ans += "4";
            }
            return ans;
        } else {
            return ans;
        }
    }
	
	public static void main(String[] args) throws FileNotFoundException {
		String ans = "";
		ArrayList<Questions> questionlist = Textreader.readtext();
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(questionlist.size());
		Questions Q = questionlist.get(index);
		if (Q.ismultiple && Q.ansno == 4){
			ans = ansmulti4(Q.qtxt,Q.ans[0],Q.ans[1],Q.ans[2],Q.ans[3]);
		}
		if (Q.ismultiple && Q.ansno == 5){
			ans = ansmulti5(Q.qtxt,Q.ans[0],Q.ans[1],Q.ans[2],Q.ans[3],Q.ans[4]);
		}
		if ((!(Q.ismultiple)) && (Q.ansno == 4)){
			ans = anssingle4(Q.qtxt,Q.ans[0],Q.ans[1],Q.ans[2],Q.ans[3]);
		}
		if ((!(Q.ismultiple)) && (Q.ansno == 5)){
			ans = anssingle5(Q.qtxt,Q.ans[0],Q.ans[1],Q.ans[2],Q.ans[3],Q.ans[4]);
		}
		if (ans.equals(Q.trueans)){calldialog(true,Q.correctsteps);}
	}
}
