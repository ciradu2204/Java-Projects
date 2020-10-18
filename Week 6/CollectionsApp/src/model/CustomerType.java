/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mga
 */
public enum CustomerType {
    INTERNAL_ACCOUNT (0.25, 2),
    EXTERNAL_ACCOUNT (0.1, 1),
    EXTERNAL_NOACCOUNT (0, 3);
    
    private final double discount;
    private final int priorityLevel;
    
    CustomerType(double discount, int priorityLevel) {
        this.discount = discount;
        this.priorityLevel = priorityLevel;
    }
    
    private double getDiscount() {
        return this.discount;
    }
    
    private int getPriorityLevel() {
        return this.priorityLevel;
    }
}
