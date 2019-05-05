package sample.util;

import static sample.Main.systemUsers;

public class CredentialsUtil {

    public Boolean checkAdminCredentials(String aLogin, String aPasswd){
        for(int i = 0; i < systemUsers.size(); i++) {
            if (aLogin.equals(systemUsers.get(i).login) && aPasswd.equals(systemUsers.get(i).passwd) && systemUsers.get(i).accountTypeId == 1) {
                return true;
            }
        }
        return false;
    }
}
