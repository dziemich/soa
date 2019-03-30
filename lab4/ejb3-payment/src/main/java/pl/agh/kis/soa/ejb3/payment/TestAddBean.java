package pl.agh.kis.soa.ejb3.payment;

import javax.ejb.Stateful;

@Stateful
public class TestAddBean {

    public int add(int a, int b) {
        return a + b;
    }
}
