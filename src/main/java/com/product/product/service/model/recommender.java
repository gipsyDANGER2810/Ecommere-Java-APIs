package com.product.product.service.model;

import org.python.core.*;
import org.python.util.PythonInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class recommender {

    public static String getRecommendation(String name) {
        String suggestion = null;

        try {
            // Command to run the Python script using CPython
            String pythonCommand = "python";
            String scriptPath = "C:/Users/swapn/Desktop/dataset/recommend.py"; // Replace with your script path
            String[] cmd = {pythonCommand, scriptPath, name};

            // Build the process
            ProcessBuilder processBuilder = new ProcessBuilder(cmd);
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the Python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            suggestion = reader.readLine();

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Python script executed. Exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return suggestion;
    }
}
