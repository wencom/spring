package com.wencom.service;

import com.wencom.exception.MyException;

import java.io.FileNotFoundException;

public interface DemoService {
    String NAME = "demoService";

    void show1();
    void show2();
    void show3() throws FileNotFoundException;
    void show4();
    void show5() throws MyException;
}
