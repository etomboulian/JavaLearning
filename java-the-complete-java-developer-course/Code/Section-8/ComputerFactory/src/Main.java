public class Main {
    public static void main(String[] args) {

        ComputerCase computerCase = new ComputerCase("2208", "Dell", "240");
        Monitor monitor = new Monitor("27in Beast", "Acer", 27, "2540 x 1440");
        Motherboard motherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PersonalComputer pc = new PersonalComputer("2208", "Dell", computerCase, motherboard, monitor);

        pc.powerUp();
//        pc.getMonitor().drawPixelAt(10,10, "red");
//        pc.getMotherboard().loadProgram(("Windows OS"));
//        pc.getComputerCase().pressPowerButton();



    }
}
