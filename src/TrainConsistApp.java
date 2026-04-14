class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

abstract class GoodsBogie {
    protected String shape;
    protected String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        try {
            System.out.println("Attempting to assign cargo: " + cargoType);

            if (shape.equalsIgnoreCase("Rectangular") && cargoType.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo! Petroleum cannot be assigned to Rectangular bogie.");
            }

            this.cargo = cargoType;
            System.out.println("Cargo assigned successfully: " + cargoType);

        } catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment process completed.\n");
        }
    }

    public String getCargo() {
        return cargo;
    }
}

class RectangularBogie extends GoodsBogie {
    public RectangularBogie() {
        super("Rectangular");
    }
}

class CylindricalBogie extends GoodsBogie {
    public CylindricalBogie() {
        super("Cylindrical");
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {

        GoodsBogie cylindrical = new CylindricalBogie();
        cylindrical.assignCargo("Petroleum");

        GoodsBogie rectangular = new RectangularBogie();
        rectangular.assignCargo("Petroleum");

        rectangular.assignCargo("Grain");

        System.out.println("Program continues safely after handling exceptions.");
    }
}