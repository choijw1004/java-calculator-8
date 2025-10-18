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


}
