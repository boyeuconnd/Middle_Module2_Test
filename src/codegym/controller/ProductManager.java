package codegym.controller;

import codegym.impl.ProductManagerActs;
import codegym.model.Product;
import codegym.storage.ProductList;

import java.util.Iterator;
import java.util.Scanner;

public class ProductManager extends ProductList implements ProductManagerActs {
    Scanner scn = new Scanner(System.in);
    @Override
    public void showProductList() {
        if(productsList.isEmpty()){
            System.out.println("Product list is empty, please add products.");
        }else {
            ShowArray();
        }

    }


    @Override
    public boolean addProduct(String id,String name,int price,int status,String description) {
        boolean result =false;
        Product addProduct = new Product(id, name, price,status,description) {};
        productsList.add(addProduct);
        if(productsList.contains(addProduct)) {
            result = true;
            System.out.println("Product added");
        }else System.out.println("Product not added, try again!");
        return result;
    }



    @Override
    public boolean editProductStatic() {
        return false;
    }

    @Override
    public boolean deleteProduct(String name) {
        for (Product product:productsList) {
            if(product.getName().equalsIgnoreCase(name)){
                System.out.println("Product deleted.");
                productsList.remove(product);
                return true;
            }
        }
        System.out.println("Product "+name+" not found, try again.");

        return false;
    }

    @Override
    public boolean findProduct(String name) {
        for (Product product:productsList) {
            if(product.getName().equalsIgnoreCase(name)){
                System.out.println("Product found.");
                System.out.println("ID: "+product.getId()+
                        " Name: "+product.getName()+
                        " Price: "+product.getPrice()+
                        " Status: "+product.getStatus()+
                        " Description: "+product.getDescription());
                return true;
            }

        }
        System.out.println("Product "+name+" not found, try again.");
        return false;
    }

    @Override
    public void sortProductList() {

    }
    private void ShowArray() {
        Iterator<Product> iterator = productsList.iterator();
        while (iterator.hasNext()){
            Product thisProduct = iterator.next();
            System.out.println("ID: "+thisProduct.getId()+
                    " Name: "+thisProduct.getName()+
                    " Price: "+thisProduct.getPrice()+
                    " Status: "+thisProduct.getStatus()+
                    " Description: "+thisProduct.getDescription());
        }
    }
//    private Product setNewProductStatic(String id, String name, int price) {
//        Product addProduct = new Product(id,name,price){};
//        System.out.print("Enter product status");
//        int status = scn.nextInt();
//        System.out.print("Enter product description:");
//        String descrip = scn.nextLine();
//        addProduct.setStatus(status);
//        addProduct.setDescription(descrip);
//        return addProduct;
//    }
}