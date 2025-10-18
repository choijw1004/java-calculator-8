package calculator;

public class NumberValidator {
    public int parse(String token){
        if(isEmpty(token)){
            return 0;
        }

        int number = convertToInt(token);
        validate(number);

        return number;
    }

    private boolean isEmpty(String token){
        return token.isEmpty();
    }

    private int convertToInt(String token){
        return Integer.parseInt(token);
    }


}
