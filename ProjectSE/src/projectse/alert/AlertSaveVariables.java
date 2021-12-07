/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse.alert;

import java.util.HashMap;
import javafx.scene.control.Alert;
import projectse.ComplexNumber;

/**
 *
 * @author win10
 */
public class AlertSaveVariables implements AlertStrategy{
    private HashMap<String, ComplexNumber> v;

    public AlertSaveVariables(HashMap<String, ComplexNumber> v) {
        this.v = v;
    }
    
    @Override
    public String getCustomText() {
        if(v!=null){
            return "Variable/s Saved";
        }
        else{
            return "It's not possible to save variable/s!";
        }
    }

    @Override
    public String getCustomAlert() {
        if(v!=null){
            String customAlert="The variable/s: \n";
            for(String k: v.keySet()){
                customAlert+="- "+k+": "+v.get(k)+"\n";
            }
            customAlert+="has/have been saved";
            return customAlert;
        }
        else{
            return "Error in saving variables!";
        }
    }

    @Override
    public String getTitle() {
        if(v!=null){
            return "Saving Done";
        }
        else{
            return "Saving Failed";
        }
    }

    @Override
    public Alert.AlertType getAlertType() {
        if(v!=null){
            return Alert.AlertType.INFORMATION;
        }
        else{
            return Alert.AlertType.ERROR;
        }
    }
    
}
