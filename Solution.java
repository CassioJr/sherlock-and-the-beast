import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.stream.IntStream;


class Result {

    /*
     * Complete the 'decentNumber' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void decentNumber(int n) {
        StringBuilder decentNumber = new StringBuilder();
        //Verifica o maximo de numeros 5
        int number = n;
        // Verifica se é divisivel por 3, caso não seja irá ser decrementado
        while (number % 3 != 0) {
            number -= 5;
        }
        //Verifica se existe a possibilidade de um decentNumber, senão insere a quantidade de 5 e 3 para formar o decentNumber
        if (number < 0) {
            decentNumber.append("-1");
        } else {
            decentNumber.append("5".repeat(number));
            decentNumber.append("3".repeat(n - number));
        }
        System.out.println(decentNumber);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());
        long startTime = System.nanoTime();
        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                Result.decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        long finishTime = System.nanoTime() - startTime;
        System.out.println("Tempo de execução total em millis: "
                + finishTime/1000000);

        bufferedReader.close();
    }
}