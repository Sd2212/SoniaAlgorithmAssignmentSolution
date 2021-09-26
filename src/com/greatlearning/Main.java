package com.greatlearning;

import com.greatlearningservice.MergeSort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MergeSort mergeSort=new MergeSort();
        mergeSort.implementation();
        System.out.println();


        System.out.println(" Enter the operation you want to perform");
        System.out.println("1.Display the company's stock prices in ascending order");
        System.out.println("2.Display the company's stock prices in descending order");
        System.out.println("3.Display the total no of companies for which stock prices rose today");
        System.out.println("4.Display the total no of companies for which stock prices decline today");
        System.out.println("5.Search a specfic stock price");
        System.out.println("6.Press  0 to exit");

        Scanner sc=new Scanner(System.in);
        int option=sc.nextInt();
        switch (option){
            case 1:double[] array=mergeSort.arr1;
                mergeSort.sortArray(array, 0, array.length-1);break;
            case 2:double[] array1=mergeSort.arr1;
                mergeSort.reverse(array1,0,array1.length-1);break;
            case 3:mergeSort.checkrose();break;
            case 4:mergeSort.checkdecline();break;
            case 5:System.out.println("Enter the key value");
                double key=sc.nextDouble();
                double[] arr=mergeSort.arr1;
                double result= mergeSort.binarySearch(arr,0,arr.length, key );
                if (result==-1){
                    System.out.println("Stock with value "+key+" is not present");}
                else{
                    System.out.println("Stock with value "+key+" is  present");}
                break;
            case 0: System.out.println("Exited Succesfully");
                System.exit(0);
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
}
