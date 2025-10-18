package calculator;

public class Calculator {
    public int calculate(String input){
        if(input.isEmpty()){
            return 0;
        }

        Parser parser = new Parser();
        Delimiter delimiter = new Delimiter();
        NumberValidator validator = new NumberValidator();

        if(parser.hasCustomDelimiter(input)){
            String customDelimiter = parser.getDelimiter(input);
            delimiter.add(customDelimiter);
            input = parser.getNumbers(input);
        }

        String[] tokens = delimiter.split(input);

        int sum = 0;
        for(String token : tokens){
            sum += validator.parse(token);
        }

        return sum;
    }
}
