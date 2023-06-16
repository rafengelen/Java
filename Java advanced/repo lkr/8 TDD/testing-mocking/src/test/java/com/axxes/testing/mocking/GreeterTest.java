package com.axxes.testing.mocking;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class GreeterTest {
    @Test
    void when_inputIsBob_resultShouldBeHelloBob(){
        Greeter greeter = new Greeter();
        assertThat(greeter.greet("Bob")).isEqualTo("Hello, Bob");
    }
    @Test
    void when_inputIsNull_resultShouldBeHelloThere(){
        Greeter greeter = new Greeter();
        assertThat(greeter.greet()).isEqualTo("Hello, there");
    }

    @Test
    void when_inputIsBobJane_resultShouldBeHelloBobJane(){
        Greeter greeter = new Greeter();
        assertThat(greeter.greet("Bob", "Jane")).isEqualTo("Hello, Bob and Jane");
    }
}
