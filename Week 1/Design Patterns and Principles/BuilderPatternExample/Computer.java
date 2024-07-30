public class Computer {
  private String CPU;
  private String RAM;
  private String storage;
  private String powerSupply;
  private String GPU;

  private Computer(Builder builder) {
    this.CPU = builder.CPU;
    this.GPU = builder.GPU;
    this.RAM = builder.RAM;
    this.storage = builder.storage;
    this.powerSupply = builder.powerSupply;
  }

  public String getCPU() {
    return CPU;
  }

  public String getGPU() {
    return GPU;
  }

  public String getRAM() {
    return RAM;
  }

  public String getStorage() {
    return storage;
  }

  public String getPowerSupply() {
    return powerSupply;
  }

  public static class Builder {
    private String CPU;
    private String GPU;
    private String RAM;
    private String storage;
    private String powerSupply;

    public Builder setCPU(String CPU) {
      this.CPU = CPU;
      return this;
    }

    public Builder setGPU(String GPU) {
      this.GPU = GPU;
      return this;
    }

    public Builder setRAM(String RAM) {
      this.RAM = RAM;
      return this;
    }

    public Builder setStorage(String storage) {
      this.storage = storage;
      return this;
    }

    public Builder setPowerSupply(String powerSupply) {
      this.powerSupply = powerSupply;
      return this;
    }

    public Computer build() {
      return new Computer(this);
    }
  }

  @Override
  public String toString() {
    return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", powerSupply=" + powerSupply + ", GPU="
        + GPU + "]";
  }
}