package text_based_game.UnitTest;

public class Testing {

   /**
    * Compares the ACTUAL output from what is EXPECTED.
    * returns true if two values are the same, and false if not.
    * This method uses generic type, which means any type that can be compared
    * can be used as a parameter.
    * @param T actual  : the actual output from executing the code
    * @param T expected: the expected output from the code
    * @return boolean: true if matches, false if not.
    */
    public static <T extends Comparable<T>>
           boolean actualMatchesExpected(T actual, T expected) {
        if (actual.compareTo(expected) != 0) {
            return false;
        }
        
        return true;
    }
    
   /**
    * Prints the error message, indicating which method test failed.
    * also shows the actual result and expected result.
    * @param String methodName: the method name that failed testing
    * @param T actual  : the actual output from executing the code
    * @param T expected: the expected output from the code
    */
    public static <T extends Comparable<T>>
           void printErrorMessage(String methodName, T actual, T expected) {
            System.out.println("ERROR: " + methodName + " FAILED.");
            System.out.println("   expected: " + expected);
            System.out.println("   actual  : " + actual);
    }
    
   /**
    * Overloaded method of printErrorMessage, used when the CASE NUMBER
    * has to be specified.
    * @param String methodName: the method name that failed testing
    * @param int caseNumber: the testing case number that failed
    * @param T actual  : the actual output from executing the code
    * @param T expected: the expected output from the code
    */
    public static <T extends Comparable<T>>
           void printErrorMessage(String methodName, int caseNumber, T actual, T expected) {
            System.out.println("ERROR: " + methodName + ", CASE #" + caseNumber + " FAILED.");
            System.out.println("   expected: " + expected);
            System.out.println("   actual  : " + actual);
    }
    
   /**
    * Prints the message:
    *    "testMethodName(): UNIT TEST PASSED"
    */
    public static void printAllTestsPassed(String testMethodName) {
        System.out.println(testMethodName + "(): UNIT TEST PASSED");
    }
    
}