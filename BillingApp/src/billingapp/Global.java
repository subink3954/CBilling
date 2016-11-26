/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingapp;

import billingapp.utility.TabContent;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 *
 * @author arun
 */
public abstract class Global {
    
            public static boolean closeTabs(final TabPane tabPane, final Tab leaveItOpen) {
            final ObservableList<Tab> tabs = tabPane.getTabs();
            final List<Tab> tabsToRemove = new ArrayList<>(tabs.size());

            for (Tab tab : tabs) {
                if (!tab.equals(leaveItOpen)) {
                    tabPane.getSelectionModel().select(tab);
                    TabContent controller = (TabContent) tab
                            .getProperties().get("controller");
                    if (controller.shouldClose()) {
                        tabsToRemove.add(tab); //mark this tab to be removed
                    } else {
                        return false;
                    }
                }
            }

            tabs.removeAll(tabsToRemove); //actually remove the tags here
            return true;
        
    }

}
