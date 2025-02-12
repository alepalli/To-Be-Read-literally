package com.alepalli.To_Be_Read_Literally.services;

import com.alepalli.To_Be_Read_Literally.entities.Library;
import com.alepalli.To_Be_Read_Literally.repositories.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
    }

    // recupera tutti i progressi di lettura di un utente
    public List<Library> getLibraryByUser(Long userId){
        return libraryRepository.findByUserId(userId);
    }

    // aggiunge o aggiorna un progresso di lettura
    public Library saveOrUpdateLibrary(Library library){
        return libraryRepository.save(library);
    }

    // cancella un progresso di lettura
    public void deleteLibrary(Long id){
        libraryRepository.deleteById(id);
    }

    // trova un progresso di lettura specifico per utente e libro
    public Optional<Library> findByUserAndBook(Long userId, Long bookId){
        return libraryRepository.findByUserIdAndBookId(userId, bookId);

    }

}
