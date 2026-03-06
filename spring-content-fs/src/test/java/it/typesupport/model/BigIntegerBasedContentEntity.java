package it.typesupport.model;

import java.math.BigInteger;
import java.util.Random;

public class BigIntegerBasedContentEntity extends ContentEntity<BigInteger> implements IdGenerator<BigInteger> {
    @Override
    public BigInteger generateId() {
        Random r = new Random();
        return new BigInteger(96, r);
    }
}
