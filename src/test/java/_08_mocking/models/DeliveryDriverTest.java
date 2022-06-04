package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeliveryDriverTest {

    DeliveryDriver deliveryDriver;
    String name = "name";
    @Mock
    Car car;
    @Mock
    CellPhone phone;
    @BeforeEach
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    	deliveryDriver = new DeliveryDriver(name, car, phone);
    }

    @Test
    void itShouldWasteTime() {
        //given
    	boolean expected = true;
    	when(phone.browseCatMemes()).thenReturn(true);
        //when
    	boolean actual = deliveryDriver.wasteTime();
        //then
    	assertEquals(expected,actual);
    }

    @Test
    void itShouldRefuel() {
        //given
    	int octaneGrade = 85;
    	boolean expected = true;
    	when(car.fillTank(octaneGrade)).thenReturn(true);
        //when
    	boolean actual = deliveryDriver.refuel(octaneGrade);
        //then
    	assertEquals(expected,actual);
    }

    @Test
    void itShouldContactCustomer() {
        //given
    	String phoneNum = "8582267833";
    	boolean expected = true;
    	when(phone.call(phoneNum)).thenReturn(true);
        //when
    	boolean actual = deliveryDriver.contactCustomer(phoneNum);
        //then
    	assertEquals(expected,actual);
    }

}