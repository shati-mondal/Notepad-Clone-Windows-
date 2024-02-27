import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionsFile {

    Gui gui;
    String fileName;
    String fileAddress;

    public FunctionsFile(Gui gui) {
        this.gui = gui;
    }

    // functions to create a new file
    // whenever some one click on the new items
    public void newFile() {
        gui.textArea.setText(""); // erase the current text
        gui.window.setTitle("new"); // set the default new name of the new file
    }

    // function to open a existing file
    public void newOpen() {

        // to display dialog file
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        // logic to open any files
        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            // System.out.println(fileName + fileAddress);
            gui.window.setTitle(fileName);
        }

        // display the content of the file
        // use buffer reader
        try {
            // you need to read the address of the file
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");

            String line = null;

            while ((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // function to save
    public void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // function to save as
    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            FileWriter fw = new FileWriter(fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // function to create exit operation
    public void exit(){
        System.exit(0);
    }
}
