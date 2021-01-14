package se.lexicon.model;

public enum Protein {
    CHICKEN(1), BEEF(2), VEGETARIAN(3), PORK(4), SCRIMPS(5), MEATBALL(6), NON_BINARY(7);

    private int typeCode;

    Protein(int typeCode) {
        this.typeCode = typeCode;
    }

    //Generate Getters/Setters
    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }
}
