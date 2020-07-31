package com.cda.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cda.dao.ILivreDao;

@Component
public class BddDataTestBean {
    @Autowired
    private ILivreDao livreDao;

    public BddDataTestBean(){
    }
}