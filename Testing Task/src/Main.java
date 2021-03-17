public class Main {
    public static void main(String[] args){
        String test;

        test = "3[x]3[x]";
        System.out.println("Входная строка: " + test);
        if (StringValidator.validate(test)){
            System.out.println(StringUnpacker.evolve(test));
        }
        System.out.println();

        test = "3[]3[x]";
        System.out.println("Входная строка: " + test);
        if (StringValidator.validate(test)){
            System.out.println(StringUnpacker.evolve(test));
        }
        System.out.println();

        test = "[x]3[x]";
        System.out.println("Входная строка: " + test);
        if (StringValidator.validate(test)){
            System.out.println(StringUnpacker.evolve(test));
        }
        System.out.println();

        test = "3[x]3[x][";
        System.out.println("Входная строка: " + test);
        if (StringValidator.validate(test)){
            System.out.println(StringUnpacker.evolve(test));
        }
        System.out.println();

        test = "3[3[2[x]]]3[x]";
        System.out.println("Входная строка: " + test);
        if (StringValidator.validate(test)){
            System.out.println(StringUnpacker.evolve(test));
        }
        System.out.println();


        test = "6]2[x]";
        System.out.println("Входная строка: " + test);
        if (StringValidator.validate(test)){
            System.out.println(StringUnpacker.evolve(test));
        }
        System.out.println();
    }
}
