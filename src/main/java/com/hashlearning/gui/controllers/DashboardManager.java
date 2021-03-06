package com.hashlearning.gui.controllers;

import com.hashlearning.utils.SessionManager;
import com.jfoenix.controls.JFXTabPane;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardManager {

    private GridPane container;

    public void open(int index, GridPane container) {
        this.container = container;
        switch (index) {
            case 0:
                openDashboard();
                break;
            case 1:
                openCoursesPage();
                break;
            case 2:
                openAssignmentsPage();
                break;
            case 3:
                try {
                    SessionManager.signOut((Stage) container.getScene().getWindow());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }
    }


    private void openDashboard() {
        System.out.println("Dashboard selected!");

        JFXTabPane tabPane = new JFXTabPane();
        tabPane.getStylesheets().add(getClass().getResource("/css/jfoenix-components.css").toExternalForm());
        tabPane.setTabMinHeight(60);
        tabPane.setTabMinWidth(200);

        Tab tab1 = new Tab();
        tab1.setText("COURSES");
        Label coursesLabel = new Label("Courses Page!");
        coursesLabel.setStyle("-fx-font-size: 50px");
        tab1.setContent(coursesLabel);
        tabPane.getTabs().add(tab1);

        Tab tab2 = new Tab();
        tab2.setText("ASSIGNMENTS");
        Label assignmentsLabel = new Label("Assignments Page!");
        tab2.setContent(assignmentsLabel);
        assignmentsLabel.setStyle("-fx-font-size: 50px");
        tabPane.getTabs().add(tab2);
        tabPane.getSelectionModel().select(0);

        container.getChildren().add(tabPane);
    }

    private void openCoursesPage() {

    }

    private void openAssignmentsPage() {

    }

}
