package com.example.jpanafast;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("gui")
public class Gui extends VerticalLayout {

    private TreeService treeService;

    @Autowired
    public Gui(TreeService treeService) {
        this.treeService = treeService;

        Grid<Tree> grid = new Grid<>(Tree.class);
        grid.setItems(treeService.findAllTrees());
        grid.setColumns("id", "name", "color");


        TextField nameTextField = new TextField("Name");
        TextField colorTextField = new TextField("Color");
        TextField idTextField = new TextField("ID");

        Button addTreeButton = new Button("Add tree");
        Button deleteTreeButton = new Button("Delete tree");
        Button modifyTreeButton = new Button("Modify tree");


        deleteTreeButton.addClickListener(buttonClickEvent -> {
           treeService.deleteTree(Long.parseLong(idTextField.getValue()));
        });

        addTreeButton.addClickListener(buttonClickEvent -> {
           treeService.saveTree(nameTextField.getValue(), colorTextField.getValue());
        });

        modifyTreeButton.addClickListener(buttonClickEvent -> {
           treeService.updateTree(Long.parseLong(idTextField.getValue()), nameTextField.getValue(), colorTextField.getValue());
        });

        add(grid, nameTextField, colorTextField, addTreeButton, idTextField, deleteTreeButton, modifyTreeButton);

    }


}
