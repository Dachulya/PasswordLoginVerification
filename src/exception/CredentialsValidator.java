package exception;
import java.util.Objects;

public class CredentialsValidator {
    private static final String INVALID_LENGTH="ДЛИНА МОЖЕТ БЫТЬ ОТ 1 ДО 20";
    private static final String INVALID_SYMBOL="строка содержит некорректный знак";
    private static final String PASSWORDS_NOT_MATCH="ПАРОЛЬ И ПОДТВЕРЖДЕНИЕ ПАРОЛЯ НЕ СОВПАДАЮТ";
    public static boolean validateCredentials(String login,String password,String confirmPassword){
        if (isLengthNotInRange(login,1,20)){
            throw new WrongLoginException(INVALID_LENGTH);
        }
        if (isSymbolsNotValid(login)){
            throw new WrongLoginException(INVALID_SYMBOL);

        }



        if (isLengthNotInRange(password,1,20)){
            throw new WrongPasswordException(INVALID_LENGTH);
        }
        if (isSymbolsNotValid(password)){
            throw new WrongPasswordException(INVALID_SYMBOL);

        }


        if (!Objects.equals(password,confirmPassword)){
            throw new WrongPasswordException(PASSWORDS_NOT_MATCH);

        }
        return true;
    }
    private static boolean isLengthNotInRange(String value,int min, int max){
        if (value==null){
            return true;
        }
        int length=value.length();
        return length < min || length>max;
    }
    private static boolean isSymbolsNotValid(String value){
        if (value==null || value.isEmpty()){
            return true;
        }
        for (char c: value.toCharArray()){//перебор каждого символа строки
            boolean symbolMatches=(c>='a' && c<='z')||//в латинице символы по порядку можно укзать границы этого списка
                    (c>='A' && c<='Z')||
                    (Character.isDigit(c))||//проверяем что символ является цифрой
                    (c=='_');//или является знаком подчёркивания
            if (!symbolMatches){
                return true;
            }
        }
        return false;
    }
}

