package se.lexicon.model;

public enum SnackType {
    BAR(1), CHIPS(2), DELICATOBALL(3), NON_BINARY(4);

    private int typeCode;

    SnackType(int typeCode) {
        this.typeCode = typeCode;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }
}
