package complexcalculator.operation;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *Operation Interface
 *Supports the execute and modify commands
 * @author Group11
 */
public interface Operation {
    public void modify(String s) throws Exception;
    public List<String> getOperations();
}