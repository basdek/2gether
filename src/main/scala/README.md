# Login2Gether

## Domain concepts

* User

    * A ```User``` represents a natural person of flesh and blood. 

    * A ```User``` needs to have credentials (username, password?) to do identification, authentication and login.
    
    * A ```User``` has several important operations, that we will split into 
        * Unprotected operations
    
            1. Identification (via Credentials?)
            
            1. Authentication (via Credentials?)
        
            1. Logging in is an operation that has two predicates:
                1. Authentication
                2. The Permission of a Mate
            
        * Protected operations (only executable when successfully logged in)
        
            1. Issuing login permission to a ```Mate```
            
            1. Creating a ```Secret``` 
            
            1. Viewing the ```Secret```s of which you are the ```Owner```
            
            1. Viewing the ```Secret```s for which you have been issued the right to read by another ```User```
            
            1. Issuing the permission to view an ```Own```ed ```Secret``` to another ```User```
          

* Secret

    * A ```Secret``` is an ascii text message that is *owned* by a ```User```, which for this relationship 
    henceforth shall be called the ```Secret```s ```Owner```

    * A ```Secret``` can be shared by its ```Owner``` with any other ```User```.
      
    * From this point it follows that we need a mechanism to store the right to read the ```Secret``` for a ```User``` 
    

* Permission

    * A ```Permission``` is used to express the relationship between a ```User``` and a ```Resource```/```Operation```.

        * In the context of a ```Permission```, the ```User``` **for** which the ```Permission``` is issued is called the
        ```Permission```s *subject*.

        * For an example on what an ```Operation``` might be, see (Domain concepts > User > Unprotected operations and the
        same for protected operations.)
        
        * A ```Resource```, in the context of this software is either:
             1. another ```User``` (NOT self!) or
             2. a specific ```Secret```
    
        *  I.e. a Triple of type: "*Jan* is allowed to *View* *Document.xml*"
    
    * A ```Permission``` has a lifetime, it can *expire*.

        * I.e. a way to store: "*Jan* is allowed to *View* *Document.xml* up until *DateTime*"
        
        * Expiration is not mandatory: a ```Permision``` might be indefinitely valid.

    * A ```Permission``` can contain metadata.

        * An example of metadata would be the issuer of the ```Permission```.
    
