package Tests;

import Base.Base;
import Pages.AdminPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.RecruitmentPage;
import Pages.SideMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UIValidationTests extends Base {

    @Test
    public void TC_UI01_elementosFormularioLoginVisibles() {
        LoginPage login = new LoginPage(driver, wait);

        Assert.assertTrue(login.isUsernameFieldDisplayed(),
                "TC-UI01 FALLO: El campo de usuario no es visible.");
        Assert.assertTrue(login.isPasswordFieldDisplayed(),
                "TC-UI01 FALLO: El campo de contrasena no es visible.");
        Assert.assertTrue(login.isLoginButtonDisplayed(),
                "TC-UI01 FALLO: El boton Login no es visible.");
    }

    @Test
    public void TC_UI02_botonAddVisibleEnRecruitment() {
        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        RecruitmentPage rec = new RecruitmentPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToRecruitment();
        rec.goToVacancies();

        boolean visible = rec.isAddButtonVisible();
        Assert.assertTrue(visible,
                "TC-UI02 FALLO: El boton 'Add' no esta visible en Recruitment > Vacancies.");
    }

    @Test
    public void TC_UI03_widgetsDashboardVisibles() {
        LoginPage login = new LoginPage(driver, wait);
        DashboardPage dashboard = new DashboardPage(driver, wait);

        login.login("Admin", "admin123");
        boolean widgetsVisibles = dashboard.areWidgetsVisible();

        Assert.assertTrue(widgetsVisibles,
                "TC-UI03 FALLO: Los widgets 'Time at Work' y 'Quick Launch' no son visibles en el Dashboard.");
    }

    @Test
    public void TC_UI04_tablaUsuariosEnAdminVisible() {
        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        AdminPage admin = new AdminPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToAdmin();

        boolean tablaVisible = admin.isUserTableVisible();
        Assert.assertTrue(tablaVisible,
                "TC-UI04 FALLO: La tabla de usuarios no es visible en el modulo Admin.");
    }
}
