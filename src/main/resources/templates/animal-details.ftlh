<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${animal.name} - Animal Gallery Details</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
    <nav>
        <a href="/animals">Home</a>
        <a href="/about">About</a>
        <a href="/animals">Details</a>
    </nav>
    <h1>${animal.name} Details</h1>
    <div class="gallery">
        <div class="animal-card-double">
            <div class="animal-name">${animal.name}</div>
            
            <#if animal.habitat??>
            <div class="animal-description"><b>Habitat:</b> 
                ${animal.habitat}</div>
            </#if>
            
            <#if animal.favoriteFood??>
            <div class="animal-description"><b>Diet:</b> 
                ${animal.favoriteFood}</div>
            </#if>
            
            <#if animal.description??>
            <div class="animal-description"><b>About:</b> 
                ${animal.description}</div>
            </#if>
            
            <#if animal.age??>
            <div class="animal-description"><b>Age:</b> 
                ${animal.age} years old</div>
            </#if>
            
            <!-- You can add more hardcoded sections if needed -->
            <div class="animal-description"><b>Care & Wellness:</b> 
                This animal thrives in a carefully maintained environment that mimics its natural habitat.</div>
            
            <div class="animal-description"><b>Behavior:</b> 
                Each animal has unique behavioral patterns that make them fascinating to observe.</div>
                
            <!-- Action buttons for editing/deleting -->
            <div style="margin-top: 20px; text-align: center; display: flex; justify-content: center; gap: 15px; flex-wrap: wrap;">
                <a href="/animals/edit/${animal.animalId}" style="background-color: #28a745; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px; display: inline-block; white-space: nowrap;">Edit Animal</a>
                <a href="/animals/delete/${animal.animalId}" style="background-color: #dc3545; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px; display: inline-block; white-space: nowrap;" onclick="return confirm('Are you sure you want to delete this animal?')">Delete Animal</a>
                <a href="/animals" style="background-color: #007bff; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px; display: inline-block; white-space: nowrap;">Back to List</a>
            </div>
        </div>
    </div>
</body>
</html>