/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingapp.controller;

import billingapp.utility.TabContent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author arun
 */
public class InvoiceController implements TabContent {

    private Stage mainWindow;
    private TabPane tabPane;
    
    @FXML
    private void onInvoiceItemAddAction(ActionEvent event) {
        
    }
    @FXML
    private void onCustomersRefreshAction(ActionEvent event) {
        
    }
    @FXML
    private void onItemsRefreshAction(ActionEvent event) {
        
    }
    @FXML
    private void onUnitsRefreshAction(ActionEvent event) {
        
    }
    @FXML
    private void onInvoiceItemDeleteAction(ActionEvent event) {
        
    }
    @FXML
    private void onSaveInvoiceAction(ActionEvent event) {
        
    }   
    @FXML
    private void onCloseTabAction(ActionEvent event) {
        
    }
    
    /**
     * Initializes the controller class.
     */
    public void initialize() {
        // TODO
    } 
    
    @Override
    public boolean shouldClose() {
        return true;
    }

    @Override
    public void putFocusOnNode() {
    }

    @Override
    public boolean loadData() {
        return true;
    }

    @Override
    public void setMainWindow(Stage stage) {
        this.mainWindow = stage;
    }

    @Override
    public void setTabPane(TabPane tabPane) {
        this.tabPane = tabPane;
    }

    
}
