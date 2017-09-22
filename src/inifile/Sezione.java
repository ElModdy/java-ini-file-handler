package inifile;

import java.util.Map;
import java.util.stream.Collectors;

public class Sezione {
    
    Map<String, String> parameters;
    
    Sezione(Map<String, String> parameters) {
        fillParameters(parameters);
    }
    
    public void fillParameters(Map<String, String> parameters){
        this.parameters = parameters;
    }
    
    public void addParameter(String key, String value){
        parameters.put(key, value);
    }
    
    public String getParameter(String key){
        return parameters.get(key);
    }
    
    public String removeParameter(String key){
        return parameters.remove(key);
    }
    
    @Override
    public String toString() {
        return parameters.entrySet().stream()
                                    .map( e -> e.getKey() + "=" + e.getValue())
                                    .collect(Collectors.joining("\n"));
    }   
}