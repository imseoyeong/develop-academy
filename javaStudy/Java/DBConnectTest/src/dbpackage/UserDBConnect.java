package dbpackage;

import java.sql.*;

// 컨트롤 클래스로 주로 기능적인 부분을 담당할 것
public class UserDBConnect {
    private String driver = "com.mysql.cj.jdbc.Driver"; // 스트링부트 할 때도 쓸거라서 이름 기억해두기.
    private String url = "jdbc:mysql://127.0.0.1:3306/cookdb?serverTimeZone=UTC"; // 연동하고자 하는 sql 위치를 잡아준다.
    // - 127.0.0.1 -> ip 루프백 주소?
    // - 3306은 포트 번호
    // - serverTimeZone=UTC 시간 기준 잡는 것
    private String user = "root";
    private String password = "1234";
    private Connection conn = null; // 연결 객체
    private Statement stmt = null; // 명령 객체


    public UserDBConnect() {

    }

    // 초기 작업
    public void initDBConnect() {
        try {
            Class.forName(this.driver); // mysql 드라이버를 메모리에 로드
            this.conn = DriverManager.getConnection(this.url, this.user, this.password); // mysql 서버에 연결을 시도. 연결이 되면 연격 객체를 conn에 담아놓는다.
            this.stmt = this.conn.createStatement(); // 명령 객체가 만들어짐 -> 쿼리를 실행시킬 수 있음.
        } catch (ClassNotFoundException e) { // 예외 처리
            e.printStackTrace();
        } catch (SQLException e) { // 예외 처리
            e.printStackTrace();
        }
    }
    // *********** 처음부터 여기까지가 sql 연결 기본 셋팅 ***********

    // 레코드 갯수 구하기
    public int countRecord() {
        String sql = "select count(*) as cnt from usertbl";
        int rcount = 0;
        try {
            ResultSet rs = this.stmt.executeQuery(sql); // ResultSet: 셀렉트 문의 결과를 담을 수 있는 객체의 클래스. 기억해두깅
            while (rs.next()) {
                rcount = rs.getInt("cnt");
                // String id = rs.getString("userid");
                // String name = rs.getString("username");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rcount;
    }

    // usertbl의 모든 레코드를 들고와서 유저 객체에 담아서 배열에 담은 후 그 배열을 리턴
    public User[] allFetchUsertbl() {
        int count = this.countRecord(); // countRecord 호출하면 usertbl에 레코드가 몇 개인지 알 수 있다.
        User[] userList = new User[count]; // User 배열 안에 값을 넣어야 하기 때문에 countRecord 호출해서 값을 가져온 것.
        String sql = "select * from usertbl";
        try {
            ResultSet rs = this.stmt.executeQuery(sql); // "select * from usertbl" 결과가 rs에 들어 옴
            int userCount = 0;
            while (rs.next()) {
                String userid = rs.getString("userid");
                String userName = rs.getString("userName");
                int birthYear = rs.getInt("birthYear");
                String addr = rs.getString("addr");
                String mobile1 = rs.getString("mobile1");
                String mobile2 = rs.getString("mobile2");
                int height = rs.getInt("height");
                Date mdate = rs.getDate("mdate");

                User user = new User(userid, userName, birthYear, addr, mobile1, mobile2, height, mdate);
                userList[userCount++] = user; // 0번의 유저가 들어가고 카운트가 증가
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public User selectUser(String username) {
        String sql = "select * from usertbl where username = '" + username + "'";
        User user = null;
        try {
            ResultSet rs = this.stmt.executeQuery(sql);
            while (rs.next()) {
                String userid = rs.getString("userid");
                String userName = rs.getString("userName");
                int birthYear = rs.getInt("birthYear");
                String addr = rs.getString("addr");
                String mobile1 = rs.getString("mobile1");
                String mobile2 = rs.getString("mobile2");
                int height = rs.getInt("height");
                Date mdate = rs.getDate("mdate");

                user = new User(userid, userName, birthYear, addr, mobile1, mobile2, height, mdate);
                break;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // 저장하는 단계 insert
    public void inputUser(User user) { // 전달받은 user 객체를 table에 넣는다.
        String sql = "insert into usertbl values(?, ?, ?, ?, ?, ?, ?, ?)"; // 동적
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserName());
            pstmt.setInt(3, user.getBirthYear());
            pstmt.setString(4, user.getAddr());
            pstmt.setString(5, user.getMobile1());
            pstmt.setString(6, user.getMobile2());
            pstmt.setInt(7, user.getHeight());
            pstmt.setDate(8, user.getMdate());
            pstmt.executeUpdate(); // 얘가 리턴하는 값은 정수값으로 실제 실행된 레코드 갯수. 근까 영향받은 레코드 수

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteUser(String username) {
        String sql = "delete from usertbl where username = '" + username + "'";
        try {
            int delete_count = this.stmt.executeUpdate(sql);
            if (delete_count > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 마무리 작업. db와의 연결을 끊고 깔끔하게 뒷정리
    public void releaseDB() {
        try {
            this.stmt.close();
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
