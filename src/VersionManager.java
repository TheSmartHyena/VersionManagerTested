public class VersionManager {
    private int version = 1;

    public void updateVersion(ETypeUpdate type) {
        this.version = version + switch(type) {
            case ETypeUpdate.PATCH -> 1;
            case ETypeUpdate.MINEUR -> 10;
            case ETypeUpdate.MAJEUR -> 100;
            default -> 0;
        };
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Version: " + this.version;
    }
}