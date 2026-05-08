package Tests;

import Base.Base;
import Pages.LoginPage;
import Pages.SideMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends Base {

    @Test
    public void TC_NAV01_navegacionModuloPIM() {
        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToPIM();
        waitForUrlContains("pim");

        String url = getCurrentUrl();
        Assert.assertTrue(url.contains("pim"),
                "TC-NAV01 FALLO: La URL no contiene 'pim'. URL actual: " + url);
    }

    @Test
    public void TC_NAV02_navegacionModuloRecruitment() {
        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToRecruitment();
        waitForUrlContains("recruitment");

        String url = getCurrentUrl();
        Assert.assertTrue(url.contains("recruitment"),
                "TC-NAV02 FALLO: La URL no contiene 'recruitment'. URL actual: " + url);
    }

    @Test
    public void TC_NAV03_navegacionModuloAdmin() {
        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToAdmin();
        waitForUrlContains("admin");

        String url = getCurrentUrl();
        Assert.assertTrue(url.contains("admin"),
                "TC-NAV03 FALLO: La URL no contiene 'admin'. URL actual: " + url);
    }

    @Test
    public void TC_NAV04_navegacionModuloLeave() {
        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToLeave();
        waitForUrlContains("leave");

        String url = getCurrentUrl();
        Assert.assertTrue(url.contains("leave"),
                "TC-NAV04 FALLO: La URL no contiene 'leave'. URL actual: " + url);
    }
}
