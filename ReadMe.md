# Animal Gallery

A Spring Boot MVC web application for managing an interactive animal gallery with CRUD operations, image uploads, and search functionality.

## Get the project
- **clone**
  ```bash
  git clone https://github.com/dylanbsgit/csc340_a3_animal-gallery.git
  ```
- OR download zip.

## Open the project in VS Code
- This project is built to run with **jdk 17** or later.

## Dependencies
[Dependencies](pom.xml) include Spring Boot Web, JPA, H2 Database, and FreeMarker, in addition to the usual. JPA handles the persistence, H2 is the in-memory database used for development, FreeMarker generates HTML templates.

## Configuration 
The `application.properties` file contains configuration for the app:
```properties
# File upload size limits
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
```

## Build and Run
- Build and run the main class. You should see the H2 database initialized.
- Access the application at: `http://localhost:8080/animals`

## Database Access
- H2 Console available at: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave blank)

## ORM Concepts
We are using ORM (Object-Relational Mapping) to deal with databases. This is a technique that allows us to interact with a relational database using object-oriented programming principles.

- **JPA** (Jakarta Persistence, formerly Java Persistence API) is a specification that defines ORM standards in Java. It provides an abstraction layer for ORM frameworks.
- **Hibernate**: Hibernate is a popular ORM framework that implements JPA. It simplifies database operations by mapping Java objects to database tables and handling queries efficiently.

## Architecture

### [Entity](src/main/java/com/animal/Animal.java)
- The `Animal` class is annotated as an `@Entity`. This maps class attributes to database tables and SQL types.
- Any Entity must have at least one attribute annotated as an `@Id`. In our case it's the `animalId` attribute.
  - We use an autogeneration strategy for the ID using `@GeneratedValue(strategy = GenerationType.IDENTITY)`.
  - For this reason, we added a constructor to make an Animal without an ID.
- An Entity must have a no-argument constructor.
- Fields include: `name`, `description`, `habitat`, `favoriteFood`, `age`, `behavior`, `imageFilename`.

### [Repository](src/main/java/com/animal/AnimalRepository.java)
- We extend the JPA Repository that comes with prebuilt database operations such as select all, select by id, insert, delete, etc.
- Annotated as a `@Repository`.
- Parametrized using our object and its ID type: `public interface AnimalRepository extends JpaRepository<Animal, Long>`
- Custom queries for search functionality:
  - `findByNameContainingIgnoreCase(String name)` - Search animals by name
  - `findByFavoriteFoodContainingIgnoreCase(String favoriteFood)` - Filter by favorite food

### [Service](src/main/java/com/animal/AnimalService.java)
- Annotated as a `@Service`.
- Acts as go-between from controller to database. Defines functions needed from the repository.
- Functions include standard JPA operations (save, delete, findAll) and custom operations (searchByName, searchByFavoriteFood).
- The Repository class is `@Autowired`. Do not use a constructor to make a Repository object.
- Includes `initializeData()` method to populate database with sample animals.

### [Controller](src/main/java/com/animal/AnimalController.java)
- This is a `@Controller` (not `@RestController`). This MVC Controller returns views instead of objects.
- All methods return view names. The template engine finds the template with this name and renders a view.
- Returns `"redirect:/link/to/redirect"` when there's no view attached to an action (e.g., redirecting after delete).
- Model attributes added using `model.addAttribute("animalsList", service.getAllAnimals())`.
- The Service class is `@Autowired`. Do not use a constructor.
- **File Upload Handling**: Supports `MultipartFile` for image uploads with custom naming convention.

## Views
- All views live in `src/main/resources/templates`.
- These are `.ftlh` files (FreeMarker templates). They work like HTML but are used by the server to append data from the database.
- **VS Code Configuration**: Associate `.ftlh` files with HTML:
  - Settings (Ctrl+comma) → Search "association" → Add Item → Key: `*.ftlh`, Value: `html` → OK

### Template Usage
- **animal-list.ftlh**: "Loop through Animal list and display each Animal"
  ```html
  <#list animalsList as animal>
    <div class="animal-card">
      <div class="animal-name">${animal.name}</div>
    </div>
  </#list>
  ```
- **Forms**: For any form that sends POST requests, the input `name` attribute should match the data field:
  ```html
  <input type="text" name="name" placeholder="Animal Name"/>
  <input type="file" name="imageFile" accept="image/*"/>
  ```

### View Mappings
- Remember that any view must have a corresponding mapping. Any web page displayed MUST have a mapping in a controller.
- Forms have separate GET mappings to display the form and POST mappings to process the form data.
- **File Upload Forms**: Use `enctype="multipart/form-data"` for image uploads.

## Key Features

### CRUD Operations
- **Create**: `GET /animals/new` (show form), `POST /animals/new` (process form)
- **Read**: `GET /animals` (list all), `GET /animals/{id}` (show details)
- **Update**: `GET /animals/edit/{id}` (show form), `POST /animals/update` (process form)
- **Delete**: `GET /animals/delete/{id}` (delete and redirect)

### Image Management
- **File Upload**: Images uploaded via multipart forms
- **Custom Naming**: Images saved as `AnimalName_ID.extension` (e.g., `Red_Panda5.jpg`)
- **Storage**: Images stored in `src/main/resources/static/Animal Pictures/`
- **Display**: Images displayed on both list and detail views

### Search Functionality
- **Name Search**: `GET /animals/search?name={query}`
- **Food Filter**: `GET /animals/category?favoriteFood={query}`

### Data Management
- **Initialize Data**: `GET /animals/init-data` - Populate with sample animals
- **Clear Data**: `GET /animals/clear-data` - Remove all animals

## Important Notes
- **Web Browsers**: Only allow GET and POST requests (unless using JavaScript)! We use POST for updates and GET for deletes.
- **Form Data**: When getting data from forms, we do not need the `@RequestBody` annotation.
- **Save vs Update**: Hibernate uses the same method for both. If an entity exists it gets updated, else it gets created. This is why we attach an ID to our update form.
- **Server Port**: Application runs on `http://localhost:8080`
- **File Access**: Images must be accessed through the server, not as direct files.

## On the browser go to:
`http://localhost:8080/animals`
