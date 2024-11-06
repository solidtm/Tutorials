package assignments.assignment3.client;

import BasicIO.ASCIIDataFile;
import assignments.assignment3.storage.CabinetImpl;

public class Demonstration {
    private final ASCIIDataFile file;
    private final CabinetImpl<String> cabinet;

    public Demonstration(String fileName){
        this.cabinet = new CabinetImpl<>();
        this.file =  new ASCIIDataFile(fileName);

        loadInventory();

        for (String binLabel : cabinet.getBins()) {
            System.out.println("Bin Label: " + binLabel + " contains " + cabinet.query(binLabel) + " items.");
        }
    }

    public void loadInventory() {
        try {
            String currentBinLabel = null;
            boolean isLabel = true;

            while (!file.isEOF()) {
                String line = file.readLine();


                if (line != null){
                    line = line.trim();

                    if (line.isEmpty()) {
                        isLabel = true;
                        continue;
                    }

                    if (isLabel) {
                        currentBinLabel = line;
                        isLabel = false;
                    } else {
                        cabinet.add(line, currentBinLabel);
                    }
                }
            }
        } finally {
            file.close();
        }
    }

    public static void main(String[] args) { new Demonstration("inventory.txt");}
}
