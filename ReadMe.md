# Animal Gallery API

Simple CRUD API for Animal Objects with JPA (Hibernate)

## Getting Started

### Prerequisites
- Java 21
- Maven
- Neon.tech PostgreSQL database

### Installation
1. Clone the repository
```bash
git clone https://github.com/dylanbsgit/csc340_a3_animal-gallery.git
```

2. Open the project in your IDE

3. Configure your database connection in `src/main/resources/application.properties`:
```properties
spring.datasource.url="YOUR NEON URL KEY HERE"
```

4. Run the application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

Base URL: `http://localhost:8080/api/animals`

### Get All Animals
**GET** `/`

Returns a list of all animals in the database.

**Response:**
```json
[
  {
    "animalId": 1,
    "name": "Leo",
    "description": "A majestic lion",
    "age": 5,
    "favoriteFood": "Meat",
    "habitat": "Savanna"
  },
  {
    "animalId": 2,
    "name": "Bella",
    "description": "A playful dolphin",
    "age": 3,
    "favoriteFood": "Fish",
    "habitat": "Ocean"
  }
]
```

### Get Animal by ID
**GET** `/{animalId}`

Returns a specific animal by its ID.

**Path Parameters:**
- `animalId` (Long) - REQUIRED

**Response:**
```json
{
  "animalId": 1,
  "name": "Leo",
  "description": "A majestic lion",
  "age": 5,
  "favoriteFood": "Meat",
  "habitat": "Savanna"
}
```

### Search Animals by Name
**GET** `/search`

Returns animals whose names contain the specified string.

**Query Parameters:**
- `name` (String) - REQUIRED

**Example:** `/search?name=Leo`

**Response:**
```json
[
  {
    "animalId": 1,
    "name": "Leo",
    "description": "A majestic lion",
    "age": 5,
    "favoriteFood": "Meat",
    "habitat": "Savanna"
  }
]
```

### Get Animals by Favorite Food
**GET** `/category`

Returns animals that have the specified favorite food.

**Query Parameters:**
- `favoriteFood` (String) - REQUIRED

**Example:** `/category?favoriteFood=Fish`

**Response:**
```json
[
  {
    "animalId": 2,
    "name": "Bella",
    "description": "A playful dolphin",
    "age": 3,
    "favoriteFood": "Fish",
    "habitat": "Ocean"
  }
]
```

### Create New Animal
**POST** `/`

Creates a new animal entry.

**Request Body:**
```json
{
  "name": "Max",
  "description": "A friendly elephant",
  "age": 12,
  "favoriteFood": "Leaves",
  "habitat": "Forest"
}
```

**Response:**
```json
{
  "animalId": 3,
  "name": "Max",
  "description": "A friendly elephant",
  "age": 12,
  "favoriteFood": "Leaves",
  "habitat": "Forest"
}
```

### Update Animal
**PUT** `/{animalId}`

Updates an existing animal.

**Path Parameters:**
- `animalId` (Long) - REQUIRED

**Request Body:**
```json
{
  "name": "Max Updated",
  "description": "An updated friendly elephant",
  "age": 13,
  "favoriteFood": "Fruits",
  "habitat": "Jungle"
}
```

**Response:**
```json
{
  "animalId": 3,
  "name": "Max Updated",
  "description": "An updated friendly elephant",
  "age": 13,
  "favoriteFood": "Fruits",
  "habitat": "Jungle"
}
```

### Delete Animal
**DELETE** `/{animalId}`

Deletes an existing animal.

## Technologies Used

- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL (Neon.tech)
- Maven

## Database Schema

The application uses a single `animals` table with the following structure:

| Column | Type | Description |
|--------|------|-------------|
| animalId | Long | Primary key (auto-generated) |
| name | String | Animal's name |
| description | String | Description of the animal |
| age | Integer | Animal's age |
| favoriteFood | String | Animal's favorite food |
| habitat | String | Animal's natural habitat |
