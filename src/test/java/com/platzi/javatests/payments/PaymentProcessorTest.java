package com.platzi.javatests.payments;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    @Test
    public void paymentIsCorrect() {

        //simular la pasarela de pago
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        //simular el llamado al requestpaymente y retornando un paymentstatus OK
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
        assertTrue(paymentProcessor.makePayment(100));

    }

    @Test
    public void paymentIsWrong() {

        //simular la pasarela de pago
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        //simular el llamado al requestpaymente y retornando un paymentstatus ERROR
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);
        assertFalse(paymentProcessor.makePayment(100));

    }
}