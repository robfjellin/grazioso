public class Monkey extends RescueAnimal {
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    public Monkey(String name, String gender, String age, String weight, String acquisitionDate,
                  String acquisitionLocation, String trainingStatus, boolean reserved,
                  String inServiceCountry, String tailLength, String height, String bodyLength, String species) {
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionLocation);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                " | Gender: " + getGender() +
                " | Age: " + getAge() +
                " | Weight: " + getWeight() +
                " | Acquisition Date: " + getAcquisitionDate() +
                " | Acquisition Location: " + getAcquisitionLocation() +
                " | Training Status: " + getTrainingStatus() +
                " | Reserved: " + (getReserved() ? "Yes" : "No") +
                " | In-Service Country: " + getInServiceLocation() +
                " | Tail Length: " + tailLength +
                " | Height: " + height +
                " | Body Length: " + bodyLength +
                " | Species: " + species;
    }

    // Mutator methods
    public void setTailLength(String length) {
        tailLength = length;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setBodyLength(String length) {
        bodyLength = length;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    // Accessor methods
    public String getTailLength() {
        return tailLength;
    }

    public String getHeight() {
        return height;
    }

    public String getBodyLength() {
        return bodyLength;
    }

    public String getSpecies() {
        return species;
    }
}