package encription;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encription {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner input = new Scanner(System.in);
        String fileName = "wesam.txt";
        String encriptedFileName = "encripted.txt";
        String decriptedFileName = "decripted.txt";
        String encrypted_text = "";
        String decrypted_text = "";
        String orginal_text = "";
        String text = "";

        BufferedReader file_in = new BufferedReader(new FileReader(fileName));
        BufferedWriter file_out_encripted = new BufferedWriter(new FileWriter(encriptedFileName));
        BufferedWriter file_out_decripted = new BufferedWriter(new FileWriter(decriptedFileName));

        System.out.print("Please Enter the value of P1 >>>");
        int P1 = input.nextInt();
        System.out.print("Please Enter the value of P2 >>>");
        int P2 = input.nextInt();

        while ((orginal_text = file_in.readLine()) != null) {
            text += orginal_text;
            String enc_text = "";
            String dec_text = "";
            for (char k : orginal_text.toCharArray()) {

                enc_text += (char) ((((int) k * P1) + P2) % 128);
            }

            for (char letter : enc_text.toCharArray()) {
                for (int i = 0; i < 128; i++) {
                    boolean validChar = (((int) letter) - ((P1 * i) + P2)) % 128 == 0;
                    if (validChar) {
                        dec_text += (char) i;
                    }
                }
            }

            file_out_encripted.write(enc_text);
            file_out_encripted.newLine();
            file_out_decripted.write(dec_text);
            file_out_decripted.newLine();
            encrypted_text += enc_text + "\n";
            decrypted_text += dec_text + "\n";

        }

        System.out.println("\n--------------------- Orginal Text   -------------------\n");
        System.out.println(text);
        System.out.println("\n\n------------------- Encripted Text --------------------\n");
        System.out.println(encrypted_text);
        System.out.println("\n\n------------------- Decripted Text --------------------\n");
        System.out.println(decrypted_text);
        System.out.println("\n\n-------------------------------------------------------\n");

        file_in.close();
        file_out_decripted.close();
        file_out_encripted.close();

    }

}
