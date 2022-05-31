package com.amex;

public final class Country {

    // declared private final instance variable
    private final String countryName;
    // Mutable object
    private final ArrayList listOfStates;

    public Country(String countryName, ArrayList listOfStates) {
        super();
        this.countryName = countryName;
        // Creating deep copy for mutable object
        ArrayList tempList = new ArrayList();
        for (int i = 0; i < listOfStates.size(); i++) {
            tempList.add(listOfStates.get(i));
        }
        this.listOfStates = tempList;
    }

    public String getCountryName() {
        // Do not need to do cloning as it is immutable object
        return countryName;
    }

    public ArrayList getListOfStates() {
        // Returning cloned object 
        return (ArrayList) listOfStates.clone();
    }

    public static void main(String[] args) {
        ArrayList listOfStates = new ArrayList();
        listOfStates.add("Madhya Pradesh");
        listOfStates.add("Maharastra");
        listOfStates.add("Gujrat");

        String countryName = "India";
        Country country = new Country(countryName, listOfStates);
        System.out.println("Country : " + country.getCountryName());
        // Lets try to change local variable countryName
        countryName = "China";
        System.out.println("Updated Country : " + country.getCountryName());
        System.out.println("List of states : " + country.getListOfStates());
        // It will  not be added to the list because we are using clone in
        // getListOfStates
        country.getListOfStates().add("Kerala");
        // It will not be added to the list because we are using deep copy in
        // constructor
        listOfStates.add("Rajasthan");
        System.out.println("Updated List of states : " + country.getListOfStates());
    }
}
