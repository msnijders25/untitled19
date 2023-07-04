
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestInputScanner {


     class MenuTest {

         @Test
         public void testValidateInput_ValidInput() {
             Menu menu = new Menu() {
                 @Override
                 public void menu() {

                 }
             };

             ArrayList<Object> array = new ArrayList<>();
             array.add("waarde 1");
             array.add("waarde 2");
             array.add("waarde3 3");

             assertTrue(menu.validateInput(array, 1));
         }

         @Test
         public void testValidateInput_InvalidInput() {
             Menu menu = new Menu() {
                 @Override
                 public void menu() {
                     // Not needed for this test
                 }
             };

             ArrayList<Object> array = new ArrayList<>();
             array.add("waarde 1");
             array.add("waarde 2");
             array.add("waarde 3");

             assertFalse(menu.validateInput(array, 5));
         }

     }

}
