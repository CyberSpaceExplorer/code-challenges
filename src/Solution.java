import java.io.*;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                    && ch != '}' && ch != ')') {
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
    public static List<Integer> ChangeMaker(double price, List<Double> payment) {
        //Calculate totalPayment from payment
        Double totalPayment = payment.stream().collect(Collectors.summingDouble(Double::doubleValue));
        //totalCents = totalPayment - price
        Double changeInDollars = totalPayment - price;
        //Convert double dollars to cents - changeInCents
        int changeInCents = (int) Math.round(100 * changeInDollars);
        Integer[] changeArray = new Integer[]{0, 0, 0, 0};
        int changeInQuarters, changeInDimes, changeInNickel;
        //ChangeInCents can be 0, 1, 5, 10, 25
        // 1<ChangeInCents<5, 5<ChangeInCents<10, 10<ChangeInCents<25, 25<ChangeInCents
        changeInQuarters = changeInCents / 25;
//        changeInCents = changeInCents - changeInQuarters*25;
        changeInCents = changeInCents % 25;
        changeInDimes = changeInCents / 10;
//        changeInCents = changeInCents - changeInDimes*10;
        changeInCents = changeInCents % 10;
        changeInNickel = changeInCents / 5;
//        changeInCents = changeInCents - changeInNickel*5;
        changeInCents = changeInCents % 5;
        changeArray[0] = changeInCents;
        changeArray[1] = changeInNickel;
        changeArray[2] = changeInDimes;
        changeArray[3] = changeInQuarters;
        List<Integer> changeList = Arrays.asList(changeArray);
        return changeList;
    }

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        float positiveRatio = (float) arr.stream().filter(p -> p > 0).count() / arr.size();
        float negativeRatio = (float) arr.stream().filter(p -> p < 0).count() / arr.size();
        float zeroRatio = (float) arr.stream().filter(p -> p == 0).count() / arr.size();

        System.out.printf("%.6f%n", positiveRatio);
        System.out.printf("%.6f%n", negativeRatio);
        System.out.printf("%.6f%n", zeroRatio);
    }
    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long min= 0, max = 0;
        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++ ) {
            if(i < arr.size() - 1)
                min += arr.get(i);
            if( i > 0)
                max += arr.get(i);
        }
       System.out.println(min + " " + max);
    }
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

//    public static String timeConversion(String s) {
        // Write your code here
//        int hour = Integer.parseInt(s.substring(0,2)) ;
//        String t ;
//            if (s.endsWith("PM")&& hour < 12) {
//                   hour += 12;
//            t = hour +  s.substring(2,8);
//        } else if(s.endsWith("AM") && hour == 12) {
//                   t = "00" + s.substring(2,8);
//        } else
//              t = s.substring(0,8);
//
//            return t;
//        }
        public static String timeCoversion12to24(String twelveHoursTime) throws ParseException {

            //Date/time pattern of input date (12 Hours format - hh used for 12 hours)
            DateFormat df = new SimpleDateFormat("hh:mm:ssa");

            //Date/time pattern of desired output date (24 Hours format HH - Used for 24 hours)
            DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
            Date date = null;
            String output = null;

            //Returns Date object
            date = df.parse(twelveHoursTime);

            //old date format to new date format
            output = outputformat.format(date);
//            System.out.println(output);

            return output;
        }
    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int findMedian(List<Integer> arr) {
        // Write your code here
        System.out.println(arr.size());
        System.out.println(arr);
        Collections.sort(arr);

//        double middle = arr.size()/2;
//        if (arr.size()%2 == 0) {
//            middle = (arr.get(arr.size()/2) + arr.get(arr.size()/2 - 1))/2;
//        } else {
//            middle = arr[arr.size() / 2];
//        }
        int middle = arr.size()/2;
        return arr.get(middle);
    }
    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Long> elementCountMap = a.stream()
                .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
        System.out.println(elementCountMap);
        List<Integer> result = elementCountMap.entrySet().stream().filter(e->e.getValue() == 1).map(e->e.getKey()).collect(Collectors.toList());
        return result.get(0);
    }

}


    public class Solution {
        public static void main(String[] args) throws IOException, ParseException {
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
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("./output.txt")));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        double price = Double.parseDouble(bufferedReader.readLine().trim());
//        int paymentCount = Integer.parseInt(bufferedReader.readLine().trim());
//        List<Double> payment = IntStream.range(0, paymentCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine().replaceAll("\\s+$", "");
//                        return bufferedReader.readLine();
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .map(String::trim)
//                .map(Double::parseDouble)
//                .collect(toList());
//        double price = 1.20;
//        double price = 1.75;
//        List<Double> payment = new ArrayList<Double>();
//        payment.add(1.00);
//        payment.add(1.00);
//        List<Integer> result = Result.ChangeMaker(price, payment);
//        System.out.println(result);
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
//   }
            //IO for array of integers
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//            int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                    .map(Integer::parseInt)
//                    .collect(toList());
//
//            Result.plusMinus(arr);
//
//            bufferedReader.close();


//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                    .map(Integer::parseInt)
//                    .collect(toList());
//
//            Result.miniMaxSum(arr);
//
//            bufferedReader.close();

//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//            //13:05:45PM
//            String s = bufferedReader.readLine();
//
//           String result = Result.timeCoversion12to24(s);
//
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
//
//            bufferedReader.close();
//            bufferedWriter.close();
//        }

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList());

                   int result = Result.lonelyinteger(a);
//            int result = Result.findMedian(a);

                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();

                    bufferedReader.close();
                    bufferedWriter.close();
                }

    }


