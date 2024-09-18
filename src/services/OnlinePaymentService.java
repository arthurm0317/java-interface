package services;

public interface OnlinePaymentService {
    Double intrest(Double amount, Integer months);
    Double paymentFee(Double amount);

}
