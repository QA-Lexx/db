package page;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.FindBy;
import ru.netology.mode.User;
import java.sql.DriverManager;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.DriverManager;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage {
    @FindBy(css = "[data-test-id=login] input")
    private static SelenideElement loginField;
    @FindBy(css = "[data-test-id=password] input")
    private static SelenideElement passwordField;
    @FindBy(css = "[data-test-id=action-login] input")
    private static SelenideElement loginButton;
    @FindBy(css = "[data-test-id='error-notification'] input")
    private static SelenideElement errorNotification;

    public static void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }

    public static verificationPages validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new verificationPages();
    }
}