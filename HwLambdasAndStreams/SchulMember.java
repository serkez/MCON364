package HwLambdasAndStreams;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class SchulMember implements Comparable {
    private String lastNameOfMember;
    private String firstNameOfMember;
    private LocalDate birthDateOfMember;
    private String spouseFirstName;
    private String spouseLastName;
    private String[] childrenNames;
    private int yearsOfMembership;

    public SchulMember(){
        this.lastNameOfMember = "Doe";
        this.firstNameOfMember = "John";
        this.birthDateOfMember = LocalDate.of(1999, 1, 1);
        this.spouseFirstName = "Jane";
        this.spouseLastName = "Doe";
        this.childrenNames = new String[]{};
        this.yearsOfMembership = 1;
    }
    public SchulMember(String lastNameOfMember, String firstNameOfMember, LocalDate birthDateOfMember, String spouseFirstName, String spouseLastName, String[] childrenNames, int yearsOfMembership) {
        this.lastNameOfMember = lastNameOfMember;
        this.firstNameOfMember = firstNameOfMember;
        this.birthDateOfMember = birthDateOfMember;
        this.spouseFirstName = spouseFirstName;
        this.spouseLastName = spouseLastName;
        this.childrenNames = childrenNames;
        this.yearsOfMembership = yearsOfMembership;
    }

    public String getLastNameOfMember() {
        return lastNameOfMember;
    }

    public void setLastNameOfMember(String lastNameOfMember) {
        this.lastNameOfMember = lastNameOfMember;
    }

    public String getFirstNameOfMember() {
        return firstNameOfMember;
    }

    public void setFirstNameOfMember(String firstNameOfMember) {
        this.firstNameOfMember = firstNameOfMember;
    }

    public LocalDate getBirthDateOfMember() {
        return birthDateOfMember;
    }

    public void setBirthDateOfMember(LocalDate birthDateOfMember) {
        this.birthDateOfMember = birthDateOfMember;
    }

    public String getSpouseFirstName() {
        return spouseFirstName;
    }

    public void setSpouseFirstName(String spouseFirstName) {
        this.spouseFirstName = spouseFirstName;
    }

    public String getSpouseLastName() {
        return spouseLastName;
    }

    public void setSpouseLastName(String spouseLastName) {
        this.spouseLastName = spouseLastName;
    }

    public String[] getChildrenNames() {
        return childrenNames;
    }

    public void setChildrenNames(String[] childrenNames) {
        this.childrenNames = childrenNames;
    }

    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }

    @Override
    public int compareTo(Object m) {
        SchulMember member = (SchulMember) m;
        int ageThis = Period.between(this.birthDateOfMember, LocalDate.now()).getYears();
        int ageOther = Period.between(member.birthDateOfMember, LocalDate.now()).getYears();
        return Integer.compare(ageThis, ageOther);
    }

    @Override
    public String toString() {
        return "Member\nName: " + firstNameOfMember + " " + lastNameOfMember + "\n"
                + "DOB: " + birthDateOfMember + "\n" + "Spouse: " + spouseFirstName + " " + spouseLastName + "\n"
                + "Children: " + Arrays.toString(childrenNames) + "\nYears of Membership: " + yearsOfMembership;
    }
}
