package data;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.mode.User;
import java.sql.DriverManager;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.DriverManager;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private SQLHelper() {
    }

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    public static DataHelper.verificationCode getVerificationCode() {
        var codeSQL = "SELECT code FROM auth_codes ORDER BY created DESC LIMIT 1";
        try (var conn = getConn()) {
            var code = runner.query(conn, codeSQL, new ScalarHandler<String>());
            return new DataHelper.verificationCode(code);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM auth_codes");
        runner.execute(connection, "DELETE FROM card_transactions");
        runner.execute(connection, "DELETE FROM auth_cards");
        runner.execute(connection, "DELETE FROM auth_users");
    }
}