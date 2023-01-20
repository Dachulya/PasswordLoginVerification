package exception;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkCredential("login","passworld","confim"));
        System.out.println(checkCredential("login","passworld","confim"));
        System.out.println(checkCredential("login","passworld","confim"));
        System.out.println(checkCredential("login","passworld","confim"));
        System.out.println(checkCredential("login","passworld","confim"));
    }
    public static  boolean checkCredential(String login, String passworld,String confirmPassworld){
        try {
            return CredentialsValidator.validateCredentials(login,passworld,confirmPassworld);

        }catch (WrongLoginException e){
            System.out.println("ошибка при валидации логина"+e.getMessage());
            return false;

        }catch (WrongPasswordException e){
            System.out.println("ошибка при валидации пароля"+e.getMessage());
            return false;
        }
    }
}