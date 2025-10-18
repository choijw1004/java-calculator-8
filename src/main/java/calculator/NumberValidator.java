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

    private void validate(int number){
        if(isNegative(number)){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private boolean isNegative(int number){
        return number < 0;
    }


}
