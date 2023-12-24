# Cooking-Application
Web Ebgineering course project.

Cooking-App is an application that provides users with different recipes. The user is able to create an account and to create own recipes as well as 
view and review the recipes from others. If the user is not registerd, he can only view other recipes and not review and create its own. For registered users there is also an option to save recipes as favorites.


MODELS:

1. User model:
   Collection will contain data about user's: id, email, pssword, type, name, surname, username, ulpaded recipes, saved recipes, and reviews that the user has left on some recipes. 
   Adding the @Document annotation to relate the model's class to the collection of the same type (user) in MongoDb.
   Adding @Id annotation to define the primary key of the collection.
  
  - Adding the Enum clas for UserType in order to define constants, because the user can be "registered" or a "guest user".
  - I created DTO objects, that will request and display only relevant data, not all (such as password). By that I aldso created the coversation from the actual enity to DTO, and vice-versa.

  User service:
   1. Register the user -> The user should be added to the database 
   2. View the user's profile -> get the user by id or by name
   3. Get the list of all users
   4. Update the user's profile -> route will be based on id
   5. Login the user -> in order for the user to login, he needs already to be registered -> ??? 

2. Recipe model:
   Collection will contain data about recipe's: id, name, description, steps, list of ingredients, cookingType, restriction, reviews and the author of a recipe.
   Adding the @Document annotation to relate the model's class to the collection of the same type (recipe) in MongoDb.
   Adding @Id annotation to define the primary key of the collection.
   - Adding the Enum class for RecipeRestriction in order to define constants.
   - Created DTO objects
   
   Recipe service:
   1. Create/add a new recipe
   2. View all recipes by id/by name
   3. Update/Edit the recipe
    
   
3. Ingredient Model:
   Collection will contain data about ingredients which are contained in recipes. The columns are: id, name, description, category and measurement unit.
   - Creating a repository and the DTO object for this model. The IngredientRequestDTO is handling the request from the user (the user will not be able to enter the id).
   
   Ingredient service:
   1. View all ingredients
   2. Add ingredients
   3. Delete ingredients
   4. Update ingredients

4. Review Model:

Created a folder for exceptions. 

Dodatne rute:
1.* Kada se ukuca ime i prezime korisnika da prikaze usera i sve njegove recepte.
2.* Kada se ukuca ingredient da izbaci sve recepte u kojima se taj ingredient nalazi.
3. Ako getamo recept, da nam izbaci sve komenatre, a preko komenatara da se moze doci do usera
4. Da nam na osnovu recipe type izbacuje sve recepte te vrste.
5. Napravi login rutu.
6. Nparavi my favorites: da user moze dodati recept u favorites i izbrisati iz favorites.
7. Zastiti rute: registrovani useri mogu dodavati, editovati i addati to favorite, a obicni useri mogu samo gledati recepte.
8. Mail confirmation message.
9. Add recipe categories and that the user can search recipes by categories.