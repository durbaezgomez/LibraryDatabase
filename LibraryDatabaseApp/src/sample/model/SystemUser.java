package sample.model;

public class SystemUser {

    public int id;
    public String login;
    public String passwd;
    public String name;
    public String surname;
    public int accountTypeId;

    public SystemUser(int Userid, String Userlogin, String Userpasswd, String Username, String Usersurname, int UseraccountTypeId){
        id = Userid;
        login = Userlogin;
        passwd = Userpasswd;
        name = Username;
        surname = Usersurname;
        accountTypeId = UseraccountTypeId;
    }

    @Override
    public String toString() {
        String s = "";
        s += id +"\n";
        s += login +"\n";
        s += passwd +"\n";
        s += name +"\n";
        s += surname +"\n";
        s += accountTypeId +"\n";

        return s;
    }
}