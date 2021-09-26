package com.greatlearningservice;

import com.greatlearning.Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MergeSort {
    public int elements;
    public int tcount = 0, fcount = 0;
    public boolean bol;
    public double[] arr1;
    public double key;
    Scanner sc = new Scanner(System.in);


    public void implementation() {
        System.out.println("Enter the number of Companies:");
        elements = sc.nextInt();
        arr1 = new double[elements];
        for (int i = 0; i < elements ; i++) {
            System.out.println("Enter the current stock price of the company " + (i+1) + " :");
            arr1[i] = sc.nextDouble();

            System.out.println("Whether the company's stock rose today compared to yesterday?");
            bol = sc.nextBoolean();
            if (bol == true) {
                tcount++;
            } else {
                fcount++;
            }
        }
    }

    public void checkrose() {
        System.out.println("Total no of companies for which stock prices rose today: " + tcount);
    }

    public void checkdecline() {
        System.out.println("Total no of companies for which stock prices decline today: " + fcount);
    }

    public void sortArray(double[] array, int start, int end) {
        if (start<end) {
            int mid = (start + end) / 2;
            sortArray(array, start, mid);
            sortArray(array, mid+ 1, end);
            conquerArray(array, start, mid, end);
        }
    }

    public void conquerArray(double[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        double L[] = new double[ n1];
        double R[] = new double[ n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = array[ l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[ (m + 1 + j)];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[ k] = L[i];
                i++;
            } else {
                array[ k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[ k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[ k] = R[j];
            j++;
            k++;
        }
        System.out.println("Stocks in ascending order: ");
        for (int n = 0; n < array.length; ++n)
            System.out.print(array[n] + " ");

    }

    public void reverse(double[] array, int start, int end) {
        if (end<=start)
            return;
        int mid = start+(end -start) / 2;
        reverse(array, start, mid);
        reverse(array, mid+ 1, end);
        merge(array, start, mid, end);

    }
    public void merge(double[] array, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        double L[] = new double[ n1];
        double R[] = new double[ n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[ l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[ (m + 1 + j)];
        }
        int i = 0, j = 0;
        int k = l;
        for ( k=l; k<r+1;k++)
            if(i < n1 && j < n2) {
                if (L[i] >= R[j]) {
                    array[ k] = L[i];
                    i++;
                } else {
                    array[ k] = R[j];
                    j++;
                }
            }
            else  if (i < n1) {
                array[ k] = L[i];
                i++;
            }
            else if (j < n2) {
                array[ k] = R[j];
                j++;
                k++;
            }
        System.out.println("Stocks in descending order: ");
        for (int n = 0; n < array.length; n++ )
            System.out.print(array[n] + " ");

    }


    public double binarySearch(double[] array, double l, double r, double key) {
        if (l <= r) {
            double mid = (l + (r - l)) / 2;
            if (array[(int) mid] == key)
                return mid;
            if (array[(int) mid] > key) {
                return binarySearch(arr1, l, mid - 1, key);
            } else {
                return binarySearch(arr1, mid + 1, r, key);
            }

        }
        return -1;
    }

}