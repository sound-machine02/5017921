public class TestBuilder {
  public static void main(String[] args) {

    Computer officePC = new Computer.Builder().setCPU("Intel i3").setRAM("8GB").setStorage("512GB").build();

    Computer gamingPC = new Computer.Builder().setCPU("Intel i7").setGPU("RTX 4060").setRAM("32GB").setStorage("1 TB")
        .setPowerSupply("650 W").build();

    System.out.println(officePC);
    System.out.println(gamingPC);
  }
}