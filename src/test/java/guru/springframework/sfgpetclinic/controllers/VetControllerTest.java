package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    private SpecialtyService specialtyService;
    private VetService vetService;

    private VetController vetController;

    @BeforeEach
    public void init() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);

        vetController = new VetController(vetService);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();

        Set<Speciality> specialities = new HashSet<>();
        specialities.add(new Speciality("nose corrections"));

        vetService.save(new Vet(1l, "Jan", "de Boer", specialities));
        vetService.save(new Vet(2l, "Sjaan", "van Dijk", specialities));

        String listVets = vetController.listVets(model);

        assertEquals("vets/index", listVets);

        Set modelAttribute = (Set) ((ModelMapImpl) model).getAttributes().get("vets");
        assertEquals(modelAttribute.size(), 2);
    }
}