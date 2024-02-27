public class FunctionEdit {
    Gui gui;
    public FunctionEdit(Gui gui){
        this.gui=gui;
    }

    public void undo(){
        gui.um.undo();
    }

    public void redo(){
        gui.um.redo();
    }
}
