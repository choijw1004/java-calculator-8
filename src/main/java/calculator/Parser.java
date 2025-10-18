package calculator;

public class Parser {
    public boolean hasCustomDelimiter(String input){
        return input.startsWith("//");
    }

    public String getDelimiter(String input){
        int start = "//".length();
        int end = input.indexOf("\n");

        if(end == -1){
            end = input.indexOf("\\n");
        }

        return input.substring(start, end);
    }

    public String getNumbers(String input){
        int start = input.indexOf("\n");
        if(start != -1){
            return input.substring(start + 1);
        }

        start = input.indexOf("\\n");

        if(start != -1){
            return input.substring(start + 2);
        }

        throw new IllegalArgumentException();
    }

}
