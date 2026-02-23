package com.ecommerce.monolith.customer.service;

/**
 * Interface définissant les services pour le module Customer.
 * Elle sert de contrat pour valider l'existence des clients.
 */
public interface CustomerService {

    // Cette méthode est cruciale pour l'exercice (Module Order)
    // Elle permet de vérifier si un client existe avant de passer commande
    boolean existsById(Long id);

    // Vous pourrez ajouter d'autres méthodes ici plus tard (ex: getById)
}