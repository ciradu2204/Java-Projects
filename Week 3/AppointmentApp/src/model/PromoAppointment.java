package model;

import java.time.LocalTime;

public class PromoAppointment extends Appointment {
   private String promoCode;
   private int discountPercentage;

    public PromoAppointment(){
        super();
        this.promoCode = null;
        this.discountPercentage = 0;
    }

    public PromoAppointment(String customerName, LocalTime appointmentTime, int appointmentLength, String promoCode, int discountPercentage){
        super(customerName, appointmentTime, appointmentLength);
        this.promoCode =promoCode;
        this.discountPercentage = discountPercentage;

    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String toString() {
        return "\nCustomer: " + this.getCustomerName()+
                " Time: " + this.getAppointmentTime() +
                " Length: " + Integer.toString(this.getAppointmentLength()) +
                " PromoCode: " + this.promoCode +
                " DiscountPercentage: " + this.discountPercentage + "\n";

    }

    public String toString(char delimiter) {
        final char EOLN='\n';
        final String QUOTE="\"";
        String str = QUOTE + this.getCustomerName() + QUOTE + delimiter +
                QUOTE + this.getAppointmentTime() + QUOTE + delimiter +
                Integer.toString(this.getAppointmentLength()) + delimiter +
                QUOTE + this.promoCode + QUOTE + delimiter +
                Integer.toString(this.getDiscountPercentage()) + EOLN;

        return str;
    }

}
