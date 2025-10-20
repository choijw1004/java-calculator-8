package calculator;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {
    private Set<String> delimiters;

    public Delimiter(){
        this.delimiters = new HashSet<>();
        delimiters.add(",");
        delimiters.add(":");
    }

    public void add(String customDelimiter){
        delimiters.add(customDelimiter);
    }

    public String[] split(String string){
        String safeDelimiters = String.join("",delimiters)
                .replace("\\","\\\\")
                .replace("-","\\-")
                .replace("^","\\^")
                .replace("]", "\\]");

        String regex = "[" + safeDelimiters + "]";
        return string.split(regex);
    }
}
