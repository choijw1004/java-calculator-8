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

        if(end == -1 || end <= start){
            throw new IllegalArgumentException();
        }

        String delimiter = input.substring(start, end);

        if(delimiter.length() != 1){
            throw new IllegalArgumentException();
        }

        return delimiter;
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
