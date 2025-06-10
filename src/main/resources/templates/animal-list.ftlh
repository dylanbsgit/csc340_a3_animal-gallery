<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Animal Gallery Home</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
    <nav>
        <a href="/animals">Home</a>
        <a href="/about">About</a>
        <a href="/animals">Animals</a>
    </nav>
    <h1>Dynamic Web App: Animal Gallery (Home)</h1>
    
    <!-- Add Animal Button -->
    <div style="text-align: center; margin: 20px;">
        <a href="/animals/new" style="background-color: #28a745; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px;">Add New Animal</a>
        <a href="/animals/clear-data" style="background-color: #dc3545; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px; margin-left: 10px;">Clear All Data</a>
        <a href="/animals/init-data" style="background-color: #17a2b8; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px; margin-left: 10px;">Add Test Data</a>
    </div>
    
    <div class="gallery">
        <!-- Check if we have animals -->
        <#if animalsList?? && (animalsList?size > 0)>
            <!-- Loop through each animal from the database -->
            <#list animalsList as animal>
                <div class="animal-card" onclick="window.location.href='/animals/${animal.animalId}'">
                    <div class="animal-name">${animal.name}</div>
                    <div class="animal-description">${animal.description!"No description available"}</div>
                    
                    <!-- Show the fields that actually exist in your entity -->
                    <#if animal.habitat??>
                        <div class="animal-habitat"><strong>Habitat:</strong> ${animal.habitat}</div>
                    </#if>
                    <#if animal.age??>
                        <div class="animal-age"><strong>Age:</strong> ${animal.age} years</div>
                    </#if>
                    <#if animal.favoriteFood??>
                        <div class="animal-food"><strong>Favorite Food:</strong> ${animal.favoriteFood}</div>
                    </#if>
                    
                    <!-- Action buttons for each animal -->
                    <div class="animal-actions" style="margin-top: 10px;">
                        <a href="/animals/edit/${animal.animalId}" style="background-color: #007bff; color: white; padding: 5px 10px; text-decoration: none; border-radius: 3px; font-size: 12px;">Edit</a>
                        <a href="/animals/delete/${animal.animalId}" style="background-color: #dc3545; color: white; padding: 5px 10px; text-decoration: none; border-radius: 3px; font-size: 12px; margin-left: 5px;" onclick="return confirm('Are you sure you want to delete ${animal.name}?')">Delete</a>
                    </div>
                </div>
            </#list>
        <#else>
            <!-- Show message when no animals exist -->
            <div style="text-align: center; padding: 50px;">
                <h2>No animals found in the database!</h2>
                <p>Click the button below to add some test data:</p>
                <a href="/animals/init-data" style="background-color: #17a2b8; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px;">Add Test Animals</a>
            </div>
        </#if>
    </div>
    
    <!-- Search functionality -->
    <div style="text-align: center; margin: 30px;">
        <h3>Search Animals</h3>
        <form action="/animals/search" method="get" style="display: inline-block; margin: 10px;">
            <input type="text" name="name" placeholder="Search by name..." style="padding: 8px;">
            <button type="submit" style="background-color: #007bff; color: white; padding: 8px 15px; border: none; border-radius: 4px;">Search</button>
        </form>
        <form action="/animals/category" method="get" style="display: inline-block; margin: 10px;">
            <input type="text" name="favoriteFood" placeholder="Search by favorite food..." style="padding: 8px;">
            <button type="submit" style="background-color: #28a745; color: white; padding: 8px 15px; border: none; border-radius: 4px;">Filter</button>
        </form>
    </div>
</body>
</html>