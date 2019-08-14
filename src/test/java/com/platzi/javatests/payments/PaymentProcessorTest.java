package com.platzi.javatests.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private  PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup(){
        //simular la pasarela de pago
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void paymentIsCorrect() {

        //simular el llamado al requestpaymente y retornando un paymentstatus OK
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        assertTrue(paymentProcessor.makePayment(100));
    }

    @Test
    public void paymentIsWrong() {

        //simular el llamado al requestpaymente y retornando un paymentstatus ERROR
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        assertFalse(paymentProcessor.makePayment(100));

    }
}