<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Animal</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
    <nav>
        <a href="/animals">Home</a>
        <a href="/about">About</a>
        <a href="/animals">Animals</a>
    </nav>
    
    <div style="max-width: 600px; margin: 0 auto; padding: 20px;">
        <h1>Add New Animal</h1>
        
        <form action="/animals/new" method="post" style="background-color: #f8f9fa; padding: 20px; border-radius: 8px;">
            
            <!-- Animal Name -->
            <div style="margin-bottom: 15px;">
                <label for="name" style="display: block; margin-bottom: 5px; font-weight: bold;">Name:</label>
                <input type="text" id="name" name="name" required 
                       style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;"
                       placeholder="Enter animal name">
            </div>
            
            <!-- Description -->
            <div style="margin-bottom: 15px;">
                <label for="description" style="display: block; margin-bottom: 5px; font-weight: bold;">Description:</label>
                <textarea id="description" name="description" required rows="4"
                          style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;"
                          placeholder="Describe the animal..."></textarea>
            </div>
            
            <!-- Age -->
            <div style="margin-bottom: 15px;">
                <label for="age" style="display: block; margin-bottom: 5px; font-weight: bold;">Age (years):</label>
                <input type="number" id="age" name="age" required min="0" max="200"
                       style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;"
                       placeholder="Enter age">
            </div>
            
            <!-- Habitat -->
            <div style="margin-bottom: 15px;">
                <label for="habitat" style="display: block; margin-bottom: 5px; font-weight: bold;">Habitat:</label>
                <input type="text" id="habitat" name="habitat" required
                       style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;"
                       placeholder="Enter habitat (e.g., Forest, Ocean, Grassland)">
            </div>
            
            <!-- Favorite Food -->
            <div style="margin-bottom: 20px;">
                <label for="favoriteFood" style="display: block; margin-bottom: 5px; font-weight: bold;">Favorite Food:</label>
                <input type="text" id="favoriteFood" name="favoriteFood" required
                       style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;"
                       placeholder="Enter favorite food">
            </div>
            
            <!-- Action Buttons -->
            <div style="text-align: center;">
                <button type="submit" style="background-color: #28a745; color: white; padding: 10px 20px; border: none; border-radius: 4px; margin-right: 10px; cursor: pointer;">
                    Add Animal
                </button>
                <a href="/animals" style="background-color: #6c757d; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px;">
                    Cancel
                </a>
            </div>
        </form>
    </div>
</body>
</html>