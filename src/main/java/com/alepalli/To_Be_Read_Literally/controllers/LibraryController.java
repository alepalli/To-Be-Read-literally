package com.alepalli.To_Be_Read_Literally.controllers;

import com.alepalli.To_Be_Read_Literally.entities.Library;
import com.alepalli.To_Be_Read_Literally.services.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    // Recupera tutti i progressi di lettura di un utente
    @GetMapping("/user/{userId}")
    public List<Library> getUserLibrary(@PathVariable Long userId){
        return libraryService.getLibraryByUser(userId);
    }

    // Aggiunge o aggiorna un progresso di lettura
    @PostMapping
    public Library saveLibrary(@RequestBody Library library){
        return libraryService.saveOrUpdateLibrary(library);
    }

    // Cancella un progresso di lettura
    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Long id){
        libraryService.deleteLibrary(id);
    }

    // Trova il progresso di lettura di un utente per un libro specifico
    @GetMapping("/user/{userId}/book{bookId}")
    public Optional<Library> getLibraryByUserAndBook(@PathVariable Long userId, @PathVariable Long bookId){
        return libraryService.findByUserAndBook(userId, bookId);
    }
}
