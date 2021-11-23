/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectse;


import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author PRINCIPAL
 */
public class ComplexNumberTest {
    
    @Test
    public void testAdd(){
       ComplexNumber c1=new ComplexNumber(5.2,3.2);
       ComplexNumber c2=new ComplexNumber(1.2,2.2);
       ComplexNumber c3=c1.add(c2);
       assertEquals("6.4 + 5.4i",c3.toString());
       
       ComplexNumber c4=new ComplexNumber(5.2,0);
       ComplexNumber c5=new ComplexNumber(1.2,0);
       ComplexNumber c6=c4.add(c5);
       assertEquals("6.4",c6.toString());
       
       ComplexNumber c7=new ComplexNumber(5.2,8.2);
       ComplexNumber c8=new ComplexNumber(1.2, -1.1);
       ComplexNumber c9=c7.add(c8);
       assertEquals("6.4 + 7.1i",c9.toString());
       
       ComplexNumber c10=new ComplexNumber(0,2);
       ComplexNumber c11=new ComplexNumber(0,2);
       ComplexNumber c12=c10.add(c11);
       assertEquals("4.0i",c12.toString());
    }
    
   @Test
    public void testSubtract(){
    ComplexNumber c1=new ComplexNumber(5.2,3.2);
       ComplexNumber c2=new ComplexNumber(1.2,2.2);
       ComplexNumber c3=c1.subtract(c2);
       assertEquals("4.0 + 1.0i",c3.toString());
       
    ComplexNumber c4=new ComplexNumber(5.2,0);
       ComplexNumber c5=new ComplexNumber(1.2,0);
       ComplexNumber c6=c4.subtract(c5);
       assertEquals("4.0",c6.toString());
       
    }
    
    @Test
    public void testMultiplication(){
    ComplexNumber c1=new ComplexNumber(5.2,3.2);
       ComplexNumber c2=new ComplexNumber(1.2,2.2);
       ComplexNumber c3=c1.multiplication(c2);
       assertEquals("-0.8000000000000007 + 15.280000000000001i",c3.toString());
 
       ComplexNumber c4=new ComplexNumber(5,0);
       ComplexNumber c5=new ComplexNumber(1,0);
       ComplexNumber c6=c4.multiplication(c5);
       assertEquals("5.0",c6.toString());
       
       ComplexNumber c7=new ComplexNumber(0,3);
       ComplexNumber c8=new ComplexNumber(0,3);
       ComplexNumber c9=c7.multiplication(c8);
       assertEquals("-9.0",c9.toString());
       
    }
    
    @Test
    public void testDivision(){
    ComplexNumber c1=new ComplexNumber(5.2,3.2);
       ComplexNumber c2=new ComplexNumber(1.2,2.2);
       ComplexNumber c3=c1.division(c2);
       assertEquals("2.114649681528662 - 1.210191082802548i",c3.toString());
 
       ComplexNumber c4=new ComplexNumber(6,0);
       ComplexNumber c5=new ComplexNumber(2,0);
       ComplexNumber c6=c4.division(c5);
       assertEquals("3.0",c6.toString());
       
       ComplexNumber c7=new ComplexNumber(0,3);
       ComplexNumber c8=new ComplexNumber(0,3);
       ComplexNumber c9=c7.division(c8);
       assertEquals("1.0",c9.toString());
       
    }
    
    @Test
    public void testInvertSign(){
    ComplexNumber c1=new ComplexNumber(5.2,3.2);
       assertEquals("-5.2 - 3.2i",c1.invertSign().toString());
       
    ComplexNumber c2=new ComplexNumber(5.2,0);
       assertEquals("-5.2",c2.invertSign().toString());
       
    ComplexNumber c3=new ComplexNumber(-5.2,-3.2);
       assertEquals("5.2 + 3.2i",c3.invertSign().toString());
    }
    
     @Test
    public void testSqrt(){
       ComplexNumber c1=new ComplexNumber(1,81);
       ComplexNumber c2= c1.sqrt();
       assertEquals("6.403365232606779 + 6.324799309239564i", c2.toString());
       
       ComplexNumber c3=new ComplexNumber(64,0);
       ComplexNumber c4= c3.sqrt();
       assertEquals("8.0",c4.toString());
       
       ComplexNumber c5=new ComplexNumber(-64,0);
       ComplexNumber c6= c5.sqrt();
       assertEquals("0.0625 - 8.0i",c6.toString());
       
       ComplexNumber c7=new ComplexNumber(0,81);
       ComplexNumber c8= c7.sqrt();
       assertEquals("6.3639610306789285 + 6.363961030678927i",c8.toString());
       
    }

}