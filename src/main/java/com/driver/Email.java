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
    
    public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    	if (!oldPassword.equals(getPassword())) {
            System.out.println("The old password is incorrect.");
            return;
        }
        if (newPassword.length() < 8) {
            System.out.println("The new password must be at least 8 characters long.");
            return;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < newPassword.length(); i++) {
            char c = newPassword.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
            if (hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
                break;
            }
        }
        if (!hasUppercase) {
            System.out.println("The new password must contain at least one uppercase letter.");
            return;
        }
        if (!hasLowercase) {
            System.out.println("The new password must contain at least one lowercase letter.");
            return;
        }
        if (!hasDigit) {
            System.out.println("The new password must contain at least one digit.");
            return;
        }
        if (!hasSpecialChar) {
            System.out.println("The new password must contain at least one special character.");
            return;
        }
        setPassword(newPassword);
        System.out.println("Password changed successfully.");
    }

	
}
