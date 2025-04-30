import dbpackage.User;
import dbpackage.UserDBConnect;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        UserDBConnect db = new UserDBConnect();
        db.initDBConnect(); // 초기 작업 불러오기
        User[] userList = db.allFetchUsertbl();

        for (int i=0; i< userList.length; i++) {
            System.out.println(userList[i].getUserId());
            System.out.println(userList[i].getUserName());
            System.out.println(userList[i].getBirthYear());
            System.out.println(userList[i].getAddr());
            System.out.println(userList[i].getMobile1());
            System.out.println(userList[i].getMobile2());
            System.out.println(userList[i].getHeight());
            System.out.println(userList[i].getMdate());
        }

        System.out.println("=================================");
        User user = db.selectUser("유재석");
        System.out.println(user.getUserId());
        System.out.println(user.getUserName());
        System.out.println(user.getBirthYear());
        System.out.println(user.getAddr());
        System.out.println(user.getMobile1());
        System.out.println(user.getMobile2());
        System.out.println(user.getHeight());
        System.out.println(user.getMdate());
        System.out.println("=================================");

        db.inputUser(new User("ISY", "임서영", 1997, "경기", "010", "40583640", 160, Date.valueOf("2025-04-30")));
//        db.deleteUser("강호동");
        db.releaseDB();
    }
}