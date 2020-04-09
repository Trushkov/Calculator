import java.util.Scanner;

public class DataParser {
    private int var1;
    private int var2;
    private int q = 0;
    private char op;
    private char exitChar;
    private boolean resultIsRoman = false;
    private boolean exitFlag;
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
                q+=1;
            }
            op = input[1].charAt(0);
            try {
                var2 = Integer.parseInt(input[2]);
            }catch (RuntimeException e){
                RomanNumber roman = new RomanNumber(input[2]);
                var2 = roman.toInt();
                q+=1;
            }
            if (var1 > 10 || var2 > 10){
                throw new RuntimeException("Значение каждого из чисел не может превышать 10");
            }
            if (q==1){
                throw new RuntimeException("Числа должны быть одной системы счисления: либо римской либо арабской");
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
    public boolean isResultRoman(){
        return resultIsRoman;
    }
}
