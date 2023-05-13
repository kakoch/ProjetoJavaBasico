import builders.StudentsBuilder;
import entities.Student;

import java.util.*;


public class Main {
    static List<Student> allStudents = StudentsBuilder.getAllStudents();

    public static void main(String[] args) {
        System.out.println("1 - Resultado do exercicio 1.");
        System.out.println("2 - Resultado do exercicio 2.");
        System.out.println("3 - Resultado do exercicio 3.");
        System.out.println("4 - Resultado do exercicio 4.");
        System.out.println("5 - Resultado do exercicio 5.");
        System.out.println("6 - Resultado do exercicio 6.");
        System.out.println("7 - Resultado do exercicio 7.");
        System.out.print("Digite a opção: ");
        Scanner sc = new Scanner(System.in);
        int chosenExercise = sc.nextInt();
        switch (chosenExercise) {
            case 1 -> exerOne();
            case 2 -> exerTwo();
            case 3 -> exerThree();
            case 4 -> exerFor();
            case 5 -> exerFive();
            case 6 -> exerSix();
            case 7 -> exerSeven();
            default -> System.out.println("Opção invalida");
        }
    }

    //1. Recupere da lista os alunos que passaram de ano (nota minima 7.0).
    //            - Exiba os dados nesse formato: <código> - <nome> : Média = <nota>
    // Estava com duvidas para como fazer para formatar a nota com uma casa decima,
    //e pesquisando, acabei descobrindo a chamada  "enhanced for loop" que simplificou  o loop
    public static void exerOne() {
        for (Student student : allStudents) {
            float average = (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3;
            if (average >= 7.0) {
                String formatAverageGrade = String.format("%.1f", average);
                System.out.println(student.getCode() + " - " + student.getName() + " : Média = " + formatAverageGrade);
            }
        }
    }

    // 2. Recupere da lista os alunos que não passaram de ano.
    //   - Exiba os dados nesse formato: <código> - <nome> : Média = <media> (Faltou = <nota_faltante>)
    public static void exerTwo() {
        for (Student student : allStudents) {
            float average = (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3;
            if (average < 7.0) {
                String formatAverageGrade = String.format("%.1f", average);
                System.out.println(student.getCode() + " - " + student.getName() + " : Média = " + formatAverageGrade + " (Faltou = " + String.format("%.1f", (average - 7)) + ")");
            }
        }
    }

    /*
    3. Traga os alunos que tiraram a nota máxima (nota 10).
        - Exiba os dados nesse formato: <código> - <nome>*/
    public static void exerThree() {
        for (Student student : allStudents) {
            float noteMax = 10;
            if (student.getTestOne() == noteMax || student.getTestTwo() == noteMax || student.getTestThree() == noteMax) {
                System.out.println(student.getCode() + " - " + student.getName());
            }
        }
    }

    /*
       4. Traga o aluno que tirou a menor nota, em caso de notas iguais, traga ambos os alunos.
           - Exiba os dados nesse formato: <código> - <nome> : Nota = <nota>*/
    public static void exerFor() {
        float noteMin = Float.MAX_VALUE;
        for (Student student : allStudents) {
            float note = Math.min(student.getTestOne(), Math.min(student.getTestTwo(), student.getTestThree()));
            if (note < noteMin) {
                noteMin = note;
            }
        }
        for (Student student : allStudents) {
            float note = Math.min(student.getTestOne(), Math.min(student.getTestTwo(), student.getTestThree()));
            if (note == noteMin) {
                System.out.println(student.getCode() + " - " + student.getName() + " : Nota = " + String.format("%.1f", note));
            }
        }
    }

    /*
    5. Faça uma lista com top 3 notas de alunos. Em caso de notas iguais coloque todos na mesma posição.
            - Ex:
                1º - Fulano : Nota = 10.0;
                   - Beltrano : Nota = 10.0;
                2º - Joãozinho : Nota = 9.0;
                3º - Mariazinha : Nota = 8.9;
            - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
    */
    public static void exerFive() {
        List<Student> allStudents = new ArrayList<>(StudentsBuilder.getAllStudents());
        allStudents.sort((s1, s2) -> Float.compare(getMaxNote(s2), getMaxNote(s1)));
        List<Student> topStudents = allStudents.subList(0, Math.min(3, allStudents.size()));
        for (int i = 0; i < topStudents.size(); i++) {
            Student student = topStudents.get(i);
            float note = getMaxNote(student);
            System.out.println((i + 1) + "º - " + student.getName() + " : Nota = " + String.format("%.1f", note));
        }
    }

    private static float getMaxNote(Student student) {
        return Math.max(Math.max(student.getTestOne(), student.getTestTwo()), student.getTestThree());
    }
    /*
    6. Faça uma lista com as 3 menores notas de alunos. Em caso de notas iguais coloque todos na mesma posição.
              Exemplo igual a anterior
            - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
    */
    public static void exerSix() {
        List<Student> allStudents = new ArrayList<>(StudentsBuilder.getAllStudents());
        allStudents.sort((s1, s2) -> Float.compare(getMinNote(s1), getMinNote(s2)));
        List<Student> topStudents = allStudents.subList(0, Math.min(3, allStudents.size()));
        for (int i = 0; i < topStudents.size(); i++) {
            Student student = topStudents.get(i);
            float note = getMinNote(student);
            System.out.println((i + 1) + "º - " + student.getName() + " : Nota = " + String.format("%.1f", note));
        }
    }
    private static float getMinNote(Student student) {
        return Math.min(Math.min(student.getTestOne(), student.getTestTwo()), student.getTestThree());
    }
        /*
        7. Monte a média de todos os alunos e exiba em tela ordenando da maior para a menor nota.
            - Exiba os dados nesse formato: <posicao> - <código> - <nome> : Média = <nota>
         */
    public static void exerSeven() {
        List<Student> allStudents = new ArrayList<>(StudentsBuilder.getAllStudents());
        Collections.sort(allStudents, (s1, s2) -> Float.compare(getAverage(s2), getAverage(s1)));
        for (int i = 0; i < allStudents.size(); i++) {
            Student student = allStudents.get(i);
            float note = getAverage(student);
            System.out.println((i + 1) + "º - " + student.getCode() + " - " + student.getName() + " : Média = " + String.format("%.1f", note));
        }
    }

    private static float getAverage(Student student) {
        return (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3.0f;
    }
}
