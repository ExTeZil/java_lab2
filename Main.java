package com.company;
import java.util.*;
import java.io.*;


public class Main {
    /*
    public static void task1() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок : ");
        String str = scanner.nextLine();
        String[] words = str.split(" ");
        if (str.length() == 0 || words.length == 0) {
            throw new IOException("Не був введений рядок!");
        }
        task1a(words.clone());
        task2a(words.clone());
    }
    */

    //4. а) видаляє всі слова, які містять хоча б одну латинську літеру; б) видаляє всі числа з тексту.
    public static void task1a(String[] words){
        String rezult = "";
        for (int i = 0;i<words.length;i++){
            char[] word = words[i].toCharArray();
            boolean flag = false;
            for (int j  = 0;j<word.length;j++){
                if((int)word[j] >64 && (int) word[j] <91) {
                    flag = true;
                    break;
                }
                if((int)word[j] > 96 && (int) word[j] <123){
                    flag = true;
                    break;
                }
            }
            if(!flag) rezult += words[i] + " ";
        }
        System.out.println("Результат: " +rezult+"" + "\n");
    }

    public static void task1b(String str){
        String rezult = "";
        for (char letter:str.toCharArray()) {
            if(!((int)letter >47&& (int)letter <97)) rezult += letter;
        }
        System.out.println("Результат: " +rezult+ "\n");
    }

    public static void task3(String text) {
        String[] sentens = new String[0];
        int peso = 0;
        sentens = text.split("[.!?]\\s*");
        for (int i = 0; i < sentens.length; ++i) {
                if(sentens[i].length()% 2 != 0){
                    peso = peso + 1;
                }
            }
        System.out.println(peso);

        String kilkistofsentens = String.valueOf(peso);
        try(FileWriter writer = new FileWriter("output.txt", false))
        {
            // запись всей строки
            writer.write("Кількість речень, що містять непарну кількість слів: " + kilkistofsentens);
            writer.flush();
        }

        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {

        String[] words = new String[0];
        String str = "";
        String str1 = "";
        Scanner scanner = new Scanner(System.in);

        String text = "";

        System.out.print("1.Ввести рядок " +
                "\n2.Видалити всі слова, які містять хоча б одну латинську літеру" +
                "\n3.видалити всі числа з тексту " +
                "\n4.Вихід" +
                "\nВведіть число : ");
        int num = scanner.nextInt();
        while (num != 999) {
            switch (num) {
                case 1:
                    try {
                        Scanner inputScanner = new Scanner(System.in);
                        System.out.println("Введіть рядок : ");
                        str = inputScanner.nextLine();
                        words = str.split(" ");
                        if (str.length() == 0 || words.length == 0) {
                            throw new IOException("Не був введений рядок!");
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }
                    /*
                    try {
                        System.out.println("\n\nЗавданння 1 :");
                        task1();
                    }
                    catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    */
                    break;
                case 2:
                    task1a(words);
                    break;
                case 3:
                    task1b(str);
                    break;
                /* Дано файл цілих чисел. Продублювати в ньому всі парні числа, які знаходяться на непарних місцях */
                case 4:
                    try (FileReader reader = new FileReader("numbers.txt")) {
                        int c;
                        while (((c = reader.read())!= - 1)) {
                            str1 += (char) c;
                        }
                        System.out.println(str1);
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    List<Integer> numbers = new ArrayList<>();
                    for (String number : str1.split(" ")) {
                        numbers.add(Integer.parseInt(number));
                    }
                    List<Integer> numbers2 = new LinkedList<>();
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers2.add(numbers.get(i));
                        if ((i + 1) % 2 != 0 && numbers.get(i) % 2 == 0 && numbers.get(i) != 0) {
                            numbers2.add(numbers.get(i));
                        }
                    }
                    for (int i = 0; i < numbers.size(); i++) {
                        System.out.print(numbers.get(i) + "(" + (i + 1) + ")" + " ");
                    }
                    System.out.println();

                    for (int i = 0; i < numbers2.size(); i++) {
                        System.out.print(numbers2.get(i) + " ");
                    }

                    String numbers2tring = numbers2.toString();

                    try (FileWriter writer = new FileWriter("numbers.txt", false)) {
                        writer.write(numbers2tring);
                        writer.append('\n');
                        writer.flush();
                    }
                    catch(IOException ex) { System.out.println(ex.getMessage()); }


                    /*
                    int lese;
                    int killkist=0;
                    for (int i = 0; i < numbers.size(); i++){
                        if (numbers.get(i) % 2 == 0 && 0 != i % 2) {
                            numbers.add(i, numbers.get(i));
                        }
            }
                    for (Integer num5:numbers) {
                        System.out.println(num5);
                    }
                    */
                    break;
                case 6:
                    try (FileReader reader = new FileReader("text.txt")) {
                        int c;
                        while (((c = reader.read())!= - 1)) {
                            text += (char) c;

                        }
                        System.out.println(text);
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    int peso = 0;
                    task3(text);
                    System.out.println(peso);
                    break;
                default:
                    System.out.println("Не вірно введене число!Введіть ще раз :");
                    break;
            }


            System.out.print("\n1.Ввести рядок " +
                    "\n2.Видалити всі слова, які містять хоча б одну латинську літеру" +
                    "\n3.видалити всі числа з тексту " +
                    "\n4.видалити всі числа з тексту " +
                    "\n5.видалити всі числа з тексту " +
                    "\n6.Вихід" +
                    "\nВведіть число : ");
            num = scanner.nextInt();
        }
    }
}