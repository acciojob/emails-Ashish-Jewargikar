package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }


    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword.equals(this.password)){
            if(isValid(newPassword)){
                System.out.println("Password changed successfully!");
                password=newPassword;
            }
            else{
                System.out.println("The new password is not valid!");
            }
        }
        else{
            System.out.println("The given password does not match current password!");
        }
    }

//    public void setPassword(String password) {
//        this.password = password;
//    }

    public boolean isValid(String pas){
        if(pas.length()<8){
            return false;
        }
        if(!isUppercase(pas)){
          return false;
        }
        if(!isLowercase(pas)){
            return false;
        }
        if(!isDigit(pas)){
            return false;
        }
        if(!isSpecial(pas)){
            return false;
        }
        return true;
    }
    public boolean isUppercase(String pas){
        for(int i=0;i<pas.length();i++){
            if(Character.isUpperCase(pas.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public boolean isLowercase(String pas){
        for(int i=0;i<pas.length();i++){
            if(Character.isLowerCase(pas.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public boolean isDigit(String pas){
        for(int i=0;i<pas.length();i++){
            if(Character.isDigit(pas.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public boolean isSpecial(String pas){
        for(int i=0;i<pas.length();i++){
            if(Character.isDigit(pas.charAt(i))){
                continue;
            }
            else if (Character.isLetter(pas.charAt(i))) {
                continue;
            }
            else{
                return true;
            }
        }
        return false;
    }
}