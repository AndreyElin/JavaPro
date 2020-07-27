package server;

import java.sql.*;

public class SimpleAuthService implements AuthService {

    private static Connection connection;
    private static PreparedStatement psGetNickname;
    private static PreparedStatement psRegistration;

    public static boolean connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Registration.db");
            prepareAllStatement();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void disconnect() {
        try {
            psRegistration.close();
            psGetNickname.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void prepareAllStatement() throws SQLException {
        psGetNickname = connection.prepareStatement("SELECT nickname FROM reg WHERE login = ? AND password = ?;");
        psRegistration = connection.prepareStatement("INSERT INTO reg (login, password, nickname) VALUES (?, ?, ?);");
    }


    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        connect();
        String nick = null;
        try {
            psGetNickname.setString(1, login);
            psGetNickname.setString(2, password);
            ResultSet rs = psGetNickname.executeQuery();
            if (rs.next()) {
                nick = rs.getString(1);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return nick;
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        try {
            connect();
            psRegistration.setString(1, login);
            psRegistration.setString(2, password);
            psRegistration.setString(3, nickname);
            psRegistration.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return false;
    }
}
