package com.example.Spring.Webflux.Test.Tests;

import com.example.Spring.Webflux.Test.Services.UppercaseConverter;
import org.junit.Test;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

class UppercaseConverterTest {

    final TestPublisher<String> testPublisher = TestPublisher.create();
    @Test
    void testUpperCase() {
        UppercaseConverter uppercaseConverter = new UppercaseConverter(testPublisher.flux());
        StepVerifier.create(uppercaseConverter.getUpperCase())
                .then(() -> testPublisher.emit("datos", "GeNeRaDoS", "Sofka"))
                .expectNext("DATOS", "GENERADOS", "SOFKA")
                .verifyComplete();
    }

}
