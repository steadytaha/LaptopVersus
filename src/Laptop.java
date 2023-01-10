
public class Laptop extends Product {

    int id, GPUScore, CPUScore, storage, ram;
    String GPU, processor, operatingSystem;
    double screen;

    public Laptop(int id, String brand, String model, String GPU, String processor, int ram, int storage, double screen, double weight, int year, String operatingSystem, int price, int GPUScore, int CPUScore,
            String img) {
        super(weight, brand, model, year, price, img);
        this.GPU = GPU;
        this.id = id;
        this.GPUScore = GPUScore;
        this.CPUScore = CPUScore;
        this.processor = processor;
        this.ram=ram;
        this.storage=storage;
        this.operatingSystem=operatingSystem;
        this.screen=screen;
        
        
    }

    public int getCPUScore() {
        return CPUScore;
    }

    public void setCPUScore(int CPUScore) {
        this.CPUScore = CPUScore;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getScreen() {
        return screen;
    }

    public void setScreen(double screen) {
        this.screen = screen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public int getGPUScore() {
        return GPUScore;
    }

    public void setGPUScore(int GPUscore) {
        this.GPUScore = GPUscore;
    }
}
