package dev.footer.tetrajs.kjs.registry;

import dev.latvian.mods.kubejs.event.StartupEventJS;
import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TetraRegistryEvent extends StartupEventJS {
	
	public void createMaterial(String key, String category, double primary, double secondary, double tertiary,
							   int durability, int integrityCost, int integrityGain, int magicCapacity, String toolLevel,
							   double toolEfficiency, Map<String, String> tints, List<String> textures, Map<String, List<String>> material,
							   Map<String, String> requiredTools) {
		// Create a new instance of the Tetra material
		Map<String, Object> newMaterial = new HashMap<>();
		newMaterial.put("key", key);
		newMaterial.put("category", category);
		newMaterial.put("primary", primary);
		newMaterial.put("secondary", secondary);
		newMaterial.put("tertiary", tertiary);
		newMaterial.put("durability", durability);
		newMaterial.put("integrityCost", integrityCost);
		newMaterial.put("integrityGain", integrityGain);
		newMaterial.put("magicCapacity", magicCapacity);
		newMaterial.put("toolLevel", toolLevel);
		newMaterial.put("toolEfficiency", toolEfficiency);
		newMaterial.put("tints", tints);
		newMaterial.put("textures", textures);
		newMaterial.put("material", material);
		newMaterial.put("requiredTools", requiredTools);
	
		// Convert the map to JSON
		System.out.println("About to create JSON...");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(newMaterial);
		System.out.println("JSON created! Now checking for directory...");
	
		// Check if the directory exists and create it if it doesn't
		Path dirPath = Paths.get("src/main/resources/data/tetra/materials/");
		if (!Files.exists(dirPath)) {
			System.out.println("Directory doesn't exist. Creating it...");
			try {
				Files.createDirectories(dirPath);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		System.out.println("Directory exists. Now writing JSON to file...");
	
		// Write the JSON to a file
		try (FileWriter file = new FileWriter(dirPath.resolve(key + ".json").toString())) {
			file.write(json);
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}