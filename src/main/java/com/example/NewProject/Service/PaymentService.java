package com.example.NewProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NewProject.Model.Payment;
import com.example.NewProject.Model.PaymentNotFoundException;
import com.example.NewProject.Repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRep;

	public List<Payment> getpayment() throws PaymentNotFoundException {
		List<Payment> paymentSer = paymentRep.findAll();
		if (paymentSer.isEmpty()) {
			throw new PaymentNotFoundException("Payment not Found");
		} else {
			return paymentSer;
		}
	}

	public Optional<Payment> getPaymentById(int id) throws PaymentNotFoundException {
		Optional<Payment> paymentSer = paymentRep.findById(id);
		if (paymentSer.isEmpty()) {
			throw new PaymentNotFoundException("Id is not found ");
		} else {
			return paymentSer;
		}
	}

	public void addPayment(Payment payment) {
		paymentRep.save(payment);
	}

	public void upDatePayment(Payment payment, int id) throws PaymentNotFoundException {
		Optional<Payment> paymentSer = paymentRep.findById(id);
		if (paymentSer.isEmpty()) {
			throw new PaymentNotFoundException("Id not Found ");
		} else {
			Payment paymentt = paymentSer.get();
			paymentt.setId(paymentt.getId());
			paymentt.setAmount(paymentt.getAmount());
			paymentt.setPaymentDate(paymentt.getPaymentDate());
			paymentt.setPaymentStatus(paymentt.getPaymentStatus());
			paymentRep.save(paymentt);
		}

	}

	public void deletePayment(int id) throws PaymentNotFoundException {
		Optional<Payment> paymentser = paymentRep.findById(id);
		if (paymentser.isEmpty()) {
			throw new PaymentNotFoundException("Id not found");
		}
		paymentRep.deleteById(id);

	}

}
