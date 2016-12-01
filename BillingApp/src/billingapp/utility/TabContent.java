/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingapp.utility;

import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 *
 * @author arun
 */
public interface TabContent {
    public boolean shouldClose();
    public void putFocusOnNode();
    public boolean loadData();
    public void setMainWindow(Stage stage);
    public void setTabPane(TabPane tabPane); 
}
