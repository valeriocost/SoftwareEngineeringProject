/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse.alert;

import javafx.scene.control.Alert;

/**
 *
 * @author win10
 */
public abstract class AlertError implements AlertStrategy{
    private String operation; 
    
    public AlertError(String operation) {
        this.operation=operation;
    }
    
    @Override
    public Alert.AlertType getAlertType() {
        return Alert.AlertType.ERROR;
   }

    @Override
    public String getTitle(){
        return "Fatal Error";
    }

    @Override
    public abstract String getCustomAlert();

    @Override
    public abstract String getCustomText();

    public String getOperation() {
        return operation;
    }

    
    
}
