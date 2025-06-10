<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Animal - Animal Gallery</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
    <nav>
        <a href="/animals">Home</a>
        <a href="/about">About</a>
        <a href="/animals">Animals</a>
    </nav>
    
    <h1>Add New Animal</h1>
    
    <div style="max-width: 600px; margin: 0 auto; padding: 20px;">
        <form action="/animals/new" method="post" enctype="multipart/form-data" style="background-color: #f8f9fa; padding: 20px; border-radius: 8px;">
            
            <div style="margin-bottom: 15px;">
                <label for="name" style="display: block; margin-bottom: 5px; font-weight: bold;">Name:</label>
                <input type="text" id="name" name="name" required 
                       style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label for="description" style="display: block; margin-bottom: 5px; font-weight: bold;">Description:</label>
                <textarea id="description" name="description" rows="4" 
                          style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;"></textarea>
            </div>
            
            <div style="margin-bottom: 15px;">
                <label for="habitat" style="display: block; margin-bottom: 5px; font-weight: bold;">Habitat:</label>
                <input type="text" id="habitat" name="habitat"
                       style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label for="favoriteFood" style="display: block; margin-bottom: 5px; font-weight: bold;">Favorite Food:</label>
                <input type="text" id="favoriteFood" name="favoriteFood"
                       style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;">
            </div>
            
            <div style="margin-bottom: 15px;">
                <label for="age" style="display: block; margin-bottom: 5px; font-weight: bold;">Age:</label>
                <input type="number" id="age" name="age" min="0"
                       style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;">
            </div>
            
            <!-- Image upload field -->
            <div style="margin-bottom: 15px;">
                <label for="imageFile" style="display: block; margin-bottom: 5px; font-weight: bold;">Upload Image (optional):</label>
                <input type="file" id="imageFile" name="imageFile" accept="image/*"
                       style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;">
                <small style="color: #666; font-size: 12px;">Select a JPG, PNG, or other image file</small>
            </div>
            
            <!-- Behavior field -->
            <div style="margin-bottom: 15px;">
                <label for="behavior" style="display: block; margin-bottom: 5px; font-weight: bold;">Behavior:</label>
                <textarea id="behavior" name="behavior" rows="3" placeholder="Describe the animal's behavior patterns..."
                          style="width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;"></textarea>
            </div>
            
            <div style="text-align: center; margin-top: 20px;">
                <button type="submit" style="background-color: #28a745; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; margin-right: 10px;">Add Animal</button>
                <a href="/animals" style="background-color: #6c757d; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px;">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>