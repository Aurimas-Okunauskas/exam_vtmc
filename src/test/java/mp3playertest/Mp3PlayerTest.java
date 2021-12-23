package mp3playertest;

import basetest.BaseTest;
import org.testng.annotations.Test;
import page.CommonPage;

public class Mp3PlayerTest extends BaseTest {

    @Test
    public void mp3PlayerTest() {
        CommonPage commonPage = new CommonPage(driver);

        commonPage.clickMp3Players();
        commonPage.clickShowAllMp3Players();


    }

}
