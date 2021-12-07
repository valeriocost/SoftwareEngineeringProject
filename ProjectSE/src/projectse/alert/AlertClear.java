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
public class AlertClear implements AlertStrategy{

    @Override
    public String getCustomText() {
        return "Operation/s Deleted";
    }

    @Override
    public String getCustomAlert() {
        return "The operation/s has/have been deleted";
    }

    @Override
    public String getTitle() {
        return "Clear Done";
    }

    @Override
    public Alert.AlertType getAlertType() {
        return Alert.AlertType.INFORMATION;
    }
    
}
