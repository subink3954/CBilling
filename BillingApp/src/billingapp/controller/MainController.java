/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingapp.controller;

import billingapp.Global;
import billingapp.utility.TabContent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author arun
 */
public class MainController  {
    
    
    @FXML
    private Label label;
    
    @FXML
    private ImageView leftImageView;
    
    @FXML
    private TabPane tabPane;
    
    public Stage MainWindow = null;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    

    public void initialize() {
        // TODO
    } 
    
        @FXML
    private void onAboutDialogAction(ActionEvent event) {
        addTab("About", "About");
    }
    
    @FXML
    private void onNewBillDialogAction(ActionEvent event) {
        addTab("Bill", "New Bill");
    }
    
    private void addTab(final String fxmlFileName, final String title) {

        final String KEY = "fxml";

        /*Ensure that no second instance of a view other than that of Invoice
         view is instantiated*/
        /*if (!fxmlFileName.equalsIgnoreCase(INVOICE_VIEW_FILE_NAME)) { //view other than Invoice view
            ObservableList<Tab> tabs = tabPane.getTabs();
            for (Tab tabInstance : tabs) {
                if (tabInstance.getProperties().get(KEY).toString()
                        .equalsIgnoreCase(fxmlFileName)) { //view already instantiated
                    tabPane.getSelectionModel().select(tabInstance);
                    return;
                }
            }
        }*/

        final String viewPath = "/billingapp/resource/views/" + fxmlFileName + ".fxml";

        FXMLLoader loader = new FXMLLoader();
        URL resource = this.getClass().getResource(viewPath);
        loader.setLocation(resource);
        Parent rootPane = null;
        try {
            rootPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            //Utility.beep();
            /*Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Occurred");
            alert.setHeaderText("Error in creating user interface");
            alert.setContentText("An error occurred in creating user interface "
                    + "for the selected command");
            alert.initOwner(MainWindow);
             Global.styleAlertDialog(alert);
            alert.showAndWait();*/
            return;
        }

       final TabContent controller = (TabContent) loader.getController();
        controller.setMainWindow(MainWindow);
        controller.setTabPane(tabPane);

        if (!controller.loadData()) {
            return;
        }

        Tab tab = new Tab();
        tab.getProperties().put("controller", controller);
        tab.getProperties().put(KEY, fxmlFileName);
        tab.setContent(rootPane);
        tab.setText(title);
        setContextMenu(tab);

        tab.setOnCloseRequest((Event event1) -> {
            if (!controller.shouldClose()) {
                event1.consume();
            }
        });
        
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
        controller.putFocusOnNode();
    }

    
    private void setContextMenu(final Tab tab) {

        final MenuItem closeTabItem = new MenuItem("Close Tab");
        final MenuItem closeOtherTabsItem = new MenuItem("Close Other Tabs");
        final MenuItem closeAllTabsItem = new MenuItem("Close All Tabs");

        final ContextMenu contextMenu = new ContextMenu(closeTabItem, closeOtherTabsItem,
                closeAllTabsItem);

        setCloseTabAction(tab, closeTabItem);
        setCloseOtherTabsAction(tab, closeOtherTabsItem);
        setCloseAllTabsAction(tab, closeAllTabsItem);

        tab.setContextMenu(contextMenu);
    }
    
    private void setCloseAllTabsAction(final Tab tab, final MenuItem menuItem) {
        final EventHandler<ActionEvent> eventHandler = (ActionEvent event) -> {
            closeAllTabs();
        };

        menuItem.setOnAction(eventHandler);
    }

    private void setCloseOtherTabsAction(final Tab tab, final MenuItem menuItem) {
        final EventHandler<ActionEvent> eventHandler = (ActionEvent event) -> {
            final TabPane tabPane = tab.getTabPane();
            Global.closeTabs(tabPane, tab);
        };

        menuItem.setOnAction(eventHandler);
    }

    private void setCloseTabAction(final Tab tab, final MenuItem menuItem) {

        final EventHandler<ActionEvent> eventHandler = (ActionEvent event) -> {
            final TabPane tabPane = tab.getTabPane();
            tabPane.getSelectionModel().select(tab);
            TabContent controller = (TabContent) tab.getProperties().get("controller");
            if (controller.shouldClose()) {
                tabPane.getTabs().remove(tab);
            }
        };

        menuItem.setOnAction(eventHandler);
    }

    public boolean closeAllTabs() {
        final ObservableList<Tab> tabs = tabPane.getTabs();
        final List<Tab> tabsToRemove = new ArrayList<>(tabs.size());

        for (Tab tabControl : tabs) {
            tabPane.getSelectionModel().select(tabControl);
            TabContent controller = (TabContent) tabControl.getProperties().get("controller");
            if (!controller.shouldClose()) {
                return false;
            } else {
                tabsToRemove.add(tabControl); //mark this tab to be removed
            }
        }

        tabs.removeAll(tabsToRemove); //actually remove the tags here
        return true;
    }

    
}
