package inifile;

import java.util.Map;


public class Conf {
    Map<String, Sezione> sections;
    
    public Conf(Map<String, Sezione> sections){
        this.sections = sections;
    }
    
    public void fillSection(Map<String, Sezione> parameters){
        this.sections = parameters;
    }
    
    public void addSection(String key, Sezione value){
        sections.put(key, value);
    }
    
    public Sezione getSection(String key){
        return sections.get(key);
    }
    
    public Sezione removeSection(String key){
        return sections.remove(key);
    }

    public Map<String, Sezione> getSections(){
        return sections;
    }
}