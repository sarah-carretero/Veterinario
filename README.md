# Veterinario
A Java console application for managing pet records associated with their owners.

## Overview
Veterinario allows users to register pets, associate multiple pets with an owner, display registered records, and search for owners or pets through an interactive command-line menu.

## Features
* Register pets and associate them with an owner
* Store multiple pets for each owner
* Display all registered owners and pets
* Display pets associated with a specific owner
* Search for an owner
* Search for a pet using its name, type, and age
* Interactive console-based menu

## Technologies
* Java
* HashMap
* ArrayList
* List
* Scanner

## Data Structure
The application uses a `HashMap<String, List<mascota>>` to associate each owner with a list of registered pets.
Each `mascota` object stores:
* Name
* Type
* Age

## Project Structure
* `veterinario.java` — Main program, menu, registration, consultation, and search functionality
* `mascota.java` — Pet data model and accessor methods

## Academic Context
Developed as academic coursework in Computer Systems Engineering at UDLAP.

## How to Run
Compile the program:

```bash
javac veterinario.java mascota.java
```

Run the application:

```bash
java veterinario
```
