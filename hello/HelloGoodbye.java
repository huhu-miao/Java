/* *****************************************************************************
 *  Compilation: javac HelloGoodbye.java
 *  Execution:    java HelloGoodbye name1 name2
 *
 *  Prints "Hello Kevin and Bob."
 *  Prints "Goodbye Bob and Kevin."
 *  In both Sentences, "Kevin" is replaced by name1 and "BOb" is replaced by name2.
 *
 *  Last modified:     3/31/2020
 **************************************************************************** */

public class HelloGoodbye {
    public static void main(String[] args) {
        System.out.println("Hello " + args[0] + " and " + args[1] + ".");
        System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
    }
}
