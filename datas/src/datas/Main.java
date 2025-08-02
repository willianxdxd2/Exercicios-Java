package datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        
        // Definindo o padrão para as datas
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        // Parsing das strings para LocalDate e LocalDateTime
        LocalDateTime y1 = LocalDateTime.parse("25/06/2018 15:42:07", formatter2);
        LocalDate y2 = LocalDate.parse("25/06/2018", formatter1);
        
        // Exibindo as datas
        System.out.println(y1); // Imprime a data com hora
        System.out.println(y2); // Imprime apenas a data
    }
}