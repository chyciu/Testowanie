import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PetTest {

    private static Pet pet;

    @BeforeClass
    public static void setup () {
        pet = mock(Pet.class);
    }

    @AfterClass
    public static void cleanup () {
        pet = null;
    }

    @Test
    public void getName_mockedPet_callVerification () {

        pet.getName();
        verify(pet).getName();
    }

    @Test
    public void setName_mockedPet_callVerification () {

        pet.setName("Fafik");
        verify(pet).setName("Fafik");
    }


    @Test
    public void setAge_mockedPet_callVerification () {

        pet.setAge(3);
        verify(pet).setAge(3);
    }

    @Test
    public void getAge_mockedPet_callVerification () {

        pet.getAge();
        verify(pet).getAge();
    }

    @Test
    public void getName_mockedPetWhichReturnsFafikName_Fafik () {

        String expected = "Fafik";
        when(pet.getName()).thenReturn("Fafik");

        String actual = pet.getName();
        assertThat(expected).isEqualTo(actual);
        //System.out.println("Fafik");
        // dodalem tylko dla sprawdzenia, czy działa...
    }



}
