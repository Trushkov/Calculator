public class Calculator {
    public static double calculate(int var1, int var2, char op){
        double result = 0;
        switch (op){
            case '+': result = var1 + var2;
            break;
            case '-': result = var1 - var2;
            break;
            case '*': result = var1 * var2;
            break;
            case '/': result = var1 / var2;
            break;
            default: throw new IllegalArgumentException("Неверный знак опреации");
        }
        return result;
    }
}
