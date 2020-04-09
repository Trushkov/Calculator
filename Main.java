public class Main {
    private static final char exitChar = '!';
    public static void main(String[] args) {
        System.out.println("Введите выражение в следующем формате: a оператор b (через пробел). Числа должны быть целыми арабскими или римскими от 1 до 10 включительно.\nДля завершения программы введите '!'");
        DataParser parser = new DataParser(exitChar);
        while (true) {
           try {
               parser.read();
           }catch ( RuntimeException e){
               System.err.println(e.getMessage());
               break;
           }
           if (parser.isExitFlag()){
               System.out.println("Завершение программы");
               break;
           }
            double res = Calculator.calculate(parser.getVar1(), parser.getVar2(), parser.getOp());
            String result = String.valueOf(res);
            if (parser.resultIsRoman){
                result = new RomanNumber((int)res).toString();
           }
            System.out.println(result);
        }
    }
}
