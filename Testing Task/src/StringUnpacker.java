public class StringUnpacker {
    // Метод для получения строки, повторенной n раз.
    public static String multiplyString(String str, int n){
        StringBuilder multipliedStrBl = new StringBuilder();

        for (int i = 0; i < n; i++){
            multipliedStrBl.append(str);
        }

        return multipliedStrBl.toString();
    }

    /*  Рекурсивный метод, который нужен для своего рода раскрытия "матрешки" из скобок.
        ("Матрешкой" я называю подстроки в подстроке: [..[..[..]..]..])
        На вход он получает строку, заданную изначально, а также индекс, чтобы знать
        откуда ему начинать свою работу.
    */
    public static String evolveSubString(String inputStr, int index){
        StringBuilder bldChislo = new StringBuilder();
        StringBuilder bldResult = new StringBuilder();
        boolean methodWork = false;

        for (int i = index; i <= inputStr.length(); i++ ){
            char currentChar = inputStr.charAt(i);

            if(currentChar == '['){
                methodWork = true;
                continue;
            }
            if(currentChar == ']'){
                bldResult = new StringBuilder(multiplyString(bldResult.toString(), Integer.parseInt(bldChislo.toString())));
                bldResult.append("_");
                bldResult.append(i);
                return bldResult.toString();
            }

            if(currentChar >= 48 && currentChar <= 57){
                if (!methodWork){
                    bldChislo.append(currentChar);
                }
                else {
                    String[] answer = evolveSubString(inputStr, i).split("_");
                    bldResult.append(answer[0]);
                    i = Integer.parseInt(answer[1]);
                }
                continue;
            }
                bldResult.append(currentChar);
        }

        return bldResult.toString();
    }

    /* Главный метод проходит по строке и вызывает метод evolveSubString() для раскрытия "матрешки",
       когда натыкается на нее.  А символы вне "матрешек" просто записывает в выходную строку.
     */
    public static String evolve(String inputStr){
        StringBuilder bldResult = new StringBuilder();

        for (int i = 0; i < inputStr.length(); i++) {
            char currentChar = inputStr.charAt(i);

            if (currentChar >= 48 && currentChar <= 57) {
                String[] answer = evolveSubString(inputStr, i).split("_");
                bldResult.append(answer[0]);
                i = Integer.parseInt(answer[1]);
            }
            else{
                bldResult.append(currentChar);
            }
        }
        return bldResult.toString();
    }
}
