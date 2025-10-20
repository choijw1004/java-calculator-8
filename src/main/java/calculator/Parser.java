package calculator;

public class Parser {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";
    private static final String LITERAL_CUSTOM_DELIMITER_SUFFIX = "\\n";

    public boolean hasCustomDelimiter(String input){
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    public String getDelimiter(String input){
        int start = CUSTOM_DELIMITER_PREFIX.length();
        int end = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        if(end == -1){
            end = input.indexOf(LITERAL_CUSTOM_DELIMITER_SUFFIX);
        }

        if(end == -1 || end <= start){
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }

        String delimiter = input.substring(start, end);

        if(delimiter.length() != 1){
            throw new IllegalArgumentException("구분자는 단일 문자여야 합니다.");
        }

        return delimiter;
    }

    public String getNumbers(String input){
        int start = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if(start != -1){
            return input.substring(start + 1);
        }

        start = input.indexOf(LITERAL_CUSTOM_DELIMITER_SUFFIX);

        if(start != -1){
            return input.substring(start + 2);
        }

        throw new IllegalArgumentException("숫자 부분을 찾을 수 없습니다.");
    }

}
