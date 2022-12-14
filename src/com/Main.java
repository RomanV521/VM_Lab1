package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final int rank = 5;

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Введите число в 10-ричной системе: ");
//        int input=sc.nextInt();
//        System.out.println(toBin(input,rank));

        GetNum(new File("input.txt"), new FileWriter("output.txt", false));
    }

    /**
     * Перевод из десятичной в двоичную<br><br>
     * Convert from decimal to binary
     * @param input
     * @param rank
     * @return
     */
    public static String toBin(int input, int rank)
    {
        int b=1;
        String output="";

//        for (int i=0; i<rank; i++)
//        {
//            output = (((input & b) != 0)?"1":"0")+output;
//            b=b*2;
//        }

        //При помощи деления на два
        while(input !=0){
            b = input%2;
            output = b + output;
            input = input/2;
        }
        return output;
    }

    public static void GetNum(File fileInput, FileWriter fileOutput) throws IOException {

        if (fileInput.length() == 0){
            System.out.println("Файл пуст");
        } else {
            Scanner scanFile = new Scanner(fileInput);
            String numBin;
            int num;
            fileOutput.write("Из 10-чной в 2-чную:"+System.lineSeparator());

            while (scanFile.hasNext()){
                if (scanFile.hasNextInt()){
                    num = scanFile.nextInt();
                    numBin = toBin(num,rank);
                    System.out.println(numBin);

                    fileOutput.write("  "+num + " = " +numBin+";"+System.lineSeparator());
                }
                else{
                    System.out.println("Вы ввели не число");
                    break;
                }
            }
            FileWriter fileWriterInput = new FileWriter(fileInput, false);
            fileOutput.close();
            fileWriterInput.close();
        }
    }
}
