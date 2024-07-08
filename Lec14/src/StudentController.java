import java.awt.event.*;
public class StudentController implements ActionListener {
    private StudentModel model;
    private StudentView view;
    private StudentDisplayView displayView;
    
    public StudentController() {
        model = new StudentModel();
        view = new StudentView();
        displayView = new StudentDisplayView();
        
        model.addContactView(displayView);
        model.addContactView(view);
        
        view.getDisplay().addActionListener(this);
        view.getExit().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (e.getSource().equals(view.getDisplay())){
            updateModel();
        }
        else if (e.getSource().equals(view.getExit())) {
            System.exit(0);
        }
    }
    
    private void updateModel() {
        model.updateModel(view.getFirstName(), view.getLastName(), view.getCourse(), view.getAddress());
    }
}
