package java6_3.controller;

import model.Pet;

public class PetController {
    private final Pet pet;

    public PetController(Pet pet) {
        this.pet = pet;
    }

    public void update(double targetX, double targetY) {
        pet.moveTowards(targetX, targetY);
    }
}
