package other;

public class ExcelCalculation {
    char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'};

    public String calculate(int number) {
        if (number == 0) { return ""; }

        String result = "";

        if (number % 26 == 0) {
            if (number != 26) {
                result += a[((((number - (number % 26)) / 26))) - 2] + "" + a[25];
            } else {
                result += a[25];
            }
        } else {
            if (number > 25) {
                if ((((number - (number % 26)) / 26)) > 26) {
                    result += a[(((((number - (number % 26)) / 26))) - 1) / 26 - 1] + "" + a[((((number - (number % 26)) / 26)) % 26) - 1] + calculate((number % 26));
                } else {
                    result += a[((((number - (number % 26)) / 26))) - 1] + calculate((number % 26));
                }
            } else {
                result = String.valueOf(a[number - 1]) + result;
            }
        }
        return result;
    }
}
