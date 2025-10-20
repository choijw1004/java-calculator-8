package calculator;

public class Calculator {
    private final Parser parser;
    private final Delimiter delimiter;
    private final NumberValidator numberValidator;

    private Calculator(Parser parser, Delimiter delimiter, NumberValidator numberValidator){
        this.parser = parser;
        this.delimiter = delimiter;
        this.numberValidator = numberValidator;
    }

    public static Calculator getInstance(){
        return new Calculator(
                new Parser(),
                new Delimiter(),
                new NumberValidator()
        );
    }

    public int calculate(String input){
        if(input.isEmpty()){
            return 0;
        }

        if(parser.hasCustomDelimiter(input)){
            String customDelimiter = parser.getDelimiter(input);
            delimiter.add(customDelimiter);
            input = parser.getNumbers(input);
        }

        String[] tokens = delimiter.split(input);

        int sum = 0;
        for(String token : tokens){
            sum += numberValidator.parse(token);
        }

        return sum;
    }
}
