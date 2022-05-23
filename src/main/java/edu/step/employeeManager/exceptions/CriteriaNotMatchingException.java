package edu.step.employeeManager.exceptions;

public class CriteriaNotMatchingException extends Exception{

    public  CriteriaNotMatchingException (Integer id) {
        super("Employee" + id + "should match criteria:" +
                "First name should be longer than 2 characters  \n" +
                "Last name should be longer than 2 characters \n" +
                "Should be a valid birthdate \n" +
                "Salary should be a number \n" +
                "Should be a valid hire date  \n" +
                "Phone number should be longer than 3 characters \n" +
                "Email should contain @ symbol \n" +
                "Company name should be longer than 2 characters \n" +
                "IDNP should be longer than 13 characters \n" +
                "Street number should contain a number \n" +
                "Street name should be longer than 3 characters \n" +
                "Apartment number should contain a number \n" +
                "House number should contain a number \n" +
                "Department name should be longer than 2 characters \n" +
                "Profession name should be longer than 2 characters ");
    }
}
