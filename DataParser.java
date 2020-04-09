import java.util.Scanner;

public class DataParser {
    private int var1;
    private int var2;
    private char op;
    private char exitChar;
    boolean resultIsRoman = false;
    boolean exitFlag;
    public  DataParser(char exitChar){
        this.exitChar = exitChar;
    }
    public void read(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.indexOf(exitChar) != -1){
            exitFlag = true;
            return;
        }
        try {
            String[] input = str.split(" ");
                        try {
                var1 = Integer.parseInt(input[0]);
            }catch (RuntimeException e){
                RomanNumber roman = new RomanNumber(input[0]);
                var1 = roman.toInt();
                resultIsRoman = true;
            }
            op = input[1].charAt(0);
            try {
                var2 = Integer.parseInt(input[2]);
            }catch (RuntimeException e){
                RomanNumber roman = new RomanNumber(input[2]);
                var2 = roman.toInt();
            }
            if (var1 > 10 || var2 > 10){
                throw new RuntimeException("Значение каждого из чисел не может превышать 10");
            }
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            throw new IllegalArgumentException("Неверный формат данных");
        }
    }
    public int getVar1(){
        return var1;
    }

    public int getVar2() {
        return var2;
    }

    public char getOp() {
        return op;
    }

    public boolean isExitFlag() {
        return exitFlag;
    }
}
