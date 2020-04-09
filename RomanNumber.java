public class RomanNumber {
    private int num;
    private static int[] numbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] letters = {"C","XC", "L","XL", "X", "IX", "V", "IV", "I"};
    public RomanNumber(int num){
        this.num = num;
    }
    public RomanNumber(String roman){
        if (roman.length()==0)
            throw new NumberFormatException("Значение не может быть пустым");
        int i = 0;
        int arabic = 0;
        roman = roman.toUpperCase();
        while (i<roman.length()){
            char letter = roman.charAt(i);
            int number = letterToNumber(letter);
            if (number < 0)
                throw new NumberFormatException("Введены неверные символы (возможно упущены пробелы)");
            i++;
            if (i == roman.length()){
                arabic += number;
            }
            else {
                int nextNumber = letterToNumber(roman.charAt(i));
                if (nextNumber > number){
                    arabic += (nextNumber - number);
                    i++;
                }
                else {
                    arabic += number;
                }
            }
        }
        num = arabic;
    }
    private int letterToNumber(char letter){
        switch (letter){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            default: return -1;
        }
    }

    @Override
    public String toString() {
        String roman = "";
        int N = num;
        for (int i = 0; i<numbers.length; i++){
            while (N>=numbers[i]){
                roman +=letters[i];
                N -= numbers[i];
            }
        }
        return roman;
    }
    public int toInt(){
        return num;
    }
}
