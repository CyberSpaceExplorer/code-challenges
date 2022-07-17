import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'containsValidBraces' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING testString as parameter.
     */
    public static String containsValidBraces(String testString) {
        // Write your code here
        System.out.println(testString);
        System.out.println(testString.length());
        if (testString.length() == 1) return "valid";
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < testString.length(); i++) {
            Character ch = testString.charAt(i);
            if (ch == '{' || ch == '['
                    || ch == '(') {
                stack.push(ch);
            } else if (ch != '{' && ch != '['
                    && ch != '(' && ch != ']'
                    && ch != '}' && ch != ')'){
                    continue;
            } else if (stack.isEmpty()
                        || (stack.peek() == '[' && ch != ']')
                        || (stack.peek() == '{' && ch != '}')
                        || (stack.peek() == '(' && ch != ')')) {
                    return "invalid";
            } else {
                stack.pop();
            }

        }
        if (stack.empty())
            return ("valid");
        return "invalid";
    }

    /*
     * Complete the 'ChangeMaker' function below.
     *
     * The function is expected to return an Integer List (e.g. {0(cents), 1(nickles), 0(dimes), 3(quarters)}).
     * The function accepts following parameters:
     *  1. Double price (e.g. 1.20)
     *  2. Double List payment (e.g. {1.00,1.00})
     */
    public static List<Integer> ChangeMaker( double price, List<Double> payment){
        //Calculate totalPayment from payment
        Double totalPayment = payment.stream().collect(Collectors.summingDouble(Double::doubleValue));
        //totalCents = totalPayment - price
        Double changeInDollars = totalPayment - price;
        //Convert double dollars to cents - changeInCents
        int changeInCents = (int) Math.round(100*changeInDollars);
        Integer[] changeArray = new Integer[]{0, 0, 0, 0};
        int changeInQuarters, changeInDimes, changeInNickel;
        //ChangeInCents can be 0, 1, 5, 10, 25
        // 1<ChangeInCents<5, 5<ChangeInCents<10, 10<ChangeInCents<25, 25<ChangeInCents
        changeInQuarters = changeInCents/25;
//        changeInCents = changeInCents - changeInQuarters*25;
        changeInCents = changeInCents%25;
        changeInDimes = changeInCents/10;
//        changeInCents = changeInCents - changeInDimes*10;
        changeInCents = changeInCents%10;
        changeInNickel = changeInCents/5;
//        changeInCents = changeInCents - changeInNickel*5;
        changeInCents = changeInCents%5;
        changeArray[0] = changeInCents;
        changeArray[1] = changeInNickel;
        changeArray[2] = changeInDimes;
        changeArray[3] = changeInQuarters;
        List<Integer> changeList = Arrays.asList(changeArray);
        return changeList;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        String testString = bufferedReader.readLine();
//        String testString = "function foo(bar) { for(let i = 0; i <= 4; i++) { if(arr[0] === arr[i]) { console.log(\"foo\"); } } }";
//       String testString = "([{{[(())]}}])";
//        String testString = "([])";
//        String testString = "()";
//        String testString = "{[(])}";
//        String result = Result.containsValidBraces(testString);
//        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
        //I/O for Change Maker
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("./output.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("./output.txt")));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double price = Double.parseDouble(bufferedReader.readLine().trim());
        int paymentCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Double> payment = IntStream.range(0, paymentCount).mapToObj(i -> {
                    try {
//                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Double::parseDouble)
                .collect(toList());
//        double price = 1.20;
//        double price = 1.75;
//        List<Double> payment = new ArrayList<Double>();
//        payment.add(1.00);
//        payment.add(1.00);
        List<Integer> result = Result.ChangeMaker(price, payment);
        System.out.println(result);
//        result.stream().forEach(System.out::println);

//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining(",", "{", "}"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}