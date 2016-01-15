public class Board {

    String[][] b;

    public Board() {
        b= new String[8][8];
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) { b[i][j] = "";}
        }
    }

    public void setValue(int row, int column, String value){
        b[column][row]=value;
    }

    public String getValue(int row, int column) {
        return b[column][row];
    }

}