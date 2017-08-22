package com.ipeas.data;

import org.openqa.selenium.WebElement;

public class RadioButton {

    public boolean state;
    public WebElement xpath;
    public boolean isState() {
          return state;
    }
    public void setState(boolean state) {
          this.state = state;
    }
    public WebElement getXpath() {
          return xpath;
    }
    public void setXpath(WebElement xpath) {
          this.xpath = xpath;
    }

}
