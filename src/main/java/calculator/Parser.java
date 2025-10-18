package calculator;

public class Parser {
    public boolean hasCustomDelimiter(String input){
        return input.startsWith("//");
    }

    public String getDelimiter(String input){
        int start = "//".length();
        int end = input.indexOf("\n");
        return input.substring(start, end);
    }

    public String getNumbers(String input){
        int start = input.indexOf("\n");
        return input.substring(start + 1);
    }

}
