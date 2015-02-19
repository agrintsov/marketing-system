package com.sagr.marketing.system.ui.controller;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import com.google.inject.Inject;
import com.sagr.marketing.system.customer.Customer;
import com.sagr.marketing.system.customer.ICustomerService;
import com.sagr.marketing.system.ui.ISceneManager;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * @author Oleksandr Hrintsov.
 */
public class Customers implements ISceneController, Initializable {
    private ISceneManager sceneManager;
    private ICustomerService customerService;
    private ObservableList<Customer> customers;

    @FXML
    private TableView<Customer> customerTable;

    @Inject
    public Customers(ISceneManager sceneManager, ICustomerService customerService) {
        this.sceneManager = sceneManager;
        this.customerService = customerService;
    }

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void initialize(URL location, ResourceBundle resources) {
        customers = FXCollections.observableList(customerService.getAll());
        customerTable.setItems(customers);
    }
}
