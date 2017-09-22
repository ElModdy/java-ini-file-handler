/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inifile;

import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author usr
 */
public class Sezione {
    
    Map<String, String> parameters;
    
    Sezione(Map<String, String> parameters) {
        this.parameters = parameters; 
    }

    @Override
    public String toString() {
        return parameters.entrySet().stream()
                                    .map( entry -> "\n\tchiave: " + entry.getKey() + ", valore: " + entry.getValue())
                                    .collect(Collectors.joining());
    }
}
