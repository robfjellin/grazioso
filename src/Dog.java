
public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;

    // Constructor
    public Dog(String name, String breed, String gender, String age,
               String weight, String acquisitionDate, String acquisitionCountry,
               String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

    }


    @Override
    public String toString() {
        return "Name: " + getName() +
                " | Breed: " + breed +
                " | Gender: " + getGender() +
                " | Age: " + getAge() +
                " | Weight: " + getWeight() +
                " | Acquisition Date: " + getAcquisitionDate() +
                " | Acquisition Location: " + getAcquisitionLocation() +
                " | Training Status: " + getTrainingStatus() +
                " | Reserved: " + (getReserved() ? "Yes" : "No") +
                " | In-Service Country: " + getInServiceLocation();
    }

    // Accessor Method
    public String getBreed() {
        return breed;
    }

    // Mutator Method
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }

    // TEST
}
