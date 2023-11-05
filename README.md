# Cooking-Application
Web Ebgineering course project.


MODELS:

1. User model:
   Collection will contain data about user's: id, email, pssword, type, name, surname and userName. 
   Adding the @Document annotation to relate the model's class to the collection of the same type (user) in MongoDb.
   Adding @Id annotation to define the primary key of the collection.
  
  - Adding the Enum clas for UserType in order to define constants, because the user can be "registered" or a "guest user".
  - I created DTO objects, that will request and display only relevant data, not all (such as password). By that I aldso created the coversation from the actual enity to DTO, and vice-versa.
  - I NEED A BETTER EXPLANATION OF REPOSITORY INTERFACE. Which methods should I define in this interface (only CRUD)?
  - I updated the userService with methods to get all users, get users by id, get users by full name, add users, update users and delete users.
  - In userController I added the required endpoints related to the userService methods.
  - 

2. Recipe model:
   Collection will contain data about recipe's: id, name, description, steps, ingredients, cookingType, restriction, reviews.
   Adding the @Document annotation to relate the model's class to the collection of the same type (recipe) in MongoDb.
   Adding @Id annotation to define the primary key of the collection.
   - Was there a possibility to make a review model and store the review od recepies, which I link with the id (proceeding the recipeid to Review model)?
     Wouldn't than that be related (MongoDb -> non-relational)??
   - Is it okay if I leave the reviews in a string array?
   - Adding the Enum class for RecipeRestriction in order to define constants.
   - Created DTO objects
   - Updated the recipeService (getAll, getById, getByName, addRecipe, updateRecipe, deleteRecipe)
   - Updated the RecipeContorller and added endpoints
   
3. Tip model:
   Collection will contain data about tip's: id, name, description, relieseDate (of type LocalDate).
   Adding the @Document annotation to relate the model's class to the collection of the same type (tip) in MongoDb.
   Adding @Id annotation to define the primary key of the collection.
   - Created DTO objects
   - Updated the tipService (getAll, getById, getByName, addTip, updateTip, deleteTip)
   - Updated the TipContorller and added endpoints

Created a folder for exceptions. 
   
   