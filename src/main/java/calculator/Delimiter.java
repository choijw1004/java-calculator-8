package calculator;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {
    private final List<String> delimiters = new ArrayList<>();

    public Delimiter(){
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
