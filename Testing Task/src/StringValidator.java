public class StringValidator {
    /* Решил добавить в валидацию вывод первой появившейся ошибки,
       чтобы понимать изъян входной строки. (получается частичный анализ строки на изъяны)
    */

    // Проверка строки на допустимые символы по ASCII коду.
    //  **В задании не было сказано о нижнем и вверхнем регистрах.**
    //  Решил сделать вверхний регистр допустимым.
    public static boolean charactersCheck(String inputStr){
        for (int i = 0; i < inputStr.length(); i++){
            char currentChar = inputStr.charAt(i);
            if (!((currentChar  >= 48 && currentChar <= 57) ||
                    (currentChar == '[' || currentChar == ']') ||
                    (currentChar >= 97 && currentChar <= 122) ||
                    (currentChar >= 65 && currentChar <= 90))){
                System.out.println("В строке есть недопустимые символы!");
                return false;
            }
        }
        return true;
    }

    // Проверка на то, что после цифры идет открывающая скобка или другая цифра.
    // Также, что перед открывающей скобкой стоит цифра.

    // ** Из описания ограничений в условии задачи я не совсем понял:
    //      является ли пустая подстрока в [] валидной   **
    //      (Решил, что все же нет)
    public static boolean rightSequenceCheck(String inputStr){
        for (int i = 0; i < inputStr.length()-1; i++){
            char currentChar = inputStr.charAt(i);
            char nextChar = inputStr.charAt(i+1);
            char previosChar;

            if(currentChar >= 48 && currentChar <= 57){
                if(!((nextChar >= 48 && nextChar <= 57) || nextChar == '[')){
                    System.out.println("После коэффициента умножения посдтроки нет открывающей скобки");
                    return false;
                }
            }

            if(currentChar == '['){
                try{
                   previosChar = inputStr.charAt(i-1);
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println("Нет коэффициента умножения подстроки");
                    return false;
                }

                if (nextChar == ']') {
                    System.out.println("В строке есть пустая подстрока");
                    return false;
                }
                if (!(previosChar >= 48 && previosChar <= 57)){
                    System.out.println("Нет коэффициента умножения подстроки");
                    return false;
                }
            }
        }
        return true;
    }

    // Проверка баланса скобок.
    public static boolean bracketsCheck(String inputStr){
        int countBracket = 0;

        for (int i = 0; i < inputStr.length(); i++){
            char currentChar = inputStr.charAt(i);

            if (currentChar == '[') countBracket++;
            if (currentChar == ']') countBracket--;
            if (countBracket < 0) {
                System.out.println("Неправильно расставлены скобки");
                return false;
            }
        }
        if (countBracket != 0){
            System.out.println("Число открывающих скобок не совпадает с числом закрывающих");
            return false;
        }
        return true;
    }

    // Общий метод, объединяющий все проверки
    public static boolean validate(String inputStr){
        if (inputStr.length() == 0){
            System.out.println("На вход дана пустая строка!");
            return false;
        }
        if (!charactersCheck(inputStr)) return false;
        if (!rightSequenceCheck(inputStr)) return false;
        return bracketsCheck(inputStr);

    }
}
