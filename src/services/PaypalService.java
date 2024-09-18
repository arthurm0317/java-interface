package services;

public class PaypalService implements OnlinePaymentService{
    @Override
    public Double intrest(Double amount, Integer months) {
        return amount*(0.01*months);
    }

    @Override
    public Double paymentFee(Double amount) {
        return amount+ amount*0.02;
    }
}
