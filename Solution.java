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
        // Verifica o número máximo de 5 que pode estar no decentNumber
        int numberFives = n;

        // Verifica se o number é divisível por 3, se não for, decrementa por 5
        // Visando garantir que o número de dígitos "5" no decentNumber seja o máximo possível
        while (numberFives % 3 != 0) {
            numberFives -= 5;
        }
        // Verifica se existe a possibilidade de um decentNumber
        if (numberFives < 0) {
            // Se o numero for negativo, significa que não é possível formar um decentNumber
            decentNumber.append("-1");
        } else {
            decentNumber.append("5".repeat(numberFives));
            decentNumber.append("3".repeat(n - numberFives));
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
                + finishTime / 1000000);

        bufferedReader.close();
    }
}