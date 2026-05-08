package Tests;

import Base.Base;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.PIMPage;
import Pages.SideMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests extends Base {

    @Test
    public void TC_P01_loginExitosoConCredencialesValidas() {
        LoginPage login = new LoginPage(driver, wait);
        DashboardPage dashboard = new DashboardPage(driver, wait);

        login.login("Admin", "admin123");

        boolean resultado = dashboard.isDashboardTitleVisible();
        Assert.assertTrue(resultado, "TC-P01 FALLO: El titulo 'Dashboard' no es visible tras login exitoso.");
    }

    @Test
    public void TC_P02_urlCorrectaTrasLoginExitoso() {
        LoginPage login = new LoginPage(driver, wait);
        DashboardPage dashboard = new DashboardPage(driver, wait);

        login.login("Admin", "admin123");
        String url = dashboard.getDashboardUrl();

        Assert.assertTrue(url.contains("dashboard"),
                "TC-P02 FALLO: La URL no contiene 'dashboard'. URL actual: " + url);
    }

    @Test
    public void TC_P03_busquedaEmpleadoPorNombreEnPIM() {
        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        PIMPage pim = new PIMPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToPIM();
        pim.searchEmployee("John");

        boolean resultadosVisibles = pim.areSearchResultsVisible();
        Assert.assertTrue(resultadosVisibles,
                "TC-P03 FALLO: No se muestran resultados de busqueda para 'John'.");
    }

    @Test
    public void TC_P04_seleccionDropdownEmploymentStatus() {
        LoginPage login = new LoginPage(driver, wait);
        SideMenuPage menu = new SideMenuPage(driver, wait);
        PIMPage pim = new PIMPage(driver, wait);

        login.login("Admin", "admin123");
        menu.goToPIM();
        pim.selectEmploymentStatus();

        String seleccion = pim.getSelectedEmploymentStatus();
        Assert.assertTrue(seleccion.contains("Full-Time Permanent"),
                "TC-P04 FALLO: La opcion seleccionada no es 'Full-Time Permanent'. Valor obtenido: " + seleccion);
    }
}
