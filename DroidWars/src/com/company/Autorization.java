package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Autorization {
    private User user;
    private AutorizationView autorizationView;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Autorization(User user, AutorizationView autorizationView) {
        this.user = user;
        this.autorizationView = autorizationView;
    }

    public void autorize() {
        boolean choice = true;
        do {
            autorizationView.getMsg(autorizationView.GREETINGS_MSG);
            try {
                String chooseRole = br.readLine();
                switch (chooseRole) {
                    case "1": {
                        registerUser();
                        autorizationView.getMsg(autorizationView.REGISTRATION_MSG);
                        break;
                    }
                    case "2": {
                        login();
                        DroidBattleField battleField = new DroidBattleField();
                        if (user.getRole().equals(Role.ADMINISTRATOR)){
                            AdminMenuView adminMenuView = new AdminMenuView();
                            AdminMenu adminMenu = new AdminMenu(adminMenuView,battleField);
                            adminMenu.run();
                            autorizationView.getMsg(autorizationView.EXIT_MSG);
                            autorize();
                        } else if (user.getRole().equals(Role.COMMON_USER)){
                            CommonUserMenuView commonUserMenuView = new CommonUserMenuView();
                            CommonUserMenu commonUserMenu = new CommonUserMenu(commonUserMenuView,battleField);
                            commonUserMenu.run();
                            autorizationView.getMsg(autorizationView.EXIT_MSG);
                        } else {

                        }
                        choice = false;
                        break;
                    }
                    case "3": {
                        autorizationView.getMsg(autorizationView.EXIT_MSG);
                        return;
                    }
                    default: {
                        autorizationView.getMsg(autorizationView.INVALID_MSG);
                        break;
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (choice);
    }

    public void registerUser() {
        boolean userCreated = true;
        boolean argumentCorrect = true;
        do {
            try {
                autorizationView.getMsg(autorizationView.CREATE_USER_MSG);
                String pattern = "\\w+";
                Matcher match;
                String tmp;
                do {
                    autorizationView.getMsg(autorizationView.INPUT_USERNAME_MSG);
                    tmp = br.readLine();
                    if(!tmp.matches(pattern)){
                        System.err.println(autorizationView.VALID_USERNAME_REQUIREMENTS_MSG);
                    }
                } while (!tmp.matches(pattern));
                user.setUserName(tmp);

                String fileName = user.getUserName().concat(".ser");
                File userFile = new File("./users/"+fileName);
                if(userFile.exists()){
                    autorizationView.getMsg(autorizationView.USER_EXIST_MSG);
                    registerUser();
                } else {
                    autorizationView.getMsg(autorizationView.INPUT_PASSWORD__MSG);
                    tmp = br.readLine();
                    user.setPassword(tmp);
                    do {
                        autorizationView.getMsg(autorizationView.INPUT_ROLE__MSG);
                        String role = br.readLine();
                        switch (role) {
                            case "1": {
                                user.setRole(Role.ADMINISTRATOR);
                                argumentCorrect = false;
                                break;
                            }
                            case "2": {
                                user.setRole(Role.COMMON_USER);
                                argumentCorrect = false;
                                break;
                            }
                            default: {
                                autorizationView.getMsg(autorizationView.INPUT_ROLE__MSG);
                                break;
                            }
                        }
                    } while (argumentCorrect);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                user.addUser();
                userCreated = false;
            } catch (InvalidUsernameEcxeption invalidUsernameEcxeption) {
                invalidUsernameEcxeption.getMessage();
                continue;
            }
        } while (userCreated);
    }

    public void login() {
        boolean argumentCorrect = true;
        boolean accountExist = true;
        do {
            try {
                autorizationView.getMsg(autorizationView.LOGIN_MSG);
                autorizationView.getMsg(autorizationView.INPUT_USERNAME_MSG);
                String tmp = br.readLine();
                user.setUserName(tmp);
                autorizationView.getMsg(autorizationView.INPUT_PASSWORD__MSG);
                tmp = br.readLine();
                user.setPassword(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (user.deserialize()==null) {
                    accountExist = true;
                    System.err.println(autorizationView.NO_SUCH_ACCOUNT_MSG);
                } else {
                    user.setRole(user.deserialize());
                    accountExist = false;
                }
            } catch (IOException e) {
                System.err.println(autorizationView.NO_SUCH_ACCOUNT_MSG);
                continue;
            } catch (ClassNotFoundException e) {
                System.err.println(autorizationView.NO_SUCH_ACCOUNT_MSG);
                continue;
            }
        } while (accountExist);
    }

}
