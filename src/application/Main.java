package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.OnlinePaymentService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre com os dados do contrato");
        System.out.print("Numero: ");
        int number = scanner.nextInt();
        System.out.print("Data (dd/mm/yyyy): ");
        LocalDate date = LocalDate.parse(scanner.next(),dtf);
        System.out.print("Valor do contrato: ");
        double totalValue = scanner.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Entre com o numero de parcelas: ");
        int parcelas = scanner.nextInt();


        OnlinePaymentService paypalService = new PaypalService();

        ContractService contractService = new ContractService(paypalService);
        contractService.processContract(contract, parcelas);

        for(Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }

    }
}

