package inifile;

import java.util.Map;

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
    
    public Map<String, String> getParameters(){
        return parameters;
    }
}