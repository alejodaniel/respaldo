package com.mycompany.DAO;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class ConfigXml {

    public HashMap<String, String> Conection() {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("host", "jdbc:postgresql://localhost:5432/autenticacion");
        hm.put("user", "postgres");
        hm.put("password", "123456789");
        return hm;
    }
}
