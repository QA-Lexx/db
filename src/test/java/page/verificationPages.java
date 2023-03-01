package page;
import com.codeborne.selenide.SelenideElement;
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
import static com.codeborne.selenide.Selenide.page;

public class verificationPages {
    @FindBy(css = "[data-test-id=code] input")
    private static SelenideElement codeField;
    @FindBy(css = "[data-test-id=action-verify]")
    private static SelenideElement verifyButton;
    @FindBy(css = "[data-test-id='error-notification']")
    private static SelenideElement errorNotification;

    public static void verifyVerificationPageVisibility() {
        codeField.shouldBe(visible);
    }

    public static void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }

    public static DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return page(DashboardPage.class);
    }

    public static void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}