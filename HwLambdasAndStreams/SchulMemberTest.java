package HwLambdasAndStreams;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

//tests different features of the SchulMmeberClass
public class SchulMemberTest {
    @Test
    public void TestDefaultConstructor() {
        SchulMember member1 = new SchulMember();
        String expected = "John";
        String actual = member1.getFirstNameOfMember();
        assertEquals(expected, actual);
    }

    @Test
    public void TestConstructor() {
        SchulMember member10 = new SchulMember("Perez", "Dan", LocalDate.of(1980, 3, 9), "Devorah", "Perez", new String[]{}, 9);
        String expected = "Dan";
        String actual = member10.getFirstNameOfMember();
        assertEquals(expected, actual);
    }

    @Test //I actually caught a slight formatting issue because of this one
    public void TestToString() {
        SchulMember member10 = new SchulMember("Perez", "Dan", LocalDate.of(1980, 3, 9), "Devorah", "Perez", new String[]{}, 9);
        String expected = "Member\n" + "Name: Dan Perez\n" + "DOB: 1980-03-09\n" + "Spouse: Devorah Perez\n" + "Children: []\n" + "Years of Membership: 9";
        String actual = member10.toString();
        assertEquals(expected, actual);
    }

    @Test //people of different ages
    public void TestComparator() {
        SchulMember member10 = new SchulMember("Perez", "Dan", LocalDate.of(1980, 3, 9), "Devorah", "Perez", new String[]{}, 9);
        SchulMember member9 = new SchulMember("Cohn", "Huda", LocalDate.of(1974, 7, 10), "Noah", "Cohn", new String[]{"Nancy", "Howard", "Parker", "Bushland", "Nimrod", "Mendel"}, 23);
        int expected = 1;
        int actual = member9.compareTo(member10);
        assertEquals(expected, actual);
    }

    @Test //people with same exact birthday
    public void TestComparator2() {
        SchulMember member10 = new SchulMember("Perez", "Dan", LocalDate.of(1980, 3, 9), "Devorah", "Perez", new String[]{}, 9);
        SchulMember member9 = new SchulMember("Cohn", "Huda", LocalDate.of(1980, 3, 9), "Noah", "Cohn", new String[]{"Nancy", "Howard", "Parker", "Bushland", "Nimrod", "Mendel"}, 23);
        int expected = 0;
        int actual = member9.compareTo(member10);
        assertEquals(expected, actual);
    }

    @Test //person with self
    public void TestComparator3() {
        SchulMember member10 = new SchulMember("Perez", "Dan", LocalDate.of(1980, 3, 9), "Devorah", "Perez", new String[]{}, 9);
        int expected = 0;
        int actual = member10.compareTo(member10);
        assertEquals(expected, actual);
    }
}
