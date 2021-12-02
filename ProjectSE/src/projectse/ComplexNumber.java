package projectse;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ComplexNumber class manages all the main operations on complex numbers,
 * allowing to operate even on non-complex numbers in case of the absence of the 
 * imaginary part.
 * 
 * @author Group11
 */


public class ComplexNumber implements Serializable{  
     private double re;   // the real part
     private double im;   // the imaginary part
     
     private static final Map<String, Operation> customOperations = new HashMap<>();
     
    /**
     * Constructor of the ComplexNumber class
     * @param re the real part
     * @param im the imaginary part
     */
    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }
    
    /**
     * Gets the real part of a complex number
     * @return the real part of a complex number
     */
    public double getRe() {
        return re;
    }
    
    /**
     * Sets the real part of a complex number
     * @param re the real part of a complex number
     */
    public void setRe(double re) {
        this.re = re;
    }

    /**
     * Gets the imaginary part of a complex number
     * @return the imaginary part of a complex number
     */
    public double getIm() {
        return im;
    }

    /**
     * Sets the imaginary part of a complex number
     * @param im the imaginary part of a complex number
     */
    public void setIm(double im) {
        this.im = im;
    }
    
    /**
     * returns the String representation of a complex number 
     * @return String "a+bi"
     */
     @Override
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + "-" + (-im) + "i";
        return re + "+" + im + "i";
    }
    
    /**
     * Calculates the modulus of a complex number
     * @return modulus
     */
    public double abs(){
    return Math.hypot(re, im);
    }
    
    /**
     * Calculates in radians the phase of a complex number
     * @return phase
     */
     public double phase() {
        return Math.atan2(im, re);
    }
     
    /**
     * Supports addition between two complex numbers
     * @param c2 the addend
     * @return the result of the addition
     */
    public ComplexNumber add(ComplexNumber c2){
        ComplexNumber c1=this;  //invoking object
        double real = c1.re + c2.re;
        double imag = c1.im + c2.im;
        return new ComplexNumber(real, imag);
    }     
     
    /**
     * Supports subtraction between two complex numbers
     * @param c2 the subtracting
     * @return the result of the subtraction
     */
    public ComplexNumber subtract(ComplexNumber c2){
        ComplexNumber c1=this;  //invoking object
        double real = c1.re - c2.re;
        double imag = c1.im - c2.im;
        return new ComplexNumber(real, imag);
     }
    
    /**
     * Supports multiplication between two complex numbers
     * @param c2 the multiplier
     * @return the result of the multiplication
     */
      public ComplexNumber multiplication(ComplexNumber c2) {
        ComplexNumber c1 = this;
        double real = c1.re * c2.re - c1.im * c2.im;
        double imag = c1.re * c2.im + c1.im * c2.re;
        return new ComplexNumber(real, imag);
    }
      
    
     /**
      * Calculates the reciprocal of a complex number
      * @return a new Complex object whose value is the reciprocal of this
      */
    public ComplexNumber reciprocal() {
        double scale = re*re + im*im;
        return new ComplexNumber(re / scale, -im / scale);
    }
    
    
    /**
     * Supports division between two complex numbers
     * @param c2 the divider
     * @return the result of the division
     */
    public ComplexNumber division(ComplexNumber c2) {
        ComplexNumber c1 = this;
        return c1.multiplication(c2.reciprocal());
    }
    
    
    /**
     * Inverts the sign of a number
     * @return a new number with inverted sign
     */
    public ComplexNumber invertSign(){
        ComplexNumber c1=this;
        this.re=-this.re;
        this.im=-this.im;
        return c1;  
    }
    
    
    /**
     * Supports the square root of a complex number
     * @return the sqrt of the number
     */
    public ComplexNumber sqrt(){
    ComplexNumber csqrt = this;
    double dX, dY, dW, dR;

      if((re == 0) && (im == 0.0)) {
          csqrt.re = 0.0;
          csqrt.im = 0.0;
          return (csqrt);
      } 

      dX = Math.abs(re);
      dY = Math.abs(im);

      if( dX >= dY ) {
          dR = dY/dX;
          dW = Math.sqrt(dX)*Math.sqrt(0.5*(1.0 + Math.sqrt(1+dR*dR)));
      } else {
          dR = dX/dY;
          dW = Math.sqrt(dY)*Math.sqrt(0.5*(dR + Math.sqrt(1+dR*dR)));
      }

      if(re >= 0.0) {
         csqrt.re = dW;
         csqrt.im = im/(2.0*dW);
      } else {
         csqrt.im = (im > 0.0) ? dW : -dW;
         csqrt.re =  im/(2.0*csqrt.re);
      }

      return csqrt;
    }
     
    /**
     * Calculates the hash code of a complex number
     * @return the hash code of the complex number
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.re) ^ (Double.doubleToLongBits(this.re) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.im) ^ (Double.doubleToLongBits(this.im) >>> 32));
        return hash;
    }

    /**
     * Checks if two numbers are equals
     * @param obj the other number to compare
     * @return a boolean (equal or false) 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(this.re) != Double.doubleToLongBits(other.re)) {
            return false;
        }
        if (Double.doubleToLongBits(this.im) != Double.doubleToLongBits(other.im)) {
            return false;
        }
        return true;
    }
    
    /**
     * Gets the string of a complex number
     * @return the string of a complex number
     */
    public String getComplexString(){
        return this.toString();
    }
    
        
    /**
     * Parses a complex number expressed as a String and returns the corresponding ComplexNumber object.
     * 
     * @param s String to be parsed.
     * @return ComplexNumber object from s
     */
    public static ComplexNumber parse(String s){
        String[] splitted = s.split("[+|-]");
        String re, im;
        if(splitted.length == 3){
            re = splitted[1];
            im = splitted[2].replace("i", "");
            if(s.contains("+") && s.indexOf("+") == 0){
                if(s.contains("-") && s.lastIndexOf("-") != 0)
                    return new ComplexNumber(Double.parseDouble(re), -Double.parseDouble(im));
                return new ComplexNumber(Double.parseDouble(re), Double.parseDouble(im));
            } else{
                if(s.contains("-") && s.lastIndexOf("-") != 0)
                    return new ComplexNumber(-Double.parseDouble(re), -Double.parseDouble(im));
                return new ComplexNumber(-Double.parseDouble(re), Double.parseDouble(im));
            }
        } else if(splitted.length == 2){
            if(s.startsWith("+") || s.startsWith("-")){
                if(s.contains("i"))
                    return new ComplexNumber(0.0, Double.parseDouble(s.replace("i", "")));
                else{
                    return new ComplexNumber(Double.parseDouble(s), 0.0);
                }
                    
            } else{
                re = splitted[0];
                im = splitted[1].replace("i", "");
                if(s.contains("-") && s.lastIndexOf("-") != 0)
                    return new ComplexNumber(Double.parseDouble(re), -Double.parseDouble(im));
                return new ComplexNumber(Double.parseDouble(re), Double.parseDouble(im));
            }    
        } else if(s.contains("i")){
            return new ComplexNumber(0.0, Double.parseDouble(splitted[0].replace("i", "")));
        } else{
            return new ComplexNumber(Double.parseDouble(splitted[0]), 0.0);
        }
    }
    
    /**
     * Saves a custom operation into the collection. If the name of the operation has already been inserted, the operation will be replaced.
     * @param name The name of the custom operation.
     * @param op The operation referring to that name.
     */
    public static void insertCustomOperation(String name, Operation op){
        customOperations.put(name, op);
    }
    
    /**
     * Deletes a custom operation from the collection. If the name of the operation has not been inserted yet, nothing will happen.
     * @param name The name of the custom operation.
     */
    public static void deleteCustomOperation(String name){
        customOperations.remove(name);
    }
    
    /**
     * Returns a set of all the names of the inserted custom operations.
     * @return Set of String of names.
     */
    public static Set<String> getOperationsNames(){
        return customOperations.keySet();
    }
    
    /**
     * Returns the operation associated with the given name.
     * @param name of the operation
     * @return Operation associated with name. Or null if the name is not associated with any operations.
     */
    public static Operation getOperation(String name){
        return customOperations.get(name);
    }
    
    public static void saveOperations(){
        String filename = "save.bin";
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
            out.writeObject(customOperations);
            out.close();
        } catch (FileNotFoundException ex) {
             Logger.getLogger(ComplexNumber.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(ComplexNumber.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public static Set<String> loadOperations() {
        Map<String, Operation> ops = new HashMap<>();
        
        try(ObjectInputStream din = new ObjectInputStream(new BufferedInputStream(new FileInputStream("save.bin")))){
            ops = (Map<String,Operation>) din.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Error reading file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        
        for(String k : ops.keySet()){
            ComplexNumber.insertCustomOperation(k, ops.get(k));
        }
        return ops.keySet();
    }
    
    public static void clearOperations(){
        File saved = new File("save.bin");
        if(!saved.delete())
            System.out.println("Error clearing file");
    }
}