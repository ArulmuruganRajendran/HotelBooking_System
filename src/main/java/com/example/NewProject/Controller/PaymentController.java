package com.example.NewProject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NewProject.Model.Payment;
import com.example.NewProject.Model.PaymentNotFoundException;
import com.example.NewProject.Service.PaymentService;

@RestController
@RequestMapping("/Payments")
public class PaymentController {
	@Autowired
	PaymentService paymentSer;

	@GetMapping
	public List<Payment> getHotel() throws PaymentNotFoundException {
		List<Payment> paymentCon = paymentSer.getpayment();
		return paymentCon;
	}

	@GetMapping("/{id}")
	public Optional<Payment> getPaymentById(@PathVariable int id) throws PaymentNotFoundException {
		Optional<Payment> paymentCon = paymentSer.getPaymentById(id);
		return paymentCon;

	}
	@PostMapping
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment ) {
		paymentSer.addPayment(payment);
		return  new ResponseEntity<Payment>(HttpStatus.CREATED);
		
	}
	@PutMapping("/{id}")
	public HttpStatus upDatePayment(@RequestBody Payment payment,@PathVariable int id) throws PaymentNotFoundException {
		paymentSer.upDatePayment(payment, id);
		return HttpStatus.OK;
		
	}
	@DeleteMapping("/{id}")
	public HttpStatus deletePayment(@PathVariable int id) throws PaymentNotFoundException {
		paymentSer.deletePayment(id);
		return HttpStatus.OK;
		
	}

}