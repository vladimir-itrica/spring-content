package it.typesupport.model;

import java.io.Serializable;

public interface IdGenerator<SID extends Serializable> {
    SID generateId();
}
