package services;

import entities.Contract;
import entities.Installment;

public class ContractService {
    private final OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months){
        Double value = contract.getTotalValue()/months;
        for (int i=1; i<=months;i++){
            contract.getInstallments().add(new Installment(contract.getDate().plusMonths(i),
                    paymentService.paymentFee(value +paymentService.intrest(value, i))));
        }
    }
}
