package com.exemplo;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class conversorDeMoeda {
    private static final String[] OPTIONS = {
            "1) USD → EUR",
            "2) EUR → USD",
            "3) USD → BRL",
            "4) BRL → USD",
            "5) EUR → BRL",
            "6) BRL → EUR",
            "0) Sair"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ApiClient api = new ApiClient();

        while (true) {
            System.out.println("\n=== Seja bem vindo/a ao Conversor de Moedas ===");
            for (String opt : OPTIONS) System.out.println(opt);
            System.out.print("Escolha uma opção: ");
            String choice = sc.nextLine().trim();

            if ("0".equals(choice)) {
                System.out.println("Saindo... Até logo!");
                break;
            }

            String from, to;
            switch (choice) {
                case "1": from="USD"; to="EUR"; break;
                case "2": from="EUR"; to="USD"; break;
                case "3": from="USD"; to="BRL"; break;
                case "4": from="BRL"; to="USD"; break;
                case "5": from="EUR"; to="BRL"; break;
                case "6": from="BRL"; to="EUR"; break;
                default:
                    System.out.println("Opção inválida."); continue;
            }

            try {
                System.out.print("Valor em " + from + ": ");
                double amount = Double.parseDouble(sc.nextLine().replace(",","."));
                Map<String, Double> rates = api.getRates(from);

                if (!rates.containsKey(to)) {
                    System.out.println("Não foi possível converter de " + from + " para " + to);
                    continue;
                }

                double rate = rates.get(to);
                double result = amount * rate;
                System.out.printf("%.2f %s = %.2f %s%n", amount, from, result, to);

            } catch (IOException | InterruptedException e) {
                System.err.println("Erro ao buscar cotações: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Entrada inválida.");
            }
        }

        sc.close();
    }
}
